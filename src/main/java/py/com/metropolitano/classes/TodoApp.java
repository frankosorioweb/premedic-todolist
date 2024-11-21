/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.metropolitano.classes;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import py.com.metropolitano.constans.TodoOptions;
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
    
    public void run() {
        while( this.currentOption != TodoOptions.MAIN_EXIT) {
            // Mostrar el menú de opciones
            this.printMenu();
            
            // Leer una opción de menú válida
            this.readValidOption(1, 5);
            
            // Mostramos la opción correspondiente
            this.selectMenuOption();
        }
        
        exit();
    }
    
    // Liberamos los recursos
    private void exit() {
        this.scanner.close();
    }
    
    public void printMenu() {
        System.out.println("---- *** ---- TODO APP | Menú principal ---- *** ----");
        System.out.println("1. Crear nueva tarea");
        System.out.println("2. Marcar tarea como completada");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Mostrar tareas pendientes");
        System.out.println("5. Salir");
    }
    
    public void readValidOption(int minValue, int maxValue) {
        int option = -1;
        boolean isValid = false;
        
        while(!isValid) {
            try {
                System.out.print("Elige una opción: ");
                option = this.scanner.nextInt();
                this.scanner.nextLine();
                
                isValid = option >= minValue && option <= maxValue;
                if(!isValid) {
                    System.out.println("Por favor, ingresa una opción de menú válida");
                }
            }catch(InputMismatchException e) {
                System.out.println("Por favor, ingresa una opción de menú válida");
                this.scanner.nextLine();
            }
        }
        
        this.currentOption = option;
    }
    
    public void selectMenuOption() {
        switch(this.currentOption) {
            case TodoOptions.MAIN_CREATE_NEW_TASK:
                addTask();
                break;
        }
    }
    
    // 1: Permite agregar una nueva tarea
    public void addTask() {
        Todo todo = new Todo(this.scanner);
        todo.readTask();
    };
}
