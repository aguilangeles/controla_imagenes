/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarControles {

    private int idTraza;
    private int idTif;
    private List<ControlPorArchivo> listaControles = new ArrayList<>();

    public LlenarControles(int idTraza,int idTif){
        this.idTraza = idTraza;
        this.idTif=idTif;
        llenarControles();
    }

    private List<ControlPorArchivo> llenarControles() {
        Conexion conexion = new Conexion();
        if(conexion.isConexion()){
            try {
                ControlPorArchivo control;
                String query = "select tac.id,  tac.idcontrol, c.descripcion "
                        + "from traza_archivo_controles tac "
                        + "join controles c "
                        + "on c.id = tac.idcontrol "
                        + "where tac.idtraza = " + idTraza + " and tac.idarchivo = " + idTif + ";";
                conexion.ExecuteSql(query);
                while (conexion.resulset.next()) {
                    int trzaArchivo = conexion.resulset.getInt(1);
                    int controlidArchivo = conexion.resulset.getInt(2);
                    String descripcion = conexion.resulset.getString(3);
                    control = new ControlPorArchivo(idTif, trzaArchivo, controlidArchivo, descripcion, false);
                    listaControles.add(control);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LlenarControles.class.getName()).log(Level.SEVERE, null, ex);
            }
}

        conexion.desconectar();
        return listaControles;
    }

    public List<ControlPorArchivo> getLista() {
        return listaControles;
    }
}
