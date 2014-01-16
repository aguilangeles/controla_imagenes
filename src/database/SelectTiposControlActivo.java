/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidad.TiposDeControl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import helper.MensajeJoptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class SelectTiposControlActivo {

  private Conexion conexion;
  private List<TiposDeControl> ctlsActivosList;

  public SelectTiposControlActivo(Conexion conexion) {
    this.conexion = conexion;
    this.ctlsActivosList = poblarLista();
  }

  private List<TiposDeControl> poblarLista() {
    List<TiposDeControl> listaCa = new ArrayList<>();
    TiposDeControl tipos;
    if (conexion.isConexion())
      {
      try
        {
        conexion.executeQuery("Select id, descripcion from controles where estado = 1 ");
        while (conexion.resulset.next())
          {
          int id = conexion.resulset.getInt(1);
          String descripcion = conexion.resulset.getString(2);
          tipos = new TiposDeControl(id, descripcion);
          listaCa.add(tipos);
          }
        } catch (SQLException ex)
        {
        MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), SelectTiposControlActivo.class.getName());

        }
      }
    return listaCa;
  }

  public List<TiposDeControl> getListaCrtlsActivos() {
    return ctlsActivosList;
  }
}
