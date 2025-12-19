/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di_tarea_5_11;

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
        String archivojasper="src/di_tarea_5_11/DI_T5_11_LopezGonzalez_JIgnacio.jasper";
        try {
            //Cargamos los parametros del informe en una tabla Hash
            Map parametros = new HashMap();
            parametros.put("Identificador del producto",(id_articulo+1));
            
            //Generamos el informe en memoria
            JasperPrint print = JasperFillManager.fillReport(archivojasper, parametros, conexion);
            
            // Exporta el informe a PDF 
            JasperExportManager.exportReportToPdfFile(print, "producto_"+(id_articulo+1)+".pdf");
            File path = new File ("producto_"+(id_articulo+1)+".pdf");
            JOptionPane.showMessageDialog(null, "Se ha generado el informe correctamente.\n El archivo se encuentra en la ruta: "+path.getAbsolutePath(), "Exito", JOptionPane.INFORMATION_MESSAGE);
//            System.out.println("Todo OK");
            
            //Abre el archivo PDF generado
            
            System.out.println(path.getAbsolutePath());
            Desktop.getDesktop().open(path);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
