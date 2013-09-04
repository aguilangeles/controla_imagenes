/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.InsertTrazaArchivoContolYEstado;
import Entidades.NombrePaginaDelPDF;
import BasedeDatos.Conexion;
import BasedeDatos.InsertarNuevoArchivo;
import BasedeDatos.InsertarNuevaTraza;
import java.util.List;
import javax.swing.JLabel;
import TratarFile.CrearElRamdom;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class OnlyPdf {

  private InsertarNuevaTraza sTraza;
  private Conexion conexion;
  private int idUsuario, idDocumento, idVerificacion, tamanioLote, muestra, idRango, idTraza;
  private String parent, ultimaCarpeta;
  private CrearElRamdom crearRamdom;
  private JLabel infoLabel;
  private List<Integer> idControl;

  public OnlyPdf(InsertarNuevaTraza sTraza, Conexion conexion, int idUsuario, int idDocumento, int idVerificacion, int tamanioLote, int muestra, int idRango, int idTraza, String parent, String ultimaCarpeta, CrearElRamdom crearRamdom, JLabel infoLabel, List<Integer> idControl) {
    this.sTraza = sTraza;
    this.conexion = conexion;
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.tamanioLote = tamanioLote;
    this.muestra = muestra;
    this.idRango = idRango;
    this.idTraza = idTraza;
    this.parent = parent;
    this.ultimaCarpeta = ultimaCarpeta;
    this.crearRamdom = crearRamdom;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    OnlyPdf();
  }

  private void OnlyPdf() {
    sTraza = new InsertarNuevaTraza(conexion, idUsuario, idDocumento, idVerificacion,
            tamanioLote, parent, ultimaCarpeta, muestra, idRango);
    List<Object> ramdomPdf = crearRamdom.getSeleccion();
    for (Object o : ramdomPdf) {
      NombrePaginaDelPDF pagina = (NombrePaginaDelPDF) o;
      int parentlength = parent.length() + 1;
      String adaptarFile = pagina.getNombre().substring(parentlength);
      String filename = adaptarFile.replace("\\", "\\\\");
      int page = pagina.getNumeroPagina();
      InsertarNuevoArchivo archivo = new InsertarNuevoArchivo(conexion, idTraza, filename, page, infoLabel);
      imagenyControl();
      Runtime gar = Runtime.getRuntime();
      gar.gc();
    }
  }

  private void imagenyControl() {
    InsertTrazaArchivoContolYEstado insertTrazaArchivoContolYEstado = new InsertTrazaArchivoContolYEstado(idTraza, idControl, conexion);
  }
}
