/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_ejercicios1_3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author ASUS
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    // Constructor que llama al padre
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    // Sobrescribimos el método que escribe el header para no duplicarlo
    @Override
    protected void writeStreamHeader() throws IOException {
        // No hacemos nada, así evitamos que se escriba un nuevo header
    }
}
