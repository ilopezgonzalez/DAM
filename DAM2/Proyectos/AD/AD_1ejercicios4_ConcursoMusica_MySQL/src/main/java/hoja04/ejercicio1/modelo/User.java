/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.modelo;

/**
 *
 * @author damt209
 */
public class User {
    
    
    private String user;
    private String password;
    private int numero_votos;

    public User(String user, String password, int numero_votos) {
        this.user = user;
        this.password = password;
        this.numero_votos=numero_votos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumero_votos() {
        return numero_votos;
    }

    public void setNumero_votos(int numero_votos) {
        this.numero_votos = numero_votos;
    }
    
    

    
    
    
}
