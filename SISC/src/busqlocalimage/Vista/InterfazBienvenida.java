/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazBienvenida.java
 *
 * Created on 03-06-2013, 08:14:27 PM
 */
package busqlocalimage.Vista;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

/**
 *
 * @author Alex
 */
public class InterfazBienvenida extends javax.swing.JFrame {

    /** Creates new form InterfazBienvenida */
    public InterfazBienvenida() {

        initComponents();
        setLocationRelativeTo(null);

        this.ButtonBuscarImagen.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.ButtonIndexarImagen.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.ButtonComoFunciona.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonBuscarImagen = new javax.swing.JButton();
        ButtonIndexarImagen = new javax.swing.JButton();
        ButtonComoFunciona = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISC: Sistema de Búsqueda de Imágenes por Conteido");
        setName("frameBienv"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Inicio ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        ButtonBuscarImagen.setFont(new java.awt.Font("Calibri", 0, 16));
        ButtonBuscarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Search-Images-icon-24px.png"))); // NOI18N
        ButtonBuscarImagen.setText("Buscar Imagen");
        ButtonBuscarImagen.setFocusable(false);
        ButtonBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarImagenActionPerformed(evt);
            }
        });

        ButtonIndexarImagen.setFont(new java.awt.Font("Calibri", 0, 16));
        ButtonIndexarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/binary-tree-icon-24px.png"))); // NOI18N
        ButtonIndexarImagen.setText("Rutas Favoritas");
        ButtonIndexarImagen.setFocusable(false);
        ButtonIndexarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonIndexarImagenActionPerformed(evt);
            }
        });

        ButtonComoFunciona.setFont(new java.awt.Font("Calibri", 0, 16));
        ButtonComoFunciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Help-icon-24px.png"))); // NOI18N
        ButtonComoFunciona.setText("¿Cómo Funciona?");
        ButtonComoFunciona.setFocusable(false);
        ButtonComoFunciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonComoFuncionaActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/logo_120.png"))); // NOI18N
        jLabel2.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonBuscarImagen)
                    .addComponent(ButtonIndexarImagen)
                    .addComponent(ButtonComoFunciona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ButtonBuscarImagen, ButtonComoFunciona, ButtonIndexarImagen});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(ButtonBuscarImagen)
                        .addGap(35, 35, 35)
                        .addComponent(ButtonIndexarImagen)
                        .addGap(35, 35, 35)
                        .addComponent(ButtonComoFunciona))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonBuscarImagen, ButtonComoFunciona, ButtonIndexarImagen});

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 40));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Bienvenidos_120.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonIndexarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonIndexarImagenActionPerformed
        panelSISC("cardIndexarImagenes");
    }//GEN-LAST:event_ButtonIndexarImagenActionPerformed

    private void ButtonBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarImagenActionPerformed
        panelSISC("cardBuscarImagen");
    }//GEN-LAST:event_ButtonBuscarImagenActionPerformed

    private void ButtonComoFuncionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonComoFuncionaActionPerformed
        panelSISC("cardAyudaSISC");
    }//GEN-LAST:event_ButtonComoFuncionaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InterfazBienvenida().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscarImagen;
    private javax.swing.JButton ButtonComoFunciona;
    private javax.swing.JButton ButtonIndexarImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void panelSISC(String panel) {

        this.dispose();
        new InterfazPlantillaPestanas(panel).setVisible(true);
    }//Fin metodo panelSISC
}