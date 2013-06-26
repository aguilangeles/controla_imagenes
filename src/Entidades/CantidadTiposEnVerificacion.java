/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import writeproperties.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class CantidadTiposEnVerificacion {
    private int size;

    public CantidadTiposEnVerificacion(Conexion conexion, int id) {
        this.size = size(conexion, id);
    }

    private int size(Conexion conexion, int id) {
            int ret = 0;
        try {
                String insert = "select count(idControl) "
                        + "from controles_verificacion "
                        + "where idVerificacion = "
                        + "(SELECT  idVerificacion FROM qualitys.traza where id ="+id+")";
                conexion.ExecuteSql(insert);
                while (conexion.resulset.next()) {
                        ret = conexion.resulset.getInt(1);
                }

        } catch (SQLException ex) {
            Logger.getLogger(CantidadTiposEnVerificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ret;
    }

    public int getSize() {
        return size;
    }



}
