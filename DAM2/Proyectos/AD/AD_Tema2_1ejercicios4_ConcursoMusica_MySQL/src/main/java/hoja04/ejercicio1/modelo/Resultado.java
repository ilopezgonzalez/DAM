/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.modelo;

/**
 *
 * @author cic
 * @param <T>
 */

public class Resultado<T> {
    
    private final boolean ok;
    private final T data;
    private final String message;

    private Resultado(boolean ok, T data, String message) {
        this.ok = ok;
        this.data = data;
        this.message = message;
    }

    public static <T> Resultado<T> ok(T data) {
        return new Resultado<>(true, data, null);
    }

    public static <T> Resultado<T> fail(String message) {
        return new Resultado<>(false, null, message);
    }

    public boolean isOk() { return ok; }
    public T getData() { return data; }
    public String getMessage() { return message; }
}
