/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import BasedeDatos.IdControlFromVerificacionList;
import BasedeDatos.Conexion;
import Helpers.GetExtensionIdImagen;
import Helpers.GetUltimaCarpeta;
import TratarFile.IdentificarExtension;
import TratarFile.IdentificarExtensionSublote;
import TratarFile.IdentificarParent;
import java.awt.HeadlessException;
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
  private int idUsuario;
  private JFrame cargarLoteFrame;
  private List<Integer> idtipoControlList = new ArrayList<>();

  public AceptarCargarLote(JComboBox tipoDocumentoBox, JComboBox tipoVerificacionBox,
          JTextField pathJtext, Conexion conexion, JButton aceptarJButton, JLabel infoLabel, int idUsuario, JFrame frame) {
    this.tipoDocumentoBox = tipoDocumentoBox;
    this.tipoVerificacionBox = tipoVerificacionBox;
    this.pathnameJtext = pathJtext;
    this.conexion = conexion;
    this.aceptarButton = aceptarJButton;
    this.infoJLabel = infoLabel;
    this.idUsuario = idUsuario;
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
        getAceptarDocumentos(file);
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

  public List<Integer> getIdTipoControlList() {
    return idtipoControlList;
  }

//  private String getUltimaCarpeta(String aParent) {
//    String ret = "";
//    if (aParent.contains("\\"))
//      {
//      String replace = aParent.replace("\\", ", ");
//      String[] rsplit = replace.split(", ");
//      for (int i = 0; i < rsplit.length; i++)
//        {
//        ret = (rsplit[i]);
//        }
//      }
//    return ret;
//  }
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

//  private void setMessageJcombotipodoc() throws HeadlessException {
//    //condicion obsoleta
//    JOptionPane.showMessageDialog(pathnameJtext, "Tipo de documentos sin seleccionar",//porque se posiciona el en index cero de los combos
//            "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
//  }
//
//  private void setMessageComboTipoVerificacion() throws HeadlessException {
//    JOptionPane.showMessageDialog(pathnameJtext, "Tipo de Verificacion sin seleccionar",
//            "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
//  }
  private void getFilesForVolumen(File file) {
    File[] files = file.listFiles();//lista los mismos
    getControlesPorVerificacion();//controles de la verificacion seleccionada
    conexion.isConexionClose();////cierra conexion
    IdentificarParent parent = new IdentificarParent(files); // trae la ruta completa
    String rutaCompleta = parent.getParent();
    String ultimaCarpeta = GetUltimaCarpeta.getLastFolder(rutaCompleta);//trae la ultima carpeta
    IdentificarExtension idext = new IdentificarExtension(cargarLoteFrame, infoJLabel, idtipoControlList, file,
            rutaCompleta, ultimaCarpeta, idUsuario, getTipoDocumento(), IdControlFromVerificacionList.getIdVerificacion());
    idext.execute();
    aceptarButton.setEnabled(false);
  }

  private void getAceptarDocumentos(File file) {

    ContadorSublotes contadorSublotes = new ContadorSublotes(file);
    GetExtensionIdImagen extensionIdImagen = new GetExtensionIdImagen(ContadorSublotes.getExtension());
    List<Object> listaIdc = contadorSublotes.getDocumentoList();
    getControlesPorVerificacion();
    conexion.isConexion();
    IdentificarExtensionSublote idext = new IdentificarExtensionSublote(cargarLoteFrame, infoJLabel, idtipoControlList, file, idUsuario, getTipoDocumento(), IdControlFromVerificacionList.getIdVerificacion(), listaIdc);
    idext.execute();
  }
}
