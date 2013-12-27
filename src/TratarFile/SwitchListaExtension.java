/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import Helpers.GetExtensionIdImagen;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class SwitchListaExtension {

  private List<Object> lista;
  private JLabel infoLabel;

  public SwitchListaExtension(List<Object> lista, JLabel infoLabel) {
    this.lista = lista;
    this.infoLabel = infoLabel;
  }

  public List<Object> switchExtension() {
    int idImagen = GetExtensionIdImagen.getIdImagen();
    switch (idImagen)
      {
      case 1:
        BuscarPaginasPdf pagePdf = new BuscarPaginasPdf(lista, infoLabel);
        lista = pagePdf.getListaPaginas();
        break;
      case 2:
      case 3:
        lista = lista;
        break;
      }
    return lista;
  }
}
