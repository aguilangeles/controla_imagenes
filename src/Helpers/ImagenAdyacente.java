/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ImagenAdyacente {
  private String name;
  private int page;
  private String nameforDb;

  public ImagenAdyacente(String name, int page, String nameforDb) {
    this.name = name;
    this.page = page;
    this.nameforDb = nameforDb;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public String getNameforDb() {
    return nameforDb;
  }

  public void setNameforDb(String nameforDb) {
    this.nameforDb = nameforDb;
  }

  @Override
  public String toString() {
    return "ImagenAdyacente{" + "name=" + name + ", page=" + page + ", nameforDb=" + nameforDb + '}';
  }
  

}
