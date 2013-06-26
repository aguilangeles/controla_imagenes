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
import writeproperties.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarArchivo {
    private int idTraza;
    private Conexion conexion;
    private String parent;
    private boolean isPdf;
    private List<Imagen> imagenProcesada=new ArrayList<>();
    private ImagenesWorker worker;

    public LlenarArchivo(Conexion conexion, int idTraza, String parent, boolean isPdf) {
        this.conexion = conexion;
        this.idTraza = idTraza;
        this.parent = parent;
        this.isPdf = isPdf;
        llenarImagenes();
    }

    private List<Imagen> llenarImagenes() {
        Imagen imagen;
        try {
            String query = "SELECT id , ruta_archivo, pagina_pdf FROM qualitys.archivo where idtraza = " + idTraza + ";";
            conexion.ExecuteSql(query);
            while (conexion.resulset.next()) {
                int id = conexion.resulset.getInt(1);
                String ruta_archivo = conexion.resulset.getString(2);
                int pagina = conexion.resulset.getInt(3);
                if (isPdf) {
                    imagen = new Imagen(id, ruta_archivo, parent, pagina);
                    imagenProcesada.add(imagen);
                } else {
                    imagen = new Imagen(id, ruta_archivo, parent);
                    System.out.println(imagen);
                    imagenProcesada.add(imagen);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(LlenarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagenProcesada;
    }

    public List<Imagen> getListaArchivos() {
        return imagenProcesada;
    }
}
