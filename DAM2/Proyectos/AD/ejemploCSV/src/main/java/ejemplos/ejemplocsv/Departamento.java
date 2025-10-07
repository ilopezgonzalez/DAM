/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.ejemplocsv;

import java.util.LinkedHashMap;

/**
 *
 * @author cic
 */
public class Departamento implements Identificable {

    private int id;
    private String codigo;
    private String nombre;

    public Departamento(int id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public LinkedHashMap<String, String> datosObjeto() {
        LinkedHashMap<String, String> aux = new LinkedHashMap();
        aux.put("Id Dep", String.valueOf(id));
        aux.put("Codigo Dep", codigo);
        aux.put("Nombre Dep", nombre);
        return aux;
    }

}
