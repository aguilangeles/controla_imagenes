/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Daos.Imagen;
import Ventana.ImagenesWorker;

/**
 *
 * @author MUTNPROD003
 */
public final class GetRutaDeImagen {

  private String siguienteRuta, anteriorRuta;

  public GetRutaDeImagen() {
  }



  public String anteriorImagen(boolean pdf, Imagen imagen) {
    if (pdf) {
      ImagenesWorker worker = new ImagenesWorker(imagen.getRutaParaConversion(),
              imagen.getParent(), imagen.getPagina());
      anteriorRuta = worker.doInBackground();
      imagen.setRutaCarpetaTemp(anteriorRuta);
    } else if (!pdf) {
      anteriorRuta = imagen.getRutaParaConversion();
    }
    return anteriorRuta;
  }
//  public String anteriorImagen(boolean pdf, Imagen imagen) {
//    String visualizacion = "";
//    if (pdf) {
//      anteriorRuta = imagen.getRutaCarpetaTemp();
//    } else if (!pdf) {
//      anteriorRuta = imagen.getRutaParaConversion();
//    }
//    return anteriorRuta;
//  }

  public String siguienteImagen(boolean pdf, Imagen imagen) {
    if (pdf) {
      ImagenesWorker worker = new ImagenesWorker(imagen.getRutaParaConversion(),
              imagen.getParent(), imagen.getPagina());
      siguienteRuta = worker.doInBackground();
      imagen.setRutaCarpetaTemp(siguienteRuta);
    } else if (!pdf) {
      siguienteRuta = imagen.getRutaParaConversion();
    }
    return siguienteRuta;
  }
}