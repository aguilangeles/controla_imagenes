/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import entidad.TiposDeControl;
import java.sql.SQLException;
import javax.swing.JComboBox;
import database.Conexion;
import helper.MensajeJoptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Verificacion_CargarComboBoxs extends JComboBox<Object> {

  private String classname = Verificacion_CargarComboBoxs.class.getName();
  private MensajeJoptionPane msg;
  private DefaultComboBoxModel tipoDocumento = new DefaultComboBoxModel();
  private DefaultComboBoxModel tipoVerificacion = new DefaultComboBoxModel();
  private Conexion conexion = new Conexion();

  public Verificacion_CargarComboBoxs() {
  }

  public void llenarQualitys() {
    if (conexion.isConexion())
      {
      try
        {
        String ret = "SELECT id, nombre FROM qualitys.tipos_verificacion  where estado = 1;";
        conexion.executeQuery(ret);
        while (conexion.resulset.next())
          {
          int id = conexion.resulset.getInt(1);
          String nombre = conexion.resulset.getString(2);
          TiposDeControl t = new TiposDeControl(id, nombre);
          tipoVerificacion.addElement(t.newToString());
          }
        conexion.isConexionClose();
        } catch (SQLException ex)
        {
        msg = new MensajeJoptionPane(this, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), classname);
        }
      }
  }

  public void llenarDocumentos() {
    try
      {
      if (conexion.isConexion())
        {
        String ret = "SELECT * FROM qualitys.tipos_documentos;";
        conexion.executeQuery(ret);
        while (conexion.resulset.next())
          {
          int id = conexion.resulset.getInt(1);
          String nombre = conexion.resulset.getString(2);
          TiposDeControl t = new TiposDeControl(id, nombre);
          tipoDocumento.addElement(t.getId() + "-" + t.getTexto());
          }
        }
      conexion.isConexionClose();
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), classname);
      }

  }

  public DefaultComboBoxModel getTipoDocumento() {
    return tipoDocumento;
  }

  public DefaultComboBoxModel getTipoVerificacion() {
    return tipoVerificacion;
  }

}
