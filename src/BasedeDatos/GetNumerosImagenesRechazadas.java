/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Cuenta la cantidad de imagenes con estado 1 (rechazado) e incluye esa
 * cantidad en la traza bajo nro_rechazo.
 *
 * @author MUTNPROD003
 */
public class GetNumerosImagenesRechazadas {

  public GetNumerosImagenesRechazadas(int idTraza) {
    int numero = 0;
    Conexion c = new Conexion();
    if (c.isConexion())
      {
      try
        {
        String query = "SELECT count(estado) "
                + " FROM qualitys.archivo "
                + " where idtraza = " + idTraza
                + " and estado = 1;";
        c.executeQuery(query);
        while (c.resulset.next())
          {
          numero = c.resulset.getInt(1);
          }
        String update = "UPDATE `qualitys`.`traza` "
                + "SET `nro_rechazo` = " + numero
                + " WHERE id = " + idTraza + ";";
        c.executeUpdate(update);
        c.isConexionClose();
        } catch (SQLException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Numero de Rechazo", JOptionPane.ERROR_MESSAGE);
        }
      }
  }
}
