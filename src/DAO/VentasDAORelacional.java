/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import MODEL.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author LuikFear
 */
public class VentasDAORelacional {
      
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();

    
    public LinkedList<Ventas> listar() {
       
          String sql = "select * from ventas";
           
           LinkedList<Ventas> listar = new LinkedList<>();
            
        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
               
                   listar.add(new Ventas(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5)));
       
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    
    
    }
    
    
//    public void crear_venta(Ventas venta) {
//       String sql = "insert into ventas (nombre,nit,fecha,total) values (?,?,?,?,?);";
//        try {
//            con = acceso.Conectar();
//            ps = con.prepareStatement(sql);
//
//            //ps.setInt(1, venta.getCodigo);
//            ps.setString(2, venta.getNombre());
//            ps.setInt(3, venta.getNit());
//            ps.setString(4, venta.getFecha());
//            ps.setFloat(5, venta.getTotal());
//           
//
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    
    
     public void crear_venta(Ventas VEN) {
       String sql = "insert into ventas (nombre,nit,fecha,total) values (?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            //ps.setInt(1, venta.getCodigo);
            ps.setString(1, VEN.getNombre());
            ps.setInt(2, VEN.getNit());
            ps.setString(3, VEN.getFecha());
            ps.setFloat(4, VEN.getTotal());
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

   
    
}
