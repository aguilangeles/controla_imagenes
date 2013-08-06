/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.Imagen;
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
      ImagenesWorker worker = new ImagenesWorker(imagen.getRuta_archivo(),
              imagen.getParent(), imagen.getPagina());
      anteriorRuta = worker.doInBackground();
      imagen.setRutaTemp(anteriorRuta);
    } else if (!pdf) {
      anteriorRuta = imagen.getRuta_archivo();
    }
    return anteriorRuta;
  }
//  public String anteriorImagen(boolean pdf, Imagen imagen) {
//    String visualizacion = "";
//    if (pdf) {
//      anteriorRuta = imagen.getRutaTemp();
//    } else if (!pdf) {
//      anteriorRuta = imagen.getRuta_archivo();
//    }
//    return anteriorRuta;
//  }

  public String siguienteImagen(boolean pdf, Imagen imagen) {
    if (pdf) {
      ImagenesWorker worker = new ImagenesWorker(imagen.getRuta_archivo(),
              imagen.getParent(), imagen.getPagina());
      siguienteRuta = worker.doInBackground();
      imagen.setRutaTemp(siguienteRuta);
    } else if (!pdf) {
      siguienteRuta = imagen.getRuta_archivo();
    }
    return siguienteRuta;
  }
}