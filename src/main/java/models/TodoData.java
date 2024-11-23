/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author frank
 */

@Data
public class TodoData {
    private String description;
    private Date dueDate;
    private String priority;
}
