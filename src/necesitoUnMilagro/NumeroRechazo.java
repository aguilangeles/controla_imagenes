/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class NumeroRechazo {

    public NumeroRechazo(int idTraza) {
        int numero =0;
//
            Conexion c = new Conexion();
           if(c.isConexion()){
            try {
                c.ExecuteSql("SELECT count(estado) FROM qualitys.archivo where idtraza = "+idTraza+" and estado = 1");
                while(c.resulset.next()){
                    numero = c.resulset.getInt(1);
                }
                c.executeUpdate("UPDATE `qualitys`.`traza` SET `nro_rechazo` = "+numero+" WHERE id = "+idTraza+";");
                c.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(NumeroRechazo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }


}
