/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rangos.Paq;

import Paneles.RangosDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import writeproperties.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class LastID {

    private Conexion conexion;
    private String tabla;

    public LastID(Conexion conexion, String tabla) {
        this.conexion = conexion;
        this.tabla = tabla;
    }


    public int lastId() {
        int ret = 0;
        if (conexion.isConexion()) {
            try {
                conexion.ExecuteSql("SELECT max(id) FROM " + tabla + ";");
                while (conexion.resulset.next()) {
                    ret = conexion.resulset.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RangosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }


}
