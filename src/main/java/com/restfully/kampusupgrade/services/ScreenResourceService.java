/*
 * HvA licences apply
 */
package com.restfully.kampusupgrade.services;

import com.restfully.kampusupgrade.domain.Room;
import com.restfully.kampusupgrade.domain.Screen;
import com.restfully.kampusupgrade.mysql.Connector;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author Mathijs
 */
public class ScreenResourceService implements ScreenResources {

    @Override
    public StreamingOutput getScreen() {
        Connector conn = new Connector();
        final ArrayList<Screen> list = conn.getAllScreens();

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputScreen(outputStream, list);
            }

        };
    }

    @Override
    public StreamingOutput getScreen(int id) {
        Connector conn = new Connector();
        final ArrayList<Screen> list = conn.getScreensByID(id);

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputScreen(outputStream, list);
            }

        };
    }

    @Override
    public StreamingOutput getScreenByBuilding(int id) {
        Connector conn = new Connector();
        final ArrayList<Screen> list = conn.getScreensByBuilding(id);

        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputScreen(outputStream, list);
            }

        };
    }

    public void outputScreen(OutputStream os, ArrayList<Screen> s) {
        PrintStream writer = new PrintStream(os);
        writer.println("<screens>");
        writer.println("    <list>");
        for (int i = 0; s.size() > i; i++) {
            ArrayList<Screen> neighbourList = s.get(i).getNeighbourList();
            writer.println("        <screen id=\"" + s.get(i).getId() + "\">");
            writer.println("            <rotation>" + s.get(i).getScreenRotation() + "</rotation>");
            writer.println("            <mac>" + s.get(i).getMac() + "</mac>");
            writer.println("            <coordinates>");
            writer.println("                <x>" + s.get(i).getX() + "</x>");
            writer.println("                <y>" + s.get(i).getY() + "</y>");
            writer.println("            </coordinates>");
            writer.println("            <building id=\"" + s.get(i).getBuildingID() + "\">");
            writer.println("                <name>" + s.get(i).getBuildingname() + "</name>");
            writer.println("                <street>" + s.get(i).getBuildingstreet() + "</street>");
            writer.println("                <number>" + s.get(i).getBuildingNo() + "</number>");
            writer.println("                <postal_code>" + s.get(i).getPostal_code() + "</postal_code>");
            writer.println("                <city>" + s.get(i).getCity() + "</city>");
            writer.println("            </building>");
            writer.println("            <neighbourlist>");
            if (neighbourList != null) {
                for (int j = 0; neighbourList.size() > j; j++) {
                    writer.println("                <screen id=\"" + neighbourList.get(j).getId() + "\">");
                    writer.println("                    <rotation>" + neighbourList.get(j).getScreenRotation() + "</rotation>");
                    writer.println("                    <mac>" + neighbourList.get(j).getMac() + "</mac>");
                    writer.println("                    <coordinates>");
                    writer.println("                        <x>" + neighbourList.get(j).getX() + "</x>");
                    writer.println("                        <y>" + neighbourList.get(j).getY() + "</y>");
                    writer.println("                    </coordinates>");
                    writer.println("                    <distance>" + neighbourList.get(j).getDistance() + "</distance>");
                    writer.println("                </screen>");
                }
            }
            writer.println("            </neighbourlist>");
            writer.println("        </screen>");

        }

        writer.println("    </list>");
        writer.println("</screens>");

    }

}
