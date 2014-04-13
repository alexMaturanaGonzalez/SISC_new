/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.*;
import java.awt.*;
import java.beans.*;
import java.io.File;

public class ImagePreviewPanel extends JPanel implements PropertyChangeListener {

    private int width, height;
    private ImageIcon icon;
    private Image image;
    private static final int ACCSIZE = 155;
    private Color bg;

    public ImagePreviewPanel() {

        setPreferredSize(new Dimension(ACCSIZE, -1));
        bg = getBackground();
    }

    public void propertyChange(PropertyChangeEvent e) {

        String propertyName = e.getPropertyName();
        if (propertyName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
            File selection = (File) e.getNewValue();
            String name;

            if (selection == null) {

                return;
            } else {

                name = selection.getAbsolutePath();
            }

            if ((name != null)
                    && name.toLowerCase().endsWith(".jpg")
                    || name.toLowerCase().endsWith(".jpeg")
                    || name.toLowerCase().endsWith(".gif")
                    || name.toLowerCase().endsWith(".png")) {
                icon = new ImageIcon(name);
                image = icon.getImage();
                scaleImage();
                repaint();
            }
        }
    }

    private void scaleImage() {

        width = image.getWidth(this);
        height = image.getHeight(this);
        double ratio = 1.0;

        if (width >= height) {
            ratio = (double) (ACCSIZE - 5) / width;
            width = ACCSIZE - 5;
            height = (int) (height * ratio);
        } else {
            if (getHeight() > 150) {
                ratio = (double) (ACCSIZE - 5) / height;
                height = ACCSIZE - 5;
                width = (int) (width * ratio);
            } else {
                ratio = (double) getHeight() / height;
                height = getHeight();
                width = (int) (width * ratio);
            }
        }

        image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public void paintComponent(Graphics g) {

        g.setColor(bg);

        g.fillRect(0, 0, ACCSIZE, getHeight());
        g.drawImage(image, getWidth() / 2 - width / 2 + 5,
                getHeight() / 2 - height / 2, this);
    }
}

