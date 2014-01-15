/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import database.InsertarArchivoSublote;
import database.InsertarEnSublotes;
import entidad.ImagenInsertada;
import entidad.Sublote;
import database.InsertTrazaArchivoContol;
import database.Conexion;
import database.SelectLastID;
import database.InsertarNuevoArchivo;
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
  private static CreateRamdom ramdom;

  public Tif_Png_Jpg(JLabel infoLabel, Conexion conexion, int muestra, int idTraza, String parent, List<Integer> idControl, List<Object> listaImagenes) {
    this.conexion = conexion;
    this.muestra = muestra;
    this.idTraza = idTraza;
    this.parent = parent;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    ramdom = new CreateRamdom(listaImagenes, muestra);
    Tif_Png_Jpg();
  }

  public Tif_Png_Jpg(Conexion conexion, int muestra, int idTraza, JLabel infoLabel, List<Integer> idControl, List<Sublote> sublotes) {
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
        imagenyControl();
        }
      }
  }

  private void cargarimagen(ImagenInsertada img, int idtraza, int idsublote) {
    int estado = 0;
    InsertarNuevoArchivo insertarNuevoArchivo = new InsertarNuevoArchivo(conexion, idtraza, img.getNombre(), img.getPagina(), infoLabel, 2);
    int ultimoid = new SelectLastID(conexion, "archivo").getUltimoID();
    archivoSublote(idtraza, ultimoid, idsublote);
  }

  private void archivoSublote(int idtraza, int idarchivo, int idsublote) {
    InsertarArchivoSublote insertar_archivo_sublote = new InsertarArchivoSublote(conexion, idtraza, idarchivo, idsublote);
  }

  private void imagenyControl() {
    InsertTrazaArchivoContol insertTrazaArchivoContolYEstado =
            new InsertTrazaArchivoContol(idTraza, idControl, conexion);
  }
}
