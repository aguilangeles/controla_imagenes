/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.*;
import Helpers.VersionEImageIcon;
import ReporteLote.Reporte;
import Ventana.ImagenesWorker;

import java.beans.PropertyVetoException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class Ventana11 extends javax.swing.JFrame {
  private int sizeRamdom;
  private DefaultTableModel model;
  private TrazaDao traza;
  private ListIterator iterator;
  private boolean hasNext;
  private boolean hasPrevius;
  private int contador = 1;
  private int zoom;
  private ImagenesWorker worker;
  private boolean pdf;
  private final SetChecksBox setCB;
  private final Guardar save;
  private final VisualizarImagen visualizarImagen;
  private final GetRutaDeImagen rutadeimagen;
  private final TablaCheckBox tablaCheckBox;

  public Ventana11(TrazaDao traza) {
    initComponents();
    VersionEImageIcon version = new VersionEImageIcon(this);
    tablaCheck.requestFocus();
    this.traza = traza;
    this.setCB = new SetChecksBox(tablaCheck);//trae los estados desde la base de datos
    this.save = new Guardar();// salva los contenidos del internalframe
    this.rutadeimagen = new GetRutaDeImagen(); // llama al conversor de pdf y devuelve la ruta de imagen
    this.visualizarImagen = new VisualizarImagen(scrollimage); // llama al imagecomponent
    this.iterator = traza.getListaTif().listIterator();//genera la lista
    this.pdf = (traza.getExtension().equals(".pdf")) ? true : false;// discrimina entre pdf y otros
    this.tablaCheckBox = new TablaCheckBox(model, tablaCheck, traza);//llena la tabla con los contenidos adecuados
    //TODO pdf versus tif,png y jpg
    setExtendedState(6);
    terminar.setEnabled(false);
    internal(pdf);
    contador++;
  }

private void internal(boolean ispdf) {
    try {
      jInternal.setMaximum(true);
      anterior.setEnabled(false);
      Imagen siguientes = nextImagen();//trae el ramdom
      setTituloYRutaLabel(siguientes);
      String ruta = rutadeimagen.siguienteImagen(pdf, siguientes);
      setLabelPagina(ispdf, siguientes);
      visualizarImagen.visualizarImagen(ruta, pdf, zoom);
      setCB.set(siguientes.getId());
    } catch (PropertyVetoException ex) {
      Logger.getLogger(Ventana11.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

    public ListIterator getIterator() {
        return iterator;
    }

    private Imagen nextImagen() {
        Imagen tif = null;
        try {
            ListIterator it = getIterator();
            tif = (Imagen) it.next();
            hasNext = (!it.hasNext()) ? false : true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return tif;
    }

    private Imagen previus() {
        Imagen tif = null;
        try {
            ListIterator it = getIterator();
            tif = (Imagen) it.previous();
            hasPrevius = (!it.hasPrevious()) ? false : true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return tif;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane2 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    siguiente = new javax.swing.JButton();
    anterior = new javax.swing.JButton();
    terminar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jDesktopPane1 = new javax.swing.JDesktopPane();
    jInternal = new javax.swing.JInternalFrame();
    jPanel2 = new javax.swing.JPanel();
    scrollimage = new javax.swing.JScrollPane();
    slider = new javax.swing.JSlider();
    rutaJlabel = new javax.swing.JLabel();
    pagina = new javax.swing.JLabel();
    panelButtCheck = new javax.swing.JPanel();
    scrollChecks = new javax.swing.JScrollPane();
    jScrollPane4 = new javax.swing.JScrollPane();
    tablaCheck = new javax.swing.JTable();

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane2.setViewportView(jTable1);

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane3.setViewportView(jTable2);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(230, 252, 238));

    jPanel1.setBackground(new java.awt.Color(230, 252, 238));

    siguiente.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    siguiente.setText("Siguiente");
    siguiente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        siguienteActionPerformed(evt);
      }
    });

    anterior.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    anterior.setText("Anterior");
    anterior.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        anteriorActionPerformed(evt);
      }
    });

    terminar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    terminar.setText("Terminar");
    terminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        terminarActionPerformed(evt);
      }
    });

    jInternal.setBackground(new java.awt.Color(230, 252, 238));
    jInternal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    jInternal.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    jInternal.setIconifiable(true);
    jInternal.setMaximizable(true);
    jInternal.setResizable(true);
    jInternal.setTitle("Qualitys_control de im�genes");
    jInternal.setNextFocusableComponent(tablaCheck);
    jInternal.setVisible(true);

    slider.setMajorTickSpacing(10);
    slider.setValue(20);

    rutaJlabel.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    rutaJlabel.setText("RUTA");

    pagina.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    pagina.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    pagina.setText("Pagina: ");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollimage)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(rutaJlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(rutaJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollimage, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
    );

    scrollChecks.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    jScrollPane4.setBorder(null);

    tablaCheck.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "", "Nombre", "?"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    tablaCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    tablaCheck.setNextFocusableComponent(siguiente);
    jScrollPane4.setViewportView(tablaCheck);

    scrollChecks.setViewportView(jScrollPane4);

    javax.swing.GroupLayout panelButtCheckLayout = new javax.swing.GroupLayout(panelButtCheck);
    panelButtCheck.setLayout(panelButtCheckLayout);
    panelButtCheckLayout.setHorizontalGroup(
      panelButtCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollChecks, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
    );
    panelButtCheckLayout.setVerticalGroup(
      panelButtCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollChecks, javax.swing.GroupLayout.Alignment.TRAILING)
    );

    javax.swing.GroupLayout jInternalLayout = new javax.swing.GroupLayout(jInternal.getContentPane());
    jInternal.getContentPane().setLayout(jInternalLayout);
    jInternalLayout.setHorizontalGroup(
      jInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jInternalLayout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(panelButtCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0))
    );
    jInternalLayout.setVerticalGroup(
      jInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalLayout.createSequentialGroup()
        .addGroup(jInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(panelButtCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );

    jInternal.setBounds(10, 10, 830, 480);
    jDesktopPane1.add(jInternal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    jScrollPane1.setViewportView(jDesktopPane1);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(365, Short.MAX_VALUE)
        .addComponent(siguiente)
        .addGap(67, 67, 67)
        .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(75, 75, 75)
        .addComponent(terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29))
      .addComponent(jScrollPane1)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
      save.guardar(traza, rutaJlabel.getText(), tablaCheck, pagina, pdf);
      NumeroRechazo numeroRechazo = new NumeroRechazo(traza.getId());
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          new Reporte(traza.getId()).setVisible(true);
        }
      });
      dispose();
    }//GEN-LAST:event_terminarActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
      anterior.setEnabled(true);
      guardarYLimpiar(rutaJlabel, tablaCheck, pagina, pdf);
      Imagen imagen = nextImagen();
      try {
        setZoom((int) visualizarImagen.getScale());
        jDesktopPane1.add(jInternal);
        setTituloYRutaLabel(imagen);
        setLabelPagina(pdf, imagen);
        setCB.set(imagen.getId());
        String ruta_temp = rutadeimagen.siguienteImagen(pdf, imagen);
        visualizarImagen.visualizarImagen(ruta_temp, pdf, zoom);
        if (!isHasNext()) {
          siguiente.setEnabled(false);
          terminar.setEnabled(true);
        }
        jInternal.setVisible(true);
        System.out.println(visualizarImagen.getScale());
        contador++;
      } catch (Exception ex) {
        Logger.getLogger(Ventana11.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_siguienteActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
      System.gc();
      String visualizacion = "";
      Imagen pr = previus();
      guardarYLimpiar(rutaJlabel, tablaCheck, pagina, pdf);
      int der = contador - 1;
      setContador(der);
      siguiente.setEnabled(true);
      jDesktopPane1.add(jInternal);
      jInternal.setVisible(true);
      setTituloYRutaLabel(pr);
      setLabelPagina(pdf, pr);
      setCB.set(pr.getId());
      visualizacion = rutadeimagen.anteriorImagen(pdf, pr);
      visualizarImagen.visualizarImagen(pr.getRutaTemp(), pdf, zoom);
      if (!hasPrevius) {
        anterior.setEnabled(false);
      }
    }//GEN-LAST:event_anteriorActionPerformed

    public int getZoom() {
        return slider.getValue();
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }



    public int getContador() {
        return contador;
    }

    public boolean isHasPrevius() {
        return hasPrevius;
    }

    public void setHasPrevius(boolean hasPrevius) {
        this.hasPrevius = hasPrevius;
    }

    public int getSizeRamdom() {
        return traza.getListaTif().size();
    }

    public void setSizeRamdom(int sizeRamdom) {
        this.sizeRamdom = sizeRamdom;
    }
    /**
     * Creates new form Ventana
     *
     * @return
     */
    /**
     * @param args the command line arguments
     */
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton anterior;
  private javax.swing.JDesktopPane jDesktopPane1;
  private javax.swing.JInternalFrame jInternal;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable jTable2;
  private javax.swing.JLabel pagina;
  private javax.swing.JPanel panelButtCheck;
  private javax.swing.JLabel rutaJlabel;
  private javax.swing.JScrollPane scrollChecks;
  private javax.swing.JScrollPane scrollimage;
  private javax.swing.JButton siguiente;
  private javax.swing.JSlider slider;
  private javax.swing.JTable tablaCheck;
  private javax.swing.JButton terminar;
  // End of variables declaration//GEN-END:variables

  private void setTituloYRutaLabel(Imagen siguientes) {
    jInternal.setTitle("Imagen " + contador + "/" + getSizeRamdom());
    rutaJlabel.setText(siguientes.getRutaDb());
  }

  private void setLabelPagina(boolean ispdf, Imagen siguientes) {
    if (ispdf) {
      int page = siguientes.getPagina() + 1;
      pagina.setText("Pagina: " + page);
    } else {
      pagina.setVisible(false);
    }
  }



  private void guardarYLimpiar(JLabel rutaJlabel, JTable tablaCheck, JLabel pagina, boolean pdf) {
    save.guardar(traza, rutaJlabel.getText(), tablaCheck, pagina, pdf);
    jInternal.dispose();
    jDesktopPane1.removeAll();
    jDesktopPane1.repaint();
  }
}
