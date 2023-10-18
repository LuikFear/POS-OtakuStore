
package DAO;


import MODEL.Sucursales;
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




public class SucursalesDAORelacional {
    
     Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();
    
    public LinkedList<Sucursales> listar() {
       
          String sql = "select * from sucursales";
           
           LinkedList<Sucursales> listar = new LinkedList<>();
            
        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
               
                   listar.add(new Sucursales(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
       
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    
    
    }
    
     public Sucursales obtener_sucursal(int codigo) {
         String sql = "select * from sucursales where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Sucursales(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void crear_sucursal(Sucursales sucursal) {
       String sql = "insert into sucursales (codigo,nombre,direccion,correo,telefono) values (?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, sucursal.getCodigo());
            ps.setString(2, sucursal.getNombre());
            ps.setString(3, sucursal.getDireccion());
            ps.setString(4, sucursal.getCorreo());
            ps.setInt(5, sucursal.getTelefono());
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     public void modificar_sucursal(Sucursales sucursal) {
         String sql = "update sucursales set nombre=?, direccion=?, correo=?, telefono=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, sucursal.getNombre());
            ps.setString(2, sucursal.getDireccion());
            ps.setString(3, sucursal.getCorreo());
            ps.setInt(4, sucursal.getTelefono());
            ps.setInt(5, sucursal.getCodigo());
       

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
     public void eliminar_sucursal(int codigo) {
         String sql = "DELETE FROM sucursales WHERE codigo = ?;";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e);
        }
    }
    
    
     private String leerarchivoS() {
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
        SucursalesDAORelacional js = new SucursalesDAORelacional();
            js.expPDFS();
            
    }
        
        
        
        
    public void carga_masivaS() throws FileNotFoundException, IOException, ParseException, SQLException {
        
        String archivo_retorno = leerarchivoS();
    JsonParser parse = new JsonParser();
    JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

    
    try {
       String sql = "insert into sucursales (codigo,nombre,direccion,correo,telefono) values (?,?,?,?,?);";
       

        for (int i = 0; i < matriz.size(); i++) {
            JsonObject object = matriz.get(i).getAsJsonObject();

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
         
            ps.setString(2, object.get("nombre").getAsString());
            ps.setString(3, object.get("direccion").getAsString());
            ps.setString(4, object.get("correo").getAsString());
            ps.setInt(5, object.get("telefono").getAsInt());
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

      public void expPDFS() {
        Document file = new Document();
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        try {

            FileOutputStream gen = new FileOutputStream("Listado Oficial Sucursales.pdf");

            PdfWriter.getInstance(file, gen);
            file.open();

            Paragraph titulo = new Paragraph("Listado Sucursales");
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

            PdfPCell celdaCaja = new PdfPCell(new Phrase("Direccion", fontHeader));
            celdaCaja.setBackgroundColor(new BaseColor(255, 255, 171));
            col.addCell(celdaCaja);

            PdfPCell celdaVentas = new PdfPCell(new Phrase("Correo", fontHeader));
            celdaVentas.setBackgroundColor(new BaseColor(171, 171, 255));
            col.addCell(celdaVentas);

            PdfPCell celdaGenero = new PdfPCell(new Phrase("Telefono", fontHeader));
            celdaGenero.setBackgroundColor(new BaseColor(255, 102, 102));
            col.addCell(celdaGenero);

            

            try {
                String sql = "select * from sucursales";
                con = acceso.Conectar();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        col.addCell(Integer.toString(rs.getInt(1)));
                        col.addCell(rs.getString(2));
                        col.addCell(rs.getString(3));
                      col.addCell(rs.getString(4));
                        col.addCell(Integer.toString(rs.getInt(5)));
                        
                    } while (rs.next());
                    file.add(col);
                }
            } catch (DocumentException | SQLException e) {
            }
            file.close();
            JOptionPane.showMessageDialog(null, "PDF Listo para vizualisar");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
        try {
            File sucursales_file = new File("Listado Oficial Sucursales.pdf");
            Desktop.getDesktop().open(sucursales_file);
        } catch (Exception e) {
        }
    }
    
    
}
