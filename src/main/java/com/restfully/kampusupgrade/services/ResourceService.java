package com.restfully.kampusupgrade.services;

import com.restfully.kampusupgrade.domain.Building;
import com.restfully.kampusupgrade.domain.Customer;
import com.restfully.kampusupgrade.mysql.Connector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * REST Web Service
 *
 * @author Mahijs
 */
public class ResourceService implements RestResources {

    @Context
    private UriInfo context;

    // Added from book:
    private Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
    private AtomicInteger idCounter = new AtomicInteger();

    /**
     * Creates a new instance of RestResources
     */
    public ResourceService() {

    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.mavenproject_fbo.ResourceService
     *
     * @return an instance of com.mycompany.mavenproject_fbo.Customer
     */
    public StreamingOutput getBuilding() {

        Connector conn = new Connector();
        final ArrayList<Building> list = conn.getAllBuildings();

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputBuilding(outputStream, list);
            }

        };
    }

    public StreamingOutput getBuilding(String city) {
        Connector conn = new Connector();
        final ArrayList<Building> list = conn.getBuildingsByCity(city);

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputBuilding(outputStream, list);
            }

        };

    }

    public StreamingOutput getBuilding(int id) {
        Connector conn = new Connector();
        final ArrayList<Building> list = conn.getBuilding(id);

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputBuilding(outputStream, list);
            }

        };

    }

    public StreamingOutput getBuildingByStreet(String street) {
        Connector conn = new Connector();
        final ArrayList<Building> list = conn.getBuildingsByStreet(street);

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputBuilding(outputStream, list);
            }

        };

    }

    public StreamingOutput getBuildingByName(String name) {
        Connector conn = new Connector();
        final ArrayList<Building> list = conn.getBuildingsByName(name);

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputBuilding(outputStream, list);
            }

        };
    }

    public StreamingOutput getCustomer() {
        final Customer customer = customerDB.get(1);
        if (customer == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
              //  outputCustomer(outputStream, customer);

            }
        };
    }

    public StreamingOutput getCustomer(int id) {
        final Customer customer = customerDB.get(id);
        if (customer == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
              //  outputCustomer(outputStream, customer);

            }
        };
    }

    public Response createCustomer(InputStream is) {
        Customer customer = readCustomer(is);
        customer.setId(idCounter.incrementAndGet());
        customerDB.put(customer.getId(), customer);
        System.out.println("Created customer " + customer.getId());
        return Response.created(URI.create("/customer/" + customer.getId())).build();
    }

    /**
     * PUT method for updating or creating an instance of ResourceService
     *
     * @param content representation for the resource
     */
    public void updateCustomer(int id, InputStream is) {
        Customer update = readCustomer(is);
        Customer current = customerDB.get(id);
        if (current == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        current.setFirstName(update.getFirstName());
        current.setLastName(update.getLastName());
        current.setStreet(update.getStreet());
        current.setState(update.getState());
        current.setZip(update.getZip());
        current.setCountry(update.getCountry());
    }

    protected void outputBuilding(OutputStream os, ArrayList<Building> b)
            throws IOException {

        PrintStream writer = new PrintStream(os);
        writer.println("<buildings>");
        writer.println("    <list>");
        for (int i = 0; b.size() > i; i++) {
            writer.println("        <building id=\"" + b.get(i).getId() + "\">");
            writer.println("            <name>" + b.get(i).getName() + "</name>");
            writer.println("            <street>" + b.get(i).getStreet() + "</street>");
            writer.println("            <number>" + b.get(i).getNumber() + "</number>");
            writer.println("            <postal_code>" + b.get(i).getPostalCode() + "</postal_code>");
            writer.println("            <city>" + b.get(i).getCity() + "</city>");
            writer.println("        </building>");
        }
        writer.println("    </list>");
        writer.println("</buildings>");
    }

    protected Customer readCustomer(InputStream is) {
        try {
            DocumentBuilder builder
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            Element root = doc.getDocumentElement();

            Customer cust = new Customer();
            if (root.getAttribute("id") != null
                    && !root.getAttribute("id").trim().equals("")) {
                cust.setId(Integer.valueOf(root.getAttribute("id")));
            }
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                if (element.getTagName().equals("first-name")) {
                    cust.setFirstName((element.getTextContent()));
                } else if (element.getTagName().equals("last-name")) {
                    cust.setLastName((element.getTextContent()));
                } else if (element.getTagName().equals("street")) {
                    cust.setStreet((element.getTextContent()));
                } else if (element.getTagName().equals("city")) {
                    cust.setCity((element.getTextContent()));
                } else if (element.getTagName().equals("state")) {
                    cust.setState((element.getTextContent()));
                } else if (element.getTagName().equals("zip")) {
                    cust.setZip((element.getTextContent()));
                } else if (element.getTagName().equals("country")) {
                    cust.setCountry((element.getTextContent()));
                }
            }
            return cust;
        } catch (Exception ex) {
            throw new WebApplicationException(ex, Response.Status.BAD_REQUEST);
        }
    }
}
