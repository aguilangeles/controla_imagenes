/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteFinal;

import database.UpdateEstadoLote;
import helper.EscribeInformeDocumento;
import helper.Time;
import helper.VersionEImageIcon;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class ReporteDocumento extends javax.swing.JFrame {

  private database.Conexion conexion = new database.Conexion();
  private int idtraza;
  private DefaultTableModel modelDetalles;
  private DefaultTableModel modelTipos;
  private List<Object> lista;
  private String detalles;
  private String discrininacion;
  private ButtonGroup bg;
  private String UBICACION;

  /**
   * Creates new form Reporte
   *
   * @param idtraza
   */
  public ReporteDocumento(int idtraza) {
    initComponents();
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon(this);
    this.idtraza = idtraza;
    setResizable(false);
    if (conexion.isConexion())
      {
      Tabla_TrazaReporte poblarTablaTraza =
              new Tabla_TrazaReporte(conexion, idtraza, tablaDetalles);
      Tabla_TiposDeControlEnDocumento poblarTablaDiscriminacionTipos =
              new Tabla_TiposDeControlEnDocumento(idtraza, conexion, tabladeTipos);
      String status = AutomaticoRoA.getStatusName();
      estado.setText(status);
      UBICACION = "Reporte/Traza_" + idtraza + "  " + status + "  " + new Time().getDateForTXT() + ".txt";
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
    jLabel4 = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    estado = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("Qualitys_v_1.00.01");

    tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Title 1", "Title 2"
      }
    ));
    tablaDetalles.setToolTipText("L�nea de captura y digitalizador no deben quedar vac�os");
    tablaDetalles.setFocusable(false);
    jScrollPane1.setViewportView(tablaDetalles);

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText(" Reporte Final");

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setText("Tipos de control incluidos en el Tipo de Verificaci�n.");

    tabladeTipos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Descripcion", "Cantidad hallazgos"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabladeTipos.setFocusable(false);
    jScrollPane2.setViewportView(tabladeTipos);

    jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel4.setText("Estado del Lote:");

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Vera Sans Mono", 0, 10), new java.awt.Color(204, 204, 204))); // NOI18N
    jScrollPane3.setViewportView(jTextArea1);

    jButton1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jButton1.setMnemonic('f');
    jButton1.setText("Salir");
    jButton1.setToolTipText("Cierra el reporte y la aplicaci�n");
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
    jButton2.setToolTipText("Cierra el reporte y retorna al panel de control");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    estado.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    estado.setText("estado");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2)
          .addComponent(jScrollPane3)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane1)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(0, 0, Short.MAX_VALUE))
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
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
  /**
   * @param args the command line arguments
   */
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel estado;
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
  private javax.swing.JTable tablaDetalles;
  private javax.swing.JTable tabladeTipos;
  // End of variables declaration//GEN-END:variables

  private void getFinalizar(boolean isNewQs) {
    tablaDetalles.editCellAt(-1, -1);

    setMensajeYUpdate(isNewQs);
  }

  private void setMensajeYUpdate(boolean isNewQs) throws HeadlessException {
    if (jTextArea1.getText().length() >= 500)
      {
      JOptionPane.showMessageDialog(jTextArea1,
              "Reduzca el texto a 500 caracteres", "Limite de texto permitido",
              JOptionPane.INFORMATION_MESSAGE);
      } else if (tablaDetalles.getValueAt(9, 1).toString().equals(""))
      {
      JOptionPane.showMessageDialog(tablaDetalles,
              "Debe completar Linea de Captura", "campo vacio no permitido",
              JOptionPane.INFORMATION_MESSAGE);
      } else if (tablaDetalles.getValueAt(10, 1).toString().equals(""))
      {
      JOptionPane.showMessageDialog(tablaDetalles,
              "Debe completar Digitalizador", "campo vacio no permitido",
              JOptionPane.INFORMATION_MESSAGE);
      } else
      {
      String captura = (String) tablaDetalles.getValueAt(9, 1);
      String digitalizador = (String) tablaDetalles.getValueAt(10, 1);
      UpdateEstadoLote updateEstadoLote =
              new UpdateEstadoLote(conexion, idtraza,
              jTextArea1, captura, digitalizador);
      EscribeInformeDocumento escribeInformeDocumento =
              new EscribeInformeDocumento(tablaDetalles, jTextArea1.getText(), jButton1, tabladeTipos, UBICACION);
      conexion.isConexionClose();
      if (!isNewQs)
        {
        System.exit(0);
        } else
        {
        this.dispose();
        new panelContol.PanelControl().setVisible(true);
        }
      }
  }
}
