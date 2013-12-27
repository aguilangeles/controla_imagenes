/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import BasedeDatos.IdControlFromVerificacionList;
import BasedeDatos.Conexion;
import Helpers.GetExtensionIdImagen;
import TratarFile.IdentificarExtension;
import TratarFile.IdentificarExtensionSublote;
import TratarFile.GetParentName;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class AceptarCargarLote {

  private JComboBox tipoDocumentoBox;
  private JComboBox tipoVerificacionBox;
  private JTextField pathnameJtext;
  private Conexion conexion;
  private JButton aceptarButton;
  private JLabel infoJLabel;
  private static int idUsuario;
  private JFrame cargarLoteFrame;
  private List<Integer> idtipoControlList = new ArrayList<>();

  public AceptarCargarLote(JFrame frame, JTextField pathJtext, JButton aceptarJButton, JComboBox tipoDocumentoBox, JComboBox tipoVerificacionBox, JLabel infoLabel, Conexion conexion, int idUsuario) {
    this.tipoDocumentoBox = tipoDocumentoBox;
    this.tipoVerificacionBox = tipoVerificacionBox;
    this.pathnameJtext = pathJtext;
    this.conexion = conexion;
    this.aceptarButton = aceptarJButton;
    this.infoJLabel = infoLabel;
//    idUsuario = idUsuario;
    this.cargarLoteFrame = frame;
    getAceptar();
  }

  private void getAceptar() {

    String ruta = pathnameJtext.getText();//trae la ruta
    File file = new File(ruta);//busca el file
    if (file.exists())
      {
      if (tipoVerificacionBox.getSelectedItem().toString().equalsIgnoreCase("2-Control Básico de Documento"))
        {
        getDocumentos(file);
        } else
        {
        getFilesForVolumen(file);
        }
      } else
      {
      JOptionPane.showMessageDialog(pathnameJtext,
              "Ruta incorrecta", "Error en el ingreso de la ruta", JOptionPane.ERROR_MESSAGE);
      pathnameJtext.setText("");
      }
  }

  private void getFilesForVolumen(File file) {
    File[] files = file.listFiles();//lista los mismos
    getControlesPorVerificacion();//controles de la verificacion seleccionada
    conexion.isConexionClose();////cierra conexion
    GetParentName parent = new GetParentName(files); // trae la ruta completa
    IdentificarExtension idext = new IdentificarExtension(cargarLoteFrame, infoJLabel, idtipoControlList, file, idUsuario, getTipoDocumento(), IdControlFromVerificacionList.getIdVerificacion());
    idext.execute();
    aceptarButton.setEnabled(false);
  }

  private void getDocumentos(File file) {
    ContadorSublotes contadorSublotes = new ContadorSublotes(file);
    GetExtensionIdImagen extensionIdImagen = new GetExtensionIdImagen(ContadorSublotes.getExtension());
    List<Object> listaIdc = contadorSublotes.getDocumentoList();
    getControlesPorVerificacion();
    conexion.isConexion();
    IdentificarExtensionSublote idext = new IdentificarExtensionSublote(cargarLoteFrame, infoJLabel, idtipoControlList, file, idUsuario, getTipoDocumento(), IdControlFromVerificacionList.getIdVerificacion(), listaIdc);
    idext.execute();
    aceptarButton.setEnabled(false);

  }

  public List<Integer> getIdTipoControlList() {
    return idtipoControlList;
  }

  private int getTipoDocumento() {
    String result = (String) tipoDocumentoBox.getSelectedItem();
    String[] dos = result.split("-");
    int id = Integer.parseInt(dos[0]);
    return id;
  }

  private void getControlesPorVerificacion() {
    IdControlFromVerificacionList ctrls = new IdControlFromVerificacionList();
    idtipoControlList = ctrls.idControlesByVerificacion(tipoVerificacionBox, conexion, idtipoControlList);
  }
}
