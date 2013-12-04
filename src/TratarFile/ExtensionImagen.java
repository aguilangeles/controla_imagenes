/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

/**
 *
 * @author MUTNPROD003
 */
public class ExtensionImagen {

  private String extension;

  public ExtensionImagen(String extension) {
    this.extension = buscarExt(extension);
  }

  private String buscarExt(String extension) {
    String ret = "";
    if (extension.endsWith(".tif"))
      {
      ret = ".tif";
      } else if (extension.endsWith(".pdf"))
      {
      ret = ".pdf";
      } else if (extension.endsWith(".jpg"))
      {
      ret = ".jpg";
      } else if (extension.endsWith(".png"))
      {
      ret = ".png";
      }
    return ret;
  }

  public String getExtension() {
    return extension;
  }
}
