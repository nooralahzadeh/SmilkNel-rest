/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.services;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

/**
 *
 * @author fnoorala
 */
public class MyPropertyReader {
    
    
    public  String getPropertyValue(String key){
        String value="";
        Properties properties = new Properties();
            
        try {
        
          InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("project.properties");
          //new FileInputStream("../project.properties")
            properties.load(inStream);
            value=properties.getProperty(key);
            System.out.println(value);
            
        } catch (IOException ex) {
            System.out.println("Not Fo");
        }
        return value;
    }
    
     
    
}
