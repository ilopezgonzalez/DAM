/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_u4_hoja1_ejercicio2_servidorhttp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Constantes {

    // MENSAJES
    public static final String LINEAINICIAL_OK = "HTTP/1.1 200 OK";
    public static final String LINEAINICIAL_NOTFOUND = "HTTP/1.1 404 Not Found";
    public static final String LINEAINICIAL_BADREQUEST = "HTTP/1.1 400 Bad Request";
    public static final String PRIMERA_CABECERA = "Content-Type:text/html;charset=UTF-8";
    public static final ZonedDateTime zona=ZonedDateTime.now(ZoneId.of("GMT"));
    // DateTimeFormatter custom = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    // ZonedDateTime ahora = ZonedDateTime.now(ZoneId.of("GMT"));
    // System.out.println(ahora.format(custom));
    public static final String DATE="Date: "+zona.format(DateTimeFormatter.RFC_1123_DATE_TIME.withLocale(Locale.US));

    //contenido index
    public static final String HTML_INDEX = "<html>"
            + "<head><title>index</title></head>"
            + "<body>"
            + "<h1>¡Enhorabuena!</h1>"
            + "<p>Tu servidor HTTP mínimo funciona correctamente</p>"
            + "</body>"
            + "</html>";
    //contenido 

    public static final String HTML_QUIJOTE = "<html>"
            + "<head><title>quijote</title></head>"
            + "<body>"
            + "<h1>Así comienza el Quijote</h1>"
            + "<p>En un lugar de la Mancha, de cuyo nombre no quiero "
            + "acordarme, no ha mucho tiempo que vivía un hidalgo de los "
            + "de lanza en astillero, adarga antigua, rocín flaco y galgo "
            + "corredor. Una olla de algo más vaca que carnero, salpicón "
            + "las más noches, duelos y quebrantos (huevos con tocino) los "
            + "sábados, lentejas los viernes, algún palomino de añadidura "
            + "los domingos, consumían las tres partes de su hacienda. El "
            + "resto della concluían sayo de velarte (traje de paño fino), "
            + "calzas de velludo (terciopelo) para las fiestas con sus "
            + "pantuflos de lo mismo, y los días de entresemana se honraba "
            + "con su vellorí (pardo de paño) de lo más fino. Tenía en su "
            + "casa una ama que pasaba de los cuarenta, y una sobrina que "
            + "no llegaba a los veinte, y un mozo de campo y plaza, que "
            + "así ensillaba el rocín como tomaba la podadera...</p>"
            + "</body>"
            + "</html>";
    //contenido noEncontrado
    public static final String HTML_NOENCONTRADO = "<html>"
            + "<head><title>noEncontrado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Página no encontrada</h1>"
            + "<p>La página que solicitaste no existe en nuestro "
            + "servidor</p>"
            + "</body>"
            + "</html>";
    
    
            
}
