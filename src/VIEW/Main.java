/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import java.sql.Connection;
import MODEL.Clientes;

import DAO.ClientesDAORelacional;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.VendedoresDAORelacional;
import DAO.DAOCLientesInterface;
import DAO.ProductosDAORelacional;
import DAO.SucursalesDAORelacional;
import MODEL.Vendedores;

import DAO.VendedoresDAORelacional;
import MODEL.Productos;
import MODEL.Sucursales;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {
//tables

    DefaultTableModel tablaC;
    DefaultTableModel tablaV;
    DefaultTableModel tablaP;
    DefaultTableModel tablaS;
    int filaV = -1;
    int filaP = -1;
    int filaC = -1;
    int filaS = -1;
    VendedoresDAORelacional daoV = new VendedoresDAORelacional();
    ProductosDAORelacional daoP = new ProductosDAORelacional();
    ClientesDAORelacional daoC = new ClientesDAORelacional();
    SucursalesDAORelacional daoS = new SucursalesDAORelacional();

    public Main() {
        initComponents();
        datosC();
        datosV();
        datosP();
        datosS();
        this.setLocationRelativeTo(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Vtable = new javax.swing.JTable();
        B1crear = new javax.swing.JButton();
        B2Cargar = new javax.swing.JButton();
        B3Update = new javax.swing.JButton();
        B4Delete = new javax.swing.JButton();
        B5Export = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Productos = new javax.swing.JPanel();
        B5Export4 = new javax.swing.JButton();
        B3UpdateP = new javax.swing.JButton();
        B4Delete4 = new javax.swing.JButton();
        B2Cargar4 = new javax.swing.JButton();
        B1crearP = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Ptable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Clientes = new javax.swing.JPanel();
        Scroll = new javax.swing.JScrollPane();
        Ctable = new javax.swing.JTable();
        B1crear3 = new javax.swing.JButton();
        B2Cargar3 = new javax.swing.JButton();
        B4Delete3 = new javax.swing.JButton();
        B3Update3 = new javax.swing.JButton();
        B5Export3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Sucursales = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Stable = new javax.swing.JTable();
        B1crear1 = new javax.swing.JButton();
        B2Cargar1 = new javax.swing.JButton();
        B4Delete1 = new javax.swing.JButton();
        B3Update1 = new javax.swing.JButton();
        B5Export1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(236, 161, 172));

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/cerrar-sesion (3) (1).png"))); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        Vtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Caja", "Ventas", "Genero"
            }
        ));
        jScrollPane1.setViewportView(Vtable);

        B1crear.setText("Crear");
        B1crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1crearActionPerformed(evt);
            }
        });

        B2Cargar.setText("Carga Masiva");
        B2Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2CargarActionPerformed(evt);
            }
        });

        B3Update.setText("Actualizar");
        B3Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3UpdateActionPerformed(evt);
            }
        });

        B4Delete.setText("Eliminar");
        B4Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4DeleteActionPerformed(evt);
            }
        });

        B5Export.setText("Exportar listado a PDF");
        B5Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ExportActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/Bocho perfil.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(B5Export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(B1crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B3Update, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B2Cargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B4Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B1crear, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B3Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B4Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(B5Export, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        Tabs.addTab("Vendedores", jPanel2);

        Productos.setBackground(new java.awt.Color(255, 255, 204));

        B5Export4.setText("Exportar listado a PDF");
        B5Export4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5Export4ActionPerformed(evt);
            }
        });

        B3UpdateP.setText("Actualizar");
        B3UpdateP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3UpdatePActionPerformed(evt);
            }
        });

        B4Delete4.setText("Eliminar");
        B4Delete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4Delete4ActionPerformed(evt);
            }
        });

        B2Cargar4.setText("Carga Masiva");
        B2Cargar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2Cargar4ActionPerformed(evt);
            }
        });

        B1crearP.setText("Crear");
        B1crearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1crearPActionPerformed(evt);
            }
        });

        Ptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Cantidad", "Precio"
            }
        ));
        jScrollPane5.setViewportView(Ptable);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/Nijika perfil.png"))); // NOI18N

        javax.swing.GroupLayout ProductosLayout = new javax.swing.GroupLayout(Productos);
        Productos.setLayout(ProductosLayout);
        ProductosLayout.setHorizontalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosLayout.createSequentialGroup()
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addGap(111, 111, 111)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(B5Export4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ProductosLayout.createSequentialGroup()
                                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(B1crearP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(B3UpdateP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(B2Cargar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(B4Delete4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProductosLayout.setVerticalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B1crearP, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2Cargar4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B3UpdateP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B4Delete4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(B5Export4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        Tabs.addTab("Productos", Productos);

        Clientes.setBackground(new java.awt.Color(153, 204, 255));

        Ctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "NIT", "Correo", "Genero"
            }
        ));
        Scroll.setViewportView(Ctable);

        B1crear3.setText("Crear");
        B1crear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1crear3ActionPerformed(evt);
            }
        });

        B2Cargar3.setText("Carga Masiva");
        B2Cargar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2Cargar3ActionPerformed(evt);
            }
        });

        B4Delete3.setText("Eliminar");
        B4Delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4Delete3ActionPerformed(evt);
            }
        });

        B3Update3.setText("Actualizar");
        B3Update3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3Update3ActionPerformed(evt);
            }
        });

        B5Export3.setText("Exportar listado a PDF");
        B5Export3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5Export3ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/Ryo perfil.png"))); // NOI18N

        javax.swing.GroupLayout ClientesLayout = new javax.swing.GroupLayout(Clientes);
        Clientes.setLayout(ClientesLayout);
        ClientesLayout.setHorizontalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesLayout.createSequentialGroup()
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClientesLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(B5Export3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ClientesLayout.createSequentialGroup()
                                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(B1crear3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(B3Update3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(B2Cargar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(B4Delete3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        ClientesLayout.setVerticalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientesLayout.createSequentialGroup()
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B1crear3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2Cargar3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B3Update3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B4Delete3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(B5Export3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClientesLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        Tabs.addTab("Clientes", Clientes);

        Sucursales.setBackground(new java.awt.Color(255, 153, 153));

        Stable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Direccion", "Correo", "Telefono"
            }
        ));
        jScrollPane2.setViewportView(Stable);

        B1crear1.setText("Crear");
        B1crear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1crear1ActionPerformed(evt);
            }
        });

        B2Cargar1.setText("Carga Masiva");
        B2Cargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2Cargar1ActionPerformed(evt);
            }
        });

        B4Delete1.setText("Eliminar");
        B4Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4Delete1ActionPerformed(evt);
            }
        });

        B3Update1.setText("Actualizar");
        B3Update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3Update1ActionPerformed(evt);
            }
        });

        B5Export1.setText("Exportar listado a PDF");
        B5Export1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5Export1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/Ikuyo perfil.png"))); // NOI18N

        javax.swing.GroupLayout SucursalesLayout = new javax.swing.GroupLayout(Sucursales);
        Sucursales.setLayout(SucursalesLayout);
        SucursalesLayout.setHorizontalGroup(
            SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SucursalesLayout.createSequentialGroup()
                .addGroup(SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SucursalesLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4)
                        .addGap(69, 69, 69)
                        .addGroup(SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(B5Export1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(SucursalesLayout.createSequentialGroup()
                                .addGroup(SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(B1crear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(B3Update1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(B2Cargar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(B4Delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(SucursalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        SucursalesLayout.setVerticalGroup(
            SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SucursalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SucursalesLayout.createSequentialGroup()
                        .addGroup(SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B1crear1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2Cargar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B3Update1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B4Delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(B5Export1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SucursalesLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );

        Tabs.addTab("Sucursales", Sucursales);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabs)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login Newframe = new Login();
        Newframe.setVisible(true);
        dispose();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void B1crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1crearActionPerformed


        CrearV Newframe = new CrearV();
        Newframe.setVisible(true);
        dispose();


    }//GEN-LAST:event_B1crearActionPerformed

    private void B2CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2CargarActionPerformed
         try {
        VendedoresDAORelacional dao = new VendedoresDAORelacional();
        dao.carga_masivaV();
         Main Newframe = new Main();
        Newframe.setVisible(true);
        dispose();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_B2CargarActionPerformed

    private void B3UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3UpdateActionPerformed
        filaV = Vtable.getSelectedRow();
        if (Vtable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una opcion", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Vtable.getValueAt(filaV, 0).toString());
            this.dispose();
            new ModV(daoV.obtener_vendedor(codigo)).setVisible(true);
        }


    }//GEN-LAST:event_B3UpdateActionPerformed

    private void B1crear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1crear1ActionPerformed
        
        CrearS Newframe = new CrearS();
        Newframe.setVisible(true);
        dispose();


    }//GEN-LAST:event_B1crear1ActionPerformed

    private void B2Cargar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2Cargar1ActionPerformed
          try {
        SucursalesDAORelacional dao = new SucursalesDAORelacional();
        dao.carga_masivaS();
         Main Newframe = new Main();
        Newframe.setVisible(true);
        dispose();
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    }//GEN-LAST:event_B2Cargar1ActionPerformed

    private void B3Update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3Update1ActionPerformed
       filaS = Stable.getSelectedRow();
        if (Stable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una opcion", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Stable.getValueAt(filaS, 0).toString());
            this.dispose();
            new ModS(daoS.obtener_sucursal(codigo)).setVisible(true);
        }
    }//GEN-LAST:event_B3Update1ActionPerformed

    private void B1crear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1crear3ActionPerformed

        CrearC Newframe = new CrearC();
        Newframe.setVisible(true);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_B1crear3ActionPerformed

    private void B2Cargar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2Cargar3ActionPerformed
         try {
        ClientesDAORelacional dao = new ClientesDAORelacional();
        dao.carga_masivaC();
         Main Newframe = new Main();
        Newframe.setVisible(true);
        dispose();
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    }//GEN-LAST:event_B2Cargar3ActionPerformed

    private void B3Update3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3Update3ActionPerformed
        filaC = Ctable.getSelectedRow();
        if (Ctable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una opcion", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Ctable.getValueAt(filaC, 0).toString());
            this.dispose();
            new ModC(daoC.obtener_cliente(codigo)).setVisible(true);
        }


    }//GEN-LAST:event_B3Update3ActionPerformed

    private void B3UpdatePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3UpdatePActionPerformed
        filaP = Ptable.getSelectedRow();
        if (Ptable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una opcion", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Ptable.getValueAt(filaP, 0).toString());
            this.dispose();
            new ModP(daoP.obtener_pro(codigo)).setVisible(true);
        }

    }//GEN-LAST:event_B3UpdatePActionPerformed

    private void B2Cargar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2Cargar4ActionPerformed
      try {
       ProductosDAORelacional dao = new ProductosDAORelacional ();
        dao.carga_masivaP();
           Main Newframe = new Main();
        Newframe.setVisible(true);
        dispose();

    } catch (Exception e) {
        e.printStackTrace();
        
    }
    }//GEN-LAST:event_B2Cargar4ActionPerformed
//Crear Producto
    private void B1crearPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1crearPActionPerformed

        CrearP Newframe = new CrearP();
        Newframe.setVisible(true);
        dispose();


    }//GEN-LAST:event_B1crearPActionPerformed

    private void B4DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4DeleteActionPerformed
        filaV = Vtable.getSelectedRow();
        if (Vtable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una fila", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Vtable.getValueAt(filaV, 0).toString());
            daoV.eliminar_vendedor(codigo);
            this.dispose();
            new Main().setVisible(true);
        }

    }//GEN-LAST:event_B4DeleteActionPerformed

    private void B4Delete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4Delete4ActionPerformed
        filaP = Ptable.getSelectedRow();
        if (Ptable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una fila", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Ptable.getValueAt(filaP, 0).toString());
            daoP.eliminar_pro(codigo);
            this.dispose();
            new Main().setVisible(true);
        }
    }//GEN-LAST:event_B4Delete4ActionPerformed

    private void B4Delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4Delete3ActionPerformed
        filaC = Ctable.getSelectedRow();
        if (Ctable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una fila", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Ctable.getValueAt(filaC, 0).toString());
            daoC.eliminar_cliente(codigo);
            this.dispose();
            new Main().setVisible(true);
        }

    }//GEN-LAST:event_B4Delete3ActionPerformed

    private void B4Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4Delete1ActionPerformed
           filaS = Stable.getSelectedRow();
        if (Stable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Elige una fila", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            int codigo = Integer.parseInt(Stable.getValueAt(filaS, 0).toString());
            daoS.eliminar_sucursal(codigo);
            this.dispose();
            new Main().setVisible(true);
        }


    }//GEN-LAST:event_B4Delete1ActionPerformed

    private void B5ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ExportActionPerformed
       
         try {
        VendedoresDAORelacional daoI = new VendedoresDAORelacional();
        daoI.expPDF();
        
    } catch (Exception e) {
        e.printStackTrace();
        
    }
        
       
        
        
    }//GEN-LAST:event_B5ExportActionPerformed

    private void B5Export4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5Export4ActionPerformed
     
        
         try {
       ProductosDAORelacional dao = new ProductosDAORelacional();
        dao.expPDFP();
        
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    }//GEN-LAST:event_B5Export4ActionPerformed

    private void B5Export1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5Export1ActionPerformed
        
         try {
     SucursalesDAORelacional dao = new SucursalesDAORelacional();
        dao.expPDFS();
        
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    }//GEN-LAST:event_B5Export1ActionPerformed

    private void B5Export3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5Export3ActionPerformed
         try {
     ClientesDAORelacional dao = new ClientesDAORelacional();
        dao.expPDFC();
        
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    }//GEN-LAST:event_B5Export3ActionPerformed
    
    
    
    
    
    

    
    
    
    
    
  public void informacion(Vendedores ven) {
    if (ven.getCodigo() <= 1) {
        Venderdor Newframe = new Venderdor();
        Newframe.setVisible(true);
        dispose();
    }
}
    


    private void datosC() {
        String columnas[] = {"codigo", "nombre", "nit", "correo", "genero"};
        tablaC = new DefaultTableModel(null, columnas);
        ClientesDAORelacional CLDAO = new ClientesDAORelacional();

        for (Clientes dat : CLDAO.listar()) {
            Object help[] = new Object[5];
            help[0] = dat.getCodigo();
            help[1] = dat.getNombre();
            help[2] = dat.getNit();
            help[3] = dat.getCorreo();
            help[4] = dat.getGenero();
            tablaC.addRow(help);
        }
        Ctable.setModel(tablaC);
    }

    private void datosV() {
        String columnas[] = {"codigo", "nombre", "caja", "ventas", "genero"};
        tablaV = new DefaultTableModel(null, columnas);
        VendedoresDAORelacional VEDAO = new VendedoresDAORelacional();

        for (Vendedores dat : VEDAO.listarV()) {
            Object help[] = new Object[5];
            help[0] = dat.getCodigo();
            help[1] = dat.getNombre();
            help[2] = dat.getCaja();
            help[3] = dat.getVentas();
            help[4] = dat.getGenero();
            tablaV.addRow(help);
        }
        Vtable.setModel(tablaV);
    }

    private void datosP() {
        String columnas[] = {"codigo", "nombre", "descripcion", "cantidad", "precio"};
        tablaP = new DefaultTableModel(null, columnas);
        ProductosDAORelacional PRDAO = new ProductosDAORelacional();

        for (Productos dat : PRDAO.listarP()) {
            Object help[] = new Object[5];
            help[0] = dat.getCodigo();
            help[1] = dat.getNombre();
            help[2] = dat.getDescripcion();
            help[3] = dat.getCantidad();
            help[4] = dat.getPrecio();
            tablaP.addRow(help);
        }
        Ptable.setModel(tablaP);
    }

      private void datosS() {
        String columnas[] = {"codigo", "nombre", "Direccion", "correo", "telefono"};
        tablaS = new DefaultTableModel(null, columnas);
        SucursalesDAORelacional SUDAO = new SucursalesDAORelacional();

        for (Sucursales dat : SUDAO.listar()) {
            Object help[] = new Object[5];
            help[0] = dat.getCodigo();
            help[1] = dat.getNombre();
            help[2] = dat.getDireccion();
            help[3] = dat.getCorreo();
            help[4] = dat.getTelefono();
            tablaS.addRow(help);
        }
        Stable.setModel(tablaS);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1crear;
    private javax.swing.JButton B1crear1;
    private javax.swing.JButton B1crear3;
    private javax.swing.JButton B1crearP;
    private javax.swing.JButton B2Cargar;
    private javax.swing.JButton B2Cargar1;
    private javax.swing.JButton B2Cargar3;
    private javax.swing.JButton B2Cargar4;
    private javax.swing.JButton B3Update;
    private javax.swing.JButton B3Update1;
    private javax.swing.JButton B3Update3;
    private javax.swing.JButton B3UpdateP;
    private javax.swing.JButton B4Delete;
    private javax.swing.JButton B4Delete1;
    private javax.swing.JButton B4Delete3;
    private javax.swing.JButton B4Delete4;
    private javax.swing.JButton B5Export;
    private javax.swing.JButton B5Export1;
    private javax.swing.JButton B5Export3;
    private javax.swing.JButton B5Export4;
    private javax.swing.JPanel Clientes;
    private javax.swing.JTable Ctable;
    private javax.swing.JPanel Productos;
    private javax.swing.JTable Ptable;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JTable Stable;
    private javax.swing.JPanel Sucursales;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JTable Vtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

   
}
