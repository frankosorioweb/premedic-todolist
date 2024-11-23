/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package py.com.metropolitano;

import java.util.Scanner;
import py.com.metropolitano.constans.TodoAppOptions;
import utils.TodoApp;

/**
 *
 * @author frank
 */
public class Main {

    public static void main(String[] args) {
        // Ajustes iniciales
        TodoApp todoApp = new TodoApp();
        
        // Lanzamos la aplicación
        todoApp.run();
        
        // Cerramos la aplicación
        todoApp.exit();
    }
}
