package com.good.vo;

import com.jdbc.Conn;

import java.sql.*;
import java.util.ArrayList;

public class Good {
    private String goodId;
    private String goodName;
    private String Price;
    private String description;
    private boolean freeze;
    private boolean isPurchased;
    private boolean isOnline;
    private String userid;
    private ArrayList<String> pictures;

    public Good() {
    }

    public Good(String goodId, String goodName, String description, boolean freeze, boolean isPurchased, boolean isOnline, String userid) throws SQLException, ClassNotFoundException {
        this.goodId = goodId;
        this.goodName = goodName;
        this.description = description;
        this.freeze = freeze;
        this.isPurchased = isPurchased;
        this.isOnline = isOnline;
        this.userid = userid;
        setPictures();
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFreeze() {
        return freeze;
    }

    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures() throws SQLException, ClassNotFoundException {
        ArrayList<String> pictures = new ArrayList<String>();
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql = "select picture from goodpicture,good where goodpicture.goodid=good.goodid";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            pictures.add(res.getString("picture"));
        }
        this.pictures = pictures;
    }
}
