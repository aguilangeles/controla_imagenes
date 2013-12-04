/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class SwitchListaExtension {

  private String extension;
  private List<Object> lista;
  private JLabel infoLabel;

  public SwitchListaExtension(String extension, List<Object> lista, JLabel infoLabel) {
    this.extension = extension;
    this.lista = lista;
    this.infoLabel = infoLabel;
  }

  public List<Object> switchExtension() {
    switch (extension) {

      case ".tif":
      case ".tiff":
      case ".TIF":
      case ".TIFF":
      case ".png":
      case ".jpg":
        lista = lista;
        break;
      case ".pdf":
        BuscarPaginasPdf pagePdf = new BuscarPaginasPdf(lista, infoLabel);
        lista = pagePdf.getListaPaginas();
        break;
      }
    return lista;
  }
}
