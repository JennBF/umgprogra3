/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author 50240
 */
public class Maestros {
    
    private int Mae_Codigo;
    private String Mae_Nombre;
    private String Mae_Direccion;
    private String Mae_Estatus;

    public Maestros(int Mae_Codigo) {
        this.Mae_Codigo = Mae_Codigo;
    }
    
     public Maestros(String Mae_Nombre) {
        this.Mae_Nombre = Mae_Nombre;
    }

    public Maestros() {
    }

    public Maestros(int Mae_Codigo, String Mae_Nombre) {
        this.Mae_Codigo = Mae_Codigo;
        this.Mae_Nombre = Mae_Nombre;
    }
    
    
    public Maestros(int Mae_Codigo, String Mae_Nombre, String Mae_Direccion, String Mae_Estatus) {
        this.Mae_Codigo = Mae_Codigo;
        this.Mae_Nombre = Mae_Nombre;
        this.Mae_Direccion = Mae_Direccion;
        this.Mae_Estatus = Mae_Estatus;
    }
    
     public Maestros( String Mae_Nombre, String Mae_Direccion, String Mae_Estatus) {
        this.Mae_Nombre = Mae_Nombre;
        this.Mae_Direccion = Mae_Direccion;
        this.Mae_Estatus = Mae_Estatus;
    }


    public int getMae_Codigo() {
        return Mae_Codigo;
    }

    public void setMae_Codigo(int Mae_Codigo) {
        this.Mae_Codigo = Mae_Codigo;
    }

    public String getMae_Nombre() {
        return Mae_Nombre;
    }

    public void setMae_Nombre(String Mae_Nombre) {
        this.Mae_Nombre = Mae_Nombre;
    }

    public String getMae_Direccion() {
        return Mae_Direccion;
    }

    public void setMae_Direccion(String Mae_Direccion) {
        this.Mae_Direccion = Mae_Direccion;
    }

    public String getMae_Estatus() {
        return Mae_Estatus;
    }

    public void setMae_Estatus(String Mae_Estatus) {
        this.Mae_Estatus = Mae_Estatus;
    }

    @Override
    public String toString() {
        return "Maestros{" + "Mae_Codigo=" + Mae_Codigo + ", Mae_Nombre=" + Mae_Nombre + ", Mae_Direccion=" + Mae_Direccion + ", Mae_Estatus=" + Mae_Estatus + '}';
    }
    
    
  
}
