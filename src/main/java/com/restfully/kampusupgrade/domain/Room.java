/*
 * HvA licences apply
 */
package com.restfully.kampusupgrade.domain;

/**
 *
 * @author Mathijs
 */
public class Room {
    int id;
    int no;
    String name;
    int floor;
    int yCoordinate;
    int xCoordinate;
    int buildingID;
    String buildingname;
    String buildingstreet;
    String buildingNo;
    String buildingCity;
    String buildingPostal_code;
    String wing;

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
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

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getBuildingCity() {
        return buildingCity;
    }

    public void setBuildingCity(String buildingCity) {
        this.buildingCity = buildingCity;
    }

    public String getBuildingPostal_code() {
        return buildingPostal_code;
    }

    public void setBuildingPostal_code(String buildingPostal_code) {
        this.buildingPostal_code = buildingPostal_code;
    }
            
    
    
}
