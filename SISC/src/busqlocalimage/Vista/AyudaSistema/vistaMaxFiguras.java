/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * vistaMaxFiguras.java
 *
 * Created on 10-11-2013, 12:30:34 AM
 */
package busqlocalimage.Vista.AyudaSistema;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex
 */
public class vistaMaxFiguras extends javax.swing.JFrame {

    private String rutaImagen;
    private final ImageIcon icon;

    public vistaMaxFiguras(String rutaImagenSelect) {

        initComponents();
        //setLocationRelativeTo(null);
        setLocation(530, 100);

        this.rutaImagen = rutaImagenSelect;
        icon = new ImageIcon(getClass().getResource(rutaImagen));

        imagenDefault(icon);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISC: Vista Maximada de Figuras");
        setAlwaysOnTop(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabelImagen.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        this.dispose();
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImagen;
    // End of variables declaration//GEN-END:variables

    private void imagenDefault(ImageIcon icon) {

        Image img = icon.getImage();
        ImageIcon newIcon = new ImageIcon(img);

        jLabelImagen.setIcon(newIcon);
        jLabelImagen.setSize(440, 450);
    }//Fin metodo imagenDefault
}
