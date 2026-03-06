/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 50240
 */

import controlador.Maestros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaestrosDAO {
    

    private static final String SQL_SELECT = "SELECT Mae_Codigo, Mae_Nombre, Mae_Direccion, Mae_Estatus FROM maestros";
    private static final String SQL_QUERY = "SELECT Mae_Codigo, Mae_Nombre, Mae_Direccion, Mae_Estatus FROM maestros WHERE Mae_Codigo = ?";
    private static final String SQL_INSERT = "INSERT INTO maestros(Mae_Nombre, Mae_Direccion, Mae_Estatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE maestros SET Mae_Nombre=?, Mae_Direccion=?, Mae_Estatus=? WHERE Mae_Codigo = ?";
    private static final String SQL_DELETE = "DELETE FROM maestros WHERE Mae_Codigo=?";
 
    
    public List<Maestros> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Maestros maestrosobjeto = null;
        List<Maestros> maestrolista = new ArrayList<Maestros>();

        try {
            conn = Conexion.getConnection(); //abre la base de datos, conecta
            stmt = conn.prepareStatement(SQL_SELECT); //Statement estado, preparar la conexion trayendo la accion/comando que va a accionar del sql en la base de datos
            rs = stmt.executeQuery(); //un set de datos record set??? que esta haciendo ahi? ejecutando el query el rs conecta hace el select y se trae los datos y quedará guardado en rs
            while (rs.next()) { //si se cumple el rs (conjunto de datos) . next quiere decir que hay datos,
                
                int Mae_Codigo = rs.getInt("Mae_Codigo");
                String Mae_Nombre = rs.getString("Mae_Nombre"); //campo de la base de datos
                
                //quiere decir que va de uno a uno. 
                
                               
                maestrosobjeto = new Maestros();
                maestrosobjeto.setMae_Codigo(Mae_Codigo);
                maestrosobjeto.setMae_Codigo(Mae_Codigo);
                                
                maestrolista.add(maestrosobjeto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return maestrolista;
    }
    
    public int insert(Maestros maestrosobjeto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, maestrosobjeto.getMae_Nombre());
            stmt.setString(2, maestrosobjeto.getMae_Direccion());
            stmt.setString(3, maestrosobjeto.getMae_Estatus());
            
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
     public int update(Maestros maestrosobjeto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, maestrosobjeto.getMae_Nombre());
            stmt.setInt(2, maestrosobjeto.getMae_Codigo());
            stmt.setString(3, maestrosobjeto.getMae_Direccion());
            stmt.setString(4, maestrosobjeto.getMae_Estatus());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
      public int delete(Maestros maestrosobjeto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, maestrosobjeto.getMae_Codigo());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona empleado) { // Si se utiliza un ArrayList
    public Maestros query(Maestros maestrosobjeto) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Maestros> maestrolista = new ArrayList<Maestros>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, maestrosobjeto.getMae_Codigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Mae_Codigo = rs.getInt("Mae_Codigo");
                String Mae_Nombre = rs.getString("Mae_Nombre");
                String Mae_Direccion = rs.getString("Mae_Direccion");
                String Mae_Estatus = rs.getString("Mae_Estatus");

                
                maestrosobjeto = new Maestros();
                maestrosobjeto.setMae_Codigo(Mae_Codigo);
                maestrosobjeto.setMae_Nombre(Mae_Nombre);
                maestrosobjeto.setMae_Direccion(Mae_Direccion);
                maestrosobjeto.setMae_Estatus(Mae_Estatus);
                
                
                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return maestrosobjeto;
    }
}
