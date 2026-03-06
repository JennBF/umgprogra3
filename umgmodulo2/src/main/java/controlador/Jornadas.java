/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author 50240
 */
public class Jornadas {
    
    int Jor_Codigo;
    String Jor_Nombre; 

    public Jornadas() {
    }

    public Jornadas(int Jor_Codigo, String Jor_Nombre) {
        this.Jor_Codigo = Jor_Codigo;
        this.Jor_Nombre = Jor_Nombre;
    }

    public Jornadas(String Jor_Nombre) {
        this.Jor_Nombre = Jor_Nombre;
    }

    public Jornadas(int Jor_Codigo) {
        this.Jor_Codigo = Jor_Codigo;
    }

    public int getJor_Codigo() {
        return Jor_Codigo;
    }

    public void setJor_Codigo(int Jor_Codigo) {
        this.Jor_Codigo = Jor_Codigo;
    }

    public String getJor_Nombre() {
        return Jor_Nombre;
    }

    public void setJor_Nombre(String Jor_Nombre) {
        this.Jor_Nombre = Jor_Nombre;
    }

    @Override
    public String toString() {
        return "Jornadas{" + "Jor_Codigo=" + Jor_Codigo + ", Jor_Nombre=" + Jor_Nombre + '}';
    }
    
    
    
    
}
