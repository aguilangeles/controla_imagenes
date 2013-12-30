/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.ArchivosPorTrazaList;
import Imagenes.ImageDrawingComponent;
import Entidades.Imagen;
import Entidades.TrazaDao;
import Helpers.GetExtensionIdImagen;
//import Helpers.GetImagenesAdyacentes;
//import Helpers.RutaMouseListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class MostrarInternalFrames {

  private TrazaDao traza;
  private JDesktopPane desktopPane;
  private JInternalFrame internal;
  private JComboBox combo;
  private JScrollPane scrollImage;
  private int  sizeRamdom, idImagen;
  private JLabel rutaLabel, pageLabel;
  private JTable tabla;
  private static GetRutaDeImagen rutadeimagen = new GetRutaDeImagen();
  private static ImageDrawingComponent imageDraw = new ImageDrawingComponent();
  private static Guardar save;
  private static SetChecksBox setCB;
  private JPanel panelScroll;
  private JButton anterior, siguiente, botonAncho, pEntera;

  public MostrarInternalFrames(JDesktopPane desktopPane, JInternalFrame internal, JScrollPane scrollImage, JLabel rutaLabel, JLabel pageLabel, JTable tabla, JPanel panelSroll, JComboBox combo, TrazaDao traza, JButton siguiente, JButton anterior, JButton ancho, JButton pEntera, int sizeRamdom) {
    this.traza = traza;
    this.desktopPane = desktopPane;
    this.internal = internal;
    this.anterior = anterior;
    this.idImagen = traza.getIdImagen();
    this.combo = combo;
    this.scrollImage = scrollImage;
    this.sizeRamdom = sizeRamdom;
    this.rutaLabel = rutaLabel;
    this.pageLabel = pageLabel;
    this.tabla = tabla;
    this.siguiente = siguiente;
    this.botonAncho = ancho;
    this.pEntera = pEntera;
    this.panelScroll = panelSroll;
    MostrarInternalFrames.save = new Guardar();// sa
    MostrarInternalFrames.setCB = new SetChecksBox(tabla);//trae los estados desde la base de datos
  }

  public void mostrarPrimeraImagen(Imagen siguientes, int cantidad) {
    try
      {
      internal.setMaximum(true);
      setTituloYRutaLabel(siguientes, cantidad);
      setImagenes(siguientes);
      setCB.set(siguientes.getId());
      } catch (PropertyVetoException ex)
      {
      Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
      }
  }//

  public void setNextImage(Imagen imagen1, int cantidad) {
    anterior.setEnabled(true);
    guardarYLimpiar(rutaLabel, tabla, pageLabel);
    desktopPane.add(internal);
    setTituloYRutaLabel(imagen1, cantidad);
    setCB.set(imagen1.getId());
    setImagenes(imagen1);
    internal.setVisible(true);
  }

  public void setBackImage(Imagen pr, int cantidad) {
    guardarYLimpiar(rutaLabel, tabla, pageLabel);
    siguiente.setEnabled(true);
    desktopPane.add(internal);
    internal.setVisible(true);
    setTituloYRutaLabel(pr, cantidad);
    setImagenes(pr);
    setCB.set(pr.getId());
  }

  private void setTituloYRutaLabel(Imagen siguientes, int cantidad) {
    int tamanio = siguientes.getTotalSublote();
    String imagenw = "Imagen " + cantidad + "/" + sizeRamdom;
    internal.setTitle(imagenw);
    rutaLabel.setText(siguientes.getRutaInsertadaEnDB());
  }

  private void setLabelPagina(Imagen siguientes) {
    switch (idImagen)
      {
      case 1:
        int page1 = siguientes.getPagina() + 1;
        pageLabel.setText("Pagina: " + page1);
        break;
      case 2:
        pageLabel.setVisible(false);
      case 3:
        break;
      }
  }

  private void guardarYLimpiar(JLabel rutaJlabel, JTable tablaCheck, JLabel pagina) {
    save.guardar(traza, rutaJlabel.getText(), tablaCheck, pagina);
    internal.dispose();
    desktopPane.removeAll();
    desktopPane.repaint();
  }

  private void setImagenes(Imagen siguientes) {
    String ruta = rutadeimagen.getImage(siguientes, idImagen);
    setLabelPagina(siguientes);
    imageDraw.cargarImage(ruta, combo, panelScroll, botonAncho, pEntera, idImagen);
    scrollImage.getViewport().add(imageDraw);
  }
}
