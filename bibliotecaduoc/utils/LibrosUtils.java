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
        
        libros.add(new Libros ("Java for dummies", "Programaci�n", "Burd, Barry", 2022));
        libros.add(new Libros ("Java 17 : fundamentos pr�cticos de programaci�n", "Programaci�n", "Vegas Gertrudix, Jos� Mar�a", 2022));
        libros.add(new Libros ("El programador pragm�tico : viaje a la maestr�a", "Programaci�n", "Thomas, David y Hunt, Andrew", 2022));
        libros.add(new Libros ("Programaci�n orientada a objetos en Java: Buenas pr�cticas", "Programaci�n", "Hern�ndez Bejarano, Miguel y Baquero Rey, Luis Eduardo", 2023));
        
        return libros; 
    }
} 
  