/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class VendedorDAO {

    private static final String SQL_SELECT = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor";
    private static final String SQL_INSERT = "INSERT INTO vendedor(nombrevendedor, direvendedor) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE vendedor SET nombrevendedor=?, direvendedor=? WHERE idvendedor = ?"; //no se pone values porque no es insert. el id no se coloca dentro del set porque es su llave primaria 
    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE idvendedor=?";
    private static final String SQL_QUERY = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor WHERE id_vendedor = ?";

    //select es general. Query es específico 
    
    public List<Vendedor> select() {
        Connection conn = null; //AQUI SE ESTAN DEFINIENDO, PORQUE SE RESERVO MEMORIA PARA ELLOS 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>(); //ARRAYLIST ES UNA MATRIZ 

        try { //MANEJO DE EXCEPCIONES / ERRORES.
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally { //se cierran en inverso. Todo se debe cerrar en base de datos. 
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vendedores;
    }

    public int insert(Vendedor vendedor) { //clase vendedor, es decir que recibe un objeto. 
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getNombreVendedor()); //es un método de ese objeto stmt atrae el que tiene java, porque es un objeto en memoria llamado vendedor. El programa le estoy diciendo dame el vendedor.
            stmt.setString(2, vendedor.getDireVendedor()); //estos comodines solo pueden ser llenados de esta manera. 
//aqui no hay record set porque estoy insertando no jalando

            System.out.println("ejecutando query:" + SQL_INSERT); //la base de datos es auto incrementable, por lo tanto ella sola se encarga de la llave primaria. 
            rows = stmt.executeUpdate(); //ejecuta el insert Filas que se van a insertar retorna un int. Envía a la base de datos. 
            System.out.println("Registros afectados:" + rows); //devuelve la fila.
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try { //todo debe llevar try catch 
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireVendedor());
            stmt.setInt(3, vendedor.getId_vendedor()); //no es string porque la llave es un entero. Este va para el where.  Porque necesito el valor o sino se actualizará todo. 

            rows = stmt.executeUpdate(); //enviar a bd 
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getId_vendedor()); //solo un comodín  y es sent int porque es entero
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

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Vendedor query(Vendedor vendedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vendedor.getId_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
//sirve para crear mantenimiento en java. 
        //return vendedores;  // Si se utiliza un ArrayList
        return vendedor;
    }
        
}
//Que significa Dao Direct Access  Object  Objeto de acceso directo a la base de datos. 
