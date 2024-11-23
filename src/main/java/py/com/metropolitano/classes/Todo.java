/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.metropolitano.classes;

import java.time.LocalDate;
import java.util.Scanner;
import models.TodoItem;
import py.com.metropolitano.constans.TodoAppOptions;
import py.com.metropolitano.constans.TodoAppOptions.TASK_PRIORITY;
import utils.Utilities;

/**
 *
 * @author frank
 */
public class Todo extends TodoItem{
    private Scanner scanner;

    public Todo(Scanner scanner) {
        this.scanner = scanner;
    }
    
    // Solicita todas las propiedades al usuario
    public TodoItem readTask() {
        System.out.println();
        System.out.println("---- **** ---- TO-DO APP | AGREGAR TAREA ---- **** ---- ");
        
        // 1: Descripción
        this.readValidDescription();
        
        // 2. Fecha de vencimiento 
        this.readValidDueDate();
        
        // 2. Prioridad
        this.readValidPriority();
        
        return this;
    }
    
    private void readValidDescription() {
        String validDescription = "";
        
        do{
            System.out.println("Ingrese la Descripción:");
            validDescription = this.scanner.nextLine().trim();
            
            if(validDescription == "") {
                System.out.println("¡Ingrese una descripción válida!.");
            }
            
        } while(validDescription.trim() == "");
        
        this.setDescription(validDescription);
    }
    
    private void readValidDueDate() {
        Boolean isValid;
        LocalDate validDueDate = null;
        
        do {
            System.out.println("Ingrese la Fecha de Vencimiento (dd-MM-yyyy):");
            String dateStr = this.scanner.nextLine();

            validDueDate = Utilities.parseDate(dateStr);

            isValid = validDueDate != null;
            
            if(!isValid) {
                System.out.println("¡Ingrese una fecha de vencimiento válida!");
            }
        } while(!isValid);
        
        this.setDueDate(validDueDate);
    }
    
    private void readValidPriority() {
        String validPriority = "";
        TASK_PRIORITY priority = null;
        
        do {
            System.out.println("Ingrese la Prioridad (alta, media, baja)");
            validPriority = this.scanner.nextLine();
            
            try {
                priority = TASK_PRIORITY.valueOf(validPriority.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(validPriority);
                System.out.println("¡Ingrese una prioridad válida!");
                
                validPriority = "";
            }
        } while(validPriority == "");
        
        this.setPriority(priority);
        
        System.out.println(this.getPriority().toString());
    }
}
