
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection  {
    Connection con = null;
    String url="jdbc:mysql://localhost:3306/pos";
    String user="root";
    String pass="";
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
           
        } catch (Exception e) {
            System.out.println("error:");
            System.out.println(e);
        }      
        return con;   
    }



  
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
