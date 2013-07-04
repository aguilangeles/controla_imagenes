/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import tratamientoruta.Sublote;

/**
 *
 * @author MUTNPROD003
 */
public class VolumenPDF {
    private int idLote;
    private String absolutePath;
    private List<Sublote> sublotes;

    public VolumenPDF(int idLote, String absolutePath, List<Sublote> sublotes) {
        this.idLote = idLote;
        this.absolutePath = absolutePath;
        this.sublotes = sublotes;
    }


    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }



    public List<Sublote> getSublotes() {
        return sublotes;
    }

    public void setSublotes(List<Sublote> sublotes) {
        this.sublotes = sublotes;
    }

    @Override
    public String toString() {
        return  idLote
                + " " + absolutePath
                + "\n" + sublotes;
    }
}
