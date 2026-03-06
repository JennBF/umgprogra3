/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Jennifer
 */
public class computador {

    public computador( int cod_IdProducto) {
   
        this.cod_IdProducto = cod_IdProducto;
    }
    public computador(String color, String nombre) {
        this.color = color;
        this.nombre = nombre;

    }
    public computador() {
    }
   

    String color;
    String nombre;
    String marca;
    String ram;
    int cod_IdProducto;
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getCod_IdProducto() {
        return cod_IdProducto;
    }

    public void setCod_IdProducto(int cod_IdProducto) {
        this.cod_IdProducto = cod_IdProducto;
    }

    @Override //metodo polimorfico que se sobre escribe cuando se inice la clase 
    public String toString() {
        return "computador{" + "color=" + color + ", nombre=" + nombre + ", marca=" + marca + ", ram=" + ram + ", cod_IdProducto=" + cod_IdProducto + '}';
    }
    
///saot+tab
    
}

