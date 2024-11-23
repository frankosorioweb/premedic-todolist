/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.metropolitano.classes;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import models.TodoData;
import utils.Utilities;

/**
 *
 * @author frank
 */
public class Todo extends TodoData{
    private Scanner scanner;

    public Todo(Scanner scanner) {
        this.scanner = scanner;
    }
    
    // Solicita todas las propiedades al usuario
    public TodoData readTask() {
        System.out.println();
        System.out.println("---- **** ---- TO-DO APP | AGREGAR TAREA ---- **** ---- ");
        
        // 1: Descripción
        this.readValidDescription();
        
        // 2. Fecha de vencimiento 
        this.readValidDueDate();
        
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
        
        //this.description = validDescription;
    }
    
    private void readValidDueDate() {
        Boolean isValid;
        
        do {
            System.out.println("Ingrese la Fecha de Vencimiento (dd-MM-yyyy):");
            String dateStr = this.scanner.nextLine();

            LocalDate dueDate = Utilities.parseDate(dateStr);

            isValid = dueDate != null;
            
            System.out.println(" " + isValid);
        } while(!isValid);
    }
}
