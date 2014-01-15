/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Cuenta la cantidad de imagenes con estado 1 (rechazado) e incluye esa
 * cantidad en la traza bajo nro_rechazo.
 *
 * @author MUTNPROD003
 */
public class SelectDocsRechazados {

  private static final String className = SelectDocsRechazados.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  //
  private List<Integer> idSubloteRechazado = new ArrayList<>();

  public SelectDocsRechazados(int idTraza) {
    getDocumentsValue1(idTraza);
  }

  private void getDocumentsValue1(int idTraza) {
    int contador = 0;
    int numero = 0;
    Conexion conexion = new Conexion();
    if (conexion.isConexion())
      {
      try
        {
        String query = "SELECT  distinct "
                + " ars.idsublote "
                + " from archivo a "
                + " join qualitys.archivo_sublote ars "
                + " on a.id=ars.idarchivo "
                + " join sublotes ss "
                + " on ars.idsublote= ss.id "
                + " where a.idtraza = " + idTraza
                + " and a.estado = 1;";
        conexion.executeQuery(query);
        while (conexion.resulset.next())
          {
          contador++;
          numero = conexion.resulset.getInt(1);
          idSubloteRechazado.add(numero);
          }
        UpdateNroRechazoDocsInTraza updateNroRechazoDocsInTraza =
                new UpdateNroRechazoDocsInTraza(conexion, idTraza, contador);
        conexion.isConexionClose();
        } catch (SQLException ex)
        {
        msg.getMessage(ex.getMessage(), className);
        }
      }
    SetEstadoDocumentoInSublote setEstadoDocumentoInSublote = new SetEstadoDocumentoInSublote(idSubloteRechazado);
  }
}
