/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaduoc.models.usuarios;

public class CuentaUsuario {  
    private int prestamos; 
     
    public CuentaUsuario(int prestamos) {
        this.prestamos = prestamos; 
    } 
     
    public void Contador (){ 
        this.prestamos += 1; 
    }
    
    public void Reset (){
        this.prestamos -= 1; 
    }
        
    public void infoPrestamos (){
        getprestamos();
        
        if (getprestamos() == 0){
            System.out.println("No se registran prestamos");
        } else{
            System.out.println("Numero de prestamos: " + getprestamos());
        } 
    }

    public int getprestamos() {
        return prestamos;
    }
    
}