/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jPanelBuscarImagen.java
 *
 * Created on 03-06-2013, 10:20:40 PM
 */
package busqlocalimage.Vista.BuscarImagen;

import Controlador.ControladorBuscador;
import Controlador.ControladorImagen;
import Controlador.ControladorRutasFavoritas;
import Entidades.Imagen;
import Logica.GestionJFileChooser;
import Entidades.RutaFavorita;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

/**
 *
 * @author Alex
 */
public class jPanelBuscarImagen extends javax.swing.JPanel {

    private GestionJFileChooser jFileChooser = new GestionJFileChooser();
    private ControladorRutasFavoritas controladorRutasFavoritas = new ControladorRutasFavoritas();
    private ControladorBuscador controladorBuscador = new ControladorBuscador();
    private ControladorImagen controladorImagen = new ControladorImagen();
    public CardLayout cambiarPanel = null;
    private String rutaImagen = "";
    private ArrayList<Imagen> arrayImageResult = new ArrayList<Imagen>();
    private ArrayList<RutaFavorita> arrayRutasFav;
    private ImageIcon icon = null;
    private Color jlabelColor;
    private ImageIcon iconCheck_1 = null;
    private boolean flagCheck_1 = false;
    private ImageIcon iconCheck_2 = null;
    private boolean flagCheck_2 = false;
    private boolean flagCheck_3 = false;
    private boolean flagCheck_4 = false;
    private boolean flagCheck_5 = false;
    private boolean flagCheck_6 = false;
    private boolean flagCheck_7 = false;
    //private long tamanoMaxImage = 5242880;//5MB
    private long tamanoMaxImage = 3145728;//3mB
    private int cantImagenDirect = 0;
    private boolean flagCheck_8 = false;
    private Color ColorjTextArea;
    private boolean habilitarGestionResult = false;

