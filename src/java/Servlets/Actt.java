package Servlets;

import Helpers.conexiondb;
import Helpers.hash;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Actt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.crearp(request.getParameter("id"),request.getParameter("descrip"),request.getParameter("cate"));
        con.cerrarconexion();
        processRequest(request, response);
        request.getRequestDispatcher("exit.html").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
