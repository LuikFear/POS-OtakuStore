/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Clientes;
import MODEL.Productos;
import MODEL.Vendedores;
import MODEL.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class RA3DAORelacional {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();

    public Clientes consultar(String nombre, int nit, String correo, String genero) {
        String sql = "select * from clientes where nombre like ? or nit = ? or correo like ? or genero like ?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            ps.setInt(2, nit);
            ps.setString(3, "%" + correo + "%");
            ps.setString(4, "%" + genero + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(2));

            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void imprimirEnComboBox(ResultSet rs, JComboBox<String> despliegue) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        try {
            while (rs.next()) {
                String item = rs.getString(2);
                model.addElement(item);
            }
            despliegue.setModel(model);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        RA3DAORelacional js = new RA3DAORelacional();
        js.consultar("pedro", 2, "pe", "masculino");

    }

//    public void crear_venta(Ventas ven) {
//        String sql = "insert into ventas (no,codigo,nombre,cantidad,precio,subtotal) values (?,?,?,?,?,?);";
//        try {
//            con = acceso.Conectar();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, ven.getNo());
//            ps.setInt(1, ven.getCodigo());
//            ps.setString(2, ven.getNombre());
//            ps.setInt(3, ven.getCantidad());
//            ps.setFloat(4, ven.getPrecio());
//            ps.setFloat(5, ven.getSubtotal());
//
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
    public Productos obtener_pro(int codigo) {
        String sql = "select * from productos where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Productos(rs.getInt(1), rs.getString(2), rs.getFloat(5));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

//    public LinkedList<Ventas> listarP() {
//
//        String sql = "select * from Ventas";
//
//        LinkedList<Ventas> listarP = new LinkedList<>();
//
//        try {
//
//            con = acceso.Conectar();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//
//                listarP.add(new Ventas (rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getInt(4), rs.getFloat(5),rs.getFloat(6)));
//
//            }
//            return listarP;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return null;
//    }
    public LinkedList<Clientes> listarClientes(String nombre, int nit, String correo, String genero) {

        String sql = "SELECT * FROM clientes WHERE nombre LIKE '%" + nombre + "%' AND correo LIKE '%" + correo + "%' AND nit LIKE '%" + nit + "%' AND genero LIKE '%" + genero + "%';";
        try {
            LinkedList<Clientes> Listass = new LinkedList<>();
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Listass.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
            return Listass;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
//all
    public LinkedList<Productos> listarProductos() {
        String sql = "SELECT * FROM productos";
        LinkedList<Productos> listar = new LinkedList<>();
        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listar.add(new Productos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5)));
            }
            return listar;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void modificarProducto(int codigo, int cantidad) {
        String sql = "update productos set cantidad = cantidad-? WHERE codigo = ?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(2, codigo);
            ps.setInt(1, cantidad);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public LinkedList<Ventas> listarVentas(int no, int nit, String nombre, String fecha) {
        String sql = "SELECT * FROM ventas WHERE no LIKE '%" + no + "%' AND nombre LIKE '%" + nombre + "%' AND nit LIKE '%" + nit + "%' AND fecha LIKE '%" + fecha + "%' AND total LIKE '%%';";
        try {
            LinkedList<Ventas> ListarC = new LinkedList<>();
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListarC.add(new Ventas(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5)));
            }
            return ListarC;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

// public Clientes seleccionarCliente(String nombre, int nit, String correo, String genero) {
//    LinkedList<Clientes> listaClientes = listarClientes(nombre, nit, correo, genero);
//    Clientes SClient = null;
//  
//    if (listaClientes.size() > 0) {
//        SClient = listaClientes.getFirst();
//    }
//    
//    return SClient;
//}
    //solo 1
    public LinkedList<Productos> listarProducto(int Lpc) {
        String sql = "select codigo, nombre, cantidad, precio from productos where codigo= ?";

        try {
            LinkedList<Productos> listar = new LinkedList<>();
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Lpc);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                listar.add(new Productos(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getFloat(5)));
                return listar;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Articulo sin existencias");
        }
        return null;
    }
 
}
