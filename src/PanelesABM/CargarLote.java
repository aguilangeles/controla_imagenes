/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Ventana.Worker;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Daos.Usuario;
import Helpers.IdentificarExtension;
import Helpers.IdentificarParent;
import Helpers.VersionEImageIcon;
import java.awt.HeadlessException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author MUTNPROD003
 */
public class CargarLote extends javax.swing.JFrame {

  private Usuario usarioTipo;
  private Entidades.Conexion con = new Entidades.Conexion();
  private List<Integer> idTipoControl = new ArrayList<>();
  private int idVerificacion;
  private Worker worker;
  private JComboBox documentos, verificacion;

  /**
   * Creates new form CargarLote
   */
  public CargarLote() {
    initComponents();

  }

  public CargarLote(Usuario usuarioTipo, DefaultComboBoxModel documentos, DefaultComboBoxModel verificacion) {
    initComponents();
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon(this);
    this.usarioTipo = usuarioTipo;
    rutaCarpeta.setInputVerifier(new Helpers.InputVerifier().inputVerifierT());
    this.tipoDocumentoBox.setModel(documentos);
    this.tipoVerificacionBox.setModel(verificacion);
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
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    rutaCarpeta = new javax.swing.JTextField();
    aceptarSeleccion = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    tipoDocumentoBox = new javax.swing.JComboBox();
    tipoVerificacionBox = new javax.swing.JComboBox();
    informa = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Carga de lote");
    setResizable(false);

    jPanel1.setBackground(new java.awt.Color(230, 252, 238));

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Seleccione ruta, tipo de documento y tipo de verificación a utilizar");

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setText("Ruta");

    rutaCarpeta.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    aceptarSeleccion.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    aceptarSeleccion.setMnemonic('c');
    aceptarSeleccion.setText("Comenzar");
    aceptarSeleccion.setToolTipText("alt+c");
    aceptarSeleccion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        aceptarSeleccionActionPerformed(evt);
      }
    });
    aceptarSeleccion.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        aceptarSeleccionKeyPressed(evt);
      }
    });

    jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel4.setText("Documento");

    jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel5.setText("Verificación");

    tipoDocumentoBox.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    tipoVerificacionBox.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    informa.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 10)); // NOI18N
    informa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Proceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Vera Sans Mono", 0, 10), new java.awt.Color(51, 102, 0))); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoVerificacionBox, 0, 476, Short.MAX_VALUE))
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoDocumentoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(rutaCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(informa, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 9, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(aceptarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(189, 189, 189))
      .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(21, 21, 21)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(rutaCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(21, 21, 21)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tipoDocumentoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tipoVerificacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(aceptarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(17, 17, 17)
        .addComponent(informa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void aceptarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarSeleccionActionPerformed
    getAceptar();
    }//GEN-LAST:event_aceptarSeleccionActionPerformed

  private void aceptarSeleccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aceptarSeleccionKeyPressed
    getAceptar();
  }//GEN-LAST:event_aceptarSeleccionKeyPressed

  private String getUltimaCarpeta(String aParent) {
    String ret = "";
    if (aParent.contains("\\")) {
      String replace = aParent.replace("\\", ", ");
      String[] rsplit = replace.split(", ");
      for (int i = 0; i < rsplit.length; i++) {
        ret = (rsplit[i]);
      }
    }
    return ret;
  }

  public List<Integer> getIdTipoControl() {
    return idTipoControl;
  }

  public Usuario getUsarioTipo() {
    return usarioTipo;
  }

  private int getTipoDocumento() {
    String result = (String) tipoDocumentoBox.getSelectedItem();
    String[] dos = result.split("-");
    int id = Integer.parseInt(dos[0]);
    return id;
  }

  private List<Integer> idControlesByVerificacion() {
    String result = (String) tipoVerificacionBox.getSelectedItem();
    String[] dos = result.split("-");
    int id = Integer.parseInt(dos[0]);
    idVerificacion = id;
    String selec = "SELECT idControl FROM qualitys.controles_verificacion where"
            + " idVerificacion =" + id + ";";
    if (con.isConexion()) {
      try {
        con.executeQuery(selec);
        while (con.resulset.next()) {
          idTipoControl.add(con.resulset.getInt(1));
        }
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(tipoDocumentoBox, ex.getMessage(), CargarLote.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
    }
    return idTipoControl;
  }

  public int getIdVerificacion() {
    return idVerificacion;
  }
  /**
   * @param args the command line arguments
   */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CargarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CargarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CargarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CargarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CargarLote().setVisible(true);
//            }
//        });
//    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton aceptarSeleccion;
  private javax.swing.JLabel informa;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField rutaCarpeta;
  private javax.swing.JComboBox tipoDocumentoBox;
  private javax.swing.JComboBox tipoVerificacionBox;
  // End of variables declaration//GEN-END:variables

  private void getAceptar() throws HeadlessException {
    String ruta = rutaCarpeta.getText();
    List<Object> lista = null;
    File file = new File(ruta);
    if (file.exists()) {
      File[] files = file.listFiles();
      if (tipoDocumentoBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de documento")) {
        JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de documentos sin seleccionar",
                "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
      } else if (tipoVerificacionBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de verificacion")) {

        JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de Verificacion sin seleccionar",
                "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
      } else {
        idControlesByVerificacion();//controles
        con.isConexionClose();//
        IdentificarParent parent = new IdentificarParent(files);
        String rutaCompleta = parent.getParent();
        String ultimaCarpeta = getUltimaCarpeta(rutaCompleta);
        IdentificarExtension idext = new IdentificarExtension(this, informa, getIdTipoControl(), file,
                rutaCompleta, ultimaCarpeta, usarioTipo.getId(), getTipoDocumento(), getIdVerificacion());
        idext.execute();
        aceptarSeleccion.setEnabled(false);

      }
    } else {
      JOptionPane.showMessageDialog(rutaCarpeta, "Ruta incorrecta", "Error en el ingreso de la ruta", JOptionPane.ERROR_MESSAGE);
      rutaCarpeta.setText("");
    }
  }
}
