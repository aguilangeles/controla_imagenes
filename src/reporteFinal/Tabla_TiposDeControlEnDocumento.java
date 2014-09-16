/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteFinal;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.Conexion;
import helper.MensajeJoptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Tabla_TiposDeControlEnDocumento extends JFrame {

  private int idtraza;
  private Conexion conexion;
  private JTable tabla;
  private int idControl;
  private String rutaSublote;
  private String descripcion;

  public Tabla_TiposDeControlEnDocumento(int idtraza, Conexion conexion, JTable tabla) {
    this.idtraza = idtraza;
    this.conexion = conexion;
    this.tabla = tabla;
    crearTabla();
  }

  private void crearTabla() {
    DefaultTableModel modelo = poblarSegundatabla();
    tabla.setModel(modelo);
    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//    tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
    tabla.getColumnModel().getColumn(0).setPreferredWidth(320);
    tabla.getColumnModel().getColumn(1).setPreferredWidth(135);
  }

  private DefaultTableModel poblarSegundatabla() {
    DefaultTableModel modelTipos = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int fila, int columna) {
        return false;
      }
    };
//    modelTipos.addColumn("idSublote");
    modelTipos.addColumn("Sublote");
    modelTipos.addColumn("Ctrl");
    CantidadesEncontradasDeErroresPorTDC(modelTipos);
    return modelTipos;
  }

  private void CantidadesEncontradasDeErroresPorTDC(DefaultTableModel modelTipos) {
    try
      {
      String query = "SELECT "
              + "distinct(ss.id)"
              + ", ss.ruta"
              + ", ct.descripcion"
              + " FROM qualitys.sublotes ss"
              + " join archivo_sublote arc"
              + " on arc.idsublote = ss.id"
              + " join traza_archivo_controles tac"
              + " on tac.idarchivo = arc.idarchivo"
              + " join controles ct"
              + " on tac.idcontrol = ct.id"
              + " where ss.idtraza= " + idtraza
              + " and tac.estado = 1;";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        idControl = conexion.resulset.getInt(1);
        rutaSublote = conexion.resulset.getString(2);
        descripcion = conexion.resulset.getString(3);
        modelTipos.addRow(new Object[]
          {
          rutaSublote, descripcion
          });

        }
      } catch (SQLException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(this, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), Tabla_TiposDeControlEnDocumento.class.getName());
      }
  }
}
