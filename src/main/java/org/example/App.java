package org.example;

import org.example.config.Config;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.service.UserServiceImpl;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        UserService userService = new UserServiceImpl();
        userService.createUserTable();
//        userService.saveUser(new User("Aizat","Asanova",21));
        System.out.println(userService.getAllUsers());
    }
}
