/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.InsertTrazaArchivoContolYEstado;
import Entidades.NombrePaginaDelPDF;
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
public class OnlyPdf {

  private InsertarNuevaTraza sTraza;
  private Conexion conexion;
  private int idUsuario, idDocumento, idVerificacion, tamanioLote, muestra,
          idRango, idTraza;
  private String parent, ultimaCarpeta;
  private CrearElRamdom crearRamdom;
  private JLabel infoLabel;
  private List<Integer> idControl;
  private List<Object> listaImagenes;
  private static CrearElRamdom ramdom;
  private List<Sublote> sublotes;

  public OnlyPdf(InsertarNuevaTraza sTraza, Conexion conexion, int idUsuario,
          int idDocumento, int idVerificacion, int tamanioLote, int muestra,
          int idRango, int idTraza, String parent, String ultimaCarpeta,
          List<Object> listaImagenes, JLabel infoLabel, List<Integer> idControl) {
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
    this.listaImagenes = listaImagenes;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    ramdom = new CrearElRamdom(listaImagenes, muestra);
    OnlyPdf();
  }

  public OnlyPdf(Conexion conexion, int idUsuario,
          int idDocumento, int idVerificacion, int tamanioLote, int muestra,
          int idRango, int idTraza,
          List<Object> listaImagenes, JLabel infoLabel, List<Integer> idControl, List<Sublote> sublotes) {
    this.parent = ContadorSublotes.getParent();
    this.ultimaCarpeta = ContadorSublotes.getUltimaCarpeta();
    this.conexion = conexion;
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.tamanioLote = tamanioLote;
    this.muestra = muestra;
    this.idRango = idRango;
    this.idTraza = idTraza;
    this.listaImagenes = listaImagenes;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    this.sublotes = sublotes;
    System.out.println("constructor documentos");
    InsertarEnSublotes insertarEnSublotes = new InsertarEnSublotes(conexion, sublotes, idTraza);
    pruebainsertarImagen();
  }

  private void OnlyPdf() {//voy a cambiar por stack
    sTraza = new InsertarNuevaTraza(conexion, idDocumento, idVerificacion,
            tamanioLote, parent, ultimaCarpeta, muestra, idRango);

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
      Runtime gar = Runtime.getRuntime();
      gar.gc();
      }
  }

//  private void OnlyDocumentPdf() {//voy a cambiar por stack
//
//    List<Object> ramdomPdf = ramdom.getStack();
//    for (Object o : ramdomPdf)
//      {
//      NombrePaginaDelPDF pagina = (NombrePaginaDelPDF) o;
//      int parentlength = parent.length() + 1;
//      String adaptarFile = pagina.getNombre().substring(parentlength);
//      String filename = adaptarFile.replace("\\", "\\\\");
//      int page = pagina.getNumeroPagina();
//      InsertarNuevoArchivo archivo = new InsertarNuevoArchivo(conexion, idTraza, filename, page, infoLabel, 1);
//      imagenyControl();
//      Runtime gar = Runtime.getRuntime();
//      gar.gc();
//      }
//  }
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
