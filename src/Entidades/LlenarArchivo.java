/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Ventana.ImagenesWorker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarArchivo {

  private int idTraza;
  private Conexion conexion;
  private String parent;
  private boolean isPdf;
  private List<Imagen> imagenProcesada = new ArrayList<>();
  private ImagenesWorker worker;
  private JLabel procesando;

  public LlenarArchivo(Conexion conexion, int idTraza, String parent, boolean isPdf, JLabel procesando) {
    this.conexion = conexion;
    this.idTraza = idTraza;
    this.parent = parent;
    this.isPdf = isPdf;
    llenarImagenes();
  }

  private List<Imagen> llenarImagenes() {
    Runtime gar = Runtime.getRuntime();
    Imagen imagen;
    try {
      String query = "SELECT id , ruta_archivo, pagina_pdf FROM qualitys.archivo where idtraza = " + idTraza + ";";
      conexion.ExecuteSql(query);
      while (conexion.resulset.next()) {
        int id = conexion.resulset.getInt(1);
        String ruta_archivo = conexion.resulset.getString(2);
        int pagina = conexion.resulset.getInt(3);
        if (isPdf) {
          imagen = new Imagen(id, ruta_archivo, parent, pagina);
          imagenProcesada.add(imagen);
        } else {
          imagen = new Imagen(id, ruta_archivo, parent);
          imagenProcesada.add(imagen);
        }

      }

    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en insercion de ruta archivo", JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(LlenarArchivo.class.getName()).log(Level.SEVERE, null, ex);
    }
    gar.gc();
    return imagenProcesada;
  }

  public List<Imagen> getListaArchivos() {
    return imagenProcesada;
  }
}
