/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 * Login a la base de datos mysql Qualitys
 *
 * @author MUTNPROD003
 */
public class LogQualitys {

  private String url;
  private String base;
  private String usuario;
  private String password;

  public LogQualitys(String url, String base, String usuario, String password) {
    this.url = url;
    this.base = base;
    this.usuario = usuario;
    this.password = password;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  @Override
  public String toString() {
    return "Usuario{" + "url=" + url + ", base=" + base + ", usuario="
            + usuario + ", password=" + password + '}';
  }
}
