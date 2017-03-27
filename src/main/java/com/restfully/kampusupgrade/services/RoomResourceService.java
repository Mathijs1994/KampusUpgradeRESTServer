/*
 * HvA licences apply
 */
package com.restfully.kampusupgrade.services;

import com.restfully.kampusupgrade.domain.Building;
import com.restfully.kampusupgrade.domain.Customer;
import com.restfully.kampusupgrade.domain.Room;
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
 *
 * @author Mathijs
 */
public class RoomResourceService implements RoomResources{

      /**
     * Creates a new instance of BuildingResources
     */
    public RoomResourceService() {
        

    }
    @Override
    public StreamingOutput getRoom() {
        

        Connector conn = new Connector();
        final ArrayList<Room> list = conn.getAllRooms();

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputRoom(outputStream, list);
            }

            private void outputRoom(OutputStream os, ArrayList<Room> r) throws IOException {
        PrintStream writer = new PrintStream(os);
        writer.println("<rooms>");
        writer.println("    <list>");
        for (int i = 0; r.size() > i; i++) {
            writer.println("        <room id=\"" + r.get(i).getId() + "\">");
            writer.println("            <name>" + r.get(i).getName() + "</name>");
            writer.println("            <roomnumber>" + r.get(i).getNo()+ "</roomnumber>");
            writer.println("            <floor>" + r.get(i).getFloor() + "</floor>");
            writer.println("            <wing>" + r.get(i).getWing() + "</wing>");
            writer.println("            <coordinates>");
            writer.println("                <x>" + r.get(i).getxCoordinate() + "</x>");
            writer.println("                <y>" + r.get(i).getxCoordinate() + "</y>");
            writer.println("            </coordinates>");
            writer.println("            <building id=\"" + r.get(i).getBuildingID() + "\">");
            writer.println("                <name>" + r.get(i).getBuildingname() + "</name>");
            writer.println("                <street>" + r.get(i).getBuildingstreet() + "</street>");
            writer.println("                <number>" + r.get(i).getBuildingNo()+ "</number>");
            writer.println("                <postal_code>" + r.get(i).getBuildingPostal_code()+ "</postal_code>");
            writer.println("                <city>" + r.get(i).getBuildingCity()+ "</city>");
            writer.println("            </building>");
            writer.println("        </room>");
        }
        writer.println("    </list>");
        writer.println("</rooms>");
                
                
               
            }

        };
        
    }
    
}
