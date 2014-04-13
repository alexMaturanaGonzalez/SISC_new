/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alex
 */
public class GestionJFileChooser {

    private ImagePreviewPanel preview = new ImagePreviewPanel();

    @SuppressWarnings("static-access")
    public String abrirOpenDialogFile(String infoFilto, String extFiltro) {

        String nameArch = null;
        File file;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.requestFocusInWindow();
        fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);


        /*Para establecer filtros en la seleccion de archivos*/
        javax.swing.filechooser.FileFilter filtro = new FileNameExtensionFilter(infoFilto, extFiltro);
        //javax.swing.filechooser.FileFilter filtro = new FileNameExtensionFilter("Archivo de Imagen (.jpg)", ".jpg");


        /*Establecer filtro, borrando los demas*/
        fileChooser.setFileFilter(filtro);

        /*Añadir filtro*/
        //fileChooser.addChoosableFileFilter(filtro);


        /*Quitar filtro que permite seleccionar todos los archivos*/
        fileChooser.setAcceptAllFileFilterUsed(false);

        /*Mostrar archivos ocultos*/
        fileChooser.setFileHidingEnabled(true);

        fileChooser.setAccessory(preview);
        fileChooser.addPropertyChangeListener(preview);

        /*Setea Ventana Ventana de Dialogo*/
        int result = fileChooser.showDialog(null, " Seleccione Imagen ");
        if (result == fileChooser.APPROVE_OPTION) {

            file = fileChooser.getSelectedFile();
            nameArch = String.valueOf(file);
        } else if (result == fileChooser.CANCEL_OPTION) {

            nameArch = null;
        }

        return nameArch;
    }//FIN método abrirOpenDialogFile

    @SuppressWarnings("static-access")
    public String abrirOpenDialogDirectory() {

        String nameFolder = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(fileChooser.DIRECTORIES_ONLY);

        /*Quitar filtro que permite seleccionar todos los archivos*/
        fileChooser.setAcceptAllFileFilterUsed(true);

        /*Mostrar archivos ocultos*/
        fileChooser.setFileHidingEnabled(true);

        /*Setea Ventana de Dialogo para seleccionar Directorio*/
        int result = fileChooser.showDialog(null, " Seleccione Directorio ");
        if (result == fileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            nameFolder = String.valueOf(file);
            System.out.println(nameFolder);
        } else if (result == fileChooser.CANCEL_OPTION) {

            nameFolder = null;
        }//FIN condición If con result

        return nameFolder;
    }//FIN método abrirOpenDialogDirectory
}
