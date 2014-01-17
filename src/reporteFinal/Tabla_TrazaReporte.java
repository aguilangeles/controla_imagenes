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
public class Tabla_TrazaReporte extends JFrame {

  private Conexion conexion;
  private int idtraza;
  private JTable tabla;
  private Object fecha;
  private int tamanio;
  private int ide;
  private int muestra;
  private int rechazo;
  private int limite;
  private String rutaCompleta;
  private String resultados;
  private String verificacion;
  private String usuario;
  private String documento;
  private String estado;

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
        if (fila == 9 || fila == 10)
          {
          return true;
          }
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
    try
      {
      String query = "SELECT t.fecha_control  "
              + ", t.tamanio_lote  "
              + ", t.cantidad_muestreada "
              + ", ra.cant_rechazo "
              + ", t.nro_rechazo "
              + ", v.nombre  "
              + ", u.nombre  "
              + ", d.descripcion  "
              + ", t.id  "
              + ", t.rutaCompleta  "
              + "from traza t   "
              + "join tipos_verificacion v  "
              + "on t.idVerificacion = v.id  "
              + "join usuarios u  "
              + "on t.idUsuarios = u.id  "
              + "join tipos_documentos d  "
              + "on t.idTipoDocumento = d.id  "
              + "join rangos_qs ra "
              + "on t.idRango = ra.id "
              + "where t.id = " + idtraza + "; ";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        fecha = conexion.resulset.getObject(1);
        tamanio = conexion.resulset.getInt(2);
        muestra = conexion.resulset.getInt(3);
        limite = conexion.resulset.getInt(4);
        rechazo = conexion.resulset.getInt(5);
        verificacion = conexion.resulset.getString(6);
        usuario = conexion.resulset.getString(7);
        documento = conexion.resulset.getString(8);
        ide = conexion.resulset.getInt(9);
        rutaCompleta = conexion.resulset.getString(10);
        estado = AutomaticoRoA.getStatusName();
        resultados = ordenarResultados();
        }
      } catch (SQLException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(this, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), Tabla_TrazaReporte.class.getName());
      }
  }

  private void poblarTabla(DefaultTableModel modelo) {
    String titulos = "Operador de Control, Fecha de Control, Id Traza, Ruta Completa, "
            + "Tamanio Lote, Cantidad muestreada, Limite Rechazos, Total Rechazos, "
            + "Estado, Linea de captura, Digitalizador, Tipo de Verificacion, Tipo de Documento, ";
    String[] titulo = titulos.split(", ");
    for (int t = 0; t < titulo.length; t++)
      {
      modelo.addRow(new Object[]
        {
        titulo[t], 0
        });
      }
    resultadosEnTabla(modelo);
  }

  private String ordenarResultados() {
    String captura = "";
    String digitalizador = "";
    String ret = usuario + ", " + fecha + ", " + ide + ", " + rutaCompleta + ", " + tamanio
            + ", " + muestra + ", " + limite + ", " + rechazo + ", " + estado + ", " + captura + ", " + digitalizador
            + ", " + verificacion + ", " + documento;
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
    for (int i = 0; i < split.length; i++)
      {
      Object[] o = new Object[]
        {
        "", split[i]
        };
      modelo.setValueAt(split[i], i, 1);
      }
  }
}
