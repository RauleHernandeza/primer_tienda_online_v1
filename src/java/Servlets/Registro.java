package Servlets;

import Helpers.conexiondb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.Statement;


public class Registro extends HttpServlet {
  String todo;
  Statement st;
  ResultSet rs;
  
  
 
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
//< > 
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.crear(request.getParameter("email"), request.getIntHeader("ci"),
        request.getParameter("contras"),request.getParameter("nombre"),request.getParameter("apellido"));
        con.cerrarconexion();
        
        processRequest(request, response);
        request.getRequestDispatcher("exit.html").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); 
        
    }
    

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.borrar(req.getParameter("emaill"), req.getParameter("contrass"));
        super.doDelete(req, resp); 
        req.getRequestDispatcher("exit.html").forward(req, resp);
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
//como sobreescribir el metodo