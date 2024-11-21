/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.metropolitano.classes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class TodoApp {
    public void printMenu() {
        System.out.println("---- *** ---- TODO APP | Menú de opciones ---- *** ----");
        System.out.println("1. Crear nueva tarea");
        System.out.println("2. Marcar tarea como completada");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Mostrar tareas pendientes");
        System.out.println("5. Salir");
    }
    
    public int readValidOption() {
        Scanner scanner = new Scanner(System.in);
        
        int number = -1;
        boolean isValid = false;
        
        while(!isValid) {
            try {
                System.out.print("Elige una opción: ");
                number = scanner.nextInt();
                scanner.nextLine();
                
                isValid = number >=1 && number <= 5;
                if(!isValid) {
                    System.out.println("Por favor, ingresa una opción de menú válida");
                }
            }catch(InputMismatchException e) {
                System.out.println("Por favor, ingresa una opción de menú válida");
                scanner.nextLine();
            }
        }
        
        return number;
    }
}
