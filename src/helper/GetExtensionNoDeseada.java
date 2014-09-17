/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maria
 */
public class GetExtensionNoDeseada {
    public GetExtensionNoDeseada() {
    }
    

    public static List<String> noDeseadosList() {
        List<String> noadd = new ArrayList<>();
	noadd.add("txt");
	noadd.add("TXT");
	noadd.add("xml");
	noadd.add("XML");
	noadd.add("db");
	noadd.add("DB");
	noadd.add("dat");
	noadd.add("DAT");
		
        return noadd;
    }
  
}
