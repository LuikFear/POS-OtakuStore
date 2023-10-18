/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author LuikFear
 */
public class Vendedores {
   
    private int codigo;
    private String nombre;
    private int caja;
    private int ventas;
    private String genero;
    private String pass;

    public Vendedores(int codigo, String nombre, int caja, int ventas, String genero,String pass) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.pass = pass;
    }

    public Vendedores(String nombre, int caja, int ventas, String genero, String pass) {
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.pass = pass;
    }

    public Vendedores(int codigo, String nombre, String pass) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pass = pass;
    }

    public Vendedores(String nombre,  String pass,int caja) {
        this.nombre = nombre;
       
        this.pass = pass;
         this.caja = caja;
    }

    
    
    
    
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public Vendedores(){}   
}


