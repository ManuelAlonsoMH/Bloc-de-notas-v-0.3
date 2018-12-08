/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import views.ViewBlocnotas;

/**
 * Se generan las variables a utilizar 
 * Path: para la ruta que va a recibir la ruta del archivo.
 * Mensaje: es el el texto que se guardara el archivo.
 * row: es la fila que existe en el mensaje.
 * @author Diego
 */
public class ModelBlocnotas {
       ViewBlocnotas viewbloc;
       private String path;
       private String mensaje = "";
       boolean bandera = false;
       String caesar = "";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getCaesar(){
        return caesar;
    }
    
    public void setCaesar(String caesar){
        this.caesar = caesar;
    }
    /**
     * Permite seleccionar un archivo dentro de una ventana de dialogo
     */
    public void openFile(){
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showOpenDialog(viewbloc);
        File archivo = jfc.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(" "))){
            JOptionPane.showMessageDialog(viewbloc, "Nombre del archvio inválido");
        }
        else
            path = archivo.getAbsolutePath();
    }
    
    /**
     *  Lee un archivo según la ruta especificada
     * 
     */
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        mensaje = mensaje + row + "\n";
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewbloc,"No se econtró el archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
     /**
     * Realiza la escritura o mdoficación a un archivo ya existente o en caso de no ser así crea el archivo.
     * 
     */
    public void writeFile(){
             try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        printWriter.print(mensaje);
                        printWriter.close();
                        JOptionPane.showMessageDialog(viewbloc,"Se modificó correctamente");
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
                }
            }
    /**
     * Cifrara el t exto introducido con el método Cesar
     */
    public void string2Caesar(){
        int ascii;
        for(int i=0; i < mensaje.length(); i++){
            if(mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z'){
                if((mensaje.charAt(i) + 1) > 'z'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii + 1 - 26;
                    caesar= caesar + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii + 1;
                    caesar = caesar + ((char)ascii);
                }
            }
            else if(mensaje.charAt(i)>= 'A' && mensaje.charAt(i) <='Z'){
                if((mensaje.charAt(i) + 1) > 'Z'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii + 1 - 26;
                    caesar= caesar + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii + 1;
                    caesar = caesar + ((char)ascii);
                }
            }
            
        }
    }
        
    
    /**
     * Descifrara el texto introducido con el método Cesar
     */
    public void Caesar2String(){
        int ascii;
        for(int i=0; i < mensaje.length(); i++){
            if(mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z'){
                if((mensaje.charAt(i) - 1) < 'a'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii - 1 + 26;
                    caesar= caesar + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii - 1;
                    caesar = caesar + ((char)ascii);
                }
            }
            else if(mensaje.charAt(i)>= 'A' && mensaje.charAt(i) <='Z'){
                if((mensaje.charAt(i) - 1) < 'A'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii - 1 + 26;
                    caesar= caesar + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii - 1;
                    caesar = caesar + ((char)ascii);
                }
            }
            
        }
    }

  }

