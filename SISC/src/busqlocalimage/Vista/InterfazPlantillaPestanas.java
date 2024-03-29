/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazPlantillaPestanas.java
 *
 * Created on 03-06-2013, 12:15:25 AM
 */
package busqlocalimage.Vista;

import java.awt.CardLayout;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.utils.SubstanceConstants;

/**
 *
 * @author Alex
 */
public class InterfazPlantillaPestanas extends javax.swing.JFrame {

    private CardLayout cambiarPanel = null;

    /** Creates new form InterfazPlantillaPestanas */
    public InterfazPlantillaPestanas(String panelSeleccionado) {
        initComponents();
        setLocationRelativeTo(null);

        this.jButtonBuscarImagen.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonBuscarImagen.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.RIGHT);
        this.jButtonBuscarImagen.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.RIGHT);

        this.jButtonIndexarImagenes.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonIndexarImagenes.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.RIGHT);
        this.jButtonIndexarImagenes.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.RIGHT);

        this.jButtonComoFunciona.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonComoFunciona.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.RIGHT);
        this.jButtonComoFunciona.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.RIGHT);

        

        this.JButtonMenuPrincipal.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

        cambiarPanel = (CardLayout) panelContenedorPrincipal.getLayout();
        cambiarPanel(panelSeleccionado);

        if (panelSeleccionado.equals("cardIndexarImagenes")) {

            jButtonIndexarImagenes.setEnabled(false);
        } else if (panelSeleccionado.equals("cardBuscarImagen")) {

            jButtonBuscarImagen.setEnabled(false);
        } else if (panelSeleccionado.equals("cardAyudaSISC")) {

            jButtonComoFunciona.setEnabled(false);
        }


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedorPrincipal = new javax.swing.JPanel();
        jPanelIndexarImagenes1 = new busqlocalimage.Vista.RutasFavoritas.jPanelRutasFavoritas();
        jPanelBuscarImagen1 = new busqlocalimage.Vista.BuscarImagen.jPanelBuscarImagen();
        jPanelComoFunciona1 = new busqlocalimage.Vista.AyudaSistema.jPanelComoFunciona();
        jButtonBuscarImagen = new javax.swing.JButton();
        jButtonIndexarImagenes = new javax.swing.JButton();
        jButtonComoFunciona = new javax.swing.JButton();
        JButtonMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISC: Opciones del Sistema");
        setResizable(false);

        panelContenedorPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelContenedorPrincipal.setLayout(new java.awt.CardLayout());
        panelContenedorPrincipal.add(jPanelIndexarImagenes1, "cardIndexarImagenes");
        panelContenedorPrincipal.add(jPanelBuscarImagen1, "cardBuscarImagen");
        panelContenedorPrincipal.add(jPanelComoFunciona1, "cardAyudaSISC");

        jButtonBuscarImagen.setFont(new java.awt.Font("Calibri", 0, 14));
        jButtonBuscarImagen.setText("Buscar Imagen");
        jButtonBuscarImagen.setFocusable(false);
        jButtonBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarImagenActionPerformed(evt);
            }
        });

        jButtonIndexarImagenes.setFont(new java.awt.Font("Calibri", 0, 14));
        jButtonIndexarImagenes.setText("Rutas Favoritas");
        jButtonIndexarImagenes.setFocusable(false);
        jButtonIndexarImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIndexarImagenesActionPerformed(evt);
            }
        });

        jButtonComoFunciona.setFont(new java.awt.Font("Calibri", 0, 14));
        jButtonComoFunciona.setText("¿Cómo Funciona?");
        jButtonComoFunciona.setFocusable(false);
        jButtonComoFunciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComoFuncionaActionPerformed(evt);
            }
        });

        JButtonMenuPrincipal.setFont(new java.awt.Font("Calibri", 0, 14));
        JButtonMenuPrincipal.setText("Menú Principal");
        JButtonMenuPrincipal.setFocusable(false);
        JButtonMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonIndexarImagenes)
                    .addComponent(jButtonBuscarImagen)
                    .addComponent(jButtonComoFunciona)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JButtonMenuPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(panelContenedorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBuscarImagen, jButtonComoFunciona, jButtonIndexarImagenes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonBuscarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIndexarImagenes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonComoFunciona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 467, Short.MAX_VALUE)
                .addComponent(JButtonMenuPrincipal)
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBuscarImagen, jButtonComoFunciona, jButtonIndexarImagenes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIndexarImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndexarImagenesActionPerformed

        jButtonBuscarImagen.setEnabled(true);
        jButtonComoFunciona.setEnabled(true);
        jButtonIndexarImagenes.setEnabled(false);

        cambiarPanel("cardIndexarImagenes");
    }//GEN-LAST:event_jButtonIndexarImagenesActionPerformed

    private void jButtonBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarImagenActionPerformed

        jButtonBuscarImagen.setEnabled(false);
        jButtonComoFunciona.setEnabled(true);
        jButtonIndexarImagenes.setEnabled(true);

        cambiarPanel("cardBuscarImagen");
    }//GEN-LAST:event_jButtonBuscarImagenActionPerformed

    private void jButtonComoFuncionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComoFuncionaActionPerformed

        jButtonBuscarImagen.setEnabled(true);
        jButtonComoFunciona.setEnabled(false);
        jButtonIndexarImagenes.setEnabled(true);

        cambiarPanel("cardAyudaSISC");
    }//GEN-LAST:event_jButtonComoFuncionaActionPerformed

    private void JButtonMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonMenuPrincipalActionPerformed

        ocultarFrame();
        new InterfazBienvenida().setVisible(true);
    }//GEN-LAST:event_JButtonMenuPrincipalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InterfazPlantillaPestanas("cardBuscarImagen").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonMenuPrincipal;
    private javax.swing.JButton jButtonBuscarImagen;
    private javax.swing.JButton jButtonComoFunciona;
    private javax.swing.JButton jButtonIndexarImagenes;
    private busqlocalimage.Vista.BuscarImagen.jPanelBuscarImagen jPanelBuscarImagen1;
    private busqlocalimage.Vista.AyudaSistema.jPanelComoFunciona jPanelComoFunciona1;
    private busqlocalimage.Vista.RutasFavoritas.jPanelRutasFavoritas jPanelIndexarImagenes1;
    private javax.swing.JPanel panelContenedorPrincipal;
    // End of variables declaration//GEN-END:variables

    /*Metodo para generar el cambio de paneles*/
    public void cambiarPanel(String panel) {

        cambiarPanel.show(panelContenedorPrincipal, panel);
    }

    public void ocultarFrame() {

        this.dispose();
    }//Fin metodo
}
