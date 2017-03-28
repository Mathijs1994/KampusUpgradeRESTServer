/*
 * HvA licences apply
 */
package com.restfully.kampusupgrade.domain;

import java.util.ArrayList;

/**
 *
 * @author Mathijs
 */
public class Screen {
    int id;
    int screenRotation;
    String mac;
    int x;
    int y;
    ArrayList<Screen> neighbourList;
    int buildingID;
    String buildingname;
    String buildingstreet;
    int buildingNo;
    String City;
    String Postal_code;
    int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreenRotation() {
        return screenRotation;
    }

    public void setScreenRotation(int screenRotation) {
        this.screenRotation = screenRotation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Screen> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(ArrayList<Screen> neighbourList) {
        this.neighbourList = neighbourList;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getBuildingstreet() {
        return buildingstreet;
    }

    public void setBuildingstreet(String buildingstreet) {
        this.buildingstreet = buildingstreet;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPostal_code() {
        return Postal_code;
    }

    public void setPostal_code(String Postal_code) {
        this.Postal_code = Postal_code;
    }
  
    
    
}
