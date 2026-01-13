/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author damt209
 */

@Entity
@Table(name = "CANCIONES")
public class Cancion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCancion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "duracion")
    private String duracion;
    
    @ManyToOne
    @JoinColumn(name = "idgrupo", foreignKey = @ForeignKey(name = "FK_CANCION_GRUPO"))
    private Grupo grupo;
}
