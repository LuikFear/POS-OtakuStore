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
public class Ventas {

    private int Codigo;
    private String nombre;
    private int nit;
    private String fecha;
    private Float total;

    public Ventas(int Codigo, String nombre, int nit, String fecha, Float total) {
        this.Codigo = Codigo;
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.total = total;
    }

    public Ventas(String nombre, int nit, String fecha, Float total) {
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.total = total;
    }

    public int getNo() {
        return Codigo;
    }

    public void setNo(int Codigo) {
        this.Codigo = Codigo;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }



   
}
