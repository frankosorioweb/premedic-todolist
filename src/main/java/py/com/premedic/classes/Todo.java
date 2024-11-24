/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.premedic.classes;

import java.time.LocalDate;
import java.util.Scanner;
import py.com.premedic.models.TodoItem;
import py.com.premedic.constans.TodoAppOptions;
import py.com.premedic.constans.TodoAppOptions.TASK_PRIORITY;
import py.com.premedic.utils.Utilities;
import static py.com.premedic.utils.Utilities.SHOW_MSG;

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
        SHOW_MSG("");
        SHOW_MSG("TO-DO APP | AGREGAR TAREA", true);
        
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
            SHOW_MSG("Ingrese la Descripción:");
            validDescription = this.scanner.nextLine().trim();
            
            if(validDescription == "") {
                SHOW_MSG("¡Ingrese una descripción válida!.");
            }
            
        } while(validDescription.trim() == "");
        
        this.setDescription(validDescription);
        
        
    }
    
    private void readValidDueDate() {
        Boolean isValid;
        LocalDate validDueDate = null;
        
        do {
            SHOW_MSG("Ingrese la Fecha de Vencimiento (dd-MM-yyyy):");
            
            String dateStr = this.scanner.nextLine();

            validDueDate = Utilities.PARSE_DATE(dateStr);

            isValid = validDueDate != null;
            
            if(!isValid) {
                SHOW_MSG("¡Ingrese una fecha de vencimiento válida!");
            }
        } while(!isValid);
        
        this.setDueDate(validDueDate);
    }
    
    private void readValidPriority() {
        String validPriority = "";
        TASK_PRIORITY priority = null;
        
        do {
            SHOW_MSG("Ingrese la Prioridad (alta, media, baja)");
            validPriority = this.scanner.nextLine();
            
            try {
                priority = TASK_PRIORITY.valueOf(validPriority.toUpperCase());
            } catch (IllegalArgumentException e) {
                SHOW_MSG("¡Ingrese una prioridad válida!");
                
                validPriority = "";
            }
        } while(validPriority == "");
        
        this.setPriority(priority);
        
        SHOW_MSG(this.getPriority().toString());
    }
}
