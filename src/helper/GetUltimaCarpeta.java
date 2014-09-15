/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import panelContol.TryFilechooser;

/**
 * obtiene la ultima carpeta del volumen
 * @author aguilangeles@gmail.com
 */
public class GetUltimaCarpeta {
  private String addLastFolder;
  

  public GetUltimaCarpeta() {
  }

  public static String getLastFolder(String aParent) {
    String ret = "";
    if (aParent.contains("\\"))
      {
      String replace = aParent.replace("\\", ", ");
      String[] rsplit = replace.split(", ");
      for (int i = 0; i < rsplit.length; i++)
        {
        ret = (rsplit[i]);
        }
      }
    String ultima =(TryFilechooser.isaDirectory())?ret+"-"+TryFilechooser.getCarpeta():ret;
    return ultima;
  }

  public String getAddLastFolder() {
    return addLastFolder;
  }

  public void setAddLastFolder(String addLastFolder) {
    this.addLastFolder = addLastFolder;
  }
  
}
