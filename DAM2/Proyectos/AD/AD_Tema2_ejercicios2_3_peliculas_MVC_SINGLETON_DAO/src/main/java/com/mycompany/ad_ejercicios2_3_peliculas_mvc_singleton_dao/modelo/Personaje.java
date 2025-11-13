/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_ejercicios2_3_peliculas_mvc_singleton_dao.modelo;

/**
 *
 * @author damt209
 */
public class Personaje {
    
    private int id;
    private String name;
    private String powers;
    private String company;
    private String origin;
    private boolean isHero;

    public Personaje(int id, String name, String powers, String company, String origin, boolean isHero) {
        this.id = id;
        this.name = name;
        this.powers = powers;
        this.company = company;
        this.origin = origin;
        this.isHero = isHero;
    }
 
    
    
}

