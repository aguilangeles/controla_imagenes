/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Entidades.TiposDeControl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Trae los tipos de control por archivo
 *
 * @author MUTNPROD003
 */
public class TiposdeControlPorArchivo {

  private static Conexion conexion = new Conexion();
  private int idArchivo;
  private int idTraza;
  private JTable tabla;
  private List<TiposDeControl> tiposControlList = new ArrayList<>();

  public TiposdeControlPorArchivo(int idArchivo) {
    this.idArchivo = idArchivo;
    traerChecks();
  }

  private List<TiposDeControl> traerChecks() {
    TiposDeControl tipos;
    if (conexion.isConexion())
      {
      try
        {
        String query = "SELECT  tac.idcontrol "
                + ", c.descripcion "
                + ", tac.estado "
                + " FROM qualitys.traza_archivo_controles tac "
                + " join controles c"
                + " on tac.idcontrol = c.id "
                + " where idarchivo = " + idArchivo + ";";
        conexion.executeQuery(query);
        while (conexion.resulset.next())
          {
          int estado = conexion.resulset.getInt(3);
          boolean isEstado = (estado == 0) ? false : true;
          tipos = new TiposDeControl(conexion.resulset.getInt(1),
                  conexion.resulset.getString(2), isEstado, null, null);
          tiposControlList.add(tipos);
          }
        conexion.isConexionClose();

        } catch (SQLException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Obtener control por Imagen", JOptionPane.ERROR_MESSAGE);
        }
      }
    return tiposControlList;
  }

  public List<TiposDeControl> getTiposControlList() {
    return tiposControlList;
  }
}
