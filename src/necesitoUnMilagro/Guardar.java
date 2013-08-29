/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Daos.ControlPorImagen;
import Entidades.Conexion;
import Daos.Imagen;
import Daos.TrazaDao;
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
    private UpdateChecs updateChecs;
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
//    getNumerodePagina(pdf, pagina);
//    guardar(traza, nombre, tablaCheck, pagina, pdf);
//    borrarTemp();
  }

  public void guardar(TrazaDao traza, String nombre, JTable tablaCheck, JLabel pagina, boolean pdf) {
    if (conexion.isConexion()) {
      getNumerodePagina(pdf, pagina);
      Imagen tif = traza.getTifByNameAndPage(nombre, page);
      LlenarControles controles = new LlenarControles(traza.getId(), tif.getId(), conexion);
      for (ControlPorImagen controlxArchivo : controles.getLista()) {
        for (int index = 0; index < tablaCheck.getRowCount(); index++) {
          String descripcion = (String) tablaCheck.getValueAt(index, 1);
          boolean check = (boolean) tablaCheck.getValueAt(index, 0);
          if (descripcion.equals(controlxArchivo.getDescripcion())) {
            controlxArchivo.setCheck(check);
            updateChecs = new UpdateChecs(controlxArchivo.getEstado(),
                    controlxArchivo.getIdTrazaArchivoControl(), conexion);
            updateChecs.update();
             tablaCheck.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
            if (check) {
              updateChecs.updateEstadoArchivo(tif.getId());
            }
          }
        }
      }
      borrarTemp();
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
