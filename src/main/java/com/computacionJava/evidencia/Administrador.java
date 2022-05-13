/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computacionJava.evidencia;

/**
 *
 * @author alexm
 */
public class Administrador {
    
    String nombre = "";
    String apellido = "";
    String contraseña = "";
    

    public Administrador(String nombre,String apellido,String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        
    }
    
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
