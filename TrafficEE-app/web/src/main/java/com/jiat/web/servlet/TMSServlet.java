package com.jiat.web.servlet;

import ejb.remote.TrafficRoot;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "TMSServlet", value = "/tms")
public class TMSServlet extends HttpServlet {
    TrafficRoot root;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        try {
            InitialContext context = new InitialContext();
            HttpSession session = request.getSession();
            if (session.getAttribute("session") == null){
                root = (TrafficRoot) context.lookup("java:global/ear/app/TrafficRootBean");
                session.setAttribute("session",root);
            }else {
                root = (TrafficRoot) session.getAttribute("session");
            }


//        response.getWriter().println("vehicle count :"+ );

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
