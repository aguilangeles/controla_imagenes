///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package VentanaPrincipal;
//
//import java.sql.SQLException;
//import BasedeDatos.Conexion;
//import javax.swing.JOptionPane;
//
///**
// * Cuenta la cantidad de controles que se ingresaron en la verificación.
// * @author MUTNPROD003
// */
//public class CantidadControlesPorVerificacion {
//
//  private int cantidad;
//
//  public CantidadControlesPorVerificacion(Conexion conexion, int id) {
//    this.cantidad = cantidad(conexion, id);
//  }
//
//  private int cantidad(Conexion conexion, int id) {
//    int cantidadControles = 0;
//    try {
//      String query = "select count(idControl) "
//              + "from controles_verificacion "
//              + "where idVerificacion = "
//              + "(SELECT  idVerificacion FROM qualitys.traza where id =" + id + ")";
//      conexion.executeQuery(query);
//      while (conexion.resulset.next()) {
//        cantidadControles = conexion.resulset.getInt(1);
//      }
//
//    } catch (SQLException ex) {
//      JOptionPane.showMessageDialog(null, ex.getMessage(), "Cantidad controles por Verificacion", JOptionPane.ERROR_MESSAGE);
//    }
//    return cantidadControles;
//  }
//
//  public int getCantidad() {
//    return cantidad;
//  }
//}
