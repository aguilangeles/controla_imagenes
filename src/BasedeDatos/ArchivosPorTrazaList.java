/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Entidades.Imagen;
import Imagenes.ImagenesWorker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class ArchivosPorTrazaList {
  private List<Imagen> imagenProcesada = new ArrayList<>();
  private ImagenesWorker worker;

  public ArchivosPorTrazaList(Conexion conexion, int idTraza, String parent, boolean isPdf) {
    getImagen_y_pagina_desde_Archivo(conexion, idTraza, parent, isPdf);
  }

  private void getImagen_y_pagina_desde_Archivo(Conexion conexion, int idTraza, String parent, boolean isPdf) {
    Runtime gar = Runtime.getRuntime();
    Imagen imagen;
    try {
      String query = "SELECT id , ruta_archivo, pagina_pdf FROM qualitys.archivo where idtraza = " + idTraza + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next()) {
        int id = conexion.resulset.getInt(1);
        String ruta_archivo = conexion.resulset.getString(2);
        int pagina = conexion.resulset.getInt(3);
        diferenciarPDF(isPdf, id, ruta_archivo, parent, pagina);
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la consulta de ruta archivo", JOptionPane.ERROR_MESSAGE);
    }
    gar.gc();
  }


  private void diferenciarPDF(boolean isPdf, int id, String ruta_archivo, String parent, int pagina) {
    Imagen imagen;
    if (isPdf) {
      imagen = new Imagen(id, ruta_archivo, parent, pagina);
      imagenProcesada.add(imagen);
    } else {
      imagen = new Imagen(id, ruta_archivo, parent,0);
      imagenProcesada.add(imagen);
    }
  }
  public List<Imagen> getListaArchivos() {
    return imagenProcesada;
  }
}