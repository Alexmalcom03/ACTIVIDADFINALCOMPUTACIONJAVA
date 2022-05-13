/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computacionJava.evidencia;

/**
 *
 * @author jajimenez
 */
public class Paciente {

    private Integer id;
    private String nombre;
    private String nombreDoctor;

    public Paciente(Integer id, String nombre, String nombreDoctor) {
        this.id = id;
        this.nombre = nombre;
        this.nombreDoctor = nombreDoctor;
    }

    public Paciente() {
    }
    

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", nombreDoctor=" + nombreDoctor + '}';
    }
    

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
