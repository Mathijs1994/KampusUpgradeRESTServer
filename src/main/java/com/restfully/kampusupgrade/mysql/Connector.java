/*
 * HvA licences apply
 */
package com.restfully.kampusupgrade.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.restfully.kampusupgrade.domain.Building;
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

    public Connector() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("127.0.0.1");
        dataSource.setDatabaseName("kampusubgrade");
        dataSource.setPort(3306);

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
                    + "where city.Name = '"+ city +"';");
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
                    + "where building.ID = '"+ id +"';");
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
                    + "where building.Name = '"+ name +"';");
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
                    + "where street.Name = '"+ street +"';");
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
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }



}
