/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.modelo;

/**
 *
 * @author ASUS
 */
public class Actuacion {
    
    private int id;
    private Personaje character_id;
    private Pelicula movie_id;
    private Integer minutes_on_movie;
    private boolean main_character;
    private String actor;

    public Actuacion(int id, Personaje character_id, Pelicula movie_id, int minutes_on_movie, boolean main_character, String actor) {
        this.id = id;
        this.character_id = character_id;
        this.movie_id = movie_id;
        this.minutes_on_movie = minutes_on_movie;
        this.main_character = main_character;
        this.actor = actor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personaje getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(Personaje character_id) {
        this.character_id = character_id;
    }

    public Pelicula getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Pelicula movie_id) {
        this.movie_id = movie_id;
    }

    public int getMinutes_on_movie() {
        return minutes_on_movie;
    }

    public void setMinutes_on_movie(int minutes_on_movie) {
        this.minutes_on_movie = minutes_on_movie;
    }

    public boolean isMain_character() {
        return main_character;
    }

    public void setMain_character(boolean main_character) {
        this.main_character = main_character;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    
    
    
    
    
}
