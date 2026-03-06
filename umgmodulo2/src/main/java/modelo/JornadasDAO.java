/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Jornadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 50240
 */

public class JornadasDAO {
    

    private static final String SQL_SELECT = "SELECT Jor_Codigo, Jor_Nombre FROM jornadas";
    private static final String SQL_QUERY = "SELECT Jor_Codigo, Jor_Nombre FROM jornadas WHERE Jor_Codigo = ?";
    private static final String SQL_INSERT = "INSERT INTO jornadas(Jor_Nombre) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE jornadas SET Jor_Nombre=? WHERE Jor_Codigo = ?";
    private static final String SQL_DELETE = "DELETE FROM jornadas WHERE Jor_Codigo=?";
 
    
    public List<Jornadas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jornadas jornadasobjeto = null;
        List<Jornadas> jornadaslista = new ArrayList<Jornadas>();

        try {
            conn = Conexion.getConnection(); //abre la base de datos, conecta
            stmt = conn.prepareStatement(SQL_SELECT); //Statement estado, preparar la conexion trayendo la accion/comando que va a accionar del sql en la base de datos
            rs = stmt.executeQuery(); //un set de datos record set??? que esta haciendo ahi? ejecutando el query el rs conecta hace el select y se trae los datos y quedará guardado en rs
            while (rs.next()) { //si se cumple el rs (conjunto de datos) . next quiere decir que hay datos,
                
                int Jor_Codigo = rs.getInt("Jor_Codigo");
                String Jor_Nombre = rs.getString("Jor_Nombre"); //campo de la base de datos
                
                //quiere decir que va de uno a uno. 
                
                               
                jornadasobjeto = new Jornadas();
                jornadasobjeto.setJor_Codigo(Jor_Codigo);
                jornadasobjeto.setJor_Codigo(Jor_Codigo);
                                
                jornadaslista.add(jornadasobjeto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return jornadaslista;
    }
    
    public int insert(Jornadas jornadasobjeto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, jornadasobjeto.getJor_Nombre());
           
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
    
     public int update(Jornadas jornadasobjeto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, jornadasobjeto.getJor_Nombre());
            stmt.setInt(2, jornadasobjeto.getJor_Codigo());
           
            
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
    
      public int delete(Jornadas jornadasobjeto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, jornadasobjeto.getJor_Codigo());
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
    public Jornadas query(Jornadas jornadasobjeto) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jornadas> jornadaslista = new ArrayList<Jornadas>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, jornadasobjeto.getJor_Codigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Jor_Codigo = rs.getInt("Jor_Codigo");
                String Jor_Nombre = rs.getString("Jor_Nombre");
                

                
                jornadasobjeto = new Jornadas();
                jornadasobjeto.setJor_Codigo(Jor_Codigo);
                jornadasobjeto.setJor_Nombre(Jor_Nombre);
                
                
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
        return jornadasobjeto;
    }
}

