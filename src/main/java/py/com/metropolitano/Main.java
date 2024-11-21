/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package py.com.metropolitano;

import java.util.Scanner;
import py.com.metropolitano.constans.TodoOptions;
import py.com.metropolitano.classes.TodoApp;

/**
 *
 * @author frank
 */
public class Main {

    public static void main(String[] args) {
        TodoApp todoApp = new TodoApp();
        
        int option = -1;
        
        while( option != TodoOptions.EXIT) {
            todoApp.printMenu();
            
            option = todoApp.readValidOption();
        }
    }
}
