/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import BasedeDatos.InsertarArchivoSublote;
import BasedeDatos.InsertarEnSublotes;
import entidad.ImagenInsertada;
import entidad.Sublote;
import BasedeDatos.InsertTrazaArchivoContolYEstado;
import entidad.NombrePaginaDelPDF;
import BasedeDatos.Conexion;
import BasedeDatos.GetUltimoIDInsertado;
import BasedeDatos.InsertarNuevoArchivo;
import PaneldeControl.ContadorSublotes;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class OnlyPdf {

  private Conexion conexion;
  private int muestra,idTraza;
  private String parent;
  private CreateRamdom crearRamdom;
  private JLabel infoLabel;
  private List<Integer> idControl;
  private static CreateRamdom ramdom;
  private List<Sublote> sublotes;

  public OnlyPdf(JLabel infoLabel, Conexion conexion, int muestra, int idTraza, String parent, List<Integer> idControl, List<Object> listaImagenes) {
    this.infoLabel = infoLabel;
    this.conexion = conexion;
    this.muestra = muestra;
    this.idTraza = idTraza;
    this.parent = parent;
    this.idControl = idControl;
    ramdom = new CreateRamdom(listaImagenes, muestra);
    insertPagePdf();
  }

  public OnlyPdf(Conexion conexion, int muestra, int idTraza, List<Object> listaImagenes, JLabel infoLabel, List<Integer> idControl, List<Sublote> sublotes) {
    this.parent = ContadorSublotes.getParent();
    this.conexion = conexion;
    this.muestra = muestra;
    this.idTraza = idTraza;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    this.sublotes = sublotes;
    InsertarEnSublotes insertarEnSublotes = new InsertarEnSublotes(conexion, sublotes, idTraza);
    pruebainsertarImagen();
  }

  private void insertPagePdf() {//voy a cambiar por stack

    List<Object> ramdomPdf = ramdom.getStack();
    for (Object o : ramdomPdf)
      {
      NombrePaginaDelPDF pagina = (NombrePaginaDelPDF) o;
      int parentlength = parent.length() + 1;
      String adaptarFile = pagina.getNombre().substring(parentlength);
      String filename = adaptarFile.replace("\\", "\\\\");
      int page = pagina.getNumeroPagina();
      InsertarNuevoArchivo archivo = new InsertarNuevoArchivo(conexion, idTraza, filename, page, infoLabel, 1);
      imagenyControl();
      }
  }

  private void pruebainsertarImagen() {
    int estado = 0;
    for (Sublote s : sublotes)
      {
      for (ImagenInsertada img : s.getImagenes())
        {
        cargarImagen(img, idTraza, s.getId());
        imagenyControl();
        }
      }
  }

  private void cargarImagen(ImagenInsertada img, int idtraza, int idsublote) {
    InsertarNuevoArchivo insertarNuevoArchivo = new InsertarNuevoArchivo(conexion, idtraza, img.getNombre(), img.getPagina(), infoLabel, 2);
    int ultimoid = new GetUltimoIDInsertado(conexion, "archivo").getUltimoID();
    archivoSublote(idtraza, ultimoid, idsublote);
  }

  private void archivoSublote(int idtraza, int idarchivo, int idsublote) {
    InsertarArchivoSublote insertar_archivo_sublote = new InsertarArchivoSublote(conexion, idtraza, idarchivo, idsublote);
  }

  private void imagenyControl() {
    InsertTrazaArchivoContolYEstado insertTrazaArchivoContolYEstado =
            new InsertTrazaArchivoContolYEstado(idTraza, idControl, conexion);
  }
}
