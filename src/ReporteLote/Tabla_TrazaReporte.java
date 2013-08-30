/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Tabla_TrazaReporte extends JFrame {

  private Conexion conexion;
  private int idtraza;
  private JTable tabla;
  private Object fecha;
  private int tamanio;
  private int ide;
  private int muestra;
  private int rechazo;
  private String rutaCompleta;
  private String resultados;
  private String verificacion;
  private String usuario;
  private String documento;

  public Tabla_TrazaReporte(Conexion conexion, int idtraza, JTable tabla) {
    this.conexion = conexion;
    this.idtraza = idtraza;
    this.tabla = tabla;
    DefaultTableModel modelo = modelarTabla();
    this.tabla.setModel(modelo);
  }

  private DefaultTableModel modelarTabla() {
    DefaultTableModel modelo = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int fila, int columna) {
        return false;
      }
    };
    modelo.addColumn("Detalle");
    modelo.addColumn("Cantidad");
    consultaYCarga();
    poblarTabla(modelo);
    return modelo;
  }

  private void consultaYCarga() {
    try {
      String query = "SELECT t.fecha_control "
              + ", t.tamanio_lote "
              + ", t.cantidad_muestreada "
              + ", t.nro_rechazo  "
              + ", v.descripcion "
              + ", u.nombre "
              + ", d.descripcion "
              + ", t.id "
              + ", t.rutaCompleta "
              + "from traza t  "
              + "join tipos_verificacion v "
              + "on t.idVerificacion = v.id "
              + "join usuarios u "
              + "on t.idUsuarios = u.id "
              + "join tipos_documentos d "
              + "on t.idTipoDocumento = d.id "
              + "where t.id =" + idtraza;
      conexion.executeQuery(query);
      while (conexion.resulset.next()) {
        fecha = conexion.resulset.getObject(1);
        tamanio = conexion.resulset.getInt(2);
        muestra = conexion.resulset.getInt(3);
        rechazo = conexion.resulset.getInt(4);
        verificacion = conexion.resulset.getString(5);
        usuario = conexion.resulset.getString(6);
        documento = conexion.resulset.getString(7);
        ide = conexion.resulset.getInt(8);
        rutaCompleta = conexion.resulset.getString(9);
        resultados = ordenarResultados();
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Carga de Tabla Reporte", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void poblarTabla(DefaultTableModel modelo) {
    String titulos = "Operador de Control, Fecha de Control, Id Traza, Ruta Completa, "
            + "Tamanio Lote, Cantidad muestreada, Total Rechazos, "
            + "Linea de captura, Digitalizador, Tipo de Verificacion, Tipo de Documento, ";
    String[] titulo = titulos.split(", ");
    for (int t = 0; t < titulo.length; t++) {
      modelo.addRow(new Object[]{titulo[t], 0});
    }
    resultadosEnTabla(modelo);
  }

  private String ordenarResultados() {
    String ret = usuario + ", " + fecha + ", " + ide+ ", " + rutaCompleta +", " + tamanio
            + ", " + muestra + ", " + rechazo
            + ", --/--, --/--, " + verificacion + ", " + documento;
    return ret;
  }

  public String getResultados() {
    return resultados;
  }

  public int getRechazo() {
    return rechazo;
  }

  private void resultadosEnTabla(DefaultTableModel modelo) {
    String[] split = getResultados().split(", ");
    for (int i = 0; i < split.length; i++) {
      Object[] o = new Object[]{"", split[i]};
      modelo.setValueAt(split[i], i, 1);
    }
  }
}
