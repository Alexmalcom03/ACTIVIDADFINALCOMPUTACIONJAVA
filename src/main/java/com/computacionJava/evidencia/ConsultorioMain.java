/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computacionJava.evidencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jajimenez
 */
public class ConsultorioMain {
    
    public static List<Usuario> usuarios;
    public static List<Medico> medicos;
    public static List<Paciente> pacientes;
    public static List<Cita> citas = new ArrayList();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean existeUsuario;
        String usuario = "";
        String contrasena = "";
        System.out.println("Cargando sistema... ");
        cargarUsuarios();
        
       do{
        System.out.println("-------------------------Inicio de sesion-----------------------");
        System.out.println("Usuario:");
        usuario = sc.nextLine();
        System.out.println("Contraseña");
        contrasena = sc.nextLine();
        existeUsuario = validarCredenciales(usuario, contrasena);
        if (existeUsuario) {
            System.out.println("existe el usuario");
            //cargarCita();
            menu(usuario,contrasena);

        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
       
       }while(existeUsuario==false);

    }

    public static void cargarUsuarios() {

        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }

        usuarios.add(new Usuario(1, "carlos", "1234", "Admin"));
        usuarios.add(new Usuario(2, "sofia", "1234", "Medico"));
        usuarios.add(new Usuario(2, "ithan", "0000", "Admin"));
        usuarios.add(new Usuario(2, "alfredo", "0000", "Medico"));
        System.out.println("Los usuarios han sido cargados: " + usuarios.size());

    }

    public static boolean validarCredenciales(String usuario, String contrasena) {
        return usuarios.stream().anyMatch(x -> x.getNombre().equals(usuario) && x.getContrasena().equals(contrasena));
    }
    
       public static boolean validarRol(String usuario, String contrasena) {
        return usuarios.stream().anyMatch(x -> x.getNombre().equals(usuario) &&
                x.getContrasena().equals(contrasena) && x.getRol() == "Admin");
    }
       
      public static boolean validarMedico(String medico, String especialidad) {
        return medicos.stream().anyMatch(x -> x.getNombre().equals(medico) && 
                x.getEspecialida().equals(especialidad));
    }
      
       public static boolean validarPaciente(String Paciente, String Medico) {
        return pacientes.stream().anyMatch(x -> x.getNombre().equals(Paciente) && 
                x.getNombreDoctor().equals(Medico));
    }
       
       
       
       public static void altaMedico(){
           
             if (medicos == null) {
            medicos = new ArrayList<>();
        }

           
        System.out.println("Inserte el Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Inserte el especialidad:");
        String especialidad = sc.nextLine();
        
       int id = medicos.size()+1;
           System.out.println(id+nombre+especialidad);
           medicos.add(new Medico(id+1,nombre,especialidad));
           System.out.println("se a agregado correctamente");
           System.out.println("se ha añadido el doctor: "+medicos.get(id-1).getNombre());
       }

       
         public static void altaPaciente(){
           
             if (pacientes == null) {
            pacientes = new ArrayList<>();
        }

           
        System.out.println("Inserte el Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Inserte nombre del doctor");
        String doctor = sc.nextLine();
        
       int id = pacientes.size()+1;
           System.out.println(id+nombre+doctor);
           pacientes.add(new Paciente(id,nombre,doctor));
           System.out.println("se a agregado correctamente");
           System.out.println(pacientes.get(id-1).getNombre());
       }
       
       
       
    public static void menu(String usuario, String contrasena) {
        Integer opcion = -1;
       boolean isAdmin = validarRol(usuario,contrasena);
        
        if (isAdmin){
            while (opcion != 0) {
            Scanner opcionScanner = new Scanner(System.in);
            System.out.println("1.-Dar de alta a medico\n"
                    + "2.-Dar de alta a un paciente\n"
                    + "3.Ver las citas de todos los medicos\n"
                    + "4.-Ver las citas por nombre del medico\n"
                    + "5.-Crear cita\n"
                    + "6.-ver todas las citas\n"
                    + "7.-Guardar\n"
                    + "0.-Salir");
            System.out.println("Opción:");
            opcion = opcionScanner.nextInt();

            switch (opcion) {
                case 1:
                    altaMedico();
                    break;
                case 2:
                    altaPaciente();
                    break;
                case 3:
                    imprimirTodasCitas();
                    break;
                case 4:
                    //Pendiente
                    Collections.sort(citas);
                    for (Cita elemento: citas){
                        System.out.println(elemento);
                    }
                    break;
                case 5:
                    crearCita();
                    break;
                case 6:
                   imprimirTodasCitas();
                    break;
                case 7:
                    save();
                    break;
                case 8:
                    save();
                    break;

            }
        }
            
        }else{
            
               while (opcion != 0) {
            Scanner opcionScanner = new Scanner(System.in);
            System.out.println( "1.-Dar de alta a un paciente\n"
                    + "2.Ver las citas de todos los medicos\n"
                    + "3.-Ver las citas por nombre del medico\n"
                    + "4.-Crear cita\n"
                    + "5.-ver todas las citas\n"
                    + "6.-Guardar\n"
                    + "0.-Salir");
            System.out.println("Opción:");
            opcion = opcionScanner.nextInt();

            switch (opcion) {
                case 7:
                    crearCita();
                    break;
                case 8:
                    imprimirTodasCitas();
                    break;
                case 9:
                    save();
                    break;

            }
        }
            
        }
        
        
        
        

    }
    
    
     Comparator<String> alfabetica= new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.charAt(0), o2.charAt(0));
            }
        };


    public static void save() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCitas = mapper.writeValueAsString(citas);
            String jsonPacientes = mapper.writeValueAsString(pacientes);
            String jsonMedicos = mapper.writeValueAsString(medicos);
            
          
            
            System.out.println(jsonCitas);
            String ruta = "citas.json";

            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(jsonCitas);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error->" + e.getMessage());
        }

        /*Guardar variable*/
    }

    public static void cargarCita() throws IOException {
        String json = leerArchivo();
        Gson gson = new Gson();
        Cita[] cita = gson.fromJson(json, Cita[].class);
        //citas.add(cita);
        //System.out.println("nombre del paciente:" + cita.getPaciente().getNombre());
        for (Cita temp : cita) {
            citas.add(temp);
        }
        System.out.println("Hola mundo");
    }

    public static void imprimirTodasCitas() {
       
        for (Cita cita : citas) {
            System.out.println("---------------------------------------------------");
            System.out.println("Nombre cita:" + cita.getNombreCita());
            System.out.println("Nombre paciente:" + cita.getNombrePaciente());
            System.out.println("Nombre medico:" + cita.getNombreMedico());
        }
    }
    
    
    Comparator<String> alfabeticaLambda = (String o1, String o2)
                -> Integer.compare(o1.charAt(0), o2.charAt(0));
    

    public static void crearCita() {
        
        
        int id = citas.size() +1;
        String nombre;
         String fecha;
         String nombreMedico;
         String Especialidad ;
         String nombrePaciente;
       
        do{
        System.out.println("Inserte el nombre de la cita:");
         nombre = sc.nextLine();
        System.out.println("Inserte fecha de la cita:");
         fecha = sc.nextLine();
        
         System.out.println("Inserte el nombre del medico");
         nombreMedico = sc.nextLine();
        System.out.println("Inserte especialidad:");
         Especialidad = sc.nextLine();
       
        
        
        System.out.println("Inserte el nombre del Paciente");
        nombrePaciente = sc.nextLine();
            System.out.println("Medico"+ validarMedico(nombreMedico,Especialidad));
            System.out.println("Paciente"+ validarPaciente(nombrePaciente,nombreMedico));
        
        }while(validarMedico(nombreMedico,Especialidad)==false && 
                validarPaciente(nombrePaciente, nombreMedico)== false);
        
        Cita cita = new Cita(id, nombre, fecha, nombreMedico, Especialidad, nombrePaciente );
        //save(cita);
        citas.add(cita);
    }

      
    
    public static String leerArchivo() throws IOException {
        String archivo = "citas.json";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        StringBuilder json = new StringBuilder();
        String cadena;
        while ((cadena = b.readLine()) != null) {
            json.append(cadena);
        }
        b.close();
        return json.toString();
    }

}
