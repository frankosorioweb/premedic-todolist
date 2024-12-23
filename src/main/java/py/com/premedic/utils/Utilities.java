package py.com.premedic.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import py.com.premedic.models.TodoItem;
import py.com.premedic.constans.TodoAppOptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author frank
 */
public class Utilities {
    public static LocalDate PARSE_DATE(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TodoAppOptions.DATE_FORMAT);
        
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String FORMAT_DATE_LONG(LocalDate date) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(TodoAppOptions.DATE_FORMAT_LONG);
        
        return date.format(outputFormatter);
    }
    
    public static void SHOW_MSG(String msg, boolean formatted) {
        String pattern = "---- **** ----";
        String template = "%s %s %s";
        
        String message = formatted ? String.format(template, pattern, msg, pattern) : msg;
        
        System.out.println(message);
    }
    
    public static void SHOW_MSG(String msg) {
        SHOW_MSG(msg, false);
    }
    
    public static String GENERATE_UUID() {
        return UUID.randomUUID().toString();
    }
    
    // Ordena por fecha de vencimiento y prioridad
    public static List<TodoItem> SORT_TODOS(List<TodoItem> todos) {
        List<TodoItem> result = new ArrayList<>(todos);
        result.sort(Comparator
            //.comparing(TodoItem::getDueDate, Comparator.reverseOrder()) // Descendente
            .comparing(TodoItem::getDueDate) // Ascendente
            .thenComparing(TodoItem::getPriority) // ALTA > MEDIA > BAJA
        );
        
        return result;
    }
}
