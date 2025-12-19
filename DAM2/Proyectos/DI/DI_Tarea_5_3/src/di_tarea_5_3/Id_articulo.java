/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di_tarea_5_3;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author damt209
 */
public class Id_articulo {
    
    public static Connection conexion = null;
    String baseDatos = "jdbc:mysql://localhost/fabrica";
    String usuario = "root";
    String clave = "";
    
    public Id_articulo(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(baseDatos,usuario,clave);
        }
        catch (ClassNotFoundException cnfe){
            System.err.println("Fallo al cargar JDBC");
            System.exit(1);
        }
        catch (SQLException sqle){
            System.err.println("No se pudo conectar a BD");
            System.exit(1);
        }
        catch (java.lang.InstantiationException sqlex){
            System.err.println("Imposible Conectar");
            System.exit(1);
        }
        catch (Exception ex){
            System.err.println("Imposible Conectar");
            System.exit(1);
        }
    }
    
    public void ejecutar(int id_articulo){
        
        //Ruta del informe respecto del proyecto NetBeans
        String archivojasper="src/di_tarea_5_3/DI_T5_8_LopezGonzalez_JIgnacio.jasper";
        try {
            //Cargamos los parametros del informe en una tabla Hash
            Map parametros = new HashMap();
            parametros.put("id",id_articulo);
            
            //Generamos el informe en memoria
            JasperPrint print = JasperFillManager.fillReport(archivojasper, parametros, conexion);
            
            // Exporta el informe a PDF 
            JasperExportManager.exportReportToPdfFile(print, "informe.pdf");
            
            //Abre el archivo PDF generado
            File path = new File ("informe.pdf");
            Desktop.getDesktop().open(path);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
