/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Productos;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author LuikFear
 */
public class ProductosDAORelacional {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();
    
     public LinkedList<Productos> listarP() {

        String sql = "select * from productos";

        LinkedList<Productos> listarP = new LinkedList<>();

        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                listarP.add(new Productos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5)));

            }
            return listarP;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    
    
    
    public void crear_pro(Productos pro) {
        String sql = "insert into Productos (codigo,nombre,descripcion,cantidad,precio) values (?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getCantidad());
            ps.setFloat(5, pro.getPrecio());
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    } 
    
    
     public void modificar_pro(Productos pro) {
        String sql = "update productos set nombre=?,descripcion=?, cantidad=?, precio=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getCantidad());
            ps.setFloat(4, pro.getPrecio());
            ps.setInt(5, pro.getCodigo());
       

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    public Productos obtener_pro(int codigo) {
        String sql = "select * from productos where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Productos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    
    public void eliminar_pro(int codigo) {
        String sql = "DELETE FROM productos WHERE codigo = ?;";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e);
        }
    }
    
     private String leerarchivoP() {
        JFileChooser fc = new JFileChooser();
        JPanel datos = new JPanel();
        int op = fc.showOpenDialog(datos);
        String content = "";
        if (op == JFileChooser.APPROVE_OPTION) {
            File pRuta = fc.getSelectedFile();
            String ruta = pRuta.getAbsolutePath();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                archivo = new File(ruta);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea = "";

                while ((linea = br.readLine()) != null) {
                    content += linea + "\n";
                }
                return content;

            } catch (FileNotFoundException ex) {
                JOptionPane.showInputDialog(null, "No se encontro el archivo");
            } catch (IOException ex) {
                JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    JOptionPane.showInputDialog(null, "No se encontro el archivo");
                    return "";
                }
            }
            return content;
        }
        return null;
    }

        
        
        public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, SQLException {
        ProductosDAORelacional js = new ProductosDAORelacional();
            js.expPDFP();
            
    }
        
        
        
        
    public void carga_masivaP() throws FileNotFoundException, IOException, ParseException, SQLException {
        
        String archivo_retorno = leerarchivoP();
    JsonParser parse = new JsonParser();
    JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

    
    try {
       String sql = "insert into productos (codigo,nombre,descripcion,cantidad,precio) values (?,?,?,?,?);";
       

        for (int i = 0; i < matriz.size(); i++) {
            JsonObject object = matriz.get(i).getAsJsonObject();

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
         
            ps.setString(2, object.get("nombre").getAsString());
            ps.setString(3, object.get("descripcion").getAsString());
            ps.setInt(4, object.get("cantidad").getAsInt());
            ps.setFloat(5, object.get("precio").getAsFloat());
            ps.setInt(1, object.get("codigo").getAsInt());
            ps.executeUpdate();
        }
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
    
    
    
    }

    public void expPDFP() {
        Document file = new Document();
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        try {

            FileOutputStream gen = new FileOutputStream("Listado Oficial Productos.pdf");

            PdfWriter.getInstance(file, gen);
            file.open();

            Paragraph titulo = new Paragraph("Listado Productos");
            titulo.setAlignment(Element.ALIGN_CENTER);

            file.add(titulo);

            Paragraph fecha = new Paragraph(fechaFormateada);
            fecha.setAlignment(Element.ALIGN_CENTER);

            file.add(fecha);

            file.add(new Paragraph("\n"));
            PdfPTable col = new PdfPTable(5);
            col.setWidthPercentage(100);

            float[] cAn = {0.30f, 0.70f, 0.80f, 0.40f, 0.60f};
            col.setWidths(cAn);

            Font fontHeader = FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK);

            PdfPCell celdacodigo = new PdfPCell(new Phrase("codigo", fontHeader));
            celdacodigo.setBackgroundColor(new BaseColor(255, 120, 223));
            col.addCell(celdacodigo);

            PdfPCell celdaNombre = new PdfPCell(new Phrase("Nombre", fontHeader));
            celdaNombre.setBackgroundColor(new BaseColor(171, 255, 171));
            col.addCell(celdaNombre);

            PdfPCell celdaCaja = new PdfPCell(new Phrase("Descripcion", fontHeader));
            celdaCaja.setBackgroundColor(new BaseColor(255, 255, 171));
            col.addCell(celdaCaja);

            PdfPCell celdaVentas = new PdfPCell(new Phrase("cantidad", fontHeader));
            celdaVentas.setBackgroundColor(new BaseColor(171, 171, 255));
            col.addCell(celdaVentas);

            PdfPCell celdaGenero = new PdfPCell(new Phrase("precio", fontHeader));
            celdaGenero.setBackgroundColor(new BaseColor(255, 102, 102));
            col.addCell(celdaGenero);

            

            try {
                String sql = "select * from productos";
                con = acceso.Conectar();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        col.addCell(Integer.toString(rs.getInt(1)));
                        col.addCell(rs.getString(2));
                        col.addCell(rs.getString(3));
                      col.addCell(Integer.toString(rs.getInt(4)));
                        col.addCell(Integer.toString(rs.getInt(5)));
                        
                    } while (rs.next());
                    file.add(col);
                }
            } catch (DocumentException | SQLException e) {
            }
            file.close();
            JOptionPane.showMessageDialog(null, "PDF Creado");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
        try {
            File sucursales_file = new File("Listado Oficial Productos.pdf");
            Desktop.getDesktop().open(sucursales_file);
        } catch (Exception e) {
        }
    }
    
    
    
    
}

