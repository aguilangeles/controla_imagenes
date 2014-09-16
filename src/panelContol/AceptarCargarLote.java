/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import database.SelectIdControlfromVerificacionList;
import database.Conexion;
import helper.GetIdandExtensionImg;
import files.GetFinalListOfImages;
import documents.GetFinalListOfDocuments;
import helper.GetParent;
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
  private TryFilechooser chooser;

  public AceptarCargarLote(JFrame frame, JTextField pathJtext,
	  JButton aceptarJButton, JComboBox tipoDocumentoBox,
	  JComboBox tipoVerificacionBox, JLabel infoLabel,
	  Conexion conexion, int idUsuario, TryFilechooser chooser) {
    this.tipoDocumentoBox = tipoDocumentoBox;
    this.tipoVerificacionBox = tipoVerificacionBox;
    this.pathnameJtext = pathJtext;
    this.conexion = conexion;
    this.aceptarButton = aceptarJButton;
    this.infoJLabel = infoLabel;
    this.cargarLoteFrame = frame;
    this.chooser = chooser;
    getAceptar();
  }

  private void getAceptar() {
    String ruta = pathnameJtext.getText();//trae la ruta
    File file = new File(ruta);//busca el file
    if (file.exists())
    {
      if (tipoVerificacionBox.getSelectedItem().toString().equalsIgnoreCase("2-Control Básico de Documento"))
      {
	if(chooser.isaDirectory()){
	  getDocumentosSelected();
	}else{
	getDocumentos(file);
	  
	}
      } else
      {
	if (chooser.isaDirectory())
	{

	  getFilesForVolumeSelected();
	} else
	{
	  getFilesForVolumen(file);
	}
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
    GetParent parent = new GetParent(files); // trae la ruta completa
    GetFinalListOfImages idext = new GetFinalListOfImages(cargarLoteFrame,
	    infoJLabel, idtipoControlList, file, getTipoDocumento(),
	    SelectIdControlfromVerificacionList.getIdVerificacion());
    idext.execute();
    aceptarButton.setEnabled(false);
  }

  private void getFilesForVolumeSelected() {
    getControlesPorVerificacion();//controles de la verificacion seleccionada
    conexion.isConexionClose();////cierra conexion
    GetFinalListOfImages idext = new GetFinalListOfImages(cargarLoteFrame,
	    infoJLabel, idtipoControlList, getTipoDocumento(),
	    SelectIdControlfromVerificacionList.getIdVerificacion(), chooser);
    idext.execute();
    aceptarButton.setEnabled(false);
  }

  private void getDocumentos(File file) {
    ContadorSublotes contadorSublotes = new ContadorSublotes(file);
    GetIdandExtensionImg extensionIdImagen = new GetIdandExtensionImg(ContadorSublotes.getExtension());
    List<Object> listaIdc = contadorSublotes.getDocumentoList();
    getControlesPorVerificacion();
    conexion.isConexion();
    GetFinalListOfDocuments idext = new GetFinalListOfDocuments(cargarLoteFrame, 
	    infoJLabel, file, getTipoDocumento(),
	    SelectIdControlfromVerificacionList.getIdVerificacion(), 
	    idtipoControlList, listaIdc);
    idext.execute();
    aceptarButton.setEnabled(false);

  }
  private void getDocumentosSelected() {
    ContadorSublotes contadorSublotes = new ContadorSublotes(chooser);
    GetIdandExtensionImg extensionIdImagen = new GetIdandExtensionImg(ContadorSublotes.getExtension());
    List<Object> listaIdc = contadorSublotes.getDocumentoList();
    getControlesPorVerificacion();
    conexion.isConexion();
    GetFinalListOfDocuments idext = new GetFinalListOfDocuments(cargarLoteFrame, 
	    infoJLabel,  getTipoDocumento(),
	    SelectIdControlfromVerificacionList.getIdVerificacion(), 
	    idtipoControlList, listaIdc);
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
    SelectIdControlfromVerificacionList ctrls = new SelectIdControlfromVerificacionList();
    idtipoControlList = ctrls.idControlesByVerificacion(tipoVerificacionBox, conexion, idtipoControlList);
  }
}
