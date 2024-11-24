/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.premedic.models;

import java.time.LocalDate;
import lombok.Data;
import lombok.ToString;
import py.com.premedic.constans.TodoAppOptions.TASK_PRIORITY;
import py.com.premedic.utils.Utilities;
import static py.com.premedic.utils.Utilities.SHOW_MSG;

/**
 *
 * @author frank
 */

@Data
public class TodoItem {
    private String id;
    private String description;
    private LocalDate dueDate;
    private TASK_PRIORITY priority;
    private boolean isCompleted = false;

    public TodoItem() {
        this.id = Utilities.GENERATE_UUID();
    }
    
    public TodoItem(String description, LocalDate dueDate, TASK_PRIORITY priority) {
        this();
        
        this.setDescription(description);
        this.setDueDate(dueDate);
        this.setPriority(priority);
    }
    
    @Override
    public String toString() {
        String template = "Descripción: \"%s\" | Fecha de Vencimiento: \"%s\" | Prioridad \"%s\"";
        String todoDetails = String.format(template, this.description, Utilities.FORMAT_DATE_LONG(dueDate), this.priority);
        
        return todoDetails;
    }
}
