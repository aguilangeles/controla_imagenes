/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.InsertTrazaArchivoContolYEstado;
import BasedeDatos.Conexion;
import BasedeDatos.GetUltimoIDInsertado;
import BasedeDatos.InsertarNuevoArchivo;
import BasedeDatos.InsertarNuevaTraza;
import PaneldeControl.ContadorSublotes;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Tif_Png_Jpg {

  private InsertarNuevaTraza sTraza;
  private Conexion conexion;
  private int idUsuario, idDocumento, idVerificacion, idRango, muestra, tamanio, idTraza;
  private String parent, ultimaCarpeta;
  private static CrearElRamdom ramdom;
  private JLabel infoLabel;
  private List<Integer> idControl;
  private List<Sublote> sublotes;

  public Tif_Png_Jpg(InsertarNuevaTraza sTraza, Conexion conexion,
          int idUsuario, int idDocumento, int idVerificacion,
          int idRango, int muestra, int tamanio, int idTraza,
          String parent, String ultimaCarpeta, JLabel infoLabel,
          List<Integer> idControl, List<Object> listaImagenes) {
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
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    ramdom = new CrearElRamdom(listaImagenes, muestra);
    Tif_Png_Jpg();
  }

  public Tif_Png_Jpg(Conexion conexion, int idUsuario, int idDocumento,
          int idVerificacion, int idRango, int muestra, int tamanioLote,
          int idTraza, JLabel infoLabel, List<Integer> idControl, List<Sublote> sublotes) {
    this.conexion = conexion;
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.idRango = idRango;
    this.muestra = muestra;
    this.tamanio = tamanioLote;
    this.idTraza = idTraza;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    this.sublotes = sublotes;
    String parents = ContadorSublotes.getParent();
    String ultima = ContadorSublotes.getUltimaCarpeta();
    this.sTraza = new InsertarNuevaTraza(conexion, idUsuario, idDocumento, idVerificacion,
            tamanio, parents, ultima, muestra, idRango);
    InsertarEnSublotes insertarEnSublotes = new InsertarEnSublotes(conexion, sublotes, idTraza); // lista de sublotes
    pruebainsertarImagen();
  }

  private void Tif_Png_Jpg() {
    sTraza = new InsertarNuevaTraza(conexion, idUsuario, idDocumento, idVerificacion,
            tamanio, parent, ultimaCarpeta, muestra, idRango);
    List<Object> ramdomList = ramdom.getStack();
    for (Object obj : ramdomList)
      {
      String aImagen = (String) obj;
      int parentlength = parent.length() + 1;
      String adaptarFile = aImagen.substring(parentlength);
      String filename = adaptarFile.replace("\\", "\\\\");
      InsertarNuevoArchivo archivo = new InsertarNuevoArchivo(conexion, idTraza, filename, 0, infoLabel, 1);
      imagenyControl();
      Runtime gar = Runtime.getRuntime();
      gar.gc();
      }
  }

  private void pruebainsertarImagen() {
    int estado = 0;
    for (Sublote s : sublotes)
      {
      for (ImagenInsertada img : s.getImagenes())
        {
        cargarimagen(img, s.getIdtraza(), s.getId());
        imagenyControl();
        }
      }
  }

  private void cargarimagen(ImagenInsertada img, int idtraza, int idsublote) {
    int estado = 0;
    int nuevatraza = idtraza;
    InsertarNuevoArchivo insertarNuevoArchivo = new InsertarNuevoArchivo(conexion, nuevatraza, img.getNombre(), img.getPagina(), infoLabel, 2);
    int ultimoid = new GetUltimoIDInsertado(conexion, "archivo").getUltimoID();
    archivoSublote(idtraza, ultimoid, idsublote);
  }

  private void archivoSublote(int idtraza, int idarchivo, int idsublote) {
    Insertar_archivo_sublote insertar_archivo_sublote = new Insertar_archivo_sublote(conexion, idtraza, idarchivo, idsublote);
  }

  private void imagenyControl() {
    InsertTrazaArchivoContolYEstado insertTrazaArchivoContolYEstado =
            new InsertTrazaArchivoContolYEstado(idTraza, idControl, conexion);
  }
}
