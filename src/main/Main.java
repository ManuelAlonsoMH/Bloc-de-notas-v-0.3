/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.ViewBlocnotas;
import models.ModelBlocnotas;
import controllers.ControllerBlocnotas;
/**
 *
 * @author ManuelAlonsoMH
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewBlocnotas viewbloc = new ViewBlocnotas();
        ModelBlocnotas modelbloc = new ModelBlocnotas();
        ControllerBlocnotas controllerbloc = new ControllerBlocnotas(viewbloc, modelbloc);
        
    }
    
}
