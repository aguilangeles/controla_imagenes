/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;

import java.awt.HeadlessException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class Reporte extends javax.swing.JFrame {

  private Entidades.Conexion conexion = new Entidades.Conexion();
  private int idtraza;
  private DefaultTableModel modelDetalles;
  private DefaultTableModel modelTipos;
  private List<Object> lista;
  private String detalles;
  private String discrininacion;
  private ButtonGroup bg;

  /**
   * Creates new form Reporte
   *
   * @param idtraza
   */
  public Reporte(int idtraza) {

    initComponents();
    String rutaImagen = "Logos/nuevo logo sin letras UTN.png";
    ImageIcon im = new ImageIcon(rutaImagen);
    setIconImage(im.getImage());

    this.idtraza = idtraza;
    setResizable(false);
    if (conexion.isConexion()) {
      Tabla_TrazaReporte poblarTablaTraza = new Tabla_TrazaReporte(conexion, idtraza, tablaDetalles);
      Tabla_TiposDeControlCantidad poblarTablaDiscriminacionTipos = new Tabla_TiposDeControlCantidad(idtraza, conexion, tabladeTipos);
      actionRadioButton();
      imagenesRechazadas.setText("Cantidad de imagenes rechazadas:  " + poblarTablaTraza.getRechazo());
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaDetalles = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    tabladeTipos = new javax.swing.JTable();
    imagenesRechazadas = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    si = new javax.swing.JRadioButton();
    no = new javax.swing.JRadioButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("Qualitys_v_1.00.01");

    jPanel1.setBackground(new java.awt.Color(230, 252, 238));

    tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Title 1", "Title 2"
      }
    ));
    tablaDetalles.setFocusable(false);
    jScrollPane1.setViewportView(tablaDetalles);

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText(" Reporte Final");

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setText("Tipos de control incluidos en el Tipo de Verificación.");

    tabladeTipos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Defecto id", "Descripcion", "Cantidad hallazgos"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabladeTipos.setFocusable(false);
    jScrollPane2.setViewportView(tabladeTipos);

    imagenesRechazadas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    imagenesRechazadas.setText("Cantidad de imagenes rechazadas: xxx");

    jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel4.setText("Se rechaza el lote?");

    si.setText("SI");
    si.setOpaque(false);

    no.setText("No");
    no.setNextFocusableComponent(si);
    no.setOpaque(false);

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.setNextFocusableComponent(si);
    jScrollPane3.setViewportView(jTextArea1);

    jButton1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jButton1.setMnemonic('f');
    jButton1.setText("Finalizar");
    jButton1.setToolTipText("alt+f");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jButton1KeyPressed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(si)
            .addGap(18, 18, 18)
            .addComponent(no)
            .addGap(46, 46, 46))
          .addComponent(imagenesRechazadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(59, 59, 59))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(1, 1, 1)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(imagenesRechazadas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(si)
          .addComponent(no))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      getFinalizar();
    }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
    getFinalizar();
  }//GEN-LAST:event_jButton1KeyPressed
  private void actionRadioButton() {
    bg = new ButtonGroup();
    bg.add(si);
    bg.add(no);
  }
  /**
   * @param args the command line arguments
   */
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel imagenesRechazadas;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JRadioButton no;
  private javax.swing.JRadioButton si;
  private javax.swing.JTable tablaDetalles;
  private javax.swing.JTable tabladeTipos;
  // End of variables declaration//GEN-END:variables

  private void getFinalizar() throws HeadlessException {
    if (bg.getSelection() != null) {
      if (jTextArea1.getText().length() >= 500) {
        JOptionPane.showMessageDialog(jTextArea1, "Reduzca el texto a 500 caracteres", "Limite de texto permitido", JOptionPane.ERROR_MESSAGE);
      } else {
        UpdateEstadoLote updateEstadoLote = new UpdateEstadoLote(conexion, idtraza, si.isSelected(), jTextArea1, tablaDetalles);
        conexion.isConexionClose();
        System.exit(0);
      }
    } else {
      JOptionPane.showMessageDialog(null, "Debe aceptar o rechazar el lote antes de salir", "Selección de Lote", JOptionPane.ERROR_MESSAGE);
    }
  }
}
