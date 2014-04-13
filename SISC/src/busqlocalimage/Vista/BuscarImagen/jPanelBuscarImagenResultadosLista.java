/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jPanelBuscarImagenResultadosLista.java
 *
 * Created on 04-06-2013, 12:05:35 AM
 */
package busqlocalimage.Vista.BuscarImagen;

import Controlador.ControladorImagen;
import Entidades.Imagen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class jPanelBuscarImagenResultadosLista extends javax.swing.JPanel {

    private ControladorImagen controladorImagen = new ControladorImagen();
    private static ArrayList<Imagen> datosImagen;
    private static String[] columNames = {"Nombre", "Ruta", "Distancia", "Seleccionar"};

    /** Creates new form jPanelBuscarImagenResultadosLista */
    public jPanelBuscarImagenResultadosLista() {
        initComponents();

        setearTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckSelectTodo = new javax.swing.JCheckBox();

        jTable1.setFont(new java.awt.Font("Calibri", 0, 11));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Ruta", "Distancia", "Check"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setResizable(false);

        jCheckSelectTodo.setFont(new java.awt.Font("Calibri", 0, 11));
        jCheckSelectTodo.setText(" Seleccionar Todo");
        jCheckSelectTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckSelectTodoMouseClicked(evt);
            }
        });
        jCheckSelectTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSelectTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckSelectTodo))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jCheckSelectTodo))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckSelectTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSelectTodoActionPerformed
    }//GEN-LAST:event_jCheckSelectTodoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int numFila = selectRow();
        int numColum = selectColum();
        System.out.println("num fila: " + numFila + " dato" + datosImagen.get(numFila).getRuta());

        //String rutaImagen = datosImagen.get(numFila).getRuta();
        //jTable1.setToolTipText("<html><img src=\"" + "file:///" +rutaImagen + "\" width=\"105\" height=\"105\"></html>");

        if (numColum == 3) {

            boolean valorCheck = ((Boolean) jTable1.getValueAt(numFila, numColum)).booleanValue();
            System.out.println("Valor Check ====> " + valorCheck);


            if (controladorImagen.setearCheckImagen(datosImagen.get(numFila), valorCheck)) {

                System.out.println("Seteado ---> " + valorCheck + " !!!!!");
            } else {
                //Error Al seleccionar Datos
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
    }//GEN-LAST:event_jTable1MouseEntered

    private void jCheckSelectTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckSelectTodoMouseClicked
        boolean selecAll;
        if (this.jCheckSelectTodo.isSelected()) {

            System.out.println("Seleccionar Todo");
            selecAll = true;
        } else {

            System.out.println("Desseleccionar");
            selecAll = false;
        }

        controladorImagen.setearAllCheckImagen(datosImagen, selecAll);
        setearAllImagenes(selecAll);
    }//GEN-LAST:event_jCheckSelectTodoMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JCheckBox jCheckSelectTodo;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /*Modelo de la Tabla*/
    private static void Modelo() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(columNames, datosImagen.size()) {

            Class[] types = new Class[]{String.class, String.class, Double.class, Boolean.class};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            boolean[] canEdit = new boolean[]{
                false, false, false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public static void mostrarDatos(ArrayList<Imagen> datImagen) {

        jCheckSelectTodo.setEnabled(true);
        datosImagen = datImagen;
        Modelo();
        Fijarancho();
        for (int i = 0; i < datosImagen.size(); i++) {

            jTable1.setValueAt(datosImagen.get(i).getNombre(), i, 0);
            jTable1.setValueAt(datosImagen.get(i).getRuta(), i, 1);
            jTable1.setValueAt(datosImagen.get(i).getDistancia(), i, 2);
            jTable1.setValueAt(datosImagen.get(i).getCheck(), i, 3);
        }
    }//Fin metodo

    private static void Fijarancho() {

        int[] anchos = {40, 220, 40, 30};
        for (int i = 0; i < anchos.length; i++) {

            jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }//Fin fijar ancho

    public static void setearTable() {

        jTable1.setModel(new DefaultTableModel(columNames, 0));
        jCheckSelectTodo.setEnabled(false);
    }

    private int selectRow() {

        int numFila = jTable1.getSelectedRow();
        return numFila;
    }//Fin metodo Seleccion de Fila

    private int selectColum() {

        int numColumn = jTable1.getSelectedColumn();
        return numColumn;
    }// Fin metodo select Columna

    private void setearAllImagenes(boolean checkImagen) {

        for (int i = 0; i < datosImagen.size(); i++) {

            jTable1.setValueAt(checkImagen, i, 3);
        }
    }//Fin metodo setear All imagenes

    public static ArrayList<Imagen> getDatosImagen() {

        return datosImagen;
    }//Fin metodo get datosImagen

    private void abrirImagen(String rutaImagen) {

        if (rutaImagen != null) {
            try {

                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + rutaImagen);
            } catch (IOException ex) {

                Logger.getLogger(jPanelBuscarImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//Fin comando abrir imagen
}