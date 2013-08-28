
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Daos.TiposDeControl;
import Ventana.CantidadControlesPorVerificacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarTipos {
    private Conexion conexion;
    private int idTraza;
    private int size;
    private List<TiposDeControl> listadeTipos = new ArrayList<>();

    public LlenarTipos(Conexion conectar ,int id) {
        this.conexion=conectar;
        this.idTraza=id;
        poblarLista();
    }

    private List<TiposDeControl> poblarLista() {
        try {
          Runtime gar = Runtime.getRuntime();
            TiposDeControl tipos;
                size = new CantidadControlesPorVerificacion(conexion, idTraza).getCantidad();
                String insert = "select v.idControl"
                        + ", c.descripcion "
                        + ", c.texto"
                        + ", c.imagen "
                        + " from controles_verificacion v"
                        + " join controles c "
                        + " on v.idControl = c.id "
                        + "where idVerificacion = "
                        + "(SELECT  t.idVerificacion FROM qualitys.traza  t where t.id = "+idTraza+");";
                conexion.executeQuery(insert);
                while (conexion.resulset.next()) {
                    int idcontroles =conexion.resulset.getInt(1);
                    String descripcion =conexion.resulset.getString(2);
                    String texto =conexion.resulset.getString(3);
                    String imagen =conexion.resulset.getString(4);
                    tipos = new TiposDeControl(idcontroles, descripcion, false, texto, imagen);
                    listadeTipos.add(tipos);
                }
                conexion.isConexionClose();
          gar.gc();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Llenar Tipos", JOptionPane.ERROR_MESSAGE);

//            Logger.getLogger(LlenarTipos.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listadeTipos;
    }

    public List<TiposDeControl> getListadeTipos() {
        return listadeTipos;
    }

    public int getSize() {
        return size;
    }



}
