/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import PanelesABM.CargarLote;
import PanelesABM.ControlesABM;
import PanelesABM.RangosABM;
import PanelesABM.UsuariosABM;
import PanelesABM.VerificacionABM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Entidades.TipodeUsuario;
import javax.swing.ImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class PanelControl extends javax.swing.JFrame {
    private static final String INFO_LABEL="<html>La edición de rangos, tipos de"
            + " verificación, controles y alta de usuarios, sólo esta permitido al administrador.</html>";
    private TipodeUsuario usuarioTipo;
    private boolean administrador;

    /**
     * Creates new form PanelControl
     */
    public PanelControl() {
        initComponents();
    }

    PanelControl(TipodeUsuario usuarioTipo) {
        initComponents();
                String rutaImagen ="Logos/nuevo logo sin letras UTN.png";
        ImageIcon im = new ImageIcon(rutaImagen);
       setIconImage(im.getImage());
        jLabel1.setText(INFO_LABEL);
        this.usuarioTipo = usuarioTipo;
        this.administrador = usuarioTipo.isAdmin();
        if (!administrador) {
            rangos.setEnabled(false);
            controles.setEnabled(false);
            alta_usuarios.setEnabled(false);
            verificacion.setEnabled(false);
        }
        cargar_lote.addActionListener(null);
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public TipodeUsuario getUsuarioTipo() {
        return usuarioTipo;
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
        base_datos = new javax.swing.JButton();
        rangos = new javax.swing.JButton();
        controles = new javax.swing.JButton();
        alta_usuarios = new javax.swing.JButton();
        cargar_lote = new javax.swing.JButton();
        verificacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Panel de Control");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(230, 252, 238));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        base_datos.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        base_datos.setText("Base de Datos");
        base_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                base_datosActionPerformed(evt);
            }
        });

        rangos.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        rangos.setText("Rangos");
        rangos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangosActionPerformed(evt);
            }
        });

        controles.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        controles.setText("Controles");
        controles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlesActionPerformed(evt);
            }
        });

        alta_usuarios.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        alta_usuarios.setText("Usuarios");
        alta_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alta_usuariosActionPerformed(evt);
            }
        });

        cargar_lote.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        cargar_lote.setText("Cargar Lote");
        cargar_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_loteActionPerformed(evt);
            }
        });

        verificacion.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        verificacion.setText("Verificación");
        verificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(base_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rangos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alta_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargar_lote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(base_datos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rangos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(controles, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alta_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cargar_lote, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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

    private void base_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_base_datosActionPerformed
        actionButton(evt);
    }//GEN-LAST:event_base_datosActionPerformed

    private void rangosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangosActionPerformed
        actionButton(evt);
    }//GEN-LAST:event_rangosActionPerformed

    private void controlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlesActionPerformed
        actionButton(evt);
    }//GEN-LAST:event_controlesActionPerformed

    private void alta_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alta_usuariosActionPerformed
        actionButton(evt);
    }//GEN-LAST:event_alta_usuariosActionPerformed

    private void verificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificacionActionPerformed
        actionButton(evt);
    }//GEN-LAST:event_verificacionActionPerformed

    private void cargar_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_loteActionPerformed
        actionButton(evt);
    }//GEN-LAST:event_cargar_loteActionPerformed

    private void actionButton(java.awt.event.ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "Base de Datos":
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new IngresoBaseDeDatos(isAdministrador()).setVisible(true);
                    }
                });
                break;
            case "Rangos":
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new RangosABM().setVisible(true);
                    }
                });
                break;
            case "Cargar Lote":
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new CargarLote(getUsuarioTipo()).setVisible(true);
                    }
                });
                dispose();
                break;
            case "Controles":
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ControlesABM().setVisible(true);
                    }
                });
                break;
            case "Usuarios":
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new UsuariosABM().setVisible(true);
                    }
                });
                break;
            case "Verificacion":
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new VerificacionABM().setVisible(true);
                    }
                });
                break;
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta_usuarios;
    private javax.swing.JButton base_datos;
    private javax.swing.JButton cargar_lote;
    private javax.swing.JButton controles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton rangos;
    private javax.swing.JButton verificacion;
    // End of variables declaration//GEN-END:variables
}
