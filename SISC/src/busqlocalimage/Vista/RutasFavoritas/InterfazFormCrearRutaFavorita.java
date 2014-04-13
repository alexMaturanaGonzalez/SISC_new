/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazFormCrearRutaFavorita.java
 *
 * Created on 08-06-2013, 04:41:43 PM
 */
package busqlocalimage.Vista.RutasFavoritas;

import Controlador.ControladorImagen;
import Controlador.ControladorRutasFavoritas;
import Entidades.RutaFavorita;
import Logica.GestionJFileChooser;
import Logica.Fecha;
import Logica.GestionRutasFavoritas;
import java.awt.Color;
import java.util.ArrayList;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

/**
 *
 * @author Alex
 */
public class InterfazFormCrearRutaFavorita extends javax.swing.JFrame {

    private ControladorRutasFavoritas controladorRutasFavoritas = new ControladorRutasFavoritas();
    private ControladorImagen controladorImagen = new ControladorImagen();
    private GestionJFileChooser jFileChooser = new GestionJFileChooser();
    private int contadorImage = 0;
    private Color jTextAreaColor;
    private boolean flagCheck_1 = false;
    private boolean flagCheck_2 = false;
    int cont;

    /** Creates new form InterfazFormCrearRutaFavorita */
    public InterfazFormCrearRutaFavorita() {
        initComponents();
        this.setLocation(500, 100);

        this.jButtonCancelar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonExaminar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonIndexar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

        this.jTextCantImage.setText("0");
        this.msjeError.setVisible(false);

        this.jButtonIndexar.setEnabled(false);

        jTextAreaColor = jTextNombre.getForeground();

        this.jTextNombre.setText("Debe Ingresar un Nombre.");
        this.jTextNombre.setForeground(Color.GRAY);

        this.jTextNombre.setFocusable(false);

        cont = 0;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButtonExaminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextCantImage = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIndexar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        msjeError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sisc: Crear Nueva Ruta Favorita");
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel4.setText("Nombre");

        jTextNombre.setFont(new java.awt.Font("Calibri", 0, 11));
        jTextNombre.setText(" ");
        jTextNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextNombreMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextNombreMousePressed(evt);
            }
        });
        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });
        jTextNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextNombreFocusLost(evt);
            }
        });
        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNombreKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel5.setText("Rutas a Cargar");

        jTextArea.setColumns(20);
        jTextArea.setEditable(false);
        jTextArea.setFont(new java.awt.Font("Calibri", 0, 11));
        jScrollPane1.setViewportView(jTextArea);

        jButtonExaminar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonExaminar.setText("Examinar");
        jButtonExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExaminarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel7.setText("Total de Imágenes ");

        jTextCantImage.setEditable(false);
        jTextCantImage.setFont(new java.awt.Font("Calibri", 0, 11));
        jTextCantImage.setText(" ");
        jTextCantImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantImageActionPerformed(evt);
            }
        });

        jButtonIndexar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonIndexar.setText("Insertar");
        jButtonIndexar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIndexarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        msjeError.setFont(new java.awt.Font("Calibri", 0, 13));
        msjeError.setForeground(new java.awt.Color(255, 0, 0));
        msjeError.setText("msjeError");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextCantImage, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(269, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(msjeError, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonIndexar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExaminar)))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonExaminar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextCantImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msjeError)
                    .addComponent(jButtonIndexar)
                    .addComponent(jButtonCancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed

}//GEN-LAST:event_jTextNombreActionPerformed

    private void jTextCantImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantImageActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextCantImageActionPerformed

    private void jButtonExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExaminarActionPerformed

        String rutaDondeBuscar = jFileChooser.abrirOpenDialogDirectory();

        if (rutaDondeBuscar == null) {
        } else {

            this.jTextArea.append(rutaDondeBuscar);
            this.jTextArea.append("\n");

            contadorImage = Integer.parseInt(this.jTextCantImage.getText()) + new GestionRutasFavoritas().contadorImagenesRuta(rutaDondeBuscar);

            this.jTextCantImage.setText(Integer.toString(contadorImage));
        }

        if (contadorImage > 0) {

            flagCheck_1 = true;
            this.msjeError.setVisible(false);
        } else {

            flagCheck_1 = false;
            this.msjeError.setText("Debe Ingresar Directorio con Imágenes Válidas.");
            this.msjeError.setVisible(true);
        }

        validarBotonInsertar(flagCheck_1, flagCheck_2);
    }//GEN-LAST:event_jButtonExaminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        setearElementos();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonIndexarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndexarActionPerformed

        ArrayList<RutaFavorita> arrayRutaFavorita;
        String nameRutaFavorita = this.jTextNombre.getText().trim();
        ArrayList<String> arrayRutasFavoritas = controladorImagen.separaRutas(this.jTextArea.getText());
        String fechaCreacion = new Fecha().obtenerFecha("D", "M", "A");
        int cantImagenes = Integer.parseInt(this.jTextCantImage.getText());
        Color colorMsje;

        if (controladorRutasFavoritas.verificarRutaFavorita(nameRutaFavorita)) {

            this.msjeError.setText("Ya Existe una Ruta con ese Nombre.");
            this.msjeError.setForeground(Color.RED);
            this.msjeError.setVisible(true);

        } else if (nameRutaFavorita.equals("")) {

            this.msjeError.setText("Debe escribir un nombre.");
            this.msjeError.setForeground(Color.BLUE);
            this.msjeError.setVisible(true);
        } else {

            RutaFavorita rf = controladorRutasFavoritas.encapsularRutaFavorita(null, nameRutaFavorita, arrayRutasFavoritas, cantImagenes, fechaCreacion);

            ArrayList<RutaFavorita> arrayRutasFavTemp = new ArrayList<RutaFavorita>();
            arrayRutasFavTemp.add(rf);

            if (controladorRutasFavoritas.archivoExiste()) {

                controladorRutasFavoritas.anadirRutaFavorita(rf);
            } else {

                controladorRutasFavoritas.escribirRutasFavoritas(arrayRutasFavTemp);
            }

            arrayRutaFavorita = controladorRutasFavoritas.leerRutasFavoritas();

            jPanelListarRutasFavoritas.mostrarDatos(arrayRutaFavorita);

            this.msjeError.setVisible(false);
            this.dispose();

            jPanelRutasFavoritas.msjeError("Ruta Favorita Agregada con Éxito.", true, Color.BLACK);
        }

    }//GEN-LAST:event_jButtonIndexarActionPerformed

    private void jTextNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyPressed
    }//GEN-LAST:event_jTextNombreKeyPressed

    private void jTextNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNombreMouseClicked

       
    }//GEN-LAST:event_jTextNombreMouseClicked

    private void jTextNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextNombreFocusLost

        if (this.jTextNombre.getText().compareTo("Debe Ingresar un Nombre.") == 0) {

            System.out.println("Debe ingresar un nombre");
            flagCheck_2 = false;
        } else if (this.jTextNombre.getText().trim().compareTo("") == 0) {

            System.out.println("VACIO");
            this.msjeError.setText("Debe escribir un nombre.");
            this.msjeError.setForeground(Color.BLUE);
            this.msjeError.setVisible(true);
            flagCheck_2 = false;
        } else if (controladorRutasFavoritas.verificarRutaFavorita(this.jTextNombre.getText().trim())) {

            System.out.println("Ruta con ese nombre ya existe.");
            this.msjeError.setText("Ya Existe una Ruta con ese Nombre.");
            this.msjeError.setForeground(Color.RED);
            this.msjeError.setVisible(true);
            flagCheck_2 = false;
        } else {

            System.out.println("cambio de nombre");
            flagCheck_2 = true;
        }

        validarBotonInsertar(flagCheck_1, flagCheck_2);
    }//GEN-LAST:event_jTextNombreFocusLost

    private void jTextNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNombreMousePressed
         System.out.println("cont " + cont);
        this.jTextNombre.setFocusable(true);
        if (cont == 0) {

            this.jTextNombre.setFocusable(true);
            this.jTextNombre.setText("");
            this.jTextNombre.setForeground(jTextAreaColor);
            cont++;
        }
    }//GEN-LAST:event_jTextNombreMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InterfazFormCrearRutaFavorita().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExaminar;
    private javax.swing.JButton jButtonIndexar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTextCantImage;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JLabel msjeError;
    // End of variables declaration//GEN-END:variables

    private void setearElementos() {

        this.jTextNombre.setText("");
        this.jTextArea.setText("");
        this.jTextCantImage.setText("");
        this.msjeError.setVisible(false);
    }//Fin metodo setear Elementos

    private void validarBotonInsertar(boolean flagCheck_1, boolean flagCheck_2) {

        if (flagCheck_1 == true && flagCheck_2 == true) {

            this.jButtonIndexar.setEnabled(true);
        } else {

            this.jButtonIndexar.setEnabled(false);
        }
    }//Fin metodo validar Boton insertar
}
