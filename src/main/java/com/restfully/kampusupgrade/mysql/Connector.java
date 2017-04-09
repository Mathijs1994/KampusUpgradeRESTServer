/*
 * HvA licences apply
 */
package com.restfully.kampusupgrade.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.restfully.kampusupgrade.domain.Building;
import com.restfully.kampusupgrade.domain.Room;
import com.restfully.kampusupgrade.domain.Screen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mathijs
 */
public class Connector {

    private MysqlDataSource dataSource;
    private final String USER = "root";
    private final String PASSWORD = "supersilnehaslo";
    private final String SERVER = "127.0.0.1";
    private final int PORT = 3306;
    private final String DB_NAME = "kampusupgrade";

    public Connector() {
        dataSource = new MysqlDataSource();
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setServerName(SERVER);
        dataSource.setDatabaseName(DB_NAME);
        dataSource.setPort(PORT);

    }

    public ArrayList<Building> getAllBuildings() {

        ArrayList<Building> list = new ArrayList<Building>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select building.ID, building.Name, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No from building\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID;");
            while (rs.next()) {
                Building building = new Building();
                building.setId(rs.getInt("ID"));
                building.setName(rs.getString("Name"));
                building.setCity(rs.getString("cityname"));
                building.setStreet(rs.getString("streetname"));
                building.setPostalCode(rs.getString("Postal_Code"));
                building.setNumber(rs.getInt("No"));
                list.add(building);

            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Building> getBuildingsByCity(String city) {

        ArrayList<Building> list = new ArrayList<Building>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select building.ID, building.Name, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No from building\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where city.Name = '" + city + "';");
            while (rs.next()) {
                Building building = new Building();
                building.setId(rs.getInt("ID"));
                building.setName(rs.getString("Name"));
                building.setCity(rs.getString("cityname"));
                building.setStreet(rs.getString("streetname"));
                building.setPostalCode(rs.getString("Postal_Code"));
                building.setNumber(rs.getInt("No"));
                list.add(building);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Building> getBuilding(int id) {

        ArrayList<Building> list = new ArrayList<Building>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select building.ID, building.Name, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No from building\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where building.ID = '" + id + "';");
            while (rs.next()) {
                Building building = new Building();
                building.setId(rs.getInt("ID"));
                building.setName(rs.getString("Name"));
                building.setCity(rs.getString("cityname"));
                building.setStreet(rs.getString("streetname"));
                building.setPostalCode(rs.getString("Postal_Code"));
                building.setNumber(rs.getInt("No"));
                list.add(building);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Building> getBuildingsByName(String name) {

        ArrayList<Building> list = new ArrayList<Building>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select building.ID, building.Name, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No from building\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where building.Name = '" + name + "';");
            while (rs.next()) {
                Building building = new Building();
                building.setId(rs.getInt("ID"));
                building.setName(rs.getString("Name"));
                building.setCity(rs.getString("cityname"));
                building.setStreet(rs.getString("streetname"));
                building.setPostalCode(rs.getString("Postal_Code"));
                building.setNumber(rs.getInt("No"));
                list.add(building);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Building> getBuildingsByStreet(String street) {

        ArrayList<Building> list = new ArrayList<Building>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select building.ID, building.Name, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No from building\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where street.Name = '" + street + "';");
            while (rs.next()) {
                Building building = new Building();
                building.setId(rs.getInt("ID"));
                building.setName(rs.getString("Name"));
                building.setCity(rs.getString("cityname"));
                building.setStreet(rs.getString("streetname"));
                building.setPostalCode(rs.getString("Postal_Code"));
                building.setNumber(rs.getInt("No"));
                list.add(building);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Room> getAllRooms() {

        ArrayList<Room> list = new ArrayList<Room>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select room.ID, room.No, room.Name, floor.No as floorNo, wing.Name as wingname, coordinates.X_coordinate, coordinates.Y_coordinate,\n"
                    + "building.ID as buildingID, building.Name as buildingname, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No  as buildingNo from room\n"
                    + "inner join floor\n"
                    + "on room.ID_FLOOR = floor.ID\n"
                    + "inner join wing\n"
                    + "on room.ID_WING = wing.ID\n"
                    + "inner join coordinates\n"
                    + "on room.ID_COORDINATES = coordinates.ID\n"
                    + "inner join building\n"
                    + "on room.ID_BUILDING = building.ID\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID;");
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("ID"));
                room.setNo(rs.getInt("No"));
                room.setName(rs.getString("Name"));
                room.setFloor(rs.getInt("floorNo"));
                room.setWing(rs.getString("wingname"));
                room.setxCoordinate(rs.getInt("X_coordinate"));
                room.setyCoordinate(rs.getInt("Y_coordinate"));
                room.setBuildingID(rs.getInt("buildingID"));
                room.setBuildingname(rs.getString("buildingname"));
                room.setBuildingCity(rs.getString("cityname"));
                room.setBuildingstreet(rs.getString("streetname"));
                room.setBuildingPostal_code(rs.getString("Postal_Code"));
                room.setBuildingNo(rs.getString("buildingNo"));

                String query = "select screen.ID, screen.Bluetooth_Mac, screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate from screen\n"
                        + "inner join coordinates\n"
                        + "on screen.ID_COORDINATES = coordinates.ID\n"
                        + "inner join room\n"
                        + "on screen.ID = room.ID_CLOSEST_SCREEN\n"
                        + "where room.ID = " + room.getId() + ";";
                Statement nStmt = conn.createStatement();
                ResultSet screenRs = nStmt.executeQuery(query);
                Screen screen = new Screen();
                while (screenRs.next()) {

                    
                    screen.setId(screenRs.getInt("ID"));
                    screen.setMac(screenRs.getString("Bluetooth_Mac"));
                    screen.setScreenRotation(screenRs.getInt("Rotation_angle"));
                    screen.setX(screenRs.getInt("X_coordinate"));
                    screen.setY(screenRs.getInt("Y_coordinate"));
                    
                }
                room.setClosestScreen(screen);

                list.add(room);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Room> getRoomsByID(int id) {

        ArrayList<Room> list = new ArrayList<Room>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String query = "select room.ID, room.No, room.Name, floor.No as floorNo, wing.Name as wingname, coordinates.X_coordinate, coordinates.Y_coordinate,\n"
                    + "building.ID as buildingID, building.Name as buildingname, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No  as buildingNo from room\n"
                    + "inner join floor\n"
                    + "on room.ID_FLOOR = floor.ID\n"
                    + "inner join wing\n"
                    + "on room.ID_WING = wing.ID\n"
                    + "inner join coordinates\n"
                    + "on room.ID_COORDINATES = coordinates.ID\n"
                    + "inner join building\n"
                    + "on room.ID_BUILDING = building.ID\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where room.ID = " + id + ";";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("ID"));
                room.setNo(rs.getInt("No"));
                room.setName(rs.getString("Name"));
                room.setFloor(rs.getInt("floorNo"));
                room.setWing(rs.getString("wingname"));
                room.setxCoordinate(rs.getInt("X_coordinate"));
                room.setyCoordinate(rs.getInt("Y_coordinate"));
                room.setBuildingID(rs.getInt("buildingID"));
                room.setBuildingname(rs.getString("buildingname"));
                room.setBuildingCity(rs.getString("cityname"));
                room.setBuildingstreet(rs.getString("streetname"));
                room.setBuildingPostal_code(rs.getString("Postal_Code"));
                room.setBuildingNo(rs.getString("buildingNo"));
                  query = "select screen.ID, screen.Bluetooth_Mac, screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate from screen\n"
                        + "inner join coordinates\n"
                        + "on screen.ID_COORDINATES = coordinates.ID\n"
                        + "inner join room\n"
                        + "on screen.ID = room.ID_CLOSEST_SCREEN\n"
                        + "where room.ID = " + room.getId() + ";";
                Statement nStmt = conn.createStatement();
                ResultSet screenRs = nStmt.executeQuery(query);
                Screen screen = new Screen();
                while (screenRs.next()) {

                    
                    screen.setId(screenRs.getInt("ID"));
                    screen.setMac(screenRs.getString("Bluetooth_Mac"));
                    screen.setScreenRotation(screenRs.getInt("Rotation_angle"));
                    screen.setX(screenRs.getInt("X_coordinate"));
                    screen.setY(screenRs.getInt("Y_coordinate"));
                    
                }
                room.setClosestScreen(screen);

                
                
                list.add(room);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Room> getRoomsByNo(int no) {

        ArrayList<Room> list = new ArrayList<Room>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select room.ID, room.No, room.Name, floor.No as floorNo, wing.Name as wingname, coordinates.X_coordinate, coordinates.Y_coordinate,\n"
                    + "building.ID as buildingID, building.Name as buildingname, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No  as buildingNo from room\n"
                    + "inner join floor\n"
                    + "on room.ID_FLOOR = floor.ID\n"
                    + "inner join wing\n"
                    + "on room.ID_WING = wing.ID\n"
                    + "inner join coordinates\n"
                    + "on room.ID_COORDINATES = coordinates.ID\n"
                    + "inner join building\n"
                    + "on room.ID_BUILDING = building.ID\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where room.No = " + no + ";");
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("ID"));
                room.setNo(rs.getInt("No"));
                room.setName(rs.getString("Name"));
                room.setFloor(rs.getInt("floorNo"));
                room.setWing(rs.getString("wingname"));
                room.setxCoordinate(rs.getInt("X_coordinate"));
                room.setyCoordinate(rs.getInt("Y_coordinate"));
                room.setBuildingID(rs.getInt("buildingID"));
                room.setBuildingname(rs.getString("buildingname"));
                room.setBuildingCity(rs.getString("cityname"));
                room.setBuildingstreet(rs.getString("streetname"));
                room.setBuildingPostal_code(rs.getString("Postal_Code"));
                room.setBuildingNo(rs.getString("buildingNo"));
                 String query = "select screen.ID, screen.Bluetooth_Mac, screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate from screen\n"
                        + "inner join coordinates\n"
                        + "on screen.ID_COORDINATES = coordinates.ID\n"
                        + "inner join room\n"
                        + "on screen.ID = room.ID_CLOSEST_SCREEN\n"
                        + "where room.ID = " + room.getId() + ";";
                Statement nStmt = conn.createStatement();
                ResultSet screenRs = nStmt.executeQuery(query);
                Screen screen = new Screen();
                while (screenRs.next()) {

                    
                    screen.setId(screenRs.getInt("ID"));
                    screen.setMac(screenRs.getString("Bluetooth_Mac"));
                    screen.setScreenRotation(screenRs.getInt("Rotation_angle"));
                    screen.setX(screenRs.getInt("X_coordinate"));
                    screen.setY(screenRs.getInt("Y_coordinate"));
                    
                }
                room.setClosestScreen(screen);

                
                list.add(room);
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Room> getRoomsByBuilding(int id) {

        ArrayList<Room> list = new ArrayList<Room>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select room.ID, room.No, room.Name, floor.No as floorNo, wing.Name as wingname, coordinates.X_coordinate, coordinates.Y_coordinate,\n"
                    + "building.ID as buildingID, building.Name as buildingname, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No  as buildingNo from room\n"
                    + "inner join floor\n"
                    + "on room.ID_FLOOR = floor.ID\n"
                    + "inner join wing\n"
                    + "on room.ID_WING = wing.ID\n"
                    + "inner join coordinates\n"
                    + "on room.ID_COORDINATES = coordinates.ID\n"
                    + "inner join building\n"
                    + "on room.ID_BUILDING = building.ID\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where building.ID = " + id + ";");
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("ID"));
                room.setNo(rs.getInt("No"));
                room.setName(rs.getString("Name"));
                room.setFloor(rs.getInt("floorNo"));
                room.setWing(rs.getString("wingname"));
                room.setxCoordinate(rs.getInt("X_coordinate"));
                room.setyCoordinate(rs.getInt("Y_coordinate"));
                room.setBuildingID(rs.getInt("buildingID"));
                room.setBuildingname(rs.getString("buildingname"));
                room.setBuildingCity(rs.getString("cityname"));
                room.setBuildingstreet(rs.getString("streetname"));
                room.setBuildingPostal_code(rs.getString("Postal_Code"));
                room.setBuildingNo(rs.getString("buildingNo"));
                 String query = "select screen.ID, screen.Bluetooth_Mac, screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate from screen\n"
                        + "inner join coordinates\n"
                        + "on screen.ID_COORDINATES = coordinates.ID\n"
                        + "inner join room\n"
                        + "on screen.ID = room.ID_CLOSEST_SCREEN\n"
                        + "where room.ID = " + room.getId() + ";";
                Statement nStmt = conn.createStatement();
                ResultSet screenRs = nStmt.executeQuery(query);
                Screen screen = new Screen();
                while (screenRs.next()) {

                    
                    screen.setId(screenRs.getInt("ID"));
                    screen.setMac(screenRs.getString("Bluetooth_Mac"));
                    screen.setScreenRotation(screenRs.getInt("Rotation_angle"));
                    screen.setX(screenRs.getInt("X_coordinate"));
                    screen.setY(screenRs.getInt("Y_coordinate"));
                    
                }
                room.setClosestScreen(screen);

                list.add(room);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Screen> getAllScreens() {

        ArrayList<Screen> list = new ArrayList<Screen>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String query = "select screen.ID,screen.Bluetooth_Mac,screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate,\n"
                    + "building.ID as buildingID, building.Name as buildingname, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No  as buildingNo from screen\n"
                    + "\n"
                    + "inner join coordinates\n"
                    + "on screen.ID_COORDINATES = coordinates.ID\n"
                    + "inner join building\n"
                    + "on screen.ID_BUILDING = building.ID\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Screen screen = new Screen();

                screen.setId(rs.getInt("ID"));
                screen.setMac(rs.getString("Bluetooth_Mac"));
                screen.setScreenRotation(rs.getInt("Rotation_angle"));
                screen.setX(rs.getInt("X_coordinate"));
                screen.setY(rs.getInt("Y_coordinate"));
                screen.setBuildingID(rs.getInt("buildingID"));
                screen.setBuildingname(rs.getString("buildingname"));
                screen.setCity(rs.getString("cityname"));
                screen.setBuildingstreet(rs.getString("streetname"));
                screen.setPostal_code(rs.getString("Postal_Code"));
                screen.setBuildingNo(rs.getInt("buildingNo"));

                query = "select screen.ID,screen.Bluetooth_Mac,screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate, neighbouring_screens.Distance,neighbouring_screens.ID_SCREEN_2\n"
                        + "from screen\n"
                        + "inner join neighbouring_screens\n"
                        + "on screen.ID = neighbouring_screens.ID_SCREEN_1\n"
                        + "inner join coordinates\n"
                        + "on neighbouring_screens.ID_SCREEN_2 = coordinates.ID\n"
                        + "where screen.ID=" + screen.getId() + ";";
                Statement nStmt = conn.createStatement();
                ResultSet neighboorRs = nStmt.executeQuery(query);
                ArrayList<Screen> neighbourList = new ArrayList();
                while (neighboorRs.next()) {
                    Screen neighbourScreen = new Screen();
                    neighbourScreen.setId(neighboorRs.getInt("ID_SCREEN_2"));
                    neighbourScreen.setMac(neighboorRs.getString("Bluetooth_Mac"));
                    neighbourScreen.setScreenRotation(neighboorRs.getInt("Rotation_angle"));
                    neighbourScreen.setX(neighboorRs.getInt("X_coordinate"));
                    neighbourScreen.setY(neighboorRs.getInt("Y_coordinate"));
                    neighbourScreen.setDistance(neighboorRs.getInt("Distance"));
                    neighbourList.add(neighbourScreen);

                }
                screen.setNeighbourList(neighbourList);
                neighboorRs.close();

                list.add(screen);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Screen> getScreensByID(int id) {

        ArrayList<Screen> list = new ArrayList<Screen>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String query = "select screen.ID,screen.Bluetooth_Mac,screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate,\n"
                    + "building.ID as buildingID, building.Name as buildingname, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No  as buildingNo from screen\n"
                    + "\n"
                    + "inner join coordinates\n"
                    + "on screen.ID_COORDINATES = coordinates.ID\n"
                    + "inner join building\n"
                    + "on screen.ID_BUILDING = building.ID\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where screen.ID = " + id + ";";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Screen screen = new Screen();

                screen.setId(rs.getInt("ID"));
                screen.setMac(rs.getString("Bluetooth_Mac"));
                screen.setScreenRotation(rs.getInt("Rotation_angle"));
                screen.setX(rs.getInt("X_coordinate"));
                screen.setY(rs.getInt("Y_coordinate"));
                screen.setBuildingID(rs.getInt("buildingID"));
                screen.setBuildingname(rs.getString("buildingname"));
                screen.setCity(rs.getString("cityname"));
                screen.setBuildingstreet(rs.getString("streetname"));
                screen.setPostal_code(rs.getString("Postal_Code"));
                screen.setBuildingNo(rs.getInt("buildingNo"));

                query = "select screen.ID,screen.Bluetooth_Mac,screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate, neighbouring_screens.Distance,neighbouring_screens.ID_SCREEN_2\n"
                        + "from screen\n"
                        + "inner join neighbouring_screens\n"
                        + "on screen.ID = neighbouring_screens.ID_SCREEN_1\n"
                        + "inner join coordinates\n"
                        + "on neighbouring_screens.ID_SCREEN_2 = coordinates.ID\n"
                        + "where screen.ID=" + screen.getId() + ";\n";
                Statement nStmt = conn.createStatement();
                ResultSet neighboorRs = nStmt.executeQuery(query);
                ArrayList<Screen> neighbourList = new ArrayList();
                while (neighboorRs.next()) {

                    Screen neighbourScreen = new Screen();
                    neighbourScreen.setId(neighboorRs.getInt("ID_SCREEN_2"));
                    neighbourScreen.setMac(neighboorRs.getString("Bluetooth_Mac"));
                    neighbourScreen.setScreenRotation(neighboorRs.getInt("Rotation_angle"));
                    neighbourScreen.setX(neighboorRs.getInt("X_coordinate"));
                    neighbourScreen.setY(neighboorRs.getInt("Y_coordinate"));
                    neighbourScreen.setDistance(neighboorRs.getInt("Distance"));
                    neighbourList.add(neighbourScreen);

                }
                screen.setNeighbourList(neighbourList);
                list.add(screen);
                neighboorRs.close();

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Screen> getScreensByBuilding(int id) {

        ArrayList<Screen> list = new ArrayList<Screen>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String query = "select screen.ID,screen.Bluetooth_Mac,screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate,\n"
                    + "building.ID as buildingID, building.Name as buildingname, city.name as cityname, street.Name as streetname, street.Postal_Code, street.No  as buildingNo from screen\n"
                    + "inner join coordinates\n"
                    + "on screen.ID_COORDINATES = coordinates.ID\n"
                    + "inner join building\n"
                    + "on screen.ID_BUILDING = building.ID\n"
                    + "inner join city\n"
                    + "on building.ID_CITY = city.ID\n"
                    + "inner join street\n"
                    + "on building.ID_STREET = street.ID\n"
                    + "where building.ID = " + id + ";";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Screen screen = new Screen();

                screen.setId(rs.getInt("ID"));
                screen.setMac(rs.getString("Bluetooth_Mac"));
                screen.setScreenRotation(rs.getInt("Rotation_angle"));
                screen.setX(rs.getInt("X_coordinate"));
                screen.setY(rs.getInt("Y_coordinate"));
                screen.setBuildingID(rs.getInt("buildingID"));
                screen.setBuildingname(rs.getString("buildingname"));
                screen.setCity(rs.getString("cityname"));
                screen.setBuildingstreet(rs.getString("streetname"));
                screen.setPostal_code(rs.getString("Postal_Code"));
                screen.setBuildingNo(rs.getInt("buildingNo"));

                String neighbourQuery = "select screen.ID,screen.Bluetooth_Mac,screen.Rotation_angle, coordinates.X_coordinate, coordinates.Y_coordinate, neighbouring_screens.Distance,neighbouring_screens.ID_SCREEN_2\n"
                        + "from screen\n"
                        + "inner join neighbouring_screens\n"
                        + "on screen.ID = neighbouring_screens.ID_SCREEN_1\n"
                        + "inner join coordinates\n"
                        + "on neighbouring_screens.ID_SCREEN_2 = coordinates.ID\n"
                        + "where screen.ID=" + screen.getId() + ";\n";
                Statement nStmt = conn.createStatement();
                ResultSet neighboorRs = nStmt.executeQuery(neighbourQuery);
                ArrayList<Screen> neighbourList = new ArrayList();
                while (neighboorRs.next()) {

                    Screen neighbourScreen = new Screen();
                    neighbourScreen.setId(neighboorRs.getInt("ID_SCREEN_2"));
                    neighbourScreen.setMac(neighboorRs.getString("Bluetooth_Mac"));
                    neighbourScreen.setScreenRotation(neighboorRs.getInt("Rotation_angle"));
                    neighbourScreen.setX(neighboorRs.getInt("X_coordinate"));
                    neighbourScreen.setY(neighboorRs.getInt("Y_coordinate"));
                    neighbourScreen.setDistance(neighboorRs.getInt("Distance"));
                    neighbourList.add(neighbourScreen);

                }
                screen.setNeighbourList(neighbourList);
                neighboorRs.close();
                list.add(screen);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}
