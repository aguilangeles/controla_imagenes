/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import Imagenes.ImageDrawingComponent;
import Entidades.Imagen;
import Entidades.TrazaDao;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
  private Imagen siguientes;
  private JButton anterior, siguiente;
  private boolean pdf, tif;
  private JComboBox combo;
  private JScrollPane scrollImage;
  private int cantidad, sizeRamdom;
  private JLabel rutaLabel, pageLabel;
  private JTable tabla;
  private static GetRutaDeImagen rutadeimagen = new GetRutaDeImagen();
  private static ImageDrawingComponent imageDraw = new ImageDrawingComponent();
  private static Guardar save;
  private static SetChecksBox setCB;

  public MostrarInternalFrames(TrazaDao traza, JDesktopPane desktopPane, JInternalFrame internal,
          JButton anterior, boolean pdf, boolean tif, JComboBox combo, JScrollPane scrollImage,
          int cantidad, int sizeRamdom, JLabel rutaLabel, JLabel pageLabel, JTable tabla, JButton siguiente) {
    this.traza = traza;
    this.desktopPane = desktopPane;
    this.internal = internal;
    this.anterior = anterior;
    this.pdf = pdf;
    this.tif = tif;
    this.combo = combo;
    this.scrollImage = scrollImage;
    this.cantidad = cantidad;
    this.sizeRamdom = sizeRamdom;
    this.rutaLabel = rutaLabel;
    this.pageLabel = pageLabel;
    this.tabla = tabla;
    this.siguiente = siguiente;
    MostrarInternalFrames.save = new Guardar();// sa
    MostrarInternalFrames.setCB = new SetChecksBox(tabla);//trae los estados desde la base de datos



  }

  public void mostrarPrimeraImagen(Imagen siguientes) {
    try
      {
      internal.setMaximum(true);
      setTituloYRutaLabel(siguientes);
      setImagenes(siguientes);
      setCB.set(siguientes.getId());
      } catch (PropertyVetoException ex)
      {
      Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
      }
  }//

  public void setNextImage(Imagen imagen1) {
    anterior.setEnabled(true);
    guardarYLimpiar(rutaLabel, tabla, pageLabel, pdf);
    try
      {
      desktopPane.add(internal);
      setTituloYRutaLabel(imagen1);
      setCB.set(imagen1.getId());
      setImagenes(imagen1);
      internal.setVisible(true);
      } catch (Exception ex)
      {
      Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public void setBackImage(Imagen pr) {
    guardarYLimpiar(rutaLabel, tabla, pageLabel, pdf);
    siguiente.setEnabled(true);
    desktopPane.add(internal);
    internal.setVisible(true);
    setTituloYRutaLabel(pr);
    setImagenes(pr);
    setCB.set(pr.getId());
  }

  private void setTituloYRutaLabel(Imagen siguientes) {
    internal.setTitle("Imagen " + cantidad + "/" + sizeRamdom);
    rutaLabel.setText(siguientes.getRutaInsertadaEnDB());
  }

  private void setLabelPagina(boolean pdf, Imagen siguientes) {
    if (pdf)
      {
      int page1 = siguientes.getPagina() + 1;
      pageLabel.setText("Pagina: " + page1);
      } else
      {
      pageLabel.setVisible(false);
      }
  }

  private void guardarYLimpiar(JLabel rutaJlabel, JTable tablaCheck, JLabel pagina, boolean pdf) {
    save.guardar(traza, rutaJlabel.getText(), tablaCheck, pagina, pdf);
    internal.dispose();
    desktopPane.removeAll();
    desktopPane.repaint();
  }

  private void setImagenes(Imagen siguientes) {
    String ruta = rutadeimagen.siguienteImagen(pdf, siguientes);
    setLabelPagina(pdf, siguientes);
    imageDraw.cargarImage(ruta, pdf, tif, combo);
    scrollImage.getViewport().add(imageDraw);
  }
}
