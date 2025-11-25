/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package di_tema3_componentefile;

import java.awt.Graphics;
import java.beans.*;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ilopezgonzalez
 */
public class JLabelImagen extends JLabel implements Serializable {
    
    private File rutaImagen;

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        this.setText("");
        super.paintComponent(g);
        if (rutaImagen !=null && rutaImagen.exists()) {
            ImageIcon imageicon =new ImageIcon(rutaImagen.getAbsolutePath());
            g.drawImage(imageicon.getImage(), 0, 0, null);
        }
    }
    
    
    
    
    
    

    
}
