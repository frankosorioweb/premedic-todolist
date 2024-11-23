/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import lombok.Data;
import py.com.metropolitano.constans.TodoAppOptions.TASK_PRIORITY;

/**
 *
 * @author frank
 */

@Data
public class TodoItem {
    private String description;
    private LocalDate dueDate;
    private TASK_PRIORITY priority;
}
