/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import py.com.metropolitano.classes.Todo;
import py.com.metropolitano.constans.TodoAppOptions;
import utils.Utilities;

/**
 *
 * @author frank
 */
public class TodoApp {

    private int currentOption = -1;
    private Scanner scanner;
    
    public TodoApp() {
        // Para mostrar los acentos correctamente
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        this.scanner = new Scanner(System.in);
    }
    
    // Lanza la aplicación
    public void run() {
        while( this.currentOption != TodoAppOptions.MAIN_EXIT) {
            // Mostrar el menú de opciones
            this.printMenu();
            
            // Leer una opción de menú válida
            this.readValidOption(1, 5);
            
            // Mostramos la opción correspondiente
            this.selectMenuOption();
        }
    }
    
    // Liberamos los recursos al cerrar nuestra App
    public void exit() {
        System.out.println("");
        System.out.println("---- **** ---- CERRANDO APLICACIÓN ---- **** ---- ");
        this.scanner.close();
    }
    
    // Muestra todas las opciones del menú principal
    public void printMenu() {
        System.out.println();
        System.out.println("---- *** ---- TODO APP | Menú principal ---- *** ----");
        System.out.println("1. Crear nueva tarea.");
        System.out.println("2. Marcar tarea como completada.");
        System.out.println("3. Eliminar tarea.");
        System.out.println("4. Mostrar tareas pendientes.");
        System.out.println("5. Salir.");
    }
    
    // Permite leer una opción del usuario y valida el rango del valor
    public void readValidOption(int minValue, int maxValue) {
        int option = -1;
        Boolean isValid;
        
        do {
            try {
                System.out.print("Elige una opción: ");
                option = this.scanner.nextInt();
                this.scanner.nextLine();
                
                isValid = option >= minValue && option <= maxValue;
                if(!isValid) {
                    System.out.println(TodoAppOptions.INPUT_ERROR_MESSAGE);
                }
            }catch(InputMismatchException e) {
                isValid = false;
                
                System.out.println(TodoAppOptions.INPUT_ERROR_MESSAGE);
                this.scanner.nextLine();
            }
        }while(!isValid);
        
        this.currentOption = option;
    }
    
    // Permite navegar por el sistema, a partir de la opción ingresada
    public void selectMenuOption() {
        switch(this.currentOption) {
            // 1: Crear nueva tarea.
            case TodoAppOptions.MAIN_CREATE_NEW_TASK:
                addTask();
                break;
                
            // 2: Marcar tarea como completada.
            case TodoAppOptions.MAIN_MARK_TASK_COMPLETED:
                //todoFunctions.readTask();
                break;
                
            // 3: Eliminar tarea.
            case TodoAppOptions.MAIN_DELETE_TASK:
                //todoFunctions.readTask();
                break;
                
            // 4: Mostrar tareas pendientes.
            case TodoAppOptions.MAIN_SHOW_PENDING_TASKS:
                //todoFunctions.readTask();
                break;
        }
    }
    
    private void addTask() {
        Todo todo = new Todo(this.scanner);
        todo.readTask();
        
        // Agregar a la colección
        
    }
}
