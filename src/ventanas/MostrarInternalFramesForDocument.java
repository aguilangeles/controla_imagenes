/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import imagen.ImageDrawingComponent;
import entidad.Imagen;
import entidad.TrazaDao;
import helper.MensajeJoptionPane;
import helper.VersionEImageIcon;
import entidad.Sublote;
import java.beans.PropertyVetoException;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class MostrarInternalFramesForDocument {

  private TrazaDao traza;
  private JDesktopPane desktopPane;
  private JInternalFrame internal;
  private JComboBox combo;
  private JScrollPane scrollImage;
  private int totalDocumento, idTipoImagen;
  private JLabel rutaLabel, pageLabel, totales;
  private JTable tabla;
  private static GetRutaDeImagen rutadeimagen = new GetRutaDeImagen();
  private static ImageDrawingComponent imageDraw = new ImageDrawingComponent();
  private static Guardar save;
  private static SetChecksBox setCB;
  private JPanel panelScroll;
  private JButton anterior, siguiente, botonAncho, pEntera, nextDoc, prevDoc;
  private VersionEImageIcon vic;
  private String parcialSoTotal;

  public MostrarInternalFramesForDocument(JDesktopPane desktopPane,
          JInternalFrame internal, JLabel rutaLabel, JLabel pageLabel, JPanel panelSroll, JTable tabla, JComboBox combo, TrazaDao traza, JButton siguiente, JButton anterior, JButton ancho, JButton pEntera, JScrollPane scrollImage, int sizeRamdom, VersionEImageIcon version, JButton nextDocum, JButton prevDocum, JLabel totales) {
    this.traza = traza;
    this.desktopPane = desktopPane;
    this.internal = internal;
    this.anterior = anterior;
    this.idTipoImagen = traza.getIdImagen();
    this.combo = combo;
    this.scrollImage = scrollImage;
    this.rutaLabel = rutaLabel;
    this.pageLabel = pageLabel;
    this.tabla = tabla;
    this.siguiente = siguiente;
    this.botonAncho = ancho;
    this.pEntera = pEntera;
    this.panelScroll = panelSroll;
    this.totalDocumento = sizeRamdom;
    this.vic = version;
    this.nextDoc = nextDocum;
    this.totales = totales;
    this.prevDoc = prevDocum;
    MostrarInternalFramesForDocument.save = new Guardar();// sa
    MostrarInternalFramesForDocument.setCB = new SetChecksBox(tabla);//trae los estados desde la base de datos
  }

  public void mostrarPrimeraImagen(Imagen imagen, int nroImagen, Sublote sublote, int numSublote) {
    try {
      internal.setMaximum(true);
      vic.newColorFromPanel(panelScroll);
      internal.setBackground(vic.getColor());
      adaptarFrame(imagen, nroImagen, sublote, numSublote);

    } catch (PropertyVetoException ex) {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), MostrarInternalFrames.class.getName());
    }
  }//

  public void setNextImage(Imagen imagen1, int nroImagen, Sublote sublote, int numSublote) {
    anterior.setEnabled(true);
    prevDoc.setEnabled(true);
    guardarYLimpiar(rutaLabel, tabla, pageLabel);
    desktopPane.add(internal);
    adaptarFrame(imagen1, nroImagen, sublote, numSublote);
    internal.setVisible(true);
  }

  public void setBackImage(Imagen pr, int cantidad, Sublote sublote, int numSublote) {
    guardarYLimpiar(rutaLabel, tabla, pageLabel);
    siguiente.setEnabled(true);
    nextDoc.setEnabled(true);
    desktopPane.add(internal);
    internal.setVisible(true);
    adaptarFrame(pr, cantidad, sublote, numSublote);
  }

  private void setTituloYRutaLabel(Imagen imagen, int cantSublote, Sublote sublotes) {
    String ruta = sublotes.getNombre().replace("\\\\", "\\");
    String pathsub = ruta.replace("\\", File.separator);
    parcialSoTotal = " (" + cantSublote + "/ " + totalDocumento + ")";
    String rutaSublote1 = ruta + parcialSoTotal;
    internal.setTitle(rutaSublote1);
    rutaLabel.setText(imagen.getRutaInsertadaEnDB());
  }

  private void setLabelPagina(Imagen imagen, int nroImagen, Sublote sublote) {
    switch (idTipoImagen) {
      case 1:
        int page1 = imagen.getPagina() + 1;
        pageLabel.setText(page1 + "");
        totales.setText("/ " + sublote.getTamanio());
        break;
      case 2:
        pageLabel.setText(nroImagen + "");
        totales.setText("/ " + sublote.getTamanio());
      case 3:
        break;
    }
  }

  private void guardarYLimpiar(JLabel rutaJlabel, JTable tablaCheck, JLabel pagina) {
    String gettitle = internal.getTitle().toString().replace(parcialSoTotal, "");
    save.guardarDoc(traza, rutaJlabel.getText(), tablaCheck, pagina, gettitle);
    internal.dispose();
    desktopPane.removeAll();
    desktopPane.repaint();
  }

  private void setImagenes(Imagen siguientes, int cantidad, Sublote sublote) {
    String ruta = rutadeimagen.getImage(siguientes, idTipoImagen);
    setLabelPagina(siguientes, cantidad, sublote);
    imageDraw.cargarImage(ruta, combo, panelScroll, botonAncho, pEntera, idTipoImagen);
    scrollImage.getViewport().add(imageDraw);
  }

  private void adaptarFrame(Imagen imagen, int nroImagen, Sublote sublote, int nroSublote) {
    setTituloYRutaLabel(imagen, nroSublote, sublote);
    setImagenes(imagen, nroImagen, sublote);
    setCB.set(imagen.getId());
  }

  public String getParcialSoTotal() {
    return parcialSoTotal;
  }

}
