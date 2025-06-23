/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaduoc.models.usuarios;

public class CuentaUsuario { 
    int contadorPrestamos = 0;  
    int contadorMultas = 0; 
    int Multa = 0;
    int prestamos;
    int multas;
    int totalMulta;

    public CuentaUsuario(int prestamos, int multas, int totalMulta) {
        this.prestamos = contadorPrestamos;
        this.multas = contadorMultas; 
        this.totalMulta = (Multa + 5000) * contadorMultas;
    }

    public int getContadorPrestamos() { 
        return contadorPrestamos;
    }

    public int getContadorMultas() {
        return contadorMultas;
    }

    public int getMulta() {
        return Multa;
    }

    public int getPrestamos() {
        return prestamos;
    }

    public int getMultas() { 
        return multas;
    }

    public int getTotalMulta() {
        return totalMulta;
    }
    
    public void infoPrestamos (){
        if (getPrestamos() == 0){
            System.out.println("No se registran prestamos");
        } else{
            System.out.println("Numero de prestamos: " + getPrestamos());
        }
        
        if (getMultas() == 0){
            System.out.println("No se registran multas");
        } else {
            System.out.println("Numero de multas: " + getMultas());
            System.out.println("Total de multas: $" + getTotalMulta());
        }  
    }
    
}