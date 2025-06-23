/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaduoc.utils;

import bibliotecaduoc.models.libros.Libros;
import java.util.ArrayList;
import java.util.List;

public class LibrosUtils {
    public static List<Libros> listaLibros() {
        List<Libros> libros = new ArrayList<>();
        
        libros.add(new Libros ("Java for dummies", "Programación", "Burd, Barry", 2022));
        libros.add(new Libros ("Java 17 : fundamentos prácticos de programación", "Programación", "Vegas Gertrudix, José María", 2022));
        libros.add(new Libros ("El programador pragmático : viaje a la maestría", "Programación", "Thomas, David y Hunt, Andrew", 2022));
        libros.add(new Libros ("Programación orientada a objetos en Java: Buenas prácticas", "Programación", "Hernández Bejarano, Miguel y Baquero Rey, Luis Eduardo", 2023));
        
        return libros; 
    }
} 
  