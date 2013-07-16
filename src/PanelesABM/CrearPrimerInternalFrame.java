/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.Imagen;
import Ventana.ImagenesWorker;
import Ventana.Ventana;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author maria
 */
public class CrearPrimerInternalFrame {
  
private boolean ispdf;
private Imagen siguienteImg;
private JTable tablaCheck;
private JInternalFrame internal;
private JLabel ruta,pagina;
private int contador, sizeRamdom;

  public CrearPrimerInternalFrame(boolean ispdf, JLabel ruta, JLabel pagina, Imagen siguienteImg, JTable tablaCheck, JInternalFrame internal,  int contador, int getSizeRamdom) {
    this.ispdf = ispdf;
    this.ruta = ruta;
    this.pagina = pagina;
    this.siguienteImg = siguienteImg;
    this.tablaCheck = tablaCheck;
    this.internal = internal;
    this.contador = contador;
    this.sizeRamdom = getSizeRamdom;
  }


  
  
  public String getInternal() {
    String verImagen = null;
    try {
      internal.setMaximum(true);
      String rutaDb = siguienteImg.getRutaDb();//ruta de archivo
      internal.setTitle("Imagen " + contador + "/" + sizeRamdom);
      ruta.setText(rutaDb);
      internal.setVisible(true);
      verImagen = primeraImagen(ispdf, siguienteImg, pagina);

    } catch (PropertyVetoException ex) {
      Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
    return verImagen;
  }

  private String primeraImagen(boolean ispdf, Imagen siguientes, JLabel pagina) {
    String ret;
    if (ispdf) {
      
      ImagenesWorker worker = new ImagenesWorker(siguientes.getRuta_archivo().replace("\\", "/"), siguientes.getParent(), siguientes.getPagina());
      worker.execute();
      ret = worker.doInBackground().replace("\\", "/");
      siguientes.setRutaTemp(ret);
      int page = siguientes.getPagina() + 1;
      pagina.setText("Pagina: " + page);
    } else {
      ret = siguientes.getRuta_archivo().replace("\\", "/");
      pagina.setVisible(false);
    }
    return ret;
  }

  public Imagen getSiguienteImg() {
    return siguienteImg;
  }
  
}
