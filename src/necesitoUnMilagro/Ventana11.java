/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Daos.TrazaDao;
import Daos.Imagen;
import Helpers.VersionEImageIcon;
import ReporteLote.Reporte;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class Ventana11 extends javax.swing.JFrame {

  private int sizeRamdom;
  private int contador = 0;
  private int cantidad = 1;
  private DefaultTableModel model;
  private TrazaDao traza;
  private boolean pdf;
  private boolean tif;
  private final SetChecksBox setCB;
  private final Guardar save;
  private final GetRutaDeImagen rutadeimagen;
  private final TablaCheckBox tablaCheckBox;
  private ImageDrawingComponent imageDraw = new ImageDrawingComponent();

  public Ventana11(TrazaDao traza) {
    iniciar(traza);
    VersionEImageIcon version = new VersionEImageIcon(this);
    initComponents();
    tablaCheck.requestFocus();
    this.traza = traza;
    this.setCB = new SetChecksBox(tablaCheck);//trae los estados desde la base de datos
    setExtendedState(6);
    this.save = new Guardar();// salva los contenidos del internalframe
    this.rutadeimagen = new GetRutaDeImagen(); // llama al conversor de pdf y devuelve la ruta de imagen
    this.pdf = (traza.getExtension().equals(".pdf")) ? true : false;// discrimina entre pdf y otros
    this.tif = isTIF(pdf, traza.getExtension());
    this.tablaCheckBox = new TablaCheckBox(model, tablaCheck, traza);//llena la tabla con los contenidos adecuados
    //TODO pdf versus tif,png y jpg
    tablaCheck.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    terminar.setEnabled(false);
    internal(pdf);
  }

  private void iniciar(TrazaDao traza) {
    traza.getListaTif();
  }

  private boolean isTIF(boolean pdf, String extension) {
    if (!pdf && extension.equalsIgnoreCase(".tif")) {
      return true;
    }
    return false;
  }

  private void internal(boolean ispdf) {
    try {
      jInternal.setMaximum(true);
      anterior.setEnabled(false);
      Imagen siguientes = goImagen(contador);//trae el ramdom
      setTituloYRutaLabel(siguientes);
      String ruta = rutadeimagen.siguienteImagen(pdf, siguientes);
      setLabelPagina(ispdf, siguientes);
      imageDraw.cargarImage(ruta, pdf, tif, combo);
      scrollImage.getViewport().add(imageDraw);
      setCB.set(siguientes.getId());
    } catch (PropertyVetoException ex) {
      Logger.getLogger(Ventana11.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private Imagen goImagen(int contador) {
    int limiteSuperior = getSizeRamdom() - 1;
    Imagen imagen = traza.getListaTif().get(contador);
    if (contador == limiteSuperior) {
      siguiente.setEnabled(false);
      terminar.setEnabled(true);
    }
    return imagen;
  }

  private Imagen backImagen(int contador) {
    int limiteInferior = 0;
    Imagen imagen = traza.getListaTif().get(contador);
    if (limiteInferior == contador) {
      anterior.setEnabled(false);
    }
    return imagen;
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
    rutaJlabel = new javax.swing.JLabel();
    pagina = new javax.swing.JLabel();
    panelButtCheck = new javax.swing.JPanel();
    scrollChecks = new javax.swing.JScrollPane();
    jScrollPane4 = new javax.swing.JScrollPane();
    tablaCheck = new javax.swing.JTable();
    scrollImage = new javax.swing.JScrollPane();
    combo = new javax.swing.JComboBox();
    jLabel1 = new javax.swing.JLabel();

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
    siguiente.setMnemonic('s');
    siguiente.setText("Siguiente");
    siguiente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        siguienteActionPerformed(evt);
      }
    });

    anterior.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    anterior.setMnemonic('a');
    anterior.setText("Anterior");
    anterior.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        anteriorActionPerformed(evt);
      }
    });

    terminar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    terminar.setMnemonic('t');
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

    jPanel2.setBackground(new java.awt.Color(230, 252, 238));

    rutaJlabel.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    rutaJlabel.setText("RUTA");

    pagina.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    pagina.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    pagina.setText("Pagina: ");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(rutaJlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(rutaJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(21, 21, 21))
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
      .addComponent(scrollChecks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
    );

    scrollImage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(230, 252, 238)));

    javax.swing.GroupLayout jInternalLayout = new javax.swing.GroupLayout(jInternal.getContentPane());
    jInternal.getContentPane().setLayout(jInternalLayout);
    jInternalLayout.setHorizontalGroup(
      jInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jInternalLayout.createSequentialGroup()
        .addGroup(jInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(scrollImage))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(panelButtCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0))
    );
    jInternalLayout.setVerticalGroup(
      jInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jInternalLayout.createSequentialGroup()
        .addGroup(jInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(panelButtCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jInternalLayout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrollImage)))
        .addContainerGap())
    );

    jInternal.setBounds(10, 10, 830, 480);
    jDesktopPane1.add(jInternal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    jScrollPane1.setViewportView(jDesktopPane1);

    combo.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "150%", "125%", "100%", "75%", "50%" }));
    combo.setToolTipText("");

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    jLabel1.setText("Visualizar Imagen al");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(37, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(36, 36, 36)
        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(68, 68, 68)
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
          .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1)))
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

  private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
    setNextImage();
  }//GEN-LAST:event_siguienteActionPerformed

  private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
    setBackImage();
  }//GEN-LAST:event_anteriorActionPerformed

  private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
    setFinalizar();
  }//GEN-LAST:event_terminarActionPerformed

  public int getSizeRamdom() {
    return traza.getListaTif().size();
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
  private javax.swing.JComboBox combo;
  private javax.swing.JDesktopPane jDesktopPane1;
  private javax.swing.JInternalFrame jInternal;
  private javax.swing.JLabel jLabel1;
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
  private javax.swing.JScrollPane scrollImage;
  private javax.swing.JButton siguiente;
  private javax.swing.JTable tablaCheck;
  private javax.swing.JButton terminar;
  // End of variables declaration//GEN-END:variables

  private void setTituloYRutaLabel(Imagen siguientes) {
    jInternal.setTitle("Imagen " + cantidad + "/" + getSizeRamdom());
    rutaJlabel.setText(siguientes.getRutaInsertadaEnDB());
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

  private void setNextImage() {
    contador++;
    cantidad++;
    anterior.setEnabled(true);
    guardarYLimpiar(rutaJlabel, tablaCheck, pagina, pdf);
    Imagen imagen1 = goImagen(contador);
    try {
      jDesktopPane1.add(jInternal);
      setTituloYRutaLabel(imagen1);
      setLabelPagina(pdf, imagen1);
      setCB.set(imagen1.getId());
      String ruta_temp = rutadeimagen.siguienteImagen(pdf, imagen1);
      imageDraw.cargarImage(ruta_temp, pdf, tif, combo);
      scrollImage.getViewport().add(imageDraw);
      jInternal.setVisible(true);
    } catch (Exception ex) {
      Logger.getLogger(Ventana11.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void setBackImage() {
    contador--;
    cantidad--;
    Imagen pr = backImagen(contador);
    guardarYLimpiar(rutaJlabel, tablaCheck, pagina, pdf);
    siguiente.setEnabled(true);
    jDesktopPane1.add(jInternal);
    jInternal.setVisible(true);
    setTituloYRutaLabel(pr);
    setLabelPagina(pdf, pr);
    setCB.set(pr.getId());
    String visualizacion = rutadeimagen.anteriorImagen(pdf, pr);
    imageDraw.cargarImage(visualizacion, pdf, tif, combo);
    scrollImage.getViewport().add(imageDraw);
  }

  private void setFinalizar() {
    save.guardar(traza, rutaJlabel.getText(), tablaCheck, pagina, pdf);
    NumeroRechazo numeroRechazo = new NumeroRechazo(traza.getId());
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Reporte(traza.getId()).setVisible(true);
      }
    });
    dispose();
  }
}
