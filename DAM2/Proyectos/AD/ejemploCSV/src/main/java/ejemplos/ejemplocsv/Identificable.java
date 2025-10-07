/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejemplos.ejemplocsv;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author cic
 */
public interface Identificable {

    public LinkedHashMap<String, String> datosObjeto();

    public static void modoFicha(LinkedHashMap<String, String> datosObjeto) {
        for (Map.Entry< String, String> listado : datosObjeto.entrySet()) {
            System.out.println(listado.getKey() + ":" + listado.getValue() + "\n");
        }
    }
}
