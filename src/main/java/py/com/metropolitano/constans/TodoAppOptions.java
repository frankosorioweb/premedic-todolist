/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.metropolitano.constans;

/**
 *
 * @author frank
 */
public class TodoAppOptions {
    // Opciones del menú principal
    public static final int MAIN_CREATE_NEW_TASK = 1;
    public static final int MAIN_MARK_TASK_COMPLETED = 2;
    public static final int MAIN_DELETE_TASK = 3;
    public static final int MAIN_SHOW_PENDING_TASKS = 4;
    public static final int MAIN_EXIT = 5;
    
    // Opciones de fechas
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    
    // Mensajes
    public static final String INPUT_ERROR_MESSAGE = "Por favor, ingrese una opción de menú válida.";
    
    public static enum TASK_PRIORITY { ALTA, MEDIA, BAJA };
}
