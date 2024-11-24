/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package py.com.premedic;

import py.com.premedic.utils.TodoApp;

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
