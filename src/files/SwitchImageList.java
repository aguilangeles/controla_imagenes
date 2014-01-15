/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import Helpers.GetIdandExtensionImg;
import java.util.List;
import javax.swing.JLabel;

/**
 * discrimina el proceso segun tipo de imagen
 *
 * @author aguilangeles@gmail.com
 */
public class SwitchImageList {

  private JLabel infoLabel;

  public SwitchImageList(JLabel infoLabel) {
    this.infoLabel = infoLabel;
  }

  public List<Object> switchExtension(List<Object> objectList) {
    List<Object> finalListofImages = null;
    int idImagen = GetIdandExtensionImg.getIdImagen();
    switch (idImagen)
      {
      case 1:
        BuscarPaginasPdf pagePdf = new BuscarPaginasPdf(objectList, infoLabel);
        finalListofImages = pagePdf.getListaPaginas();
        break;
      case 2:
      case 3:
        finalListofImages = objectList;
        break;
      }
    return finalListofImages;
  }
}
