package com.arslanefimov.lab2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "СontrollerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    response.setContentType("text/html");

        String x = request.getParameter("X");
        String y = request.getParameter("Y");
        String r = request.getParameter("R");
        String event = request.getParameter("event");

    log(x);
    log(y);
    log(r);
        if(x!=null && y!=null && r!=null && event==null){
            getServletContext().getRequestDispatcher("/area_check").forward(request, response);
        } else {
            log("gg");
            getServletContext().getRequestDispatcher("/clear_data").forward(request, response);

        }

}

}
