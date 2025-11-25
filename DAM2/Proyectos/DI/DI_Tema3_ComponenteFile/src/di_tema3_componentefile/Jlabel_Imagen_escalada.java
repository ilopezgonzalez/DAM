package di_tema3_componentefile;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Jlabel_Imagen_escalada extends JLabel implements Serializable {

    private File rutaImagen;

    public Jlabel_Imagen_escalada() {
        rutaImagen=new File ("/Users/ilopezgonzalez/Desktop/Repo/dam/DAM2/Proyectos/DI/DI_Residuos2023/src/imagenes/aceite-domestico.png");
        this.setText(""); // eliminar texto
        this.setPreferredSize(new Dimension(100, 100));
    }

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
        repaint(); // forzar repintado al cambiar la imagen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (rutaImagen != null && rutaImagen.exists()) {
            ImageIcon imgIcon = new ImageIcon(rutaImagen.getAbsolutePath());
            Image imagenEscalada = imgIcon.getImage()
                    .getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(imagenEscalada, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