    /** Creates new form jPanelBuscarImagen */
    public jPanelBuscarImagen() {
        initComponents();

        this.jButtonExaminar01.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonExaminar02.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonLimpiar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonBuscar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonGuardar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonEliminar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.jButtonModificarMetadata.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

        this.iconInformation.setToolTipText("<html><h3>Acerca de Resultados:</h3>  Los resultados que se consideran similares son los <br>que no sobrepasan el valor de 150 en su distancia.</html>");
        this.iconInformationFiltro.setToolTipText("<html><h3>Acerca de Filtro:</h3>  Esta opción permite acotar los resultados de la búsqueda <br>"
                + "debido a que para que una imagen sea similar a la ingresada, <br>" + "necesariamente debe tener al menos cuatro regiones iguales. <br><br>   Aplicar Filtro puede modificar la cantidad de resultados deseados.</html>");
        this.iconInformationAlgorit.setToolTipText("<html><h3>Acerca de Algoritmos:</h3>  Si desea obtener mayor información sobre los algoritmos aplicados en el sistema <br>puede revisar la información del sistema, que se encuentra "
                + "presente en la opción  <br>\"¿Cómo Funciona?\" ubicada en la barra de opciones en la parte izquierda.</html>");

        ToolTipManager.sharedInstance().setDismissDelay(90000);
        ToolTipManager.sharedInstance().setInitialDelay(5);

        ColorjTextArea = this.jTextRutaImagen.getForeground();

        this.jTextRutaImagen.setText("Seleccionar Imagen menor a 3MB");
        this.jTextRutaImagen.setForeground(Color.GRAY);
        this.jTextDondeBuscar.setText("Seleccionar Directorio con Imágenes");
        this.jTextDondeBuscar.setForeground(Color.GRAY);

        this.jComboBoxNumResult.removeAllItems();
        this.jComboBoxNumResult.addItem("0");
        this.jComboBoxNumResult.setSelectedIndex(0);

        this.jCheckBoxFiltro.setEnabled(false);

        this.jButtonGuardar.setEnabled(false);
        this.jButtonEliminar.setEnabled(false);
        this.jButtonModificarMetadata.setEnabled(false);

        jlabelColor = this.jLabel4.getForeground();

        cambiarPanel = (CardLayout) panelContenedor.getLayout();
        cambiarPanel("cardLista");

        jLabelLista.setForeground(Color.BLACK);
        jLabelLista.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabelError.setVisible(false);

        this.imagenCheck_1.setVisible(false);
        this.imagenCheck_2.setVisible(false);

        cargarComboBox();

        jTextFieldDistanciaText.setVisible(false);

        this.jButtonBuscar.setEnabled(false);
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
        jLabelImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextRutaImagen = new javax.swing.JTextField();
        jTextDondeBuscar = new javax.swing.JTextField();
        jButtonExaminar01 = new javax.swing.JButton();
        jButtonExaminar02 = new javax.swing.JButton();
        jComboBoxAlgoritmos = new javax.swing.JComboBox();
        jComboBoxDistancia = new javax.swing.JComboBox();
        jTextFieldDistanciaText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBoxBusqAvanz = new javax.swing.JCheckBox();
        jLabelSelecRuta = new javax.swing.JLabel();
        jComboBoxRutasFav = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxDistanciaTipo = new javax.swing.JComboBox();
        imagenCheck_1 = new javax.swing.JLabel();
        imagenCheck_2 = new javax.swing.JLabel();
        iconInformationAlgorit = new javax.swing.JLabel();
        jCheckBoxFiltro = new javax.swing.JCheckBox();
        jComboBoxNumResult = new javax.swing.JComboBox();
        iconInformation = new javax.swing.JLabel();
        iconInformationFiltro = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificarMetadata = new javax.swing.JButton();
        jLabelVista = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        jPanelBuscarImagenResultadosVista1 = new busqlocalimage.Vista.BuscarImagen.jPanelBuscarImagenResultadosVista();
        jPanelBuscarImagenResultadosLista1 = new busqlocalimage.Vista.BuscarImagen.jPanelBuscarImagenResultadosLista();
        jLabelLista = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Búsqueda ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/JPEG-File-icon-128px.png"))); // NOI18N
        jLabelImagen.setText(" ");
        jLabelImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImagenMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 39, 155, 169));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel2.setText("Ruta de Imagen");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel3.setText("Dónde Buscar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel4.setText("Algoritmo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jTextRutaImagen.setEditable(false);
        jTextRutaImagen.setFont(new java.awt.Font("Calibri", 0, 12));
        jTextRutaImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRutaImagenActionPerformed(evt);
            }
        });
        jPanel1.add(jTextRutaImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 213, -1));

        jTextDondeBuscar.setEditable(false);
        jTextDondeBuscar.setFont(new java.awt.Font("Calibri", 0, 12));
        jTextDondeBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDondeBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jTextDondeBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 213, -1));

        jButtonExaminar01.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonExaminar01.setText("Examinar");
        jButtonExaminar01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExaminar01ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExaminar01, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jButtonExaminar02.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonExaminar02.setText("Examinar");
        jButtonExaminar02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExaminar02ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExaminar02, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jComboBoxAlgoritmos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jComboBoxAlgoritmos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..", "Histograma de Colores", "Promedio de Colores", "Reconocimiento de Formas" }));
        jComboBoxAlgoritmos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxAlgoritmosMouseClicked(evt);
            }
        });
        jComboBoxAlgoritmos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAlgoritmosItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 213, -1));

        jComboBoxDistancia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jComboBoxDistancia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..", "Manhattan", "Euclidean", "n", "∞" }));
        jComboBoxDistancia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDistanciaItemStateChanged(evt);
            }
        });
        jComboBoxDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDistanciaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 96, -1));

        jTextFieldDistanciaText.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextFieldDistanciaText.setText(" 1");
        jTextFieldDistanciaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDistanciaTextActionPerformed(evt);
            }
        });
        jTextFieldDistanciaText.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldDistanciaTextInputMethodTextChanged(evt);
            }
        });
        jPanel1.add(jTextFieldDistanciaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 30, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel6.setText("Número de Resultados");
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jCheckBoxBusqAvanz.setFont(new java.awt.Font("Calibri", 0, 13));
        jCheckBoxBusqAvanz.setText(" Búsqueda Avanzada");
        jCheckBoxBusqAvanz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxBusqAvanzMousePressed(evt);
            }
        });
        jCheckBoxBusqAvanz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBusqAvanzActionPerformed(evt);
            }
        });

        jLabelSelecRuta.setFont(new java.awt.Font("Calibri", 0, 12));
        jLabelSelecRuta.setText("Seleccionar Ruta Favorita");
        jLabelSelecRuta.setEnabled(false);

        jComboBoxRutasFav.setFont(new java.awt.Font("Calibri", 0, 11));
        jComboBoxRutasFav.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRutasFav.setEnabled(false);
        jComboBoxRutasFav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxRutasFavMouseClicked(evt);
            }
        });
        jComboBoxRutasFav.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRutasFavItemStateChanged(evt);
            }
        });
        jComboBoxRutasFav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRutasFavActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBoxBusqAvanz))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelSelecRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxRutasFav, 0, 278, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jCheckBoxBusqAvanz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSelecRuta)
                    .addComponent(jComboBoxRutasFav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 306, -1));

        jButtonLimpiar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 298, -1, -1));

        jButtonBuscar.setFont(new java.awt.Font("Calibri", 0, 12));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 298, -1, -1));

        jLabelError.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabelError.setForeground(new java.awt.Color(255, 0, 0));
        jLabelError.setText("Deben existir rutas favoritas para realizar búsqueda avanzada.");
        jPanel1.add(jLabelError, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 400, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 13));
        jLabel5.setText("Distancia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jComboBoxDistanciaTipo.setFont(new java.awt.Font("Calibri", 0, 12));
        jComboBoxDistanciaTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..", "L", "DPF" }));
        jComboBoxDistanciaTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDistanciaTipoItemStateChanged(evt);
            }
        });
        jComboBoxDistanciaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDistanciaTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxDistanciaTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 70, -1));

        imagenCheck_1.setText(" ");
        jPanel1.add(imagenCheck_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 30, -1));

        imagenCheck_2.setText(" ");
        jPanel1.add(imagenCheck_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 30, -1));

        iconInformationAlgorit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/icon-information.png"))); // NOI18N
        iconInformationAlgorit.setText(" ");
        iconInformationAlgorit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconInformationAlgoritMouseClicked(evt);
            }
        });
        jPanel1.add(iconInformationAlgorit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 16, 16));

        jCheckBoxFiltro.setFont(new java.awt.Font("Calibri", 0, 13));
        jCheckBoxFiltro.setText("Aplicar Filtro   ");
        jCheckBoxFiltro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jCheckBoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        jComboBoxNumResult.setFont(new java.awt.Font("Calibri", 0, 12));
        jComboBoxNumResult.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        jComboBoxNumResult.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxNumResultItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxNumResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 140, 60, -1));

        iconInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/icon-information.png"))); // NOI18N
        iconInformation.setText(" ");
        iconInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconInformationMouseClicked(evt);
            }
        });
        jPanel1.add(iconInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 16, 16));

        iconInformationFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/icon-information.png"))); // NOI18N
        iconInformationFiltro.setText(" ");
        iconInformationFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconInformationFiltroMouseClicked(evt);
            }
        });
        jPanel1.add(iconInformationFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 16, 16));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Resultados ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jButtonGuardar.setFont(new java.awt.Font("Calibri", 0, 11));
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Save-icon-16px.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Calibri", 0, 11));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Button-Delete-icon-16px.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificarMetadata.setFont(new java.awt.Font("Calibri", 0, 11));
        jButtonModificarMetadata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/edit-file-icon-16px.png"))); // NOI18N
        jButtonModificarMetadata.setText("Modificar MetaData");
        jButtonModificarMetadata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarMetadataActionPerformed(evt);
            }
        });

        jLabelVista.setFont(new java.awt.Font("Calibri", 0, 11));
        jLabelVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Images-icon-32px.png"))); // NOI18N
        jLabelVista.setText("Vista");
        jLabelVista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelVistaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelVistaMouseReleased(evt);
            }
        });

        panelContenedor.setLayout(new java.awt.CardLayout());
        panelContenedor.add(jPanelBuscarImagenResultadosVista1, "cardVista");
        panelContenedor.add(jPanelBuscarImagenResultadosLista1, "cardLista");

        jLabelLista.setFont(new java.awt.Font("Calibri", 0, 11));
        jLabelLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/text-list-numbers-icon-24px.png"))); // NOI18N
        jLabelLista.setText("Lista");
        jLabelLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelListaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificarMetadata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(jLabelLista)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelVista)
                        .addGap(21, 21, 21))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGuardar)
                            .addComponent(jButtonEliminar)
                            .addComponent(jButtonModificarMetadata)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelVista, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextRutaImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRutaImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRutaImagenActionPerformed

    private void jTextDondeBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDondeBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDondeBuscarActionPerformed

    private void jComboBoxDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDistanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDistanciaActionPerformed

    private void jTextFieldDistanciaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDistanciaTextActionPerformed
    }//GEN-LAST:event_jTextFieldDistanciaTextActionPerformed

    private void jCheckBoxBusqAvanzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBusqAvanzActionPerformed

        if (jCheckBoxBusqAvanz.isSelected() == true) {

            jTextDondeBuscar.setEnabled(false);
            jButtonExaminar02.setEnabled(false);
            jLabelSelecRuta.setEnabled(true);
            jComboBoxRutasFav.setEnabled(true);
            cargarComboBox();

            //cuando carga directorio carga los posibles numeros de numeros
            this.jComboBoxNumResult.removeAllItems();
            for (int i = 1; i <= arrayRutasFav.get(0).getCantImagenes(); i++) {

                jComboBoxNumResult.addItem(i);
            }

        } else if (jCheckBoxBusqAvanz.isSelected() == false) {

            jTextDondeBuscar.setEnabled(true);
            jButtonExaminar02.setEnabled(true);
            jLabelSelecRuta.setEnabled(false);
            jComboBoxRutasFav.setEnabled(false);

            this.jComboBoxNumResult.removeAllItems();

            if (this.jTextDondeBuscar.getText().compareTo("") == 0) {

                this.jComboBoxNumResult.addItem("0");
            } else {

                for (int i = 1; i <= cantImagenDirect; i++) {

                    jComboBoxNumResult.addItem(i);
                }
            }

            flagCheck_7 = false;

            validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);
        }    }//GEN-LAST:event_jCheckBoxBusqAvanzActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        if (arrayImageResult.size() == 0) {

            JOptionPane.showMessageDialog(null, "ERROR: No Existen Imágenes Resultantes.", "Eliminación de Imágenes", 0);
        } else {

            ArrayList<Imagen> imagenResult = jPanelBuscarImagenResultadosLista.getDatosImagen();
            ArrayList<Imagen> imagenCheckResult = new ArrayList<Imagen>();
            String strMessage = null;

            for (int i = 0; i < imagenResult.size(); i++) {

                if (imagenResult.get(i).getCheck()) {

                    System.out.println("Es true!");
                    imagenCheckResult.add(imagenResult.get(i));
                }
            }

            if (imagenCheckResult.size() != 0) {

                String rutaGuardar = jFileChooser.abrirOpenDialogDirectory();
                if (rutaGuardar != null) {

                    try {

                        controladorImagen.almacenarImagenes(imagenCheckResult, rutaGuardar);
                        strMessage = "Imagen(es) Almacena(s) con Éxito!";
                    } catch (Exception ex) {

                        strMessage = "Problemas con Almacenamiento de Imágenes o No Existen Imágenes Seleccionadas.";
                    }
                } else {

                    strMessage = "Almacenamiento Cancelado por Usuario.";
                }
            } else {

                strMessage = "No Existen Imagen(es) Seleccionada(s)!";
                System.out.println("Es 0.");
            }
            JOptionPane.showMessageDialog(null, strMessage, "Almacenamiento de Imágenes", 0);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        if (arrayImageResult.size() == 0) {

            JOptionPane.showMessageDialog(null, "ERROR: No Existen Imágenes Resultantes.", "Eliminación de Imágenes", 0);
        } else {

            ArrayList<Imagen> imagenResult = jPanelBuscarImagenResultadosLista.getDatosImagen();
            ArrayList<Imagen> imagenCheckResult = new ArrayList<Imagen>();
            ArrayList<Imagen> imagenNOCheckResult = new ArrayList<Imagen>();
            String strMessage = null;

            for (int i = 0; i < imagenResult.size(); i++) {

                if (imagenResult.get(i).getCheck() == true) {

                    imagenCheckResult.add(imagenResult.get(i));
                } else {

                    imagenNOCheckResult.add(imagenResult.get(i));
                }
            }

            if (imagenCheckResult.size() != 0) {

                System.out.println("No es 0.");

                int desElimin = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar las imágenes de su Computador?", "Confirmar Eliminación", 2);

                if (desElimin == JOptionPane.YES_OPTION) {

                    try {

                        controladorImagen.eliminarImagenes(imagenCheckResult);
                        jPanelBuscarImagenResultadosLista.mostrarDatos(imagenNOCheckResult);
                        jPanelBuscarImagenResultadosVista.mostrarDatos(imagenNOCheckResult);
                        strMessage = "Imagen(es) Eliminada(s) con Éxito!";
                    } catch (Exception ex) {

                        strMessage = "Problemas con Eliminación de Imágenes o No Existen Imágenes Seleccionadas.";
                    }
                } else {

                    strMessage = "Eliminación Cancelada por Usuario";
                }
            } else {

                strMessage = "No Existen Imagen(es) Seleccionada(s)!";
                System.out.println("Es 0.");
            }

            JOptionPane.showMessageDialog(null, strMessage, "Eliminación de Imágenes", 0);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarMetadataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarMetadataActionPerformed

        if (arrayImageResult.size() == 0) {

            JOptionPane.showMessageDialog(null, "ERROR: No Existen Imágenes Resultantes.", "Modificación de Meta-Data", 0);
        } else {

            new InterfazFormModifMetaData(arrayImageResult).setVisible(true);
        }
    }//GEN-LAST:event_jButtonModificarMetadataActionPerformed

    private void jLabelListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListaMousePressed

        jLabelLista.setForeground(Color.BLACK);
        jLabelLista.setFont(new Font("Calibri", Font.BOLD, 18));

        jLabelVista.setForeground(Color.BLACK);
        jLabelVista.setFont(new Font("Calibri", Font.PLAIN, 11));

        cambiarPanel("cardLista");

        this.jButtonGuardar.setEnabled(habilitarGestionResult);
        this.jButtonEliminar.setEnabled(habilitarGestionResult);

    }//GEN-LAST:event_jLabelListaMousePressed

    private void jLabelVistaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVistaMousePressed

        jLabelVista.setForeground(Color.BLACK);
        jLabelVista.setFont(new Font("Calibri", Font.BOLD, 18));

        jLabelLista.setForeground(Color.BLACK);
        jLabelLista.setFont(new Font("Calibri", Font.PLAIN, 11));

        cambiarPanel("cardVista");

        this.jButtonGuardar.setEnabled(false);
        this.jButtonEliminar.setEnabled(false);
    }//GEN-LAST:event_jLabelVistaMousePressed

    private void jCheckBoxBusqAvanzMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxBusqAvanzMousePressed

        if (this.jCheckBoxBusqAvanz.isSelected() == true) {

            String rutaFavPrim = this.jComboBoxRutasFav.getSelectedItem().toString();
            if (rutaFavPrim.compareTo("") == 0) {

                flagCheck_7 = false;
            } else {

                flagCheck_7 = true;
            }
        } else {

            flagCheck_7 = false;
        }

        validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);
    }//GEN-LAST:event_jCheckBoxBusqAvanzMousePressed

    private void jButtonExaminar01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExaminar01ActionPerformed

        rutaImagen = jFileChooser.abrirOpenDialogFile("Archivo de Imagen (.jpg)", "jpg");

        if (rutaImagen == null) {

            jTextRutaImagen.setText("");
            rutaImagen = "/busqlocalimage/Imagenes/JPEG-File-icon-128px.png";
            icon = new ImageIcon(getClass().getResource(rutaImagen));

            this.imagenCheck_1.setVisible(false);
            this.jLabelError.setVisible(false);

            this.jTextRutaImagen.setText("Seleccionar Imagen menor a 3MB");
            this.jTextRutaImagen.setForeground(Color.GRAY);
        } else {

            this.jTextRutaImagen.setForeground(ColorjTextArea);
            if (controladorImagen.verificarTamanoImagen(rutaImagen, tamanoMaxImage)) {

                this.jLabelError.setVisible(false);
                iconCheck_1 = new ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Check.png"));
                flagCheck_1 = true;
                this.jLabel2.setForeground(jlabelColor);

                icon = new ImageIcon(rutaImagen);

            } else {

                iconCheck_1 = new ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Error.png"));
                flagCheck_1 = false;
                this.jLabelError.setText("Tamaño de Imagen Supera el Permitido (3 MB).");
                this.jLabelError.setForeground(Color.RED);
                this.jLabelError.setVisible(true);

                icon = new ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/ImagenExcedeTamano.png"));
            }

            jTextRutaImagen.setText(rutaImagen);
            jLabelImagen.setToolTipText("Presione doble click si desea abrir imagen.");

            imagenCheck(iconCheck_1, this.imagenCheck_1);
        }

        imagenDefault(icon);

        validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);

    }//GEN-LAST:event_jButtonExaminar01ActionPerformed

    private void jButtonExaminar02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExaminar02ActionPerformed

        String rutaDondeBuscar = jFileChooser.abrirOpenDialogDirectory();

        if (rutaDondeBuscar == null) {

            jTextDondeBuscar.setText("");
            this.imagenCheck_2.setVisible(false);
            this.jLabelError.setVisible(false);

            this.jTextDondeBuscar.setText("Seleccionar Directorio con Imágenes");
            this.jTextDondeBuscar.setForeground(Color.GRAY);
        } else {

            this.jTextDondeBuscar.setForeground(ColorjTextArea);
            cantImagenDirect = controladorImagen.verificarCantImageFolder(rutaDondeBuscar);

            if (cantImagenDirect > 0) {

                this.jLabelError.setVisible(false);
                iconCheck_2 = new ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Check.png"));
                flagCheck_2 = false;

                //cuando carga directorio carga los posibles numeros de numeros
                this.jComboBoxNumResult.removeAllItems();
                for (int i = 1; i <= cantImagenDirect; i++) {

                    jComboBoxNumResult.addItem(i);
                }

            } else {

                iconCheck_2 = new ImageIcon(getClass().getResource("/busqlocalimage/Imagenes/Error.png"));
                flagCheck_2 = true;
                this.jLabelError.setText("Directorio Sin Imágenes Válidas.");
                this.jLabelError.setForeground(Color.RED);
                this.jLabelError.setVisible(true);
            }

            jTextDondeBuscar.setText(rutaDondeBuscar);

            imagenCheck(iconCheck_2, this.imagenCheck_2);
        }

        validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);
    }//GEN-LAST:event_jButtonExaminar02ActionPerformed

    private void jLabelImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagenMouseClicked

        if (rutaImagen != null) {
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + rutaImagen);
            } catch (IOException ex) {
                Logger.getLogger(jPanelBuscarImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelImagenMouseClicked

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

        this.jButtonGuardar.setEnabled(false);
        this.jButtonEliminar.setEnabled(false);
        this.jButtonModificarMetadata.setEnabled(false);
        this.imagenCheck_1.setVisible(false);
        this.imagenCheck_2.setVisible(false);
        this.jTextDondeBuscar.setEnabled(true);
        this.jButtonExaminar02.setEnabled(true);
        this.jComboBoxNumResult.removeAllItems();
        this.jComboBoxNumResult.addItem("0");

        rutaImagen = "/busqlocalimage/Imagenes/JPEG-File-icon-128px.png";
        icon = new ImageIcon(getClass().getResource(rutaImagen));
        imagenDefault(icon);
        jLabelImagen.setToolTipText(null);

        this.jTextRutaImagen.setText("Seleccionar Imagen menor a 3MB");
        this.jTextRutaImagen.setForeground(Color.GRAY);
        this.jTextDondeBuscar.setText("Seleccionar Directorio con Imágenes");
        this.jTextDondeBuscar.setForeground(Color.GRAY);

        this.jComboBoxAlgoritmos.setSelectedIndex(0);
        this.jComboBoxDistancia.setSelectedIndex(0);
        this.jComboBoxDistanciaTipo.setSelectedIndex(0);
        this.jTextFieldDistanciaText.setText("");

        this.jComboBoxDistanciaTipo.setSelectedIndex(0);

        this.jLabelError.setVisible(false);

        this.jLabel2.setForeground(jlabelColor);
        this.jLabel3.setForeground(jlabelColor);
        this.jLabel4.setForeground(jlabelColor);
        this.jLabel5.setForeground(jlabelColor);
        this.jLabel6.setForeground(jlabelColor);

        this.jCheckBoxBusqAvanz.setSelected(false);

        jPanelBuscarImagenResultadosLista.setearTable();
        jPanelBuscarImagenResultadosVista.setearElementos();

        cambiarPanel("cardLista");
        jLabelLista.setForeground(Color.BLACK);
        jLabelLista.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabelVista.setForeground(Color.BLACK);
        jLabelVista.setFont(new Font("Calibri", Font.PLAIN, 11));
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    @SuppressWarnings("static-access")
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        cambiarPanel("cardLista");
        jLabelLista.setForeground(Color.BLACK);
        jLabelLista.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabelVista.setForeground(Color.BLACK);
        jLabelVista.setFont(new Font("Calibri", Font.PLAIN, 11));

        arrayImageResult.clear();
        arrayImageResult = new ArrayList<Imagen>();
        jPanelBuscarImagenResultadosLista.setearTable();
        jPanelBuscarImagenResultadosVista.setearElementos();

        String msjeError = null;
        boolean checkRutaFav;
        if (this.jCheckBoxBusqAvanz.isSelected() == true) {

            checkRutaFav = true;
        } else {

            checkRutaFav = false;
        }

        boolean aplicarFiltro;
        if (this.jCheckBoxFiltro.isSelected() == true) {

            aplicarFiltro = true;
        } else {

            aplicarFiltro = false;
        }

        System.out.println("Valor de Filtro = " + aplicarFiltro);

        String nombreImagen = this.jTextRutaImagen.getText();
        String dondeBuscar = this.jTextDondeBuscar.getText();
        String dondeBuscarRutaFav = null;

        if (this.jComboBoxRutasFav.getItemCount() > 0) {

            dondeBuscarRutaFav = this.jComboBoxRutasFav.getSelectedItem().toString();
        } else {

            dondeBuscarRutaFav = "";
        }

        String algoritmoSelect = this.jComboBoxAlgoritmos.getSelectedItem().toString();
        String distanciaSelect = this.jComboBoxDistancia.getSelectedItem().toString();
        String distanciaTipo = this.jComboBoxDistanciaTipo.getSelectedItem().toString();
        String distanciaValue = this.jTextFieldDistanciaText.getText().trim();

        String resultados = this.jComboBoxNumResult.getSelectedItem().toString();

        int numResult;

        if (resultados.equals("")) {

            numResult = 0;
        } else {

            numResult = Integer.parseInt(resultados);
        }

        System.out.println("Result " + numResult);

        double value = 0;
        if (distanciaValue.equals("")) {

            value = 1;
            this.jTextFieldDistanciaText.setText("1");
        } else {

            value = Double.parseDouble(distanciaValue);
        }

        if (validarNombreImagen(nombreImagen) && validarDondeBuscar(dondeBuscar, checkRutaFav, dondeBuscarRutaFav) && validarAlgoritmos(algoritmoSelect, distanciaSelect, distanciaTipo)) {

            if (validarNumResultados(numResult) && validarNumDistanc(value)) {

                arrayImageResult = controladorBuscador.gestionBuscador(checkRutaFav, algoritmoSelect, dondeBuscarRutaFav, dondeBuscar, nombreImagen, distanciaTipo, distanciaSelect, value, numResult, aplicarFiltro);

                if (arrayImageResult.size() == 0) {

                    msjeError = "Búsqueda Finalizada. No Existen Resultados.";
                    this.jLabelError.setForeground(Color.RED);
                } else {

                    msjeError = "Búsqueda Finalizada. Existen " + arrayImageResult.size() + " resultados.";
                    this.jLabelError.setForeground(Color.BLACK);

                    jPanelBuscarImagenResultadosLista.mostrarDatos(arrayImageResult);
                    jPanelBuscarImagenResultadosVista.mostrarDatos(arrayImageResult);
                    cambiarPanel("cardLista");

                    this.jButtonGuardar.setEnabled(true);
                    this.jButtonEliminar.setEnabled(true);
                    this.jButtonModificarMetadata.setEnabled(true);
                    habilitarGestionResult = true;
                }

                this.jLabelError.setText(msjeError);
                this.jLabelError.setVisible(true);
            }//Fin if validar numero de Resultados y num distancia.
        }//Fin
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxAlgoritmosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxAlgoritmosMouseClicked
    }//GEN-LAST:event_jComboBoxAlgoritmosMouseClicked

    private void jComboBoxAlgoritmosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAlgoritmosItemStateChanged

        String algoritFiguras = this.jComboBoxAlgoritmos.getSelectedItem().toString();


        if (algoritFiguras.compareTo("Seleccione..") == 0) {

            flagCheck_3 = false;
            flagCheck_8 = false;
            this.jComboBoxDistancia.setEnabled(true);
            this.jComboBoxDistanciaTipo.setEnabled(true);
            this.jTextFieldDistanciaText.setEnabled(true);
            this.jCheckBoxFiltro.setEnabled(false);
        } else {

            flagCheck_3 = true;

            if (algoritFiguras.compareTo("Reconocimiento de Formas") == 0) {

                flagCheck_8 = true;
                this.jComboBoxDistancia.setEnabled(false);
                this.jComboBoxDistanciaTipo.setEnabled(false);
                this.jTextFieldDistanciaText.setEnabled(false);

                this.jCheckBoxFiltro.setEnabled(true);
            } else {

                flagCheck_8 = false;
                this.jComboBoxDistancia.setEnabled(true);
                this.jComboBoxDistanciaTipo.setEnabled(true);
                this.jTextFieldDistanciaText.setEnabled(true);

                this.jCheckBoxFiltro.setEnabled(false);
            }
        }

        validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);
    }//GEN-LAST:event_jComboBoxAlgoritmosItemStateChanged

    private void jComboBoxRutasFavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRutasFavActionPerformed
    }//GEN-LAST:event_jComboBoxRutasFavActionPerformed

    private void jLabelVistaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVistaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVistaMouseReleased

    private void jComboBoxDistanciaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDistanciaTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDistanciaTipoActionPerformed

    private void iconInformationAlgoritMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconInformationAlgoritMouseClicked
        //JOptionPane.showMessageDialog(null, "Los resultados que se consideran similares, son los que no sobrepasan el valor de 150 en su distancia.");
    }//GEN-LAST:event_iconInformationAlgoritMouseClicked

    private void jComboBoxRutasFavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxRutasFavMouseClicked

        cargarComboBox();
    }//GEN-LAST:event_jComboBoxRutasFavMouseClicked

    private void jComboBoxRutasFavItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRutasFavItemStateChanged

        if (this.jCheckBoxBusqAvanz.isSelected() == true) {

            int numRutaFavSelect = this.jComboBoxRutasFav.getSelectedIndex();

            if (numRutaFavSelect >= 0) {

                this.jComboBoxNumResult.removeAllItems();
                for (int i = 1; i <= arrayRutasFav.get(numRutaFavSelect).getCantImagenes(); i++) {

                    this.jComboBoxNumResult.addItem(i);
                }

                flagCheck_7 = true;
            } else {

                flagCheck_7 = false;
            }
        }

        validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);
    }//GEN-LAST:event_jComboBoxRutasFavItemStateChanged

    private void iconInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconInformationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_iconInformationMouseClicked

    private void iconInformationFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconInformationFiltroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_iconInformationFiltroMouseClicked

    private void jComboBoxDistanciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDistanciaItemStateChanged

        String Campo1distancia = this.jComboBoxDistancia.getSelectedItem().toString();

        if (Campo1distancia.compareTo("Seleccione..") == 0) {

            flagCheck_4 = false;
            jTextFieldDistanciaText.setVisible(false);
        } else if (Campo1distancia.compareTo("n") == 0) {

            flagCheck_4 = true;
            jTextFieldDistanciaText.setVisible(true);
        } else {

            flagCheck_4 = true;
            jTextFieldDistanciaText.setVisible(false);
        }

        validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);
    }//GEN-LAST:event_jComboBoxDistanciaItemStateChanged

    private void jComboBoxDistanciaTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDistanciaTipoItemStateChanged

        String Campo2distancia = this.jComboBoxDistanciaTipo.getSelectedItem().toString();

        if (Campo2distancia.compareTo("Seleccione..") == 0) {

            flagCheck_5 = false;
        } else {

            flagCheck_5 = true;
        }

        validarBotonBuscar(flagCheck_1, flagCheck_2, flagCheck_3, flagCheck_4, flagCheck_5, flagCheck_7, flagCheck_8);
    }//GEN-LAST:event_jComboBoxDistanciaTipoItemStateChanged

    private void jComboBoxNumResultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNumResultItemStateChanged
    }//GEN-LAST:event_jComboBoxNumResultItemStateChanged

    private void jTextFieldDistanciaTextInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldDistanciaTextInputMethodTextChanged

        System.out.println("Hola");

    }//GEN-LAST:event_jTextFieldDistanciaTextInputMethodTextChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconInformation;
    private javax.swing.JLabel iconInformationAlgorit;
    private javax.swing.JLabel iconInformationFiltro;
    private javax.swing.JLabel imagenCheck_1;
    private javax.swing.JLabel imagenCheck_2;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonExaminar01;
    private javax.swing.JButton jButtonExaminar02;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificarMetadata;
    private javax.swing.JCheckBox jCheckBoxBusqAvanz;
    private javax.swing.JCheckBox jCheckBoxFiltro;
    private javax.swing.JComboBox jComboBoxAlgoritmos;
    private javax.swing.JComboBox jComboBoxDistancia;
    private javax.swing.JComboBox jComboBoxDistanciaTipo;
    private javax.swing.JComboBox jComboBoxNumResult;
    private javax.swing.JComboBox jComboBoxRutasFav;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelLista;
    private javax.swing.JLabel jLabelSelecRuta;
    private javax.swing.JLabel jLabelVista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private busqlocalimage.Vista.BuscarImagen.jPanelBuscarImagenResultadosLista jPanelBuscarImagenResultadosLista1;
    private busqlocalimage.Vista.BuscarImagen.jPanelBuscarImagenResultadosVista jPanelBuscarImagenResultadosVista1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextDondeBuscar;
    private javax.swing.JTextField jTextFieldDistanciaText;
    private javax.swing.JTextField jTextRutaImagen;
    public static javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables

    /*Metodo para generar el cambio de paneles*/
    public void cambiarPanel(String panel) {

        cambiarPanel.show(panelContenedor, panel);
    }//FIN cambiarPanel

    private void cargarComboBox() {

        arrayRutasFav = controladorRutasFavoritas.leerRutasFavoritas();
        jComboBoxRutasFav.removeAllItems();

        if (arrayRutasFav != null) {

            for (int i = 0; i < arrayRutasFav.size(); i++) {

                jComboBoxRutasFav.addItem(arrayRutasFav.get(i).getNombre());
            }
        } else {

            System.out.println("El archivo no Existe!");
        }
    }//Fin metodo cargarComboBox

    private void imagenDefault(ImageIcon icon) {

        /*Imagen en jLabel*/
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(154, 168, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);

        jLabelImagen.setIcon(newIcon);
        jLabelImagen.setSize(155, 169);

    }//Fin metodo imagenDefault

    private boolean validarNumResultados(int numResult) {

        String msjeError;
        if (numResult <= 0) {

            msjeError = "Valor No Aceptado.";
            this.jLabelError.setText(msjeError);
            this.jLabelError.setForeground(Color.RED);
            this.jLabelError.setVisible(true);

            this.jLabel6.setForeground(Color.red);
            return false;
        } else {

            this.jLabel6.setForeground(jlabelColor);
            this.jLabelError.setVisible(false);
            return true;
        }
    }//Fin metodo Validar Numero de Resultados

    private boolean validarNumDistanc(double value) {

        String msjeError;
        if (value < 0) {

            msjeError = "Valor No Aceptado";
            this.jLabelError.setText(msjeError);
            this.jLabelError.setForeground(Color.RED);
            this.jLabelError.setVisible(true);

            this.jLabel5.setForeground(Color.red);
            return false;
        } else {

            this.jLabel5.setForeground(jlabelColor);
            this.jLabelError.setVisible(false);
            return true;
        }
    }//Fin metodo validar Numero de Distancia

    private boolean validarNombreImagen(String nombreImagen) {

        String msjeError;
        if (nombreImagen.equals("") || flagCheck_1 == false) {

            msjeError = "Debe ingresar imagen válida para continuar.";
            this.jLabelError.setText(msjeError);
            this.jLabelError.setForeground(Color.RED);
            this.jLabelError.setVisible(true);

            this.jLabel2.setForeground(Color.red);
            return false;
        } else {

            this.jLabel2.setForeground(jlabelColor);
            this.jLabelError.setVisible(false);
            return true;
        }
    }//fin validar nombre Imagen

    private boolean validarDondeBuscar(String dondeBuscar, boolean checkRutaFav, String dondeBuscarRutaFav) {

        String msjeError;
        if (dondeBuscar.equals("") && checkRutaFav == false && flagCheck_2 == false) {

            msjeError = "Debe ingresar ruta válida para continuar.";
            this.jLabelError.setText(msjeError);
            this.jLabelError.setForeground(Color.RED);
            this.jLabelError.setVisible(true);

            this.jLabel3.setForeground(Color.red);
            return false;

        } else if (dondeBuscarRutaFav.equals("") && checkRutaFav == true) {

            msjeError = "Deben existir rutas favoritas para realizar búsqueda avanzada.";
            this.jLabelError.setText(msjeError);
            this.jLabelError.setForeground(Color.BLUE);
            this.jLabelError.setVisible(true);

            this.jCheckBoxBusqAvanz.setForeground(Color.red);
            return false;
        }

        this.jLabel3.setForeground(jlabelColor);
        this.jCheckBoxBusqAvanz.setForeground(jlabelColor);
        this.jLabelError.setVisible(false);
        return true;
    }//Fin metodod validar Donde establecer Busqueda

    private void imagenCheck(ImageIcon iconCheck, JLabel imagenCheck) {

        /*Imagen en jLabel*/
        Image img = iconCheck.getImage();
        Image newimg = img.getScaledInstance(28, 21, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);

        imagenCheck.setIcon(newIcon);
        imagenCheck.setSize(28, 21);

        imagenCheck.setVisible(true);
    }//Fin metodo

    private boolean validarAlgoritmos(String algoritmoSelect, String distanciaSelect, String distanciaTipo) {

        String msjError;

        if (algoritmoSelect.compareTo("Reconocimiento de Formas") == 0) {

            return true;
        } else if (algoritmoSelect.compareTo("Seleccione..") == 0) {

            msjError = "Debe seleccionar un algoritmo.";
            this.jLabelError.setText(msjError);
            this.jLabelError.setForeground(Color.BLUE);
            this.jLabelError.setVisible(true);

            this.jLabel4.setForeground(Color.red);
            return false;

        } else if ((distanciaSelect.compareTo("Seleccione..") == 0) || (distanciaTipo.compareTo("Seleccione..") == 0)) {

            msjError = "Debe seleccionar todos los parámetros.";
            this.jLabelError.setText(msjError);
            this.jLabelError.setForeground(Color.BLUE);
            this.jLabelError.setVisible(true);

            this.jLabel4.setForeground(jlabelColor);
            this.jLabel5.setForeground(Color.red);
            return false;
        }

        this.jLabel4.setForeground(jlabelColor);
        this.jLabel5.setForeground(jlabelColor);
        this.jLabelError.setVisible(false);
        return true;
    }//Fin metodo validar algoritmos
//---------------------------------------------------------------------------------------------------------

    private void validarBotonBuscar(boolean flagCheck_1, boolean flagCheck_2, boolean flagCheck_3, boolean flagCheck_4, boolean flagCheck_5, boolean flagCheck_7, boolean flagCheck_8) {


        boolean flagAux = false;

        if (flagCheck_7 == true || flagCheck_2 == false) {

            flagAux = true;
        } else {

            flagAux = false;
        }

        if (flagCheck_8 == true) {

            flagCheck_4 = true;
            flagCheck_5 = true;
        }


        if (flagCheck_1 == true && flagAux == true && flagCheck_3 == true && flagCheck_4 == true && flagCheck_5 == true) {

            System.out.println("Validar boton Buscar");
            this.jButtonBuscar.setEnabled(true);
        } else {

            System.out.println("NO  boton Buscar");
            this.jButtonBuscar.setEnabled(false);
        }
    }//Fin metodo
}//FIn clase

