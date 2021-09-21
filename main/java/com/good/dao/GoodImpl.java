package com.good.dao;

import com.good.vo.Good;
import com.jdbc.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodImpl implements GoodDao{


    @Override
    public ArrayList<Good> getGoods() throws SQLException, ClassNotFoundException {
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql = "select * from good where isonline = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBoolean(1,true);
        ResultSet res = pstmt.executeQuery();
        ArrayList<Good> gls = new ArrayList<>();
        Good g;
        while(res.next()) {
            g = new Good(res.getString("goodid"),res.getString("goodname"),res.getString("description"),res.getBoolean("freeze"),res.getBoolean("ispurchased"),res.getBoolean("isonline"),res.getString("userid"));
            gls.add(g);
        }
        res.close();
        pstmt.close();
        conn.close();
        return gls;
    }

    @Override
    public void releaseGood(String goodname, String description, ArrayList<String> goodpicture) throws SQLException, ClassNotFoundException {
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql = "insert into good(goodname,description,freeze,ispurchased,isonline,userid) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,goodname);
        pstmt.setString(2,description);
        pstmt.setBoolean(3,false);
        pstmt.setBoolean(4,false);
        pstmt.setBoolean(5,true);
        pstmt.setString(6,null);
        pstmt.execute();
        pstmt.close();
        conn.close();
    }

    @Override
    public void offLoadGood(String goodid) throws SQLException, ClassNotFoundException {
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql1 = "update good set isonline = ? where goodid = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        pstmt1.setBoolean(1,false);
        pstmt1.setString(2,goodid);
        pstmt1.execute();
        pstmt1.close();
        conn.close();
    }

    @Override
    public ArrayList<Good> viewHisGood() throws SQLException, ClassNotFoundException {
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql = "select * from good where isonline = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBoolean(1,false);
        ResultSet res = pstmt.executeQuery();
        ArrayList<Good> gls = new ArrayList<>();
        Good g;
        while(res.next()){
            g = new Good(res.getString("goodid"),res.getString("goodname"),res.getString("description"),res.getBoolean("freeze"),res.getBoolean("ispurchased"),res.getBoolean("isonline"),res.getString("userid"));
            gls.add(g);
        }
        pstmt.close();
        conn.close();
        return gls;
    }

    @Override
    public void freezeGood(String goodid, String userid) throws SQLException, ClassNotFoundException {
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql1 = "update good set freeze = true where goodid = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        pstmt1.setString(1,goodid);
        pstmt1.execute();
        pstmt1.close();
        String sql2 = "update transaction set ischosen = ? where goodid = ? and userid = ?";
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
        pstmt2.setBoolean(1,true);
        pstmt2.setString(2,goodid);
        pstmt2.setString(3,userid);
        pstmt2.execute();
        pstmt2.close();
        conn.close();
    }

    @Override
    public void goodBackOnline(String goodid) throws SQLException, ClassNotFoundException {
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql1 = "update good set freeze = false where goodid = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        pstmt1.setString(1,goodid);
        pstmt1.execute();
        pstmt1.close();
        String sql2 = "update transaction set ischosen = ? where goodid = ? and ischosen = ?";
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
        pstmt2.setBoolean(1,false);
        pstmt2.setString(2,goodid);
        pstmt2.setBoolean(3,true);
        pstmt2.execute();
        pstmt2.close();
        conn.close();
    }

    @Override
    public void transactionSuccess(String goodid) throws SQLException, ClassNotFoundException {
        Conn c = new Conn();
        Connection conn = c.connection();
        String sql1 = "update good set isonline = ? where goodid = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        pstmt1.setBoolean(1,false);
        pstmt1.setString(2,goodid);
        pstmt1.execute();
        pstmt1.close();
        conn.close();
    }
}
