/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.InsertTrazaArchivoContolYEstado;
import BasedeDatos.Conexion;
import BasedeDatos.GetUltimoIDInsertado;
import BasedeDatos.InsertarNuevoArchivo;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Tif_Png_Jpg {

  private Conexion conexion;
  private int muestra, idTraza;
  private String parent;
  private JLabel infoLabel;
  private List<Integer> idControl;
  private List<Sublote> sublotes;
  private static CrearElRamdom ramdom;

  public Tif_Png_Jpg(JLabel infoLabel, Conexion conexion, int muestra, int idTraza, String parent, List<Integer> idControl, List<Object> listaImagenes) {
    this.conexion = conexion;
    this.muestra = muestra;
    this.idTraza = idTraza;
    this.parent = parent;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    ramdom = new CrearElRamdom(listaImagenes, muestra);
    Tif_Png_Jpg();
  }

  public Tif_Png_Jpg(Conexion conexion, int idUsuario, int idDocumento,
          int idVerificacion, int idRango, int muestra, int tamanioLote,
          int idTraza, JLabel infoLabel, List<Integer> idControl, List<Sublote> sublotes) {
    this.conexion = conexion;
    this.muestra = muestra;
    this.idTraza = idTraza;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    this.sublotes = sublotes;
    InsertarEnSublotes insertarEnSublotes = new InsertarEnSublotes(conexion, sublotes, idTraza); // lista de sublotes
    pruebainsertarImagen();
  }

  private void Tif_Png_Jpg() {
    List<Object> ramdomList = ramdom.getStack();
    for (Object obj : ramdomList)
      {
      String aImagen = (String) obj;
      int parentlength = parent.length() + 1;
      String adaptarFile = aImagen.substring(parentlength);
      String filename = adaptarFile.replace("\\", "\\\\");
      InsertarNuevoArchivo archivo = new InsertarNuevoArchivo(conexion, idTraza, filename, 0, infoLabel, 1);
      imagenyControl();
      }
  }

  private void pruebainsertarImagen() {
    int estado = 0;
    for (Sublote s : sublotes)
      {
      for (ImagenInsertada img : s.getImagenes())
        {
        cargarimagen(img, idTraza, s.getId());
        InsertTrazaArchivoContolYEstado insertTrazaArchivoContolYEstado = new InsertTrazaArchivoContolYEstado(idTraza, idControl, conexion, true);
        }
      }
  }

  private void cargarimagen(ImagenInsertada img, int idtraza, int idsublote) {
    int estado = 0;
    InsertarNuevoArchivo insertarNuevoArchivo = new InsertarNuevoArchivo(conexion, idtraza, img.getNombre(), img.getPagina(), infoLabel, 2, true);
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
