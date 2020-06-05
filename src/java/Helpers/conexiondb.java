package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexiondb {
    boolean error;
    Connection conexion = null;
    PreparedStatement st=null;
    ResultSet rs=null;
    String todo=null;

 ////////////////////////////////////////////////////////////////////////////////////   
     public Connection DBConnection() {
		 try {
            //Establecer datos de conexion
            Class.forName("org.postgresql.Driver");
            String  url="jdbc:postgresql://localhost:5432/conexion";
            conexion = DriverManager.getConnection(url,"Raul","Raul");
		}
		 catch (SQLException e) {
			System.out.println("Ha ocurrido el siguiente error con la BD:" + e.getMessage());
			error = true;
		}catch(ClassNotFoundException ex) {
            System.out.print("Ocurri� un error con los drivers.");
            error = true;
            }
	 return conexion;
   	 }   
////////////////////////////////////////////////////////////////////////////////////
      public Connection cerrarconexion() { 
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      return conexion;
      }

    ////////////////////////////////////////////////////////////////////////////////////  
      public void crear(String c, int a, String d, String e, String b){
          
        try {
            st = conexion.prepareCall("INSERT INTO usuario VALUES(?, ?, ?, ?, ?)");
            st.setString(1, c);
            st.setInt(2, a);
            st.setString(3, d);
            st.setString(4, e);
            st.setString(5, b);
            rs = st.executeQuery();
            
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
      }
      //////////////////////////////////////////////////////////////////////////////////////
      
      public void borrar (String j, String m){
          
        try {
            st = conexion.prepareCall("DELETE FROM usuario WHERE email= ? and contras = ?");
            st.setString(1, j);
            st.setString(2, m);
            rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
