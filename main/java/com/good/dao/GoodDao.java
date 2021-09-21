package com.good.dao;

import com.good.vo.Good;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GoodDao {
    public ArrayList<Good> getGoods() throws SQLException, ClassNotFoundException;
    public void releaseGood(String goodname, String description,ArrayList<String> goodpicture) throws SQLException, ClassNotFoundException;
    public void offLoadGood(String goodid) throws SQLException, ClassNotFoundException;
    public ArrayList<Good> viewHisGood() throws SQLException, ClassNotFoundException;
    public void freezeGood(String goodid,String userid) throws SQLException, ClassNotFoundException;
    public void goodBackOnline(String goodid) throws SQLException, ClassNotFoundException;
    public void transactionSuccess(String goodid) throws SQLException, ClassNotFoundException;
}
