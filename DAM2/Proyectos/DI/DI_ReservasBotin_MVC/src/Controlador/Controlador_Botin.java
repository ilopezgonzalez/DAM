/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_Botin;
import Vista.Vista_Inicio_Botin;
import Vista.Vista_Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author damt209
 */
public class Controlador_Botin implements ActionListener, MouseListener, ChangeListener {

    private Vista_Inicio_Botin vistaINICIO;
    private Vista_Formulario vistaFORM;
    private Modelo_Botin Modelo_Botin;

    public Controlador_Botin(Vista_Inicio_Botin vistaINICIO, Vista_Formulario vistaFORM, Modelo_Botin Modelo_Botin) {
        this.vistaINICIO = vistaINICIO;
        this.vistaFORM = vistaFORM;
        this.Modelo_Botin = Modelo_Botin;
        this.vistaINICIO.botonSalir.addActionListener(this);
        this.vistaINICIO.botonSalaBahia.addActionListener(this);
        this.vistaINICIO.menuSalaBahia.addActionListener(this);
        this.vistaINICIO.LabelFoto.addMouseListener(this);
        this.vistaINICIO.menuDesplegable.addMouseListener(this);
        this.vistaINICIO.desplegableSalaBahia.addActionListener(this);
        this.vistaFORM.radioBanqueteReserva.addActionListener(this);
        this.vistaFORM.radioJornadaReserva.addActionListener(this);
        this.vistaFORM.radioSeminarioReserva.addActionListener(this);
        this.vistaFORM.botonReserva.addActionListener(this);
        this.vistaFORM.slidercomensales.addChangeListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistaINICIO.botonSalir)) {
            vistaINICIO.dispose();
        }
        if (e.getSource().equals(vistaINICIO.botonSalaBahia) || e.getSource().equals(vistaINICIO.menuSalaBahia) || e.getSource().equals(vistaINICIO.desplegableSalaBahia)) {
            iniciarFormulario();
            vistaFORM.setVisible(true);
        }
        if (e.getSource().equals(vistaFORM.radioBanqueteReserva)) {
            if (vistaFORM.radioBanqueteReserva.isEnabled()) {
                vistaFORM.spinnerJornadas.setEnabled(false);
                vistaFORM.radioSiHabitaciones.setEnabled(false);
                vistaFORM.radioNoHabitaciones.setEnabled(false);
                vistaFORM.labelComensales.setEnabled(true);
                vistaFORM.labelNumeroComensales.setEnabled(true);
                vistaFORM.slidercomensales.setEnabled(true);
            }
        }
        if (e.getSource().equals(vistaFORM.radioJornadaReserva)) {
            if (vistaFORM.radioJornadaReserva.isEnabled()) {
                vistaFORM.spinnerJornadas.setEnabled(true);
                vistaFORM.radioSiHabitaciones.setEnabled(true);
                vistaFORM.radioNoHabitaciones.setEnabled(true);
                vistaFORM.labelComensales.setEnabled(false);
                vistaFORM.labelNumeroComensales.setEnabled(false);
                vistaFORM.slidercomensales.setEnabled(false);
            }
        }
        if (e.getSource().equals(vistaFORM.radioSeminarioReserva)) {
            if (vistaFORM.radioJornadaReserva.isEnabled()) {
                vistaFORM.spinnerJornadas.setEnabled(true);
                vistaFORM.radioSiHabitaciones.setEnabled(true);
                vistaFORM.radioNoHabitaciones.setEnabled(true);
                vistaFORM.labelComensales.setEnabled(false);
                vistaFORM.labelNumeroComensales.setEnabled(false);
                vistaFORM.slidercomensales.setEnabled(false);
            }
        }
        if (e.getSource().equals(vistaFORM.botonReserva)) {
            JOptionPane.showMessageDialog(vistaFORM, "Se ha realizado la reserva con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            vistaFORM.dispose();
        }
        
    }

    public void iniciarInicio() {
        vistaINICIO.setTitle("Gestión de Reservas Centro Botín");
        vistaINICIO.setLocationRelativeTo(null);
    }
    
    public void iniciarFormulario(){
        vistaFORM.labelComensales.setEnabled(false);
        vistaFORM.labelNumeroComensales.setEnabled(false);
        vistaFORM.slidercomensales.setEnabled(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(vistaINICIO.LabelFoto)) {
            if (e.getButton() == 3) {
                vistaINICIO.menuDesplegable.show(vistaINICIO, e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(vistaFORM.slidercomensales)) {
            vistaFORM.labelNumeroComensales.setText("" + vistaFORM.slidercomensales.getValue() + "");
            
        }
    }
    
    
    

}
