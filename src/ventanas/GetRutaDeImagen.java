/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import entidad.Imagen;
import imagen.ImagenesWorker;

/**
 *
 * @author MUTNPROD003
 */
public final class GetRutaDeImagen {

  private String proximaRuta;

  public GetRutaDeImagen() {
  }

  public String getImage(Imagen imagen, int idImg) {
    switch (idImg) {
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
    System.out.println("get ruta de imagen "+proximaRuta);
    return proximaRuta;
  }
}
