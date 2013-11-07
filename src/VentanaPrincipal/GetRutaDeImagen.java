/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import Entidades.Imagen;
import Imagenes.ImagenesWorker;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public final class GetRutaDeImagen {

  private String proximaRuta;
  private static String retmin;

  public GetRutaDeImagen() {
  }

  public static void anteriorImagen(boolean pdf, Imagen imagen) {
    if (pdf)
      {
      int minus = imagen.getPagina() - 1;
      ImagenesWorker worker = new ImagenesWorker(imagen.getRutaParaConversion(),
              imagen.getParent(), minus);
      retmin = worker.doInBackground();
      // imagen.setRutaCarpetaTemp(anteriorRuta);
      } else if (!pdf)
      {
      retmin = imagen.getRutaParaConversion();
      }
//    System.out.println(imagen.getRutaParaConversion());
  }

  public String getImage(boolean pdf, Imagen imagen) {
    anteriorImagen(pdf, imagen);
    if (pdf)
      {
      ImagenesWorker worker = new ImagenesWorker(imagen.getRutaParaConversion(),
              imagen.getParent(), imagen.getPagina());
      proximaRuta = worker.doInBackground();
      imagen.setRutaCarpetaTemp(proximaRuta);

      } else if (!pdf)
      {
      proximaRuta = imagen.getRutaParaConversion();
      }
    return proximaRuta;
  }

  public static String getRetmin() {
    return retmin;
  }
}