/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Tabla_TrazaReporte extends JFrame{
    private Conexion conexion;
    private int idtraza;
    private JTable tabla;
    private Object fecha;
    private int tamanio;
    private int muestra;
    private int rechazo;
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
            String query = "SELECT t.fecha_control, "
                    + "t.tamanio_lote, "
                    + "t.cantidad_muestreada "
                    + ", t.nro_rechazo , "
                    + "v.descripcion "
                    + ", u.nombre "
                    + ", d.descripcion "
                    + "from traza t  "
                    + "join tipos_verificacion v "
                    + "on t.idVerificacion = v.id "
                    + "join usuarios u "
                    + "on t.idUsuarios = u.id "
                    + "join tipos_documentos d "
                    + "on t.idTipoDocumento = d.id "
                    + "where t.id =" + idtraza;
            conexion.ExecuteSql(query);
            while (conexion.resulset.next()) {
                fecha = conexion.resulset.getObject(1);
                tamanio = conexion.resulset.getInt(2);
                muestra = conexion.resulset.getInt(3);
                rechazo = conexion.resulset.getInt(4);
                verificacion = conexion.resulset.getString(5);
                usuario = conexion.resulset.getString(6);
                documento = conexion.resulset.getString(7);
                resultados = ordenarResultados();
            }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Carga de Tabla Reporte", JOptionPane.ERROR_MESSAGE);

//            Logger.getLogger(Tabla_TrazaReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void poblarTabla(DefaultTableModel modelo) {
        String titulos = "Operador de Control, Fecha de Control, "
                + "Tamanio Lote, Cantidad muestreada, Total Rechazos, "
                + "Linea de captura, Digitalizador, Tipo de Verificacion, Tipo de Documento\n ";
        String[] titulo = titulos.split(", ");
        for (int t = 0; t < titulo.length; t++) {
            modelo.addRow(new Object[]{titulo[t], 0});
        }
        resultadosEnTabla(modelo);
    }

    private String ordenarResultados() {
        String ret = usuario+", " + fecha + ", " + tamanio
                + ", " + muestra + ", " + rechazo
                + ", --/--, --/--, "+verificacion+", "+ documento;
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
