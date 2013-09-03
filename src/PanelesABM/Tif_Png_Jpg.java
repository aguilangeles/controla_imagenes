/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.Conexion;
import Helpers.Archivo;
import Helpers.Traza;
import java.util.List;
import javax.swing.JLabel;
import tratamientoruta.CrearElRamdom;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Tif_Png_Jpg {

  private Traza sTraza;
  private Conexion conexion;
  private int idUsuario, idDocumento, idVerificacion, idRango, muestra, tamanio, idTraza;
  private String parent, ultimaCarpeta;
  private CrearElRamdom crearRamdom;
  private JLabel infoLabel;
  private List<Integer> idControl;

  public Tif_Png_Jpg(Traza sTraza, Conexion conexion, int idUsuario, int idDocumento, int idVerificacion, int idRango, int muestra, int tamanio, int idTraza, String parent, String ultimaCarpeta, CrearElRamdom crearRamdom, JLabel infoLabel, List<Integer> idControl) {
    this.sTraza = sTraza;
    this.conexion = conexion;
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.idRango = idRango;
    this.muestra = muestra;
    this.tamanio = tamanio;
    this.idTraza = idTraza;
    this.parent = parent;
    this.ultimaCarpeta = ultimaCarpeta;
    this.crearRamdom = crearRamdom;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    Tif_Png_Jpg();
  }

  private void Tif_Png_Jpg() {
    sTraza = new Traza(conexion, idUsuario, idDocumento, idVerificacion,
            tamanio, parent, ultimaCarpeta, muestra, idRango);
    List<Object> ramdomList = crearRamdom.getSeleccion();
    for (Object obj : ramdomList) {
      String aImagen = (String) obj;
      int parentlength = parent.length() + 1;
      String adaptarFile = aImagen.substring(parentlength);
      String filename = adaptarFile.replace("\\", "\\\\");
      Archivo archivo = new Archivo(conexion, idTraza, filename, 0, infoLabel);
      imagenyControl();
      Runtime gar = Runtime.getRuntime();
      gar.gc();
    }
  }

  private void imagenyControl() {
    InsertTrazaArchivoContolYEstado insertTrazaArchivoContolYEstado =
            new InsertTrazaArchivoContolYEstado(idTraza, idControl, conexion);
  }
}
