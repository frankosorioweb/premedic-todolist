/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import models.TodoItem;
import py.com.metropolitano.classes.Todo;
import py.com.metropolitano.constans.TodoAppOptions;
import py.com.metropolitano.constans.TodoAppOptions.TASK_PRIORITY;
import static utils.Utilities.SHOW_MSG;

/**
 *
 * @author frank
 */
public class TodoApp {

    private int currentOption = -1;
    private final Scanner scanner;
    
    private final List<TodoItem> todos;
    
    public TodoApp() {
        // Para mostrar los acentos correctamente
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        this.todos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        
        this.loadTestTasks();
    }
    
    private void loadTestTasks() {
        todos.add(new TodoItem("Crear redes sociales", LocalDate.of(2024, 12, 1), TASK_PRIORITY.MEDIA));
        todos.add(new TodoItem("Instalar HTTPS en el server", LocalDate.of(2024, 12, 2), TASK_PRIORITY.BAJA));
        todos.add(new TodoItem("Registrar dominio", LocalDate.of(2024, 12, 1), TASK_PRIORITY.ALTA));
        todos.add(new TodoItem("Lanzar campaña publicitaria", LocalDate.of(2024, 12, 1), TASK_PRIORITY.ALTA));
    }
    
    // Lanza la aplicación
    public void run() {
        while( this.currentOption != TodoAppOptions.MAIN_EXIT) {
            // Mostrar el menú de opciones
            this.printMenu();
            
            // Leer una opción de menú válida
            this.readValidOption(1, 5, "Elige una opción: ");
            
            // Mostramos la opción correspondiente
            this.selectMenuOption();
        }
    }
    
    // Liberamos los recursos al cerrar nuestra App
    public void exit() {
        SHOW_MSG("");
        SHOW_MSG("CERRANDO APLICACIÓN (CONTRATENME XD)", true);
        
        this.scanner.close();
    }
    
    // Muestra todas las opciones del menú principal
    public void printMenu() {
        SHOW_MSG("");
        SHOW_MSG("TODO APP | Menú principal", true);
        SHOW_MSG("1. Crear nueva tarea.");
        SHOW_MSG("2. Marcar tarea como completada.");
        SHOW_MSG("3. Eliminar tarea.");
        SHOW_MSG("4. Mostrar tareas pendientes.");
        SHOW_MSG("5. Salir.");
    }
    
    // Permite leer una opción del usuario y valida el rango del valor
    public void readValidOption(int minValue, int maxValue, String message) {
        int option = -1;
        Boolean isValid;
        
        do {
            try {
                SHOW_MSG(message);
                option = this.scanner.nextInt();
                this.scanner.nextLine();
                
                isValid = option >= minValue && option <= maxValue;
                if(!isValid) {
                    SHOW_MSG(TodoAppOptions.INPUT_ERROR_MESSAGE);
                }
            }catch(InputMismatchException e) {
                isValid = false;
                
                SHOW_MSG(TodoAppOptions.INPUT_ERROR_MESSAGE);
                this.scanner.nextLine();
            }
        }while(!isValid);
        
        this.currentOption = option;
    }
    
    // Permite navegar por el sistema, a partir de la opción ingresada
    public void selectMenuOption() {
        switch(this.currentOption) {
            // 1: Crear nueva tarea.
            case TodoAppOptions.MAIN_CREATE_NEW_TASK:
                addTask();
                break;
                
            // 2: Marcar tarea como completada.
            case TodoAppOptions.MAIN_MARK_TASK_COMPLETED:
                this.markTaskCompleted();
                break;
                
            // 3: Eliminar tarea.
            case TodoAppOptions.MAIN_DELETE_TASK:
                this.deleteTask();
                break;
                
            // 4: Mostrar tareas pendientes.
            case TodoAppOptions.MAIN_SHOW_PENDING_TASKS:
                this.showPendingTasks();
                break;
        }
    }
    
    private void addTask() {
        TodoItem data = new Todo(this.scanner).readTask();        
        
        // Agregar a la colección
        this.todos.add(data);
        
        SHOW_MSG("TAREA AGREGADA", true);
    }
    
    private List<TodoItem> getPendingTasks() {
        List<TodoItem> pendingTodos = this.todos.stream().filter(item -> !item.isCompleted()).collect(Collectors.toList());
        
        return pendingTodos;
    }
    
    private void showPendingTasks() {
        List<TodoItem> pendingTodos = this.getPendingTasks();
        List<TodoItem> sortedItems = Utilities.SORT_TODOS(pendingTodos);
        
        if(sortedItems.isEmpty()) {
            SHOW_MSG("NO HAY TAREAS PENDIENTES", true);
        } else {
            SHOW_MSG("TAREAS PENDIENTES | Vencimiento ↓ Prioridad ↑", true);
            
            int index = 1;
            for(TodoItem todo : sortedItems) {
                SHOW_MSG(index + ". " + todo.toString());
                
                index++;
            }
        }
    }
    
    private void showAllTasks(String message) {
        if(this.todos.isEmpty()) {
            SHOW_MSG("NO HAY TAREAS", true);
        } else {
            SHOW_MSG(message, true);
            
            int index = 1;
            for(TodoItem todo : this.todos) {
                SHOW_MSG(index + ". " + todo.toString());
                
                index++;
            }
        }
    }
    
    private void markTaskCompleted() {
        this.showPendingTasks();
        
        List<TodoItem> pendingTodos = this.getPendingTasks();
        
        if(!pendingTodos.isEmpty()) {
            this.readValidOption(1, pendingTodos.size(), "Ingrese una opción (1 al " + pendingTodos.size() + "): ");
            
            String selectedTodoId = pendingTodos.get(this.currentOption - 1).getId();
            Optional<TodoItem> selectedTodo = this.todos.stream().filter(item -> item.getId().equals(selectedTodoId)).findFirst();
            
            if(!selectedTodo.isEmpty()) {
                selectedTodo.get().setCompleted(true);
                SHOW_MSG("TAREA COMPLETADA", true);
            }
        }
    }
    
    private void deleteTask() {
        this.showAllTasks("ELIMINAR TAREA");
        
        if(!this.todos.isEmpty()) {
            this.readValidOption(1, this.todos.size(), "Ingrese una opción (1 al " + this.todos.size() + "): ");
            
            String selectedTodoId = this.todos.get(this.currentOption - 1).getId();
            Optional<TodoItem> selectedTodo = this.todos.stream().filter(item -> item.getId().equals(selectedTodoId)).findFirst();
            
            if(!selectedTodo.isEmpty()) {
                this.todos.remove(selectedTodo.get());
                SHOW_MSG("TAREA ELIMINADA", true);
            }
        }
    }
}
