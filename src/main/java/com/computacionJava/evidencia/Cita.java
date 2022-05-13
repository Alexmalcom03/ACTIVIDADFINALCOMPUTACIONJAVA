/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computacionJava.evidencia;

import java.util.Date;

/**
 *
 * @author jajimenez
 */
public class Cita implements Comparable <Cita> {

    private Integer id;
    private String nombreCita;
    private String fecha;
    private String NombreMedico;
    private String EspecialidadMedico;
    private String NombrePaciente;

    public Cita(Integer id, String nombreCita, String fecha, String nombreMedico, String EspecialidadMedico, String nombrePaciente) {
        this.id = id;
        this.nombreCita = nombreCita;
        this.fecha = fecha;
        this.NombreMedico = nombreMedico;
         this.EspecialidadMedico = EspecialidadMedico;
        this.NombrePaciente = nombrePaciente;
    }

    public Cita() {
    }
    
     

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCita() {
        return nombreCita;
    }

    public void setNombreCita(String nombreCita) {
        this.nombreCita = nombreCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreMedico() {
        return NombreMedico;
    }

    public void setNombreMedico(String NombreMedico) {
        this.NombreMedico = NombreMedico;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String NombrePaciente) {
        this.NombrePaciente = NombrePaciente;
    }

    @Override
    public String toString() {
        return "Cita{" + "id=" + id + ", nombreCita=" + nombreCita + ", fecha=" + fecha + ", NombreMedico=" + NombreMedico + ", EspecialidadMedico=" + EspecialidadMedico + ", NombrePaciente=" + NombrePaciente + '}';
    }

    
    
    
    
    @Override
    public int compareTo(Cita t) {
    
        return NombreMedico.compareTo(t.getNombreMedico());
    }

    
    
    public int compareToPaciente(Cita t) {
    
        return NombrePaciente.compareTo(t.getNombreMedico());
    }
 

}
