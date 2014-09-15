/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import helper.GetParent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class TryFilechooser {

  private String path; 
  private static String carpeta;
  private List<File> fileList =new ArrayList<>();
  private static boolean aDirectory;
  private JFileChooser chooser;

  public TryFilechooser() {
    getfilechooser();
  }
  
  
  private void getfilechooser() {
    chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("Seleccione Carpeta");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    chooser.setMultiSelectionEnabled(true);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    {
      File[] files = chooser.getSelectedFiles();
      GetParent parent = new GetParent(files); // trae la ruta completa

      if (files.length != 1)
      {
	aDirectory=true;
	for (int i = 0; i < files.length; i++)
	{
	  File file = files[i];
	  fileList.add(file);
	}
      } else
      {
	aDirectory=false;
	path = chooser.getSelectedFile().toString();
      }
    } else
    {
      System.out.println("No Selection ");
    }
  }

  public List<File> getFileList() {
    return fileList;
  }

  public void setFileList(List<File> fileList) {
    this.fileList = fileList;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public static boolean isaDirectory() {
    return aDirectory;
  }
  public static String getCarpeta() {
    return carpeta;
  }

  public static void setCarpeta(String carpeta) {
    TryFilechooser.carpeta = carpeta;
  }

}
