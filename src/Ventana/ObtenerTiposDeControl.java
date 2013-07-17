/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.TiposConCheck;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class ObtenerTiposDeControl {

    private Entidades.Conexion conexion = new Entidades.Conexion();
    private int idArchivo;
    private int idArchivoTraza;
    private int idTraza;
    private JTable tabla;
    private List<TiposConCheck> listadoTipos = new ArrayList<>();

    public ObtenerTiposDeControl(int idArchivo) {
        this.idArchivo = idArchivo;
        estadoDeLosControles();
    }

//    public ObtenerTiposDeControl(int idArchivo, JTable tabla) {
//        this.idArchivo = idArchivo;
//        this.tabla = tabla;
//        estadoDeLosControles();
////        poblarTabla();
//    }

    private List<TiposConCheck> estadoDeLosControles() {
        TiposConCheck tipos;
        if (conexion.isConexion()) {
            try {
                String query = "SELECT  tac.idcontrol ,c.descripcion , tac.estado "
                        + "FROM qualitys.traza_archivo_controles tac join controles c"
                        + " on tac.idcontrol = c.id where idarchivo = " + idArchivo + ";";
                conexion.ExecuteSql(query);
                while (conexion.resulset.next()) {
                    int estado = conexion.resulset.getInt(3);
                    boolean isEstado = (estado == 0) ? false : true;
                    tipos = new TiposConCheck(conexion.resulset.getInt(1), conexion.resulset.getString(2), isEstado);
                    listadoTipos.add(tipos);
                }
                conexion.desconectar();

            } catch (SQLException ex) {
                Logger.getLogger(ObtenerTiposDeControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listadoTipos;
    }


    public List<TiposConCheck> getListadoTipos() {
        return listadoTipos;
    }

//    private void poblarTabla(){
//         for (TiposConCheck t : getListadoTipos()) {
//            for (int index = 0; index < tabla.getRowCount(); index++) {
//                tabla.setValueAt(t.isCheck(), index, 0);
//            }
//        }
//    }


}
