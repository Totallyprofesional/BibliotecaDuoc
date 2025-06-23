/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaduoc;

import bibliotecaduoc.exceptions.NoNombreException;
import bibliotecaduoc.exceptions.NoMateriaException;
import bibliotecaduoc.exceptions.NoUsuarioException; 
import bibliotecaduoc.managers.DuocManager;
import bibliotecaduoc.models.libros.Libros;
import bibliotecaduoc.models.usuarios.CuentaUsuario;
import bibliotecaduoc.models.usuarios.Usuario;
import bibliotecaduoc.utils.LibrosUtils;

import java.util.ArrayList;
import java.util.InputMismatchException; 
import java.util.List; 
import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;
 
public class Menu {
    private Scanner sc;  
    private DuocManager duocManager; 
    private Usuario usuarioActual;
    private CuentaUsuario cuentaActual;  
    private List<Libros> libros = LibrosUtils.listaLibros();
    private List<Libros> prestamo = LibrosUtils.listaLibros();

    public Menu(Scanner sc, DuocManager duocManager, Usuario usuarioActual, CuentaUsuario cuentaActual) {
        this.sc = sc;
        this.duocManager = duocManager;
        this.usuarioActual = usuarioActual;
        this.cuentaActual = cuentaActual; 
    }
    
    public void mostrarMenu() throws NoNombreException, NoMateriaException, NoUsuarioException {
        int opcion = 0;
        
        do { 
            System.out.println("\n Biblioteca digital Duoc");
            System.out.println("");          
            System.out.println("1) Registrar usuario");           
            System.out.println("2) RetiroLibros");
            System.out.println("3) Lista de Libros");
            System.out.println("4) Buscar libros por nombre");
            System.out.println("5) Buscar libros por materia");
            System.out.println("6) Buscar libros por nombre y materia");
            System.out.println("7) Mostrar libros por nombre único");
            System.out.println("8) Listar libros por orden");
            System.out.println("9) Salir");
            
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                 
                switch (opcion) {
                    case 1: 
                        Registrar(sc);
                        break;
                    case 2:
                        IngresoUsuario(sc);
                        RetiroLibros(sc);
                        break;
                    case 3: 
                        MostrarLista();
                        break; 
                    case 4: 
                        NombreLibros(sc);
                        break; 
                    case 5:
                        MateriaLibros(sc);
                        break; 
                    case 6:
                        NombreMateriaLibros(sc); 
                        break;  
                    case 7:
                        LibrosUnicos(sc);
                        break;  
                    case 8:
                        LibrosOrdenados(sc);
                        break;  
                    case 9:
                        System.out.println("Fin del programa");
                        System.exit(0);
                        break;
                }           
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar una opción válida");
                sc.nextLine(); 
            }
            
        } while (opcion != 8);        
    }
    
    private void Registrar (Scanner sc) throws NoUsuarioException { 
        System.out.println("\n Registro de usuario");
        System.out.print("Ingrese rut (con guión y puntos): "); 
        String rut = sc.nextLine();
        
        if (duocManager.buscarUsuario(rut) != null) {
            System.out.println("Error: Ya existe un usuario con ese RUT");
            return;
        } 
        
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido paterno: ");
        String apellidoPaterno = sc.nextLine();
        System.out.print("Ingrese apellido materno: ");
        String apellidoMaterno = sc.nextLine();
        System.out.print("Ingrese teléfono: ");
        int teléfono = sc.nextInt();
          
        try {      
            Usuario nuevoUsuario = new Usuario (rut, nombre, apellidoPaterno, apellidoMaterno, teléfono);      
            
            if (nuevoUsuario.registrarUsuario() && duocManager.agregarUsuario (nuevoUsuario)) {         
                usuarioActual = nuevoUsuario;              
                usuarioActual.mostrarDatos();              
            }   
              
            } catch (IllegalArgumentException e) { 
                System.out.println("Error: " + e.getMessage());          
        }  
        
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    }
    
    private void IngresoUsuario (Scanner sc) throws NoUsuarioException {
        System.out.print("Ingrese RUT del cliente: ");
        String rut = sc.nextLine();
        
        Usuario UsuarioActual = duocManager.buscarUsuario(rut); 
        
        if (UsuarioActual != null) { 
            System.out.println("Perfil de usuario:"); 
            UsuarioActual.mostrarDatos();
            cuentaActual.infoPrestamos();
        } else {
            System.out.println("RUT no encontrado"); 
        }      
    }
        
    private void RetiroLibros (Scanner sc) throws NoNombreException {
        MostrarLista();
         
        try { 
            System.out.println("\n Ingrese libro a retirar: ");         
            String retiro = sc.nextLine();
            Libros.prestamoLibros(libros, prestamo, retiro);
            System.out.println("El libro" + retiro + " ha sido retirado"); 
            
        } catch (InputMismatchException e) {
            System.out.println("Nombre inválido");
        } 
        
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    }
    
    private void DevolverLibros (Scanner sc) throws NoNombreException {
        for (Libros prestamo: libros) {
        System.out.println(libros);
        }
         
        try { 
            System.out.println("\n Ingrese libro a devolver: ");         
            String devolver = sc.nextLine();
            Libros.devolucionLibros(libros, prestamo, devolver);
            System.out.println("El libro" + devolver + " ha sido retirado"); 
            
        } catch (InputMismatchException e) {
            System.out.println("Nombre inválido");
        } 
    }
   
    private void  MostrarLista () {
        System.out.println("\n Lista de libros");
        System.out.println("");
        for (Libros libro : libros) {
            System.out.println((libros.indexOf(libro) + 1) + ". " + libro.mostrarLibro());
        }
        
        // Hashset
        Libros.CatalogoLibros(libros);
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    }
    
    private void  NombreLibros (Scanner sc) {
        System.out.println("Ingrese nombre del libro: ");
        String nombre = sc.nextLine(); 
        
        try {
            Libros libro = Libros.buscarPorNombre(libros, nombre);
            System.out.println("Libro encontrado: ");
            System.out.println(libro.mostrarLibro());
        } catch (NoNombreException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    }
    
    private void MateriaLibros (Scanner sc) {
        System.out.println("Ingrese nombre de la materia: ");
        String materia = sc.nextLine(); 
         
        try {
            List<Libros> busqueda = Libros.buscarPorMateria(libros, materia);
            System.out.println("\n Libro encontrado");
            for (Libros libro : busqueda) {
                System.out.println(libro.mostrarLibro());
            }
        } catch (NoMateriaException e) { 
            System.out.println("Error: " + e.getMessage());
        }    
        
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    } 
     
    private void  NombreMateriaLibros (Scanner sc) throws NoNombreException, NoMateriaException {    
        System.out.println("Ingrese nombre del libro");
        String nombre = sc.nextLine();
        System.out.println("Ingrese nombre de la materia: ");
        String materia = sc.nextLine();
        
        try {
            Libros libro = Libros.buscarPorNombreyMateria(libros, nombre, materia);
            System.out.println("\n Libro encontrado"); 
            System.out.println(libro.mostrarLibro());            
        } catch (NoNombreException e) { 
            System.out.println("Error: " + e.getMessage()); 
        }   
        
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    } 
    
        private void LibrosUnicos(Scanner sc) {
        System.out.println("\n Lista libros por nombre único");
        HashSet<Libros> librosUnicos = Libros.CatalogoLibros(libros);
        for (Libros libro : librosUnicos) {
            System.out.println(libro.mostrarLibro());
        }
        
        // Input para volver al menú
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    }
    
    private void LibrosOrdenados(Scanner sc) {
        System.out.println("\n Libros por orden");
        TreeSet<Libros> librosOrdenados = new TreeSet<>(libros);
        for (Libros libro : librosOrdenados) { 
            System.out.println(libro.mostrarLibro());
        }
         
        System.out.println("Presione enter para continuar ...");
        sc.nextLine();
    }
    
}