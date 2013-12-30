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

//  public static void anteriorImagen(boolean pdf, Imagen imagen) {
//    if (pdf)
//      {
//      int minus = imagen.getPagina() - 1;
//      ImagenesWorker worker = new ImagenesWorker(imagen.getRutaParaConversion(),
//              imagen.getParent(), minus);
//      retmin = worker.doInBackground();
//      } else if (!pdf)
//      {
//      retmin = imagen.getRutaParaConversion();
//      }
//  }

  public String getImage(Imagen imagen, int idImg) {
    switch (idImg)
      {
      case 1:
        ImagenesWorker worker = new ImagenesWorker(imagen.getRutaParaConversion(),
                imagen.getParent(), imagen.getPagina());
        proximaRuta = worker.doInBackground();
        imagen.setRutaCarpetaTemp(proximaRuta);
        break;
      case 2:
      case 3:
        proximaRuta = imagen.getRutaParaConversion();
        break;
      }
    return proximaRuta;
  }

  public static String getRetmin() {
    return retmin;
  }
}