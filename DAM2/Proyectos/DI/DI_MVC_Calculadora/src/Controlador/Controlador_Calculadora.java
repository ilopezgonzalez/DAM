/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_Calculadora;
import Vista.Vista_Calculadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author damt209
 */
public class Controlador_Calculadora implements ActionListener{
    
    private Modelo_Calculadora modelo;
    private Vista_Calculadora vista;
    
    public Controlador_Calculadora(Modelo_Calculadora modelo, Vista_Calculadora vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.botonSumar.addActionListener(this);
        this.vista.botonRestar.addActionListener(this);
        this.vista.botonMultiplicar.addActionListener(this);
        this.vista.botonBorrar.addActionListener(this);
    }
    
    public void realizarSuma(){
        int num1=Integer.parseInt(vista.vtxt1.getText());
        int num2=Integer.parseInt(vista.vtxt2.getText());
        int sumar=modelo.suma(num1, num2);
        vista.vtxtResultado.setText(String.valueOf(sumar));
    }
    
    public void realizarRestar(){
        int num1=Integer.parseInt(vista.vtxt1.getText());
        int num2=Integer.parseInt(vista.vtxt2.getText());
        int restar=modelo.resta(num1, num2);
        vista.vtxtResultado.setText(String.valueOf(restar));
    }
    
    public void RealizarMultiplicar(){
        int num1=Integer.parseInt(vista.vtxt1.getText());
        int num2=Integer.parseInt(vista.vtxt2.getText());
        int multiplicar=modelo.multiplicacion(num1, num2);
        vista.vtxtResultado.setText(String.valueOf(multiplicar));
    }
    
    public void RealizarBorrar(){
        vista.vtxt1.setText("");
        vista.vtxt2.setText("");
        vista.vtxtResultado.setText("");
    }
    
    public void iniciar(){
        vista.setTitle("Vista para la calculadora");
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.botonSumar)){
            this.realizarSuma();
        }
        if(e.getSource().equals(vista.botonRestar)){
            this.realizarRestar();
        }
        if(e.getSource().equals(vista.botonMultiplicar)){
            this.RealizarMultiplicar();
        }
        if(e.getSource().equals(vista.botonBorrar)){
            this.RealizarBorrar();
        }
    }
    
}
