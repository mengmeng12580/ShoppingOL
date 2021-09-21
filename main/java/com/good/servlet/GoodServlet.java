package com.good.servlet;

import com.good.dao.GoodDao;
import com.good.dao.GoodImpl;
import com.good.vo.Good;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "GoodServlet", value = "/GoodServlet")
public class GoodServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodDao gd = new GoodImpl();
        try {
            ArrayList<Good> gls = gd.getGoods();
            HttpSession hs = req.getSession();
            hs.setAttribute("releasedGoods",gls);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //resp.sendRedirect("");
    }
}
