/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.modelo;

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
    private boolean isHeroe;

    public Personaje(int id, String name, String powers, String company, String origin, boolean isHeroe) {
        this.id = id;
        this.name = name;
        this.powers = powers;
        this.company = company;
        this.origin = origin;
        this.isHeroe = isHeroe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isIsHeroe() {
        return isHeroe;
    }

    public void setIsHeroe(boolean isHeroe) {
        this.isHeroe = isHeroe;
    }

    public String getOriginDisplay() {
        return (origin == null || origin.trim().isEmpty()) ? "sin cargar" : origin;
    }

    public String getRoleDisplay() {
        return isHeroe ? "HEROE" : "VILLANO";
    }

    @Override
    public String toString() {
        return "Personaje{" + "id=" + id + ", name=" + name + ", powers=" + powers + ", company=" + company + ", origin=" + origin + ", isHeroe=" + isHeroe + '}';
    }

}
