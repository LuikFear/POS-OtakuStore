/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Clientes;
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
public class ClientesDAORelacional implements DAOCLientesInterface{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();

    @Override
    public LinkedList<Clientes> listar() {
       
          String sql = "select * from clientes";
           
           LinkedList<Clientes> listar = new LinkedList<>();
            
        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
               
                   listar.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
       
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    
    
    }

    @Override
    public Clientes obtener_cliente(int codigo) {
         String sql = "select * from clientes where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    

    @Override
    public void crear_cliente(Clientes cliente) {
       String sql = "insert into clientes (codigo,nombre,nit,correo,genero) values (?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setInt(3, cliente.getNit());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getGenero());
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar_cliente(Clientes cliente) {
         String sql = "update clientes set nombre=?, nit=?, correo=?, genero=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getNit());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getGenero());
            ps.setInt(5, cliente.getCodigo());
       

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar_cliente(int codigo) {
         String sql = "DELETE FROM clientes WHERE codigo = ?;";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e);
        }
    }
    
    private String leerarchivoC() {
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
        ClientesDAORelacional js = new ClientesDAORelacional();
            js.expPDFC();
            
    }
            
        
        
        
    public void carga_masivaC() throws FileNotFoundException, IOException, ParseException, SQLException {
        
        String archivo_retorno = leerarchivoC();
    JsonParser parse = new JsonParser();
    JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

    
    try {
       String sql = "insert into clientes (codigo,nombre,nit,correo,genero) values (?,?,?,?,?);";
       

        for (int i = 0; i < matriz.size(); i++) {
            JsonObject object = matriz.get(i).getAsJsonObject();

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
         
            ps.setString(2, object.get("nombre").getAsString());
            ps.setInt(3, object.get("nit").getAsInt());
            ps.setString(4, object.get("correo").getAsString());
            ps.setString(5, object.get("genero").getAsString());
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

      public void expPDFC() {
        Document file = new Document();
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        try {

            FileOutputStream gen = new FileOutputStream("Listado Oficial Clientes.pdf");

            PdfWriter.getInstance(file, gen);
            file.open();

            Paragraph titulo = new Paragraph("Listado Clientes");
            titulo.setAlignment(Element.ALIGN_CENTER);

            file.add(titulo);

            Paragraph fecha = new Paragraph(fechaFormateada);
            fecha.setAlignment(Element.ALIGN_CENTER);

            file.add(fecha);

            file.add(new Paragraph("\n"));
            PdfPTable col = new PdfPTable(5);
            col.setWidthPercentage(100);

            float[] cAn = {0.30f, 0.60f, 0.40f, 0.90f, 0.60f};
            col.setWidths(cAn);

            Font fontHeader = FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK);

            PdfPCell celdacodigo = new PdfPCell(new Phrase("codigo", fontHeader));
            celdacodigo.setBackgroundColor(new BaseColor(255, 120, 223));
            col.addCell(celdacodigo);

            PdfPCell celdaNombre = new PdfPCell(new Phrase("Nombre", fontHeader));
            celdaNombre.setBackgroundColor(new BaseColor(171, 255, 171));
            col.addCell(celdaNombre);

            PdfPCell celdaCaja = new PdfPCell(new Phrase("nit", fontHeader));
            celdaCaja.setBackgroundColor(new BaseColor(255, 255, 171));
            col.addCell(celdaCaja);

            PdfPCell celdaVentas = new PdfPCell(new Phrase("correo", fontHeader));
            celdaVentas.setBackgroundColor(new BaseColor(171, 171, 255));
            col.addCell(celdaVentas);

            PdfPCell celdaGenero = new PdfPCell(new Phrase("genero", fontHeader));
            celdaGenero.setBackgroundColor(new BaseColor(255, 102, 102));
            col.addCell(celdaGenero);

            

            try {
                String sql = "select * from clientes";
                con = acceso.Conectar();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        col.addCell(Integer.toString(rs.getInt(1)));
                        col.addCell(rs.getString(2));
                       col.addCell(Integer.toString(rs.getInt(3)));
                       col.addCell(rs.getString(4));
                        col.addCell(rs.getString(5));
                        
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
            File sucursales_file = new File("Listado Oficial clientes.pdf");
            Desktop.getDesktop().open(sucursales_file);
        } catch (Exception e) {
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}

    
    
    
    
    
   