/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.UpdateCheckBoxs;
import BasedeDatos.LlenarControles;
import Entidades.ControlPorImagen;
import BasedeDatos.Conexion;
import Entidades.Imagen;
import Entidades.TrazaDao;
import java.io.File;
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

  public Guardar() {
  }


  public Guardar(TrazaDao traza, String nombre, JTable tablaCheck, JLabel pagina, boolean pdf) {
    this.traza = traza;
    this.nombre = nombre;
    this.tablaCheck = tablaCheck;
  }

  public void guardar(TrazaDao traza, String nombre, JTable tabla, JLabel pagina, boolean pdf) {
    if (conexion.isConexion()) {
      /*diferencia entre pdf y otros y obtiene el numero de pagina*/
      getNumerodePagina(pdf, pagina);
      /*Trae la imagen desde la base de datos, junto con la pagina*/
      Imagen imagen = traza.getImageByNameAndPage(nombre, page);
      /*trae los controles asignados a esa imagen*/
      LlenarControles controles = new LlenarControles(traza.getId(), imagen.getId(), conexion);
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
//      borrarTemp();
    }
    conexion.isConexionClose();

  }

  private void setNumeroPagina(JLabel pagina) {
    try {
      String rem = pagina.getText().replace("Pagina:", "").trim();
      int numeroPagina = Integer.parseInt(rem) - 1;
      this.page = numeroPagina;
    } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Setear numero Pagina PDF", JOptionPane.ERROR_MESSAGE);

//      System.out.println(e.getMessage());
    }
  }

  public boolean isFin() {
    return fin;
  }

  public void setFin(boolean fin) {
    this.fin = fin;
  }

   private void borrarTemp() {
    File file = new File("temp\\");
    File[] files = file.listFiles();
    for (File f : files) {
      f.delete();
      System.gc();
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
