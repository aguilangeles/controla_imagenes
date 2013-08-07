/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Daos.TiposDeControl;
import java.sql.SQLException;
import javax.swing.JComboBox;
import Entidades.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Verificacion_CargarComboBoxs extends JComboBox<Object> {

  private DefaultComboBoxModel tipoDocumento = new DefaultComboBoxModel();
  private DefaultComboBoxModel tipoVerificacion = new DefaultComboBoxModel();
  private Conexion conexion = new Conexion();
  private List<Object> documentoList = new ArrayList<>();
  private List<Object> verificacionList = new ArrayList<>();

  public Verificacion_CargarComboBoxs() {
  }

  public void llenarQualitys() {
    if (conexion.isConexion()) {
      try {
        String ret = "SELECT id, nombre FROM qualitys.tipos_verificacion  where estado = 1;";
        conexion.executeQuery(ret);
        while (conexion.resulset.next()) {
          int id = conexion.resulset.getInt(1);
          String nombre = conexion.resulset.getString(2);
          TiposDeControl t = new TiposDeControl(id, nombre);
          verificacionList.add(t.newToString());
          tipoVerificacion.addElement(t.newToString());

        }
        conexion.isConexionClose();
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la carga de JComboBox ", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public void llenarDocumentos() {
    try {
      if (conexion.isConexion()) {
        String ret = "SELECT * FROM qualitys.tipos_documentos;";
        conexion.executeQuery(ret);
        while (conexion.resulset.next()) {
          int id = conexion.resulset.getInt(1);
          String nombre = conexion.resulset.getString(2);
          TiposDeControl t = new TiposDeControl(id, nombre);
          documentoList.add(t.getId()+"-"+t.getTexto());
          tipoDocumento.addElement(t.getId()+"-"+t.getTexto());
        }
      }
      conexion.isConexionClose();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la carga de JComboBox ", JOptionPane.ERROR_MESSAGE);
    }

  }

  public DefaultComboBoxModel getTipoDocumento() {
    return tipoDocumento;
  }

  public DefaultComboBoxModel getTipoVerificacion() {
    return tipoVerificacion;
  }

  public List<Object> getDocumentoList() {
    return documentoList;
  }

  public List<Object> getVerificacionList() {
    return verificacionList;
  }
}
