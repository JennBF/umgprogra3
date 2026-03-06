/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author 50240
 */

import controlador.Maestros;
import modelo.MaestrosDAO;
import modelo.JornadasDAO;
import controlador.Jornadas;

public class Principal {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//TODO LO QUE ESTA EN MINUSCULA ES OBJETO Y MAYUSCULA ES UNA CLASE
       Maestros maestrosobjeto = new Maestros("MARIA CELESTE","ZONA 1","INACTIVO");
        System.out.println(maestrosobjeto.toString());
        MaestrosDAO maestrosobjetodao = new MaestrosDAO();
        maestrosobjetodao.insert(maestrosobjeto);
       
        maestrosobjeto.setMae_Codigo(5);
        maestrosobjeto=maestrosobjetodao.query(maestrosobjeto);
        
        //Jornadas jornadasobjeto = new Jornadas("Vespertina");
        //System.out.println(jornadasobjeto.toString());
        //JornadasDAO jornadasobjetodao = new JornadasDAO();
        //jornadasobjetodao.insert(jornadasobjeto);
       
        //jornadasobjeto.setJor_Codigo(1);
        //jornadasobjeto=jornadasobjetodao.query(jornadasobjeto);
      
      // maestrosobjeto.setMae_Codigo(6);
      //maestrosobjetodao.delete(maestrosobjeto);
        
       
       maestrosobjeto.setMae_Codigo(7);
        maestrosobjeto.setMae_Nombre("Miguel de Leon");
        maestrosobjeto.setMae_Direccion("ZONA 6");
        
        
       int v;
      v=maestrosobjetodao.update(maestrosobjeto);
        
          //System.out.println(jornadasobjeto.toString());
         System.out.println(maestrosobjeto.toString());
}
}