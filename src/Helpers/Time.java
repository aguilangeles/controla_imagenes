/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author MUTNPROD003
 */
public class Time {

    private String datetime;

    public Time() {
        getFecha_reporte();
    }

    private String getFecha_reporte() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd hh:mm:ss", Locale.ENGLISH);
        Date fecha = new java.util.Date();
        datetime = formateador.format(fecha);
        return datetime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return  datetime;
    }

}
