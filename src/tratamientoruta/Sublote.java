/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import Entidades.Pdf_NombreMasNumero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class Sublote {
    private int idSublote;
    private List<Pdf_NombreMasNumero> pdfpagina = new ArrayList<>();
    private String nombre;
//    private String absolutePath;
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


       public List<Pdf_NombreMasNumero> getPdfpagina() {
        for (int i = 0; i < paginas; i++) {
            Pdf_NombreMasNumero paginaNumero = new Pdf_NombreMasNumero(getRelativa(), i);
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



