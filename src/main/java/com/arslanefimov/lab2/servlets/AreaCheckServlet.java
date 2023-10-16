package com.arslanefimov.lab2.servlets;

import com.arslanefimov.lab2.model.AllTableData;
import com.arslanefimov.lab2.model.TableData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "AreaCheckServlet", value = "/area_check")
public class AreaCheckServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long executeStartTime = System.nanoTime();
        double x = 0;
        double y = 0;
        double r = 0;
        DecimalFormat df = new DecimalFormat("#.###");

        try {
            x = Double.parseDouble(df.format(Double.parseDouble(request.getParameter("X"))).replace(",", "."));
            y = Double.parseDouble(df.format(Double.parseDouble(request.getParameter("Y"))).replace(",", "."));
            r = Double.parseDouble(df.format(Double.parseDouble(request.getParameter("R"))).replace(",", "."));
        }catch (NumberFormatException ex){
            response.sendRedirect("jsp/badRequest.jsp");
            getServletContext().getRequestDispatcher("jsp/badRequest.jsp").forward(request, response);
        }

        boolean result = checkResult(x, y, r);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'Time: 'HH:mm:ss");
        String formatterData = dateTime.format(formatter);

        final HttpSession session = request.getSession();
        AllTableData tableData = (AllTableData) session.getAttribute("tableDataList");
        if(tableData == null){
            tableData = new AllTableData();
        }
        long endExecuteTime = System.nanoTime();
        long executeTime = endExecuteTime-executeStartTime;
        TableData data = new TableData(x, y, r, result, executeTime,formatterData);
        tableData.addData(data);

        session.setAttribute("tableDataList", tableData);
        setAttributes(x, y, r, formatterData, executeTime, result, request);

        response.sendRedirect("jsp/result.jsp");



    }

    private void setAttributes(double x, double y, double r, String dateTime, long executeTime, boolean result, HttpServletRequest request){
        request.getSession().setAttribute("nextX", x);
        request.getSession().setAttribute("nextY", y);
        request.getSession().setAttribute("nextR", r);
        request.getSession().setAttribute("nextDateTime", dateTime);
        request.getSession().setAttribute("nextExecuteTime", executeTime);
        request.getSession().setAttribute("nextResult", result ? "<span class = \"hit\">Попадание</span>" : "<span class = \"miss\">Промах</span>");
    }

    private boolean checkResult(double x, double y, double r){
        return (checkRectangle(x, y, r) || checkTriangle(x, y, r) || checkCircle(x, y, r));
    }

    private boolean checkRectangle(double x, double y, double r){
        return ((x>=0 && y<=0 ) && (y >=-r) && (x <= (r/2)));
    }

    private boolean checkTriangle(double x, double y, double r){
        return ((x>=0 && y>+0) && (r >= Math.abs(x) + Math.abs(y)));
    }

    private boolean checkCircle(double x, double y, double r){
        return ((x <= 0 && y >= 0) && (Math.pow(r, 2) >= Math.pow(x, 2) + Math.pow(y, 2)));
    }
}
