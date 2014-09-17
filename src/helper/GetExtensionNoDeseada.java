/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import archivoConfiguracion.ReadProperties;
import java.util.List;

/**
 *
 * @author Maria
 */
public class GetExtensionNoDeseada {
    public GetExtensionNoDeseada() {
    }
    

    public static List<String> noDeseadosList() {
        List<String> noadd = new ReadProperties().getIgnoremeList();
        return noadd;
    }
  
}
