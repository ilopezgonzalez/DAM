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

/**
 *
 * @author damt209
 */
public class Controlador_Botin implements ActionListener {

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
        this.vistaFORM.radioBanqueteReserva.addActionListener(this);
        this.vistaFORM.radioJornadaReserva.addActionListener(this);
        this.vistaFORM.radioSeminarioReserva.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistaINICIO.botonSalir)) {
            vistaINICIO.dispose();
        }
        if (e.getSource().equals(vistaINICIO.botonSalaBahia) || e.getSource().equals(vistaINICIO.menuSalaBahia)) {
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
    }

    public void iniciar() {
        vistaINICIO.setTitle("Gestión de Reservas Centro Botín");
        vistaINICIO.setLocationRelativeTo(null);
    }

}
