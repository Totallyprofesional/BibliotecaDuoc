/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaduoc.models.usuarios;

public class Usuario {
    private String rut;
    private String nombre; 
    private String apellidoPaterno; 
    private String apellidoMaterno;
    private String mail;
    private int tel�fono;    

    public Usuario (String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String mail, int tel�fono) {
        if (!validarRut(rut)) {
            throw new IllegalArgumentException("RUT no v�lido");
        }
        
        this.rut = rut;
        this.nombre = nombre; 
        this.apellidoPaterno = apellidoPaterno; 
        this.apellidoMaterno = apellidoMaterno;
        this.mail = mail;
        this.tel�fono = tel�fono;
    }
    
    private boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        } else {  
        return rut.length() == 12; 
        } 
    }
    
    public boolean registrarUsuario() {       
        if (validarRut(rut)) { 
            System.out.println("\n Usuario registrado correctamente: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
            return true;
        } 
        return false;     
    }
     
    public void mostrarDatos() {
        System.out.println("\n Datos del usuario");
        System.out.println("RUT: " + this.rut);
        System.out.println("Nombre completo: " + nombre + "" + apellidoPaterno + "" + apellidoMaterno);
        System.out.println("Mail: " + this.mail);
        System.out.println("Tel�fono: " + this.tel�fono); 
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut; 
    } 
    
}

