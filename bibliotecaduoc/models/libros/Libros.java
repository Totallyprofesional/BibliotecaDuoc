/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaduoc.models.libros;

import bibliotecaduoc.exceptions.NoNombreException;
import bibliotecaduoc.exceptions.NoMateriaException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List; 

public class Libros {
    private String nombre;
    private String materia;
    private String autor;
    private int a�o;    

    public Libros(String nombre, String materia, String autor, int a�o) {
        this.nombre = nombre;
        this.materia = materia;
        this.autor = autor;
        this.a�o = a�o;
    }
    
    public String getNombre() {
        return nombre;
    }
 
    public String getMateria() {
        return materia;
    }

    public String getAutor() {
        return autor;
    }

    public int getA�o() {
        return a�o;
    } 
    
    public String mostrarLibro() {
        return nombre + " | " + materia + " | " + autor + " | " + a�o;
    }

     public static Libros buscarPorNombre(List<Libros> libros, String nombre) throws NoNombreException {
        if (libros == null || libros.isEmpty()) {
            throw new NoNombreException("Por favor ingrese un nombre v�lido");
        }            
        
        for (Libros libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(nombre)) {
                return libro;
            }
        }
        throw new NoNombreException ("El libro " + nombre + " no se encuentra");
    }    
           
    public static List<Libros> buscarPorMateria(List<Libros> libros, String materia) throws NoMateriaException {
        if (materia == null || materia.isEmpty()) {
            throw new NoMateriaException("Por favor ingrese un nombre v�lido");
        }
        
        List<Libros> a�adidos = new ArrayList<>();
        for (Libros libro : libros) {  
            if (libro.getMateria().equalsIgnoreCase(materia)) {
                a�adidos.add(libro); 
            } 
        }
        
        if (a�adidos.size() == 0) { 
            throw new NoMateriaException("No hay libros de la materia " + materia);
        }
        return a�adidos;
    }
     
    public static Libros buscarPorNombreyMateria(List<Libros> libros, String nombre, String materia) throws NoNombreException, NoMateriaException {
        Libros libroExiste = buscarPorNombre(libros, nombre);
        List<Libros> a�adidos = buscarPorMateria(libros,materia);
        
        if (libroExiste.getNombre().equalsIgnoreCase(nombre) && libroExiste.getMateria().equalsIgnoreCase(materia)) {
        }
        throw new NoNombreException ("El libro " + nombre + " no se encuentra");    
    } 
     
    public static List<Libros> prestamoLibros(List<Libros> libros, List<Libros> prestamo, String retiro) throws NoNombreException {
        if (retiro == null || retiro.isEmpty()) {
            throw new NoNombreException("Por favor ingrese un nombre v�lido");
        }

        Libros encontrado = null;

        for (Libros libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(retiro)) {
            encontrado = libro;
            break;
            }
        }
 
        if (encontrado != null) {
            libros.remove(encontrado);
            prestamo.add(encontrado);
        } else {
            throw new NoNombreException("El libro " + retiro + " no se encuentra");
        }
        return prestamo;
    }

    public static List<Libros> devolucionLibros(List<Libros> libros, List<Libros> prestamo, String devolver) throws NoNombreException {
    if (devolver == null || devolver.isEmpty()) {
        throw new NoNombreException("Por favor ingrese un nombre v�lido");
    }

    Libros devuelto = null;
  
        for (Libros libro : prestamo) {
            if (libro.getNombre().equalsIgnoreCase(devolver)) {
            devuelto = libro;
            break;
            }
        }

        if (devuelto != null) {
            prestamo.remove(devuelto);
            libros.add(devuelto);
        } else {
            throw new NoNombreException("El libro " + devolver + " no se encuentra");
        }

        return libros;
    }
        
    // Hashset
    public static HashSet<Libros> CatalogoLibros(List<Libros> libros) {
        HashSet<String> nombresUnicos = new HashSet<>();
        HashSet<Libros> librosUnicos = new HashSet<>();
        for (Libros libro : libros) {
            if (nombresUnicos.add(libro.getNombre().toLowerCase())) {
                librosUnicos.add(libro);
            } 
        }
        return librosUnicos;
    } 
} 
    



    

