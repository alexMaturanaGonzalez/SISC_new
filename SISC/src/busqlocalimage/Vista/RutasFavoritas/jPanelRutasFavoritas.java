/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jPanelRutasFavoritas.java
 *
 * Created on 08-06-2013, 01:38:48 PM
 */
package busqlocalimage.Vista.RutasFavoritas;

import Controlador.ControladorRutasFavoritas;
import Entidades.RutaFavorita;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

/**
 *
 * @author Alex
 */
public class jPanelRutasFavoritas extends javax.swing.JPanel {

    private CardLayout cambiarPanel = null;
    private ControladorRutasFavoritas controladorRutasFavoritas = new ControladorRutasFavoritas();
    private static ArrayList<RutaFavorita> arrayRutaFavorita;
    private static int rutaFavSeleccionada;
    private String tipoBoton;

    /** Creates new form jPanelRutasFavoritas */
    public jPanelRutasFavoritas() {
        initComponents();

        this.jButtonAyudaRT.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonCrearRT.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonDeleteRT.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonListRT.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonModifRT.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

        this.msjeErrorRT.setVisible(false);

        cambiarPanel = (CardLayout) panelContenedor.getLayout();
        cambiarPanel("cardListaIndices");

        jButtonListRT.setSelected(true);

        if (controladorRutasFavoritas.leerRutasFavoritas() != null) {

            arrayRutaFavorita = controladorRutasFavoritas.leerRutasFavoritas();
            jPanelListarRutasFavoritas.mostrarDatos(arrayRutaFavorita);
        } else {

            controladorRutasFavoritas.crearArchivo();
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

        panelContenedor = new javax.swing.JPanel();
        jPanelIndexarImagenesListarIndices1 = new busqlocalimage.Vista.RutasFavoritas.jPanelListarRutasFavoritas();
        jPanelAyudaRutasFavoritas1 = new busqlocalimage.Vista.RutasFavoritas.jPanelAyudaRutasFavoritas();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonCrearRT = new javax.swing.JButton();
        jButtonListRT = new javax.swing.JButton();
        jButtonModifRT = new javax.swing.JButton();
        jButtonDeleteRT = new javax.swing.JButton();
        jButtonAyudaRT = new javax.swing.JButton();
        msjeErrorRT = new javax.swing.JLabel();

        panelContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelContenedor.setLayout(new java.awt.CardLayout());
        panelContenedor.add(jPanelIndexarImagenesListarIndices1, "cardListaIndices");
        panelContenedor.add(jPanelAyudaRutasFavoritas1, "cardAyudaRT");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Opciones ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/logoRT_120 - copia.png"))); // NOI18N
        jLabel1.setText(" ");

        jButtonCrearRT.setFont(new java.awt.Font("Calibri", 0, 16));
        jButtonCrearRT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/note-add-icon-24px.png"))); // NOI18N
        jButtonCrearRT.setText("Nueva Ruta Favorita");
        jButtonCrearRT.setFocusable(false);
        jButtonCrearRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearRTActionPerformed(evt);
            }
        });

        jButtonListRT.setFont(new java.awt.Font("Calibri", 0, 16));
        jButtonListRT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/text-list-numbers-icon-24px.png"))); // NOI18N
        jButtonListRT.setText("Listar Rutas Favoritas");
        jButtonListRT.setFocusable(false);
        jButtonListRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListRTActionPerformed(evt);
            }
        });

        jButtonModifRT.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonModifRT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/edit-file-icon-16px.png"))); // NOI18N
        jButtonModifRT.setText("Modificar Ruta Favorita");
        jButtonModifRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifRTActionPerformed(evt);
            }
        });

        jButtonDeleteRT.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonDeleteRT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Button-Delete-icon-16px.png"))); // NOI18N
        jButtonDeleteRT.setText("Eliminar Ruta Favorita");
        jButtonDeleteRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRTActionPerformed(evt);
            }
        });

        jButtonAyudaRT.setFont(new java.awt.Font("Calibri", 0, 16));
        jButtonAyudaRT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Help-icon-24px.png"))); // NOI18N
        jButtonAyudaRT.setText("¿Qué son las Rutas Favoritas?");
        jButtonAyudaRT.setFocusable(false);
        jButtonAyudaRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaRTActionPerformed(evt);
            }
        });

        msjeErrorRT.setFont(new java.awt.Font("Calibri", 0, 12));
        msjeErrorRT.setForeground(new java.awt.Color(255, 0, 0));
        msjeErrorRT.setText("msjError");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonDeleteRT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModifRT, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonAyudaRT)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonCrearRT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(jButtonListRT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(msjeErrorRT, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, 0, 180, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msjeErrorRT)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonCrearRT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonListRT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonModifRT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDeleteRT)
                        .addGap(11, 11, 11)
                        .addComponent(jButtonAyudaRT)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearRTActionPerformed

        tipoBoton = "CrearRT";
        selectBotones(tipoBoton);

        msjeError("", false, Color.BLACK);

        new InterfazFormCrearRutaFavorita().setVisible(true);
}//GEN-LAST:event_jButtonCrearRTActionPerformed

    private void jButtonListRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListRTActionPerformed

        cambiarPanel("cardListaIndices");

        tipoBoton = "ListRT";
        selectBotones(tipoBoton);

        msjeError("", false, Color.BLACK);

        if (controladorRutasFavoritas.leerRutasFavoritas() != null) {

            arrayRutaFavorita = controladorRutasFavoritas.leerRutasFavoritas();
            jPanelListarRutasFavoritas.mostrarDatos(arrayRutaFavorita);
        } else {

            System.out.println("El archivo no Existe!");
        }
}//GEN-LAST:event_jButtonListRTActionPerformed

    private void jButtonModifRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifRTActionPerformed
        arrayRutaFavorita = controladorRutasFavoritas.leerRutasFavoritas();

        tipoBoton = "ModifRT";
        selectBotones(tipoBoton);

        msjeError("", false, Color.BLACK);

        System.out.println("Ruta Seleccionada " + rutaFavSeleccionada);
        new InterfazFormModificarRutaFavorita(arrayRutaFavorita, rutaFavSeleccionada).setVisible(true);
    }//GEN-LAST:event_jButtonModifRTActionPerformed

    private void jButtonDeleteRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRTActionPerformed

        tipoBoton = "DeleteRT";
        selectBotones(tipoBoton);
        Color colorMsje = Color.BLACK;

        String strMessage = null;
        int desElimin = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar la Ruta Favorita seleccionada?", "Confirmar Eliminación", 2);

        if (desElimin == JOptionPane.YES_OPTION) {

            System.out.println("Ruta Seleccionada para eliminar" + rutaFavSeleccionada);
            ArrayList<RutaFavorita> arrayRutaFavElim = new ControladorRutasFavoritas().eliminarRuta(arrayRutaFavorita, rutaFavSeleccionada);
            System.out.println("DPS " + arrayRutaFavElim.size());
            jPanelListarRutasFavoritas.mostrarDatos(arrayRutaFavElim);

            strMessage = "Ruta Favorita Eliminada con Éxito.";
            colorMsje = Color.BLACK;
            //JOptionPane.showMessageDialog(null, strMessage, "Eliminación de Ruta Favorita", 0);
        } else if (desElimin == JOptionPane.CANCEL_OPTION) {

            //MSJE ERROR... ELIMINACION CANCELADA
            strMessage = "Eliminación Cancelada por Usuario.";
            colorMsje = Color.BLUE;
        }

        msjeError(strMessage, true, colorMsje);
}//GEN-LAST:event_jButtonDeleteRTActionPerformed

    private void jButtonAyudaRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAyudaRTActionPerformed

        cambiarPanel("cardAyudaRT");

        tipoBoton = "AyudaRT";
        selectBotones(tipoBoton);

        msjeError("", false, Color.BLACK);
    }//GEN-LAST:event_jButtonAyudaRTActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAyudaRT;
    private javax.swing.JButton jButtonCrearRT;
    private javax.swing.JButton jButtonDeleteRT;
    private javax.swing.JButton jButtonListRT;
    private javax.swing.JButton jButtonModifRT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private busqlocalimage.Vista.RutasFavoritas.jPanelAyudaRutasFavoritas jPanelAyudaRutasFavoritas1;
    private busqlocalimage.Vista.RutasFavoritas.jPanelListarRutasFavoritas jPanelIndexarImagenesListarIndices1;
    private static javax.swing.JLabel msjeErrorRT;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables

    /*Metodo para generar el cambio de paneles*/
    public void cambiarPanel(String panel) {

        cambiarPanel.show(panelContenedor, panel);
    }//FIN cambiarPanel

    public static void setRowLista(int row) {

        rutaFavSeleccionada = row;
        System.out.println("rutaFavSeleccionada  = " + rutaFavSeleccionada);
    }//Fin seleccionar fila

    public static void msjeError(String msjeError, boolean mostrar, Color colorMsje) {

        jPanelRutasFavoritas.msjeErrorRT.setText(msjeError);
        jPanelRutasFavoritas.msjeErrorRT.setForeground(colorMsje);
        jPanelRutasFavoritas.msjeErrorRT.setVisible(mostrar);
    }//Fin metodo msje de error

    public void selectBotones(String tipoBoton) {

        boolean selectedCrear = false;
        boolean selectedListar = false;
        boolean selectedAyuda = false;
        boolean selectedModif = false;
        boolean selectedDelete = false;
        if (tipoBoton.compareTo("CrearRT") == 0) {

            selectedCrear = true;
            selectedListar = false;
            selectedAyuda = false;
            selectedModif = false;
            selectedDelete = false;
        } else if (tipoBoton.compareTo("ListRT") == 0) {

            selectedCrear = false;
            selectedListar = true;
            selectedAyuda = false;
            selectedModif = false;
            selectedDelete = false;
        } else if (tipoBoton.compareTo("AyudaRT") == 0) {

            selectedCrear = false;
            selectedListar = false;
            selectedAyuda = true;
            selectedModif = false;
            selectedDelete = false;
        } else if (tipoBoton.compareTo("ModifRT") == 0) {

            selectedCrear = false;
            selectedListar = true;
            selectedAyuda = false;
            selectedModif = true;
            selectedDelete = false;
        } else if (tipoBoton.compareTo("DeleteRT") == 0) {

            selectedCrear = false;
            selectedListar = true;
            selectedAyuda = false;
            selectedModif = false;
            selectedDelete = true;
        }

        this.jButtonCrearRT.setSelected(selectedCrear);
        this.jButtonListRT.setSelected(selectedListar);
        this.jButtonAyudaRT.setSelected(selectedAyuda);

        this.jButtonModifRT.setSelected(selectedModif);
        this.jButtonDeleteRT.setSelected(selectedDelete);
    }//Fin metodo seleccion de botones
}
