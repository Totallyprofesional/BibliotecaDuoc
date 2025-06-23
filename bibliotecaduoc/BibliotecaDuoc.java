/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecaduoc;

import bibliotecaduoc.exceptions.NoMateriaException;
import bibliotecaduoc.exceptions.NoNombreException;
import bibliotecaduoc.exceptions.NoUsuarioException;
import bibliotecaduoc.managers.DuocManager; 
import bibliotecaduoc.managers.DuocManager;
import bibliotecaduoc.models.libros.Libros;
import bibliotecaduoc.models.usuarios.CuentaUsuario;
import bibliotecaduoc.models.usuarios.Usuario;
import java.util.List;
import java.util.Scanner;

public class BibliotecaDuoc {
    public static Scanner sc = new Scanner(System.in); 
    public static DuocManager duocManager; 
    public static Usuario usuarioActual;
    public static CuentaUsuario cuentaActual;  
  
    public static void main(String[] args) throws NoNombreException, NoMateriaException, NoUsuarioException {
        System.out.println("Menú de Biblioteca Duoc");
        
        Menu menu = new Menu (sc, duocManager, usuarioActual, cuentaActual);
        menu.mostrarMenu(); 
    }     
}   
   