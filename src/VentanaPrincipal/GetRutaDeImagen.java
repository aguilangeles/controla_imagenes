/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import Entidades.Imagen;
import Imagenes.ImagenesWorker;

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
      } else if (!pdf)
      {
      System.out.println("ruta para la conversion " + retmin);
      retmin = imagen.getRutaParaConversion();
      }
  }

  public String getImage(boolean pdf, Imagen imagen) {
    if (pdf)
      {
      ImagenesWorker worker = new ImagenesWorker(imagen.getRutaParaConversion(),
              imagen.getParent(), imagen.getPagina());
      proximaRuta = worker.doInBackground();
      imagen.setRutaCarpetaTemp(proximaRuta);

      } else if (!pdf)
      {
      proximaRuta = imagen.getRutaParaConversion();
      System.out.println("ruta para la conversion p " + proximaRuta);
      }
    return proximaRuta;
  }

  public static String getRetmin() {
    return retmin;
  }
}