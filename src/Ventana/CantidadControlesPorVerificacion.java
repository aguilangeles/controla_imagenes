/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class CantidadControlesPorVerificacion {
    private int cantidad;
    
    public CantidadControlesPorVerificacion(Conexion conexion, int id) {
        this.cantidad = cantidad(conexion, id);
    }

    private int cantidad(Conexion conexion, int id) {
        int cantidadControles = 0;
        try {
            String insert = "select count(idControl) "
                    + "from controles_verificacion "
                    + "where idVerificacion = "
                    + "(SELECT  idVerificacion FROM qualitys.traza where id =" + id + ")";
            conexion.ExecuteSql(insert);
            while (conexion.resulset.next()) {
                cantidadControles = conexion.resulset.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CantidadControlesPorVerificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidadControles;
    }

    public int getCantidad() {
        return cantidad;
    }



}
