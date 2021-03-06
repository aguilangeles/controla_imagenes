/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import database.UpdateCheckBoxs;
import database.SelectControlbyImage;
import entidad.ControlPorImagen;
import database.Conexion;
import entidad.Imagen;
import entidad.TrazaDao;
import helper.MensajeJoptionPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class Guardar {

  private TrazaDao traza;
  private String nombre;
  private JTable tablaCheck;
  private UpdateCheckBoxs updateChecs;
  private int idtraza, idimagen, page;
  private JLabel pagina;
  private Conexion conexion = new Conexion();
  private boolean fin;
  private boolean pdf;

  public Guardar() {
  }

  public void guardar(TrazaDao traza, String nombre, JTable tabla, JLabel pagina) {
    if (conexion.isConexion()) {
      pdf = (traza.getIdImagen() == 1) ? true : false;// discrimina entre pdf y otros
      /*diferencia entre pdf y otros y obtiene el numero de pagina*/
      getNumerodePagina(pdf, pagina);
      /*Trae la imagen desde la base de datos, junto con la pagina*/
      Imagen imagen = (Imagen) traza.getImageByNameAndPage(nombre, page);
      /*trae los controles asignados a esa imagen*/
      SelectControlbyImage controles = new SelectControlbyImage(traza.getId(), imagen.getId(), conexion);
      /*itera las posibilidades*/
      for (ControlPorImagen controlImagen : controles.getControlesList()) {
        for (int index = 0; index < tabla.getRowCount(); index++) {
          String descripcion = (String) tabla.getValueAt(index, 1);
          boolean check = (boolean) tabla.getValueAt(index, 0);
          if (descripcion.equals(controlImagen.getDescripcion())) {
            /*Modifica el estado en la base de datos en funcion de los cbx del frame*/
            controlImagen.setCheck(check);
            updateChecs = new UpdateCheckBoxs(controlImagen.getEstado(),
                    controlImagen.getIdTrazaArchivoControl(), conexion);
            updateChecs.updateEstadoTraza();
            tabla.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
            if (check) {
              updateChecs.updateEstadoArchivo(imagen.getId());
            }
          }
        }
      }
    }
    conexion.isConexionClose();

  }

  public void guardarDoc(TrazaDao traza, String nombre, JTable tabla, JLabel pagina, String gettitle) {
    if (conexion.isConexion()) {
      pdf = (traza.getIdImagen() == 1);// discrimina entre pdf y otros
      /*diferencia entre pdf y otros y obtiene el numero de pagina*/
      getNumerodePagina(pdf, pagina);
      /*Trae la imagen desde la base de datos, junto con la pagina*/
      Imagen imagen = (Imagen) traza.getImageByNamePageAndSublote(nombre, page, gettitle);
      /*trae los controles asignados a esa imagen*/
      SelectControlbyImage controles = new SelectControlbyImage(traza.getId(), imagen.getId(),  conexion);
      /*itera las posibilidades*/
      for (ControlPorImagen controlImagen : controles.getControlesList()) {
        /*itera la tabla*/
        for (int index = 0; index < tabla.getRowCount(); index++) {
          /*trae la descripcion */
          String descripcion = (String) tabla.getValueAt(index, 1);
          /*y el estado del control*/
          boolean check = (boolean) tabla.getValueAt(index, 0);
          if (descripcion.equals(controlImagen.getDescripcion())) {
            /*Modifica el estado en la base de datos en funcion de los cbx del frame*/
            controlImagen.setCheck(check);

            updateChecs = new UpdateCheckBoxs(controlImagen.getEstado(),
                    controlImagen.getIdTrazaArchivoControl(), conexion);
            updateChecs.updateEstadoTraza();
            tabla.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
            if (check) {
              updateChecs.updateEstadoArchivo(imagen.getId());
            }
          }
        }
      }
    }
    conexion.isConexionClose();

  }

  private void setNumeroPagina(JLabel pagina) {
    try {
      String rem = pagina.getText().replace("Pagina:", "").trim();
      int numeroPagina = Integer.parseInt(rem) - 1;
      this.page = numeroPagina;
    } catch (NumberFormatException e) {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(e.getMessage(), Guardar.class.getName());
    }
  }

  private void getNumerodePagina(boolean pdf, JLabel pagina) {
    if (pdf) {
      setNumeroPagina(pagina);
    } else {
      this.page = 0;
    }
  }
}
