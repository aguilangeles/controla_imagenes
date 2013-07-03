/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Verificacion.ListaControlesActivos;
import Verificacion.ListaControlesActivos.TipoControl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class Verificacion_CargarComboBoxs extends JComboBox<Object> {
    private JComboBox tipoDocumento;
    private JComboBox tipoVerificacion;
    private Conexion conexion ;

    public Verificacion_CargarComboBoxs(JComboBox tipoDocumento, JComboBox tipoVerificacion, Conexion conexion) {
        this.tipoDocumento = tipoDocumento;
        this.tipoVerificacion = tipoVerificacion;
        this.conexion = conexion;
        llenarDocumentos();
        llenarQualitys();
    }


        private void llenarQualitys() {
        if (conexion.isConexion()) {
                try {
                    String ret = "SELECT id, nombre FROM qualitys.tipos_verificacion  where estado = 1;";
                    conexion.ExecuteSql(ret);
                    while (conexion.resulset.next()) {
                        int id = conexion.resulset.getInt(1);
                        String nombre = conexion.resulset.getString(2);
                         TipoControl t = new ListaControlesActivos.TipoControl(id, nombre);
                        tipoVerificacion.addItem(t);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Verificacion_CargarComboBoxs.class.getName()).log(Level.SEVERE, null, ex);
                }

        }

}
    private void llenarDocumentos() {
        try {
            if (conexion.isConexion()) {

                String ret = "SELECT * FROM qualitys.tipos_documentos;";
                conexion.ExecuteSql(ret);
                while (conexion.resulset.next()) {
                    int id = conexion.resulset.getInt(1);
                    String nombre = conexion.resulset.getString(2);
                     TipoControl t = new ListaControlesActivos.TipoControl(id, nombre);
                    tipoDocumento.addItem(t);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Verificacion_CargarComboBoxs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
