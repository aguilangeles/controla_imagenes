/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import Daos.NombrePaginaDelPDF;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class Sublote {
    private int idSublote;
    private List<NombrePaginaDelPDF> pdfpagina = new ArrayList<>();
    private String nombre;
    private String fileName;
    private int paginas;
    private String relativa ;

    public Sublote(int idSublote, String absolutePath, String parent, String fileName, int paginas) {
        this.idSublote = idSublote;
        this.nombre = absolutePath;
        this.fileName = fileName;
        String rel = parent+"\\";
        this.relativa = absolutePath.substring(rel.length());
        this.paginas = paginas;
    }


       public List<NombrePaginaDelPDF> getPdfpagina() {
        for (int i = 0; i < paginas; i++) {
            NombrePaginaDelPDF paginaNumero = new NombrePaginaDelPDF(getRelativa(), i);
            pdfpagina.add(paginaNumero);
        }
        return pdfpagina;
    }


        public int getIdSublote() {
            return idSublote;
        }

        public void setIdSublote(int idSublote) {
            this.idSublote = idSublote;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getPaginas() {
            return paginas;
        }

        public void setPaginas(int paginas) {
            this.paginas = paginas;
        }

    public String getRelativa() {
        return relativa;
    }


    }



