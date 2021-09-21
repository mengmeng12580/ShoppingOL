package com.good.test;

import com.good.dao.GoodDao;
import com.good.dao.GoodImpl;
import com.good.vo.Good;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Good g1 = new Good("00002","2",null,false,false,false,null);
        GoodDao gdl = new GoodImpl();
       // ArrayList<Good> gls = gdl.getGoods();
        //gdl.releaseGood("test","test");
//        Iterator<Good> it = gls.iterator();
//        Good g = null;
//        while(it.hasNext()){
//            g = it.next();
//            System.out.println(g.getGoodId()+"-"+g.isFreeze());
//        }
    }
}
