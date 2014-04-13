/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazFormModificarRutaFavorita.java
 *
 * Created on 08-06-2013, 05:16:55 PM
 */
package busqlocalimage.Vista.RutasFavoritas;

import Controlador.ControladorRutasFavoritas;
import Logica.GestionJFileChooser;
import Entidades.RutaFavorita;
import Logica.GestionRutasFavoritas;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

/**
 *
 * @author Alex
 */
public class InterfazFormModificarRutaFavorita extends javax.swing.JFrame {

    private ControladorRutasFavoritas controladorRutasFavoritas = new ControladorRutasFavoritas();
    private GestionJFileChooser jFileChooser = new GestionJFileChooser();
    private static ArrayList<RutaFavorita> arrayRutaFavorita;
    private static int rutaFavSeleccionada;
    private DefaultListModel modeloLista = new DefaultListModel();
    private int indices;
    private int contadorImage;
    private String idRutaSeleccionada;

    /** Creates new form InterfazFormModificarRutaFavorita */
    @SuppressWarnings("static-access")
    public InterfazFormModificarRutaFavorita(ArrayList<RutaFavorita> arrayRutaFavorita_1, int rutaFavSeleccionada_1) {
        initComponents();
        this.setLocation(500, 100);
        jListRutas.setModel(modeloLista);

        this.jButtonCancelar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonModificar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonAnadir.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonEliminar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

        this.arrayRutaFavorita = arrayRutaFavorita_1;
        this.rutaFavSeleccionada = rutaFavSeleccionada_1;

        System.out.println("Tamaño " + arrayRutaFavorita.size() + " ultimo dato " + arrayRutaFavorita.get(rutaFavSeleccionada_1).getNombre());
        System.out.println("RT selecionada en Modificar = " + rutaFavSeleccionada);
        RutaFavorita rutaFav = arrayRutaFavorita.get(rutaFavSeleccionada);

        System.out.println("1");

        idRutaSeleccionada = rutaFav.getId();
        System.out.println("IDSELECT " + idRutaSeleccionada);

        this.jTextNombre.setText(rutaFav.getNombre());
        this.jTextCantImage.setText(Integer.toString(rutaFav.getCantImagenes()));
        this.jTextFechaCreacion.setText(rutaFav.getFechaCreacion());

        for (int i = 0; i < rutaFav.getRutas().size(); i++) {

            modeloLista.addElement(rutaFav.getRutas().get(i));
        }

        this.msjeError.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextCantImage = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonModificar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFechaCreacion = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jButtonAnadir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRutas = new javax.swing.JList();
        msjeError = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISC: Modificar Ruta Favorita");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel4.setText("Nombre");

        jTextNombre.setFont(new java.awt.Font("Calibri", 0, 11));
        jTextNombre.setText(" ");
        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel5.setText("Rutas a Cargar");

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

        jButtonModificar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel6.setText("Fecha de Creación");

        jTextFechaCreacion.setEditable(false);
        jTextFechaCreacion.setFont(new java.awt.Font("Calibri", 0, 11));
        jTextFechaCreacion.setText(" ");
        jTextFechaCreacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechaCreacionActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Button-Delete-icon-16px.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonAnadir.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Button-Add-icon-16px.png"))); // NOI18N
        jButtonAnadir.setText("Añadir");
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        jListRutas.setFont(new java.awt.Font("Calibri", 0, 11));
        jListRutas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListRutasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListRutasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListRutas);

        msjeError.setFont(new java.awt.Font("Calibri", 0, 11));
        msjeError.setForeground(new java.awt.Color(255, 0, 0));
        msjeError.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextCantImage, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonEliminar)
                                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(42, 42, 42)
                                    .addComponent(jTextNombre))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(10, 10, 10)
                                    .addComponent(jTextFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(msjeError, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jButtonModificar)
                        .addGap(113, 113, 113))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAnadir, jButtonEliminar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextCantImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonModificar)
                    .addComponent(msjeError))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAnadir, jButtonEliminar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextNombreActionPerformed

    private void jTextCantImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantImageActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextCantImageActionPerformed

    private void jTextFechaCreacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechaCreacionActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFechaCreacionActionPerformed

    private void jListRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRutasMouseClicked
    }//GEN-LAST:event_jListRutasMouseClicked

    private void jListRutasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRutasMousePressed

        //recoge el indice de los seleccionados
        indices = jListRutas.getSelectedIndex();
    }//GEN-LAST:event_jListRutasMousePressed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        //arrayRutaFavorita.remove(indices);
        modeloLista.remove(indices);

        if (modeloLista.isEmpty()) {

            contadorImage = 0;
        } else {

            for (int i = 0; i < modeloLista.size(); i++) {

                contadorImage = new GestionRutasFavoritas().contadorImagenesRuta((String) modeloLista.getElementAt(i));
            }
        }
        this.jTextCantImage.setText(Integer.toString(contadorImage));
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed

        String rutaDondeBuscar = jFileChooser.abrirOpenDialogDirectory();

        if (rutaDondeBuscar == null) {

            System.out.println("|aaa");
        } else {

            modeloLista.addElement(rutaDondeBuscar);
            contadorImage = Integer.parseInt(this.jTextCantImage.getText()) + new GestionRutasFavoritas().contadorImagenesRuta(rutaDondeBuscar);
            this.jTextCantImage.setText(Integer.toString(contadorImage));
        }

    }//GEN-LAST:event_jButtonAnadirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        ArrayList<String> arrayRutasModif = new ArrayList<String>();
        arrayRutasModif.clear();

        if (this.jTextNombre.getText().equals("")) {

            this.msjeError.setText("Debe escribir un nombre.");
            this.msjeError.setForeground(Color.BLUE);
            this.msjeError.setVisible(true);
        } else {

            if (modeloLista.size() == 0) {
            } else {
                for (int i = 0; i < modeloLista.size(); i++) {

                    arrayRutasModif.add((String) modeloLista.getElementAt(i));
                }
            }

            //AGREGAR BOTON PARA EJECUTAR INSERCION NUEVAMENTE; 
            RutaFavorita rutaFavoritaModificada = new RutaFavorita(idRutaSeleccionada, jTextNombre.getText(), arrayRutasModif, Integer.parseInt(jTextCantImage.getText()), jTextFechaCreacion.getText());

            jPanelListarRutasFavoritas.mostrarDatos(controladorRutasFavoritas.modificarRutaFavorita(arrayRutaFavorita, rutaFavoritaModificada));
            this.dispose();

            jPanelRutasFavoritas.msjeError("Ruta Favorita Modificada con Éxito.", true, Color.BLACK);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InterfazFormModificarRutaFavorita(arrayRutaFavorita, rutaFavSeleccionada).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jListRutas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextCantImage;
    private javax.swing.JTextField jTextFechaCreacion;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JLabel msjeError;
    // End of variables declaration//GEN-END:variables
}