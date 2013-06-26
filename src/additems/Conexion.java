/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package additems;


import java.io.FileNotFoundException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *  maguilar@utn-proyectos.com.ar
 * @author MUTNPROD003
 */
/*public class Conexion
{
    private String driver = "com.mysql.jdbc.Driver";
    private Connection conexion;
    //variables publicas
    public Statement statement = null;
    public ResultSet resulset = null;
    private PreparedStatement prepareStatement;


    public Conexion() {
    }

    public boolean conectar() throws SQLException, FileNotFoundException, ClassNotFoundException {

        driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/qualitys";
        String user = "root";
        String passw = "root";
        Class.forName(driver);
        try {
            conexion = DriverManager.getConnection(url, user, passw);
//            System.out.println("seconecto");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean desconectar() {
        try {
            conexion.close();
//            System.out.println("se desconecto");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public void ExecuteSql(String sql) {
        try {
            statement = (Statement) conexion.createStatement();
            resulset = statement.executeQuery(sql);

        } catch (SQLException sqle) {
//envia mensajes si la consulta tuvo un error
            do {

                System.out.println("SQL STATE: " + sqle.getSQLState());
                System.out.println("ERROR CODE: " + sqle.getErrorCode());
                System.out.println("MESSAGE: " + sqle.getMessage());
                System.out.println();
                sqle = sqle.getNextException();
            } while (sqle != null);
        }
    }

    public void executeUpdate(String sql) {
        try {
            prepareStatement = conexion.prepareStatement(sql);
            int filasAfectadas = prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public Object getLastID(String nombre) {
        int ret = 0;
        try {
            String query = "Select max(id) from " + nombre;
            statement = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resulset = statement.executeQuery(query);
            while (resulset.next()) {
                ret = resulset.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }
}*/
