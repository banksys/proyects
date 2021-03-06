/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package historia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class DatosArchivo    {
    
    private int anos[];
    private String datos[];
    private int totalDatos;
    
    public void mostrarUnDato(int lugar){
        System.out.printf("En el año %d %s\n", anos[lugar], datos[lugar]);
    }
    
    public String getDato(int lugar){
        return datos[lugar];
    }
    
    public int getAno(int lugar){
        return anos[lugar];
    }
    
    public int getTotalDatos(){
        return totalDatos;
    }
    
    public void llenarDatos() {
    File archivo = null;
    FileReader fr = null;
    ArrayList<String> lineas = new ArrayList<String>();
 
    try {
        archivo = new File ("C:/Users/Julian/Desktop/historia1.txt");
        String linea;
        fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
        while((linea=br.readLine())!=null)
        {
            lineas.add(linea);
        }
        // Después de agregar todas las líneas, genera el array
        totalDatos = lineas.size();
        anos = new int [totalDatos];
        datos = new String [totalDatos];
        
        for (int j = 0 ; j < lineas.size() ; j++)
        {
            linea = lineas.get(j);
            String ano = "";
            String dato = "";

            int lugar = linea.indexOf("::");
            if( lugar != -1){
                ano = linea.substring(0, lugar);
                dato = linea.substring(lugar+2 , linea.length());
                }
              ano = ano.trim();
              dato = dato.trim();
              
              
              anos[j] = Integer.parseInt(ano);
              datos[j] = dato;
              
         //   System.out.printf("En el %s %s\n", ano, dato);
            
        }// fin del for
    }//FIN DEL TRY
    
    catch(IOException e){
        System.out.println(e);
    }
    
    finally{
        try{ //el bloque finally se ejecuta siempre, por eso, si se cierra el fichero
            if( fr != null){ //al final del primer try, y ha dado un error antes, pasaría
                fr.close(); //al 1er catch y luego saldría, dejándolo abierto. Es conveniente
            } //cerrarlo aquí, comprobando que no sea -por un error anterior, como
        }catch (IOException e){ // no tener permisos de lectura o que no exista - de valor null.
            
        }}
    }// final del llenarDatos
    
    
}// final clase
