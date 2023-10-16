package com.arslanefimov.lab2.servlets;

import com.arslanefimov.lab2.model.AllTableData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "ClearDataServlet", value = "/clear_data")
public class ClearDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AllTableData tableData = (AllTableData) request.getSession().getAttribute("tableDataList");
        if(tableData!=null){
            request.getSession().removeAttribute("tableDataList");
        }
    }
}
