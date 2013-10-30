/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import BasedeDatos.IdControlFromVerificacionList;
import BasedeDatos.Conexion;
import TratarFile.IdentificarExtension;
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
  private JTextField rutaCarpeta;
  private Conexion con;
  private JButton aceptarSeleccion;
  private JLabel informa;
  private int idUsuario;
<<<<<<< HEAD
  private JFrame frame;
=======
  private JFrame cargarLoteFrame;
//  private  int idVerificacion;
  private List<Integer> idTipoControl = new ArrayList<>();
>>>>>>> NuevaVerificacion

  private static int idVerificacion;
  private static List<Integer> idTipoControl = new ArrayList<>();
  public AceptarCargarLote(JComboBox tipoDocumentoBox, JComboBox tipoVerificacionBox,
          JTextField rutaCarpeta, Conexion con, JButton aceptarSeleccion, JLabel informa, int idUsuario, JFrame frame) {
    this.tipoDocumentoBox = tipoDocumentoBox;
    this.tipoVerificacionBox = tipoVerificacionBox;
    this.rutaCarpeta = rutaCarpeta;
    this.con = con;
    this.aceptarSeleccion = aceptarSeleccion;
    this.informa = informa;
    this.idUsuario = idUsuario;
    this.frame = frame;
    getAceptar();
  }


  private void getAceptar() {
    String ruta = rutaCarpeta.getText();//trae la ruta
    File file = new File(ruta);//busca el file
    if (file.exists()) {// si el archivo existe
      File[] files = file.listFiles();//lista los mismos
<<<<<<< HEAD
      if (tipoDocumentoBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de documento")) {//condicion obsoleta
        JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de documentos sin seleccionar",//porque se posiciona el en index cero de los combos
                "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
      } else if (tipoVerificacionBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de verificacion")) {
        JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de Verificacion sin seleccionar",
                "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
      } else {
=======
      if (tipoDocumentoBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de documento"))
        {
        setMessageJcombotipodoc();
        } else if (tipoVerificacionBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de verificacion"))
        {
        setMessageComboTipoVerificacion();
        } else
        {
>>>>>>> NuevaVerificacion
        getControlesPorVerificacion();//controles de la verificacion seleccionada
        con.isConexionClose();////cierra conexion
        IdentificarParent parent = new IdentificarParent(files); // trae la ruta completa

        String rutaCompleta = parent.getParent();
        String ultimaCarpeta = getUltimaCarpeta(rutaCompleta);//trae la ultima carpeta
        IdentificarExtension idext = new IdentificarExtension(frame, informa, idTipoControl, file,
                rutaCompleta, ultimaCarpeta, idUsuario, getTipoDocumento(), idVerificacion);
        idext.execute();
        aceptarSeleccion.setEnabled(false);
<<<<<<< HEAD
      }
    } else {
      JOptionPane.showMessageDialog(rutaCarpeta, "Ruta incorrecta", "Error en el ingreso de la ruta", JOptionPane.ERROR_MESSAGE);
=======
        }
      } else
      {
      JOptionPane.showMessageDialog(rutaCarpeta,
              "Ruta incorrecta", "Error en el ingreso de la ruta", JOptionPane.ERROR_MESSAGE);
>>>>>>> NuevaVerificacion
      rutaCarpeta.setText("");
    }
  }

  public List<Integer> getIdTipoControl() {
    return idTipoControl;
  }


  private String getUltimaCarpeta(String aParent) {
    String ret = "";
    if (aParent.contains("\\")) {
      String replace = aParent.replace("\\", ", ");
      String[] rsplit = replace.split(", ");
      for (int i = 0; i < rsplit.length; i++) {
        ret = (rsplit[i]);
      }
    }
    return ret;
  }

  private int getTipoDocumento() {
    String result = (String) tipoDocumentoBox.getSelectedItem();
    String[] dos = result.split("-");
    int id = Integer.parseInt(dos[0]);
    return id;
  }

  private void getControlesPorVerificacion() {
    IdControlFromVerificacionList ctrls = new IdControlFromVerificacionList();
    idTipoControl = ctrls.idControlesByVerificacion(tipoVerificacionBox, con, idTipoControl);
    idVerificacion = ctrls.getIdVerificacion();
  }

  private void setMessageJcombotipodoc() throws HeadlessException {
    //condicion obsoleta
    JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de documentos sin seleccionar",//porque se posiciona el en index cero de los combos
            "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
  }

  private void setMessageComboTipoVerificacion() throws HeadlessException {
    JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de Verificacion sin seleccionar",
            "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
  }
}
