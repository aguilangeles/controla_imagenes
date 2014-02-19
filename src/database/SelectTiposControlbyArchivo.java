/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidad.TiposDeControl;
import helper.MensajeJoptionPane;
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
public class SelectTiposControlbyArchivo {

  private static final String className = SelectTiposControlbyArchivo.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private static Conexion conexion = new Conexion();
  private int idArchivo;
  private int idTraza;
  private int idSublote;
  private JTable tabla;
  private List<TiposDeControl> tiposControlList = new ArrayList<>();

  public SelectTiposControlbyArchivo(int idArchivo) {
    this.idArchivo = idArchivo;
    traerChecks();
  }

  public SelectTiposControlbyArchivo(int idArchivo, int idSublote) {
    this.idArchivo = idArchivo;
    this.idSublote = idSublote;
    traerChecksxDoc();
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
          tipos = new TiposDeControl(conexion.resulset.getInt(1),
                  conexion.resulset.getString(2), isEstado, null, null);
          tiposControlList.add(tipos);
        }
        conexion.isConexionClose();

      } catch (SQLException ex) {
        msg.getMessage(ex.getMessage(), className);
      }
    }
    return tiposControlList;
  }

  private List<TiposDeControl> traerChecksxDoc() {
    TiposDeControl tipos;
    if (conexion.isConexion()) {
      try {
        String query = "SELECT  tac.idcontrol "
                + ", c.descripcion "
                + ", tac.estado "
                + " FROM qualitys.traza_archivo_controles tac "
                + " join controles c"
                + " on tac.idcontrol = c.id "
                + " join archivo_sublote arsb "
                + " on tac.idarchivo = arsb.idarchivo "
                + " where tac.idarchivo = " + idArchivo
                + " and arsb.idsublote = " + idSublote + ";";
        conexion.executeQuery(query);
        while (conexion.resulset.next()) {
          int estado = conexion.resulset.getInt(3);
          boolean isEstado = (estado == 0) ? false : true;
          tipos = new TiposDeControl(conexion.resulset.getInt(1),
                  conexion.resulset.getString(2), isEstado, null, null);
          tiposControlList.add(tipos);
        }
        conexion.isConexionClose();

      } catch (SQLException ex) {
        msg.getMessage(ex.getMessage(), className);
      }
    }
    return tiposControlList;
  }

  public List<TiposDeControl> getTiposControlList() {
    return tiposControlList;
  }
}
