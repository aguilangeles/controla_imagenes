/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaVisual;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class NumeroDeArchivosRechazados {

    public NumeroDeArchivosRechazados(int idTraza) {
        int numero =0;
            Conexion conexion = new Conexion();
           if(conexion.isConexion()){
            try {
                conexion.ExecuteSql("SELECT count(estado) FROM qualitys.archivo where "
                        + "idtraza = "+idTraza+" and estado = 1");
                while(conexion.resulset.next()){
                    numero = conexion.resulset.getInt(1);
                }
                conexion.executeUpdate("UPDATE `qualitys`.`traza` SET `nro_rechazo` = "
                        +numero+" WHERE id = "+idTraza+";");
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(NumeroDeArchivosRechazados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}
