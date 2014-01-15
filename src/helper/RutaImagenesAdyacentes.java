/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entidad.Imagen;
import Imagenes.ImagenesWorker;
import Imagenes.PanelVisual;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RutaImagenesAdyacentes implements ActionListener {

  private PanelVisual panelVisual;
  private static boolean pdf, tiff;
  private static String filenotfound = "AyudaImagenes/imagen-no-encontrada.jpg";
  private static GetImagenesAdyacentes imagenesAdyacentes;
  private static int idImagen;

  public RutaImagenesAdyacentes() {
  }

  public static void getAdyacentes(Imagen imagen, int idImage) {
    idImagen = idImage;
    switch (idImagen)
      {
      case 1:

        RutaImagenesAdyacentes.pdf = true;
        String pareng = imagen.getParent();
        GetImagenesAdyacentes adyacentes =
                new GetImagenesAdyacentes(imagen.getRutaParaConversion(), imagen.getPagina());
        ImagenAdyacenteParaPdf previus = getWorkerForPreviusPage(adyacentes, pareng, imagen);
        ImagenAdyacenteParaPdf next = getWorkerForNextPAge(adyacentes, pareng, imagen);

        GetImagenesAdyacentes newAdd = new GetImagenesAdyacentes();
        newAdd.setImagenAnterior(previus.getName());
        newAdd.setImagenPosterior(next.getName());
        int paginalabel = 1 + imagen.getPagina();
        newAdd.setNombreA("Anterior de " + previus.getNameforDb() + " (" + paginalabel + ")");
        newAdd.setNombreP("Posterior de " + next.getNameforDb() + " (" + paginalabel + ")");
        imagenesAdyacentes = newAdd;
        break;
      case 2:
      case 3:
        RutaImagenesAdyacentes.tiff = true;
        imagenesAdyacentes = imagen.adyacentes();
        break;
      }
  }

  public static GetImagenesAdyacentes getImg() {
    return imagenesAdyacentes;
  }

  public static boolean isPdf() {
    return pdf;
  }

  public static boolean isTiff() {
    return tiff;
  }

  private static ImagenAdyacenteParaPdf getImagenPrevia(GetImagenesAdyacentes ady) {
    ImagenAdyacenteParaPdf ant = null;
    if (ady.getAnt() == null)
      {
      ant = new ImagenAdyacenteParaPdf(filenotfound, 0, "Sin Imagen Anterior");
      } else
      {
      ant = ady.getAnt();
      }
    return ant;
  }

  private static ImagenAdyacenteParaPdf getImagenPosterior(GetImagenesAdyacentes ady) {
    ImagenAdyacenteParaPdf pst = null;
    if (ady.getPst() == null)
      {
      pst = new ImagenAdyacenteParaPdf(filenotfound, 0, "Sin Imagen Posterior");
      } else
      {
      pst = ady.getPst();
      }
    return pst;
  }

  private static ImagenAdyacenteParaPdf getWorkerForPreviusPage(GetImagenesAdyacentes adyacente, String pareng, Imagen imagen) {
    String i = "";
    ImagenAdyacenteParaPdf nuevaImg = null;
    ImagenAdyacenteParaPdf imgAdyPrevia = getImagenPrevia(adyacente);

    if (!imgAdyPrevia.getName().equals(filenotfound))
      {
      ImagenesWorker iworker1 = new ImagenesWorker(imgAdyPrevia.getName(), pareng, imgAdyPrevia.getPage());
      i = iworker1.doInBackground();
      nuevaImg = new ImagenAdyacenteParaPdf(i, imagen.getPagina(), imagen.getRutaInsertadaEnDB());
      } else
      {

      nuevaImg = imgAdyPrevia;
      }
    return nuevaImg;
  }

  private static ImagenAdyacenteParaPdf getWorkerForNextPAge(GetImagenesAdyacentes ady, String pareng, Imagen imagen) {
    ImagenAdyacenteParaPdf newPosterior = null;
    ImagenAdyacenteParaPdf posterior = getImagenPosterior(ady);
    if (!posterior.getName().equals(filenotfound))
      {
      ImagenesWorker iworker2 = new ImagenesWorker(posterior.getName(), pareng, posterior.getPage());
      String b = (iworker2.doInBackground());
      newPosterior = new ImagenAdyacenteParaPdf(b, imagen.getPagina(), imagen.getRutaInsertadaEnDB());
      } else
      {
      newPosterior = posterior;
      }
    return newPosterior;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    new PanelVisual(imagenesAdyacentes.getImagenAnterior(),
            imagenesAdyacentes.getImagenPosterior(),
            imagenesAdyacentes.getNombreA(),
            imagenesAdyacentes.getNombreP(), idImagen).setVisible(true);
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
