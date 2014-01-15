/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Cuenta la cantidad de imagenes con estado 1 (rechazado) e incluye esa
 * cantidad en la traza bajo nro_rechazo.
 *
 * @author MUTNPROD003
 */
public class SelectImagenesRechazadas {

  private static final String className = SelectImagenesRechazadas.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);

  public SelectImagenesRechazadas(int idTraza) {
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
        msg.getMessage(ex.getMessage(), className);
        }
      }
  }
}
