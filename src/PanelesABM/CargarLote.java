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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Entidades.TipodeUsuario;
import javax.swing.ImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class CargarLote extends javax.swing.JFrame {
    private TipodeUsuario usarioTipo;

    private Entidades.Conexion con = new Entidades.Conexion();
    private List<Integer> idTipoControl = new ArrayList<>();
    private int idVerificacion;
    private Worker worker;

    /**
     * Creates new form CargarLote
     */
    public CargarLote() {
        initComponents();
    }

    public CargarLote(TipodeUsuario usuarioTipo) {
        initComponents();
        String rutaImagen = "Logos/nuevo logo sin letras UTN.png";
        ImageIcon im = new ImageIcon(rutaImagen);
        setIconImage(im.getImage());
        rutaCarpeta.setInputVerifier(new Helpers.InputVerifier().inputVerifierT());
        Verificacion_CargarComboBoxs llenarComboBox = new Verificacion_CargarComboBoxs(tipoDocumentoBox, tipoVerificacionBox, con);
        this.usarioTipo = usuarioTipo;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carga de lote");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(230, 252, 238));

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione ruta, tipo de documento y tipo de verificación a utilizar");

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        jLabel2.setText("Ruta");

        rutaCarpeta.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        rutaCarpeta.setText("C:\\\\Angeles\\\\PDF");

        aceptarSeleccion.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        aceptarSeleccion.setText("Siguiente");
        aceptarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarSeleccionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        jLabel4.setText("Documento");

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        jLabel5.setText("Verificación");

        tipoDocumentoBox.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        tipoDocumentoBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el Tipo de Documento" }));

        tipoVerificacionBox.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        tipoVerificacionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el Tipo de Verificación" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tipoVerificacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rutaCarpeta))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tipoDocumentoBox, 0, 393, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipoDocumentoBox, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoVerificacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aceptarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarSeleccionActionPerformed
        String ruta = rutaCarpeta.getText();
        File file = new File(ruta);
        if (file.exists()) {
            if (tipoDocumentoBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de documento")) {
                JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de documentos sin seleccionar",
                        "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);

            } else if (tipoVerificacionBox.getSelectedItem().toString().equalsIgnoreCase("Seleccione el tipo de verificacion")) {

                JOptionPane.showMessageDialog(rutaCarpeta, "Tipo de Verificacion sin seleccionar",
                        "Error en la seleccion del ComboBox", JOptionPane.ERROR_MESSAGE);
            } else {
                idControlesByVerificacion();
                worker = new Worker(this, rutaCarpeta, getIdTipoControl(), getTipoDocumento(), getIdVerificacion(), usarioTipo.getId());
                worker.execute();
            }
        } else {
            JOptionPane.showMessageDialog(rutaCarpeta, "Ruta incorrecta", "Error en el ingreso de la ruta", JOptionPane.ERROR_MESSAGE);
            rutaCarpeta.setText("");
        }

    }//GEN-LAST:event_aceptarSeleccionActionPerformed

    public List<Integer> getIdTipoControl() {
        return idTipoControl;
    }

    public TipodeUsuario getUsarioTipo() {
        return usarioTipo;
    }

    private int getTipoDocumento() {
        Ventana.ListaControlesActivos.TipoControl tip =
                (Ventana.ListaControlesActivos.TipoControl) tipoDocumentoBox.getSelectedItem();
        return tip.getId();
    }

    private List<Integer> idControlesByVerificacion() {
        Ventana.ListaControlesActivos.TipoControl tip = (Ventana.ListaControlesActivos.TipoControl) tipoVerificacionBox.getSelectedItem();
        idVerificacion=tip.getId();
        String selec = "SELECT idControl FROM qualitys.controles_verificacion where idVerificacion =" + tip.getId() + ";";
        if (con.isConexion()) {
            try {
                con.ExecuteSql(selec);
                while (con.resulset.next()) {
                    idTipoControl.add(con.resulset.getInt(1));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(tipoDocumentoBox, ex.getMessage(), CargarLote.class.getName(), JOptionPane.ERROR_MESSAGE
                        );
                Logger.getLogger(CargarLote.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField rutaCarpeta;
    private javax.swing.JComboBox tipoDocumentoBox;
    private javax.swing.JComboBox tipoVerificacionBox;
    // End of variables declaration//GEN-END:variables
}
