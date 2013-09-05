/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import BasedeDatos.Conexion;
import Entidades.TiposDeControl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class TiposdeControlPorArchivo {

  private Conexion conexion = new Conexion();
  private int idArchivo;
  private int idArchivoTraza;
  private int idTraza;
  private JTable tabla;
  private List<TiposDeControl> tiposControlList = new ArrayList<>();

  public TiposdeControlPorArchivo(int idArchivo) {
    this.idArchivo = idArchivo;
    traerChecks();
  }

  public TiposdeControlPorArchivo(int idArchivo, JTable tabla) {
    this.idArchivo = idArchivo;
    this.tabla = tabla;
    traerChecks();
  }

  private List<TiposDeControl> traerChecks() {
    TiposDeControl tipos;
    if (conexion.isConexion()) {
      try {
        String query = "SELECT  tac.idcontrol "
                + ", c.descripcion "
                + ", tac.estado "
                + " FROM qualitys.traza_archivo_controles tac "
                + " join controles c"
                + " on tac.idcontrol = c.id "
                + " where idarchivo = " + idArchivo + ";";
        conexion.executeQuery(query);
        while (conexion.resulset.next()) {
          int estado = conexion.resulset.getInt(3);
          boolean isEstado = (estado == 0) ? false : true;
          tipos = new TiposDeControl(conexion.resulset.getInt(1), conexion.resulset.getString(2), isEstado, null, null);
          tiposControlList.add(tipos);
        }
        conexion.isConexionClose();

      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Obtener control por Imagen", JOptionPane.ERROR_MESSAGE);
      }
    }
    return tiposControlList;
  }

  public List<TiposDeControl> getTiposControlList() {
    return tiposControlList;
  }
}
