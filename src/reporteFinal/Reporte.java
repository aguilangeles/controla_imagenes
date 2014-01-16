/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteFinal;

import database.UpdateEstadoLote;
import helper.EscribeInforme;
import helper.GetRechazosPorImagen;
import helper.MensajeJoptionPane;
import helper.Time;
import helper.VersionEImageIcon;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class Reporte extends javax.swing.JFrame {

  private database.Conexion conexion = new database.Conexion();
  private int idtraza;
  private DefaultTableModel modelDetalles;
  private DefaultTableModel modelTipos;
  private List<Object> lista;
  private String detalles;
  private ButtonGroup bg;
  private String UBICACION;

  /**
   * Creates new form Reporte
   *
   * @param idtraza
   */
  public Reporte(int idtraza) {

    initComponents();
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon(this);
    versionEImageIcon.newColorFromPanel(jPanel1);
    this.idtraza = idtraza;
    setResizable(false);
    if (conexion.isConexion())
      {
      Tabla_TrazaReporte poblarTablaTraza =
              new Tabla_TrazaReporte(conexion, idtraza, tablaDetalles);
      Tabla_TiposDeControlCantidad poblarTablaDiscriminacionTipos =
              new Tabla_TiposDeControlCantidad(idtraza, conexion, tabladeTipos);
      actionRadioButton();
      imagenesRechazadas.setText("Cantidad de imagenes rechazadas:  "
              + poblarTablaTraza.getRechazo());
      GetRechazosPorImagen rechazosximagen = new GetRechazosPorImagen(conexion, idtraza);
      this.UBICACION = "Reporte/Traza_" + idtraza + "  " + new Time().getDateForTXT() + ".txt";
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
    aceptar = new javax.swing.JRadioButton();
    rechazar = new javax.swing.JRadioButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("Qualitys_v_1.00.01");

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
        "idSub", "Sublote", "Ctrl"
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
    jLabel4.setText("Definir estado del Lote");

    aceptar.setText("Aceptado");
    aceptar.setOpaque(false);

    rechazar.setText("Rechazado");
    rechazar.setNextFocusableComponent(aceptar);
    rechazar.setOpaque(false);

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.setNextFocusableComponent(aceptar);
    jScrollPane3.setViewportView(jTextArea1);

    jButton1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jButton1.setMnemonic('f');
    jButton1.setText("Salir");
    jButton1.setToolTipText("Cierra el reporte y la aplicación.");
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

    jButton2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jButton2.setText("Realizar otro Control");
    jButton2.setToolTipText("Cierra el reporte y retorna al panel de control.");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(imagenesRechazadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane3)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(39, 39, 39)
            .addComponent(aceptar)
            .addGap(41, 41, 41)
            .addComponent(rechazar))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(0, 18, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jButton2)
            .addGap(18, 18, 18)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(imagenesRechazadas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(aceptar)
          .addComponent(rechazar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton1)
          .addComponent(jButton2))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      getFinalizar(false);
    }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
    getFinalizar(false);
  }//GEN-LAST:event_jButton1KeyPressed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    getFinalizar(true);
  }//GEN-LAST:event_jButton2ActionPerformed
  private void actionRadioButton() {
    bg = new ButtonGroup();
    bg.add(aceptar);
    bg.add(rechazar);
  }
  /**
   * @param args the command line arguments
   */
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JRadioButton aceptar;
  private javax.swing.JLabel imagenesRechazadas;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JRadioButton rechazar;
  private javax.swing.JTable tablaDetalles;
  private javax.swing.JTable tabladeTipos;
  // End of variables declaration//GEN-END:variables

  private void getFinalizar(boolean isNewQs) {
    tablaDetalles.editCellAt(-1, -1);
    if (bg.getSelection() != null)
      {
      largoMensajeYUpdate(isNewQs);
      } else
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(this, JOptionPane.INFORMATION_MESSAGE);
      msg.getMessage("Debe aceptar o rechazar el lote antes de salir", "Estado del Lote");
      }
  }//

  private void largoMensajeYUpdate(boolean isnewQ) {
    if (jTextArea1.getText().length() >= 500)
      {
      JOptionPane.showMessageDialog(jTextArea1,
              "Reduzca el texto a 500 caracteres", "Limite de texto permitido",
              JOptionPane.INFORMATION_MESSAGE);
      } else if (tablaDetalles.getValueAt(8, 1).toString().equals(""))
      {
      JOptionPane.showMessageDialog(tablaDetalles,
              "Debe completar Linea de Captura", "campo vacio no permitido",
              JOptionPane.INFORMATION_MESSAGE);
      } else if (tablaDetalles.getValueAt(9, 1).toString().equals(""))
      {
      JOptionPane.showMessageDialog(tablaDetalles,
              "Debe completar Digitalizador", "campo vacio no permitido",
              JOptionPane.INFORMATION_MESSAGE);
      } else
      {
      String captura = (String) tablaDetalles.getValueAt(8, 1);
      String digitalizador = (String) tablaDetalles.getValueAt(9, 1);
      UpdateEstadoLote updateEstadoLote =
              new UpdateEstadoLote(conexion, idtraza, aceptar.isSelected(),
              jTextArea1, captura, digitalizador);
      EscribeInforme escribeInformeDocumento =
              new EscribeInforme(tablaDetalles, aceptar.isSelected(), jTextArea1.getText(), jButton1, UBICACION);
      conexion.isConexionClose();
      if (!isnewQ)
        {
        System.exit(0);
        } else
        {
        dispose();
        new panelContol.PanelControl().setVisible(true);
        }
      }
  }
}
