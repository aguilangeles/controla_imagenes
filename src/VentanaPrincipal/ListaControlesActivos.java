/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import entidad.TiposDeControl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BasedeDatos.Conexion;
import Helpers.MensajeJoptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class ListaControlesActivos {

  private Conexion conexion;
  private List<TiposDeControl> lista;

  public ListaControlesActivos(Conexion conexion) {
    this.lista = new ArrayList<>();
    this.conexion = conexion;
    poblarLista();
  }

  private List<TiposDeControl> poblarLista() {
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
          lista.add(tipos);
          }
        } catch (SQLException ex)
        {
        MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), ListaControlesActivos.class.getName());

        }
      }
    return lista;
  }

  public List<TiposDeControl> getLista() {
    return lista;
  }
}
