/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import java.util.List;
import javax.swing.JLabel;
import tratamientoruta.BuscarPaginasPdf;

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
      case ".png":
      case ".jpg":
        lista = lista;
        break;
      case ".pdf":
        BuscarPaginasPdf pagePdf = new BuscarPaginasPdf(lista, infoLabel);
        lista = pagePdf.getLista();
        break;
    }
    return lista;
  }
}
