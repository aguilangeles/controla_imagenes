/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import database.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetRechazosPorImagen {

 private static List<ImagenyRechazo> listaImg;

  public GetRechazosPorImagen(Conexion conexion, int idtraza) {
    listaImg = getImagenes(conexion, idtraza);

  }

  public static List<ImagenyRechazo> getListaImg() {
    return listaImg;
  }

  private List<ImagenyRechazo> getImagenes(Conexion conexion, int idtraza) {
    List<ImagenyRechazo> listaImg = new ArrayList<>();
    ImagenyRechazo imgrechazo;
    String query = " SELECT a.id, a.ruta_archivo "
            + ", a.pagina_pdf  "
            + " FROM qualitys.archivo a "
            + " where a.idtraza = " + idtraza
            + " and a.estado = 1;";
    if (conexion.isConexion())
      {
      try
        {
        conexion.executeQuery(query);
        while (conexion.resulset.next())
          {
          int id = conexion.resulset.getInt(1);
          String imagen = conexion.resulset.getString(2);
          int pagina = conexion.resulset.getInt(3);
          imgrechazo = new ImagenyRechazo(id, imagen, pagina);
          listaImg.add(imgrechazo);
          }
        } catch (SQLException ex)
        {
        Logger.getLogger(GetRechazosPorImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    getControles(conexion, listaImg);
    return listaImg;
  }

  private void getControles(Conexion conexion, List<ImagenyRechazo> listaImg) {
    for (ImagenyRechazo imgrch : listaImg)
      {
      List<String> ctrls = setControlesList(imgrch.getId(), conexion);
      imgrch.setControles(ctrls);
      }
  }

  private List<String> setControlesList(int idtraza, Conexion conexion) {
    List<String> listaControles = new ArrayList<>();
    String query = " SELECT "
            + " c.descripcion "
            + " FROM qualitys.archivo a "
            + " join traza_archivo_controles tac "
            + " on a.id = tac.idarchivo "
            + " join controles c "
            + " on tac.idcontrol = c.id "
            + " where a.id ="  + idtraza
            + " and tac.estado =1 ;";
    System.out.println(query);
    if (conexion.isConexion())
      {
      try
        {
        conexion.executeQuery(query);
        while (conexion.resulset.next())
          {
          String controles = conexion.resulset.getString(1);
          listaControles.add(controles);
          }
        } catch (SQLException ex)
        {
        Logger.getLogger(GetRechazosPorImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    return listaControles;
  }


}
