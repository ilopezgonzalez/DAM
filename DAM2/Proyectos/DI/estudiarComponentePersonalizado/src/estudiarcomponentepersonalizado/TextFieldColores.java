/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package estudiarcomponentepersonalizado;

import java.awt.Color;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ilopezgonzalez
 */
public class TextFieldColores extends JTextField implements Serializable {

    private int numCaracteres;

    private Color colorFondo;
    private Color colorPorDefecto;

    public TextFieldColores() {
        super();
        colorPorDefecto = getBackground();

        super.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                analizaContenido();
            }

            private void analizaContenido() {
                if (getText().length() >= numCaracteres) {
                    setBackground(colorFondo);
                } else {
                    setBackground(colorPorDefecto);
                }
            }

        });

    }
}
