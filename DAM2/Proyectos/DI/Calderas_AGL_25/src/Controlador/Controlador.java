/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Formulario;
import Vista.Presupuesto;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author damt209
 */
public class Controlador implements ActionListener, ItemListener, ChangeListener {

    private Principal ventanaPrincipal;
    private Formulario ventanaFormulario;
    private Presupuesto ventanaPresupuesto;

    public Controlador(Principal ventanaPrincipal, Formulario ventanaFormulario, Presupuesto ventanaPresupuesto) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaFormulario = ventanaFormulario;
        this.ventanaPresupuesto = ventanaPresupuesto;
        this.ventanaPrincipal.botonGasCiudad.addActionListener(this);
        this.ventanaPrincipal.menuGasCiudad.addActionListener(this);
        this.ventanaPrincipal.menuAcercaDe.addActionListener(this);
        this.ventanaFormulario.radioMovil.addActionListener(this);
        this.ventanaFormulario.comboMecanico.addItemListener(this);
        this.ventanaFormulario.checkReaparacion.addItemListener(this);
        this.ventanaFormulario.sliderPrecioMano.addChangeListener(this);

        this.ventanaPresupuesto.campoPresupuestoServicio.addActionListener(this);
        this.ventanaPresupuesto.campoPresupuestoManoObra.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ventanaPrincipal.menuGasCiudad) || e.getSource().equals(ventanaPrincipal.botonGasCiudad)) {
            ventanaFormulario.setVisible(true);
        }
        if (e.getSource().equals(ventanaPrincipal.menuAcercaDe)) {
            JOptionPane.showMessageDialog(ventanaPrincipal, "Revisión de calderas 2025", "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(ventanaFormulario.radioMovil)) {
            ventanaFormulario.labelTelefono.setEnabled(true);
            ventanaFormulario.campoTelefono.setEnabled(true);
        }
        if (e.getSource().equals(ventanaFormulario.checkReaparacion)) {
            ventanaPresupuesto.campoPresupuestoServicio.setText(String.valueOf(120));
        }
        if (e.getSource().equals(ventanaFormulario.botonCalcular)) {
            ventanaPresupuesto.setVisible(true);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(ventanaFormulario.comboMecanico)) {
            if (ventanaFormulario.comboMecanico.getSelectedIndex() == 1) {
                ventanaFormulario.checkAnual.setEnabled(true);
                ventanaFormulario.checkLimpieza.setEnabled(true);
                ventanaFormulario.checkReaparacion.setEnabled(true);
                ventanaFormulario.checkUrgente.setEnabled(true);
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(ventanaFormulario.sliderPrecioMano)) {
            ventanaPresupuesto.campoPresupuestoManoObra.setText(String.valueOf(ventanaFormulario.sliderPrecioMano.getValue()));
        }
    }
}
