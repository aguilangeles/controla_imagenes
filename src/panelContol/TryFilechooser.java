/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class TryFilechooser {

  private String path; 
  public void getfilechooser() {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("choosertitle");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    chooser.setMultiSelectionEnabled(true);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    {
      File[] files = chooser.getSelectedFiles();
      if (files.length != 1)
      {

	for (int i = 0; i < files.length; i++)
	{
	  File file = files[i];
	  System.out.println(file.getAbsoluteFile());
	}
      } else
      {
	path = chooser.getSelectedFile().toString();
//	System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
//	System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
      }
    } else
    {
      System.out.println("No Selection ");
    }

  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}
