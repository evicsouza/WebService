/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.evicsouza.webservice;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author Eva
 */

@ApplicationPath("/")
public class MyApplication {
    
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(MyApplicationController.class);
        return classes;
        
    }
    
}
