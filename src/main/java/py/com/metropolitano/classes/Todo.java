/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.metropolitano.classes;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class Todo {
    private Scanner scanner;
    
    private String description;
    private Date dueDate;
    private String priority;

    public Todo(Scanner scanner) {
        this.scanner = scanner;
    }
    
    // Solicita todas las propiedades al usuario
    public void readTask() {
        System.out.println();
        System.out.println("---- **** ---- TO-DO APP | AGREGAR TAREA ---- **** ---- ");
        
        System.out.println("Ingrese la descripción:");
        String description = this.scanner.nextLine();
        
        System.out.println("Descripción: " + description);
        
        this.scanner.nextLine();
    }
}
