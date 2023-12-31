/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import javax.swing.JComboBox;


public class Clientes {
    private int codigo;
    private String nombre;
    private int nit;
    private String correo;
    private String genero;
    private JComboBox combo;

    public Clientes(String nombre, int nit, String correo, String genero, JComboBox combo) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.genero = genero;
        this.combo = combo;
    }
    
    public Clientes(int codigo, String nombre, int nit, String correo, String genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.genero = genero;
    }

    public Clientes(String nombre, int nit, String correo, String genero) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.genero = genero;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
  
    
    public Clientes(){}
    
}
