/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio4_vuelo;

/**
 *
 * @author ilopezgonzalez
 */
public class HiloClienteCompra extends Thread{
    
    private int idCliente;
    private int asientosPeticion;
    private AsientosAvion asientosAvion;

    public HiloClienteCompra(int idCliente, int asientosPeticion, AsientosAvion asientosAvion) {
        this.idCliente = idCliente;
        this.asientosPeticion = asientosPeticion;
        this.asientosAvion = asientosAvion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getAsientosPeticion() {
        return asientosPeticion;
    }

    public void setAsientosPeticion(int asientosPeticion) {
        this.asientosPeticion = asientosPeticion;
    }

    public AsientosAvion getAsientosAvion() {
        return asientosAvion;
    }

    public void setAsientosAvion(AsientosAvion asientosAvion) {
        this.asientosAvion = asientosAvion;
    }

    @Override
    public void run() {
        asientosAvion.reservaAsientos(idCliente, asientosPeticion);
    }
    
    
    
    
}
