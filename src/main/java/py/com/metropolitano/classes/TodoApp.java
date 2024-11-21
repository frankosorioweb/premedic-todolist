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
    
    public TodoApp() {
        // Para mostrar los acentos correctamente
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
    }
    
    public void run() {
        this.currentOption = -1;
        
        while( this.currentOption != TodoOptions.EXIT) {
            // Mostrar el menú de opciones
            this.printMenu();
            
            // Leer una opción de menú válida
            this.readValidOption();
            
            System.out.println("Opción válida: " + this.currentOption);
        }
    }
    
    public void printMenu() {
        System.out.println("---- *** ---- TODO APP | Menú principal ---- *** ----");
        System.out.println("1. Crear nueva tarea");
        System.out.println("2. Marcar tarea como completada");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Mostrar tareas pendientes");
        System.out.println("5. Salir");
    }
    
    public void readValidOption() {
        Scanner scanner = new Scanner(System.in, "ISO-8859-1");
        
        int option = -1;
        boolean isValid = false;
        
        while(!isValid) {
            try {
                System.out.print("Elige una opción: ");
                option = scanner.nextInt();
                scanner.nextLine();
                
                isValid = option >=1 && option <= 5;
                if(!isValid) {
                    System.out.println("Por favor, ingresa una opción de menú válida");
                }
            }catch(InputMismatchException e) {
                System.out.println("Por favor, ingresa una opción de menú válida");
                scanner.nextLine();
            }
        }
        
        this.currentOption = option;
    }
}
