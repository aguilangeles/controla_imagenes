/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Conexion;
import javax.swing.JOptionPane;

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
                c.executeQuery("SELECT count(estado) FROM qualitys.archivo where idtraza = "+idTraza+" and estado = 1");
                while(c.resulset.next()){
                    numero = c.resulset.getInt(1);
                }
                c.executeUpdate("UPDATE `qualitys`.`traza` SET `nro_rechazo` = "+numero+" WHERE id = "+idTraza+";");
                c.isConexionClose();
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Numero de Rechazo", JOptionPane.ERROR_MESSAGE);

//                Logger.getLogger(NumeroRechazo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }


}