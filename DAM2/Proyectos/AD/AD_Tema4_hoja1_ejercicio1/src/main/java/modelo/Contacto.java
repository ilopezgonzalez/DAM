/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author damt209
 */
@Embeddable
public class Contacto {
    
    @Column(name = "mail")
    private String mail;
    @Column(name = "web")
    private String web;
    @Column(name = "instagram")
    private String instagram;
    @Column(name = "youtube")
    private String youtube;

    public Contacto() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    @Override
    public String toString() {
        return "Contacto{" + "mail=" + mail + ", web=" + web + ", instagram=" + instagram + ", youtube=" + youtube + '}';
    }
    
    
    
}
