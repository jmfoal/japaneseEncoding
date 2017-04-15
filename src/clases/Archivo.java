/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 *
 * @author Foal
 */
public class Archivo {
    private InputStreamReader archivoEntrante;
    private OutputStreamWriter archivoSaliente;
    
    public Archivo(String archivoEntrante, String archivoSaliente) throws FileNotFoundException, IOException
    {
        this.archivoEntrante = new InputStreamReader(new FileInputStream(archivoEntrante), "UTF-8");
        
        this.archivoSaliente = new OutputStreamWriter(new FileOutputStream(archivoSaliente, true), Charset.forName("UTF-8"));
    }
    
    public void convertirArchivo() throws IOException
    {
        //Scanner sArchivoEntrante = new Scanner(this.archivoEntrante);
        BufferedReader sArchivoEntrante = new BufferedReader(this.archivoEntrante);
        for(String fila = sArchivoEntrante.readLine();fila != null; fila=sArchivoEntrante.readLine()){            
            String filaNueva = "";
            for(int i=0;i<fila.length();i++){
                filaNueva += this.convertirCaracter(fila.charAt(i));
            }
            filaNueva += "\r\n";
            System.out.println(filaNueva);
            this.archivoSaliente.write(filaNueva);
        }
    }
    
    private String convertirCaracter(char caracter)
    {
        String caracterNuevo;
        switch(caracter){
            case 'á':
                caracterNuevo = "ｧ";
            break;
            case 'é':
                caracterNuevo = "ｪ";
            break;
            case 'í':
                caracterNuevo = "ｨ";
            break;
            case 'ó':
                caracterNuevo = "ｫ";
            break;
            case 'ú':
                caracterNuevo = "ｩ";
            break;
            case 'ü':
                caracterNuevo = "ｯ";
            break;
            case 'ñ':
                caracterNuevo = "ﾃ";
            break;
            case 'Á':
                caracterNuevo = "ｱ";
            break;
            case 'É':
                caracterNuevo = "ｴ";
            break;
            case 'Í':
                caracterNuevo = "ｲ";
            break;
            case 'Ò':
                caracterNuevo = "ｵ";
            break;
            case 'Ù':
                caracterNuevo = "ｳ";
            break;
            case 'Ü':
                caracterNuevo = "ﾂ";
            break;
            case 'Ñ':
                caracterNuevo = "ﾆ";
            break;
            case '¡':
                caracterNuevo = "ｷ";
            break;
            case '¿':
                caracterNuevo = "ﾚ";
            break;
            default:
                caracterNuevo = ""+caracter+"";
            break;
        }
        return caracterNuevo;
    }
    
    public void cerrarArchivos() throws IOException
    {
        this.archivoEntrante.close();
        this.archivoSaliente.close();
    }
    
}


