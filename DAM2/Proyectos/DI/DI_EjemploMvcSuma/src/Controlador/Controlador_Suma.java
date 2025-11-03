/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_Suma;
import Vista.Vista_Suma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author damt209
 */
public class Controlador_Suma implements ActionListener {

    private Modelo_Suma modelo;
    private Vista_Suma vista;

    public Controlador_Suma(Modelo_Suma modelo, Vista_Suma vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.botonSumar.addActionListener(this);
    }

    public void realizarSuma() {
//leo el primer número de la vista
        int n1 = Integer.parseInt(vista.vtx1.getText());
//leo el segundo numero de la vista
        int n2 = Integer.parseInt(vista.vtx2.getText());
//invocamos al método suma existente en el modelo
        int sumar = modelo.suma(n1, n2);
//vuelvo el valor obtenido a la vista, en el control vtxt3-
//eso si debemos cambiar de entero a string
        vista.vtxResultado.setText(String.valueOf(sumar));
    }

    public void iniciar(){
        vista.setTitle("Vista para la suma");
        vista.setLocationRelativeTo(null);
    }
    
    
    @Override

    public void actionPerformed(ActionEvent e) {
        this.realizarSuma();
    }

}
