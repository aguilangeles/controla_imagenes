/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidad.Rangos_qs;
import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import reporteFinal.AutomaticoRoA;

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
    int nro_rechazo = 0;
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
          nro_rechazo = c.resulset.getInt(1);
          }
        setEstadoYrechazo(idTraza, nro_rechazo, c);
        c.isConexionClose();
        } catch (SQLException ex)
        {
        msg.getMessage(ex.getMessage(), className);
        }
      }
  }

  private void setEstadoYrechazo(int idTraza, int nro_rechazo, Conexion c) throws SQLException {
    int rechazo = Rangos_qs.getRechazo();
    AutomaticoRoA estado = new AutomaticoRoA(rechazo, nro_rechazo);
    int estadoLote = AutomaticoRoA.getStatusValue();
    String update = "UPDATE `qualitys`.`traza` "
            + "SET `nro_rechazo` = " + nro_rechazo
            + ", `estadoLote` = " + estadoLote
            + " WHERE id = " + idTraza + ";";
    c.executeUpdate(update);
  }
}
