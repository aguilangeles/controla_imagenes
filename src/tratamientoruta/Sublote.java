/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class Sublote {
    private int idSublote;
    private List<PaginaPdf> pdfpagina = new ArrayList<>();
    private PaginaPdf pp;
    private String absolutePath;
    private String parent;
    private String fileName;
    private int paginas;
    private String relativa ;

    public Sublote(int idSublote, String absolutePath, String parent, String fileName, int paginas) {
        this.idSublote = idSublote;
        this.absolutePath = absolutePath;
        this.parent = parent;
        this.fileName = fileName;
        String rel = parent+"\\";
        this.relativa = absolutePath.substring(rel.length());
        this.paginas = paginas;
    }


        public List<PaginaPdf> getPdfpagina() {
              for(int i =0; i<paginas; i++){
                pp = new PaginaPdf(getRelativa(), i);
                pdfpagina.add(pp);
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
            return absolutePath;
        }

        public void setNombre(String nombre) {
            this.absolutePath = nombre;
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

    @Override
    public String toString() {
        return "Sublote{" + "idSublote=" + idSublote + ", pdfpagina=" + pdfpagina + ", pp=" + pp + ", nombre=" + absolutePath + ", paginas=" + paginas + '}';
    }
    }
//



