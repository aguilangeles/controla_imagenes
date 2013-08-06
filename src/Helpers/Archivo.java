/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entidades.Conexion;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Archivo {

  private Conexion conexion;
  private int id = 1;
  private String ruta;
  private int page;

  public Archivo(Conexion conexion, int id, String ruta, int page, JLabel procesando) {
    this.conexion = conexion;
    this.id += id;
    this.ruta = ruta;
    this.page = page;
    archivo_Insertar(procesando);
  }

  private boolean archivo_Insertar(JLabel procesando) {
    //cambiar por booleano
    int estado = 0;
    String ret = "Insert into qualitys.archivo (idTraza, ruta_archivo, pagina_pdf, estado)"
            + " VALUES (" + id + ", '" + ruta + "' ," + page + " ," + estado + ");";
    procesando.setText("Insertando " + ruta);
    try {
      conexion.executeUpdate(ret);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Archivo Insertar", JOptionPane.ERROR_MESSAGE);

//        Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }
}
