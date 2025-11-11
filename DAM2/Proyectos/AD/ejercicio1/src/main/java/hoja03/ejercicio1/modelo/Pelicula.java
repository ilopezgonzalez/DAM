/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.modelo;

/**
 *
 * @author cic
 */
public class Pelicula {
    //Cuando se usan datos primitivos cuando se inicializa una variable lo hace en 0 y no hace falta inicializar.
    private int id;
    private String title;
    private Integer duration; // duración en minutos, puede ser null
    private Integer year; // año de producción
    private String producer;

    public Pelicula() {}

    public Pelicula(int id, String title, Integer duration, Integer year, String producer) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.year = year;
        this.producer = producer;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getProducer() { return producer; }
    public void setProducer(String producer) { this.producer = producer; }

    public String getProducerDisplay() {
        return (producer == null || producer.trim().isEmpty()) ? "sin cargar" : producer;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", title, year == null ? "-" : year.toString(), getProducerDisplay());
    }
}
