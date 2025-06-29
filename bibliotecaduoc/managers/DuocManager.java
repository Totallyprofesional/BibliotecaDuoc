/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaduoc.managers;

import bibliotecaduoc.exceptions.NoUsuarioException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import bibliotecaduoc.models.usuarios.Usuario; 
 
public class DuocManager {
    private Map < String, Usuario > usuarios;
    private static DuocManager instancia;
     
    public DuocManager() {   
        this.usuarios = new HashMap<>(); 
    } 
    
    public static DuocManager getInstancia() {  
        if (instancia == null) {
            instancia = new DuocManager(); 
        }
        return instancia;
    } 
    
    public boolean agregarUsuario (Usuario usuario) {
        if (usuarios.containsKey(usuario.getRut())) {
            return false;
        }
        usuarios.put(usuario.getRut(), usuario);
        return true;
    }
     
    public Usuario obtenerUsuario(String rut) {
        return usuarios.get(rut);
    }
    
    public Usuario buscarUsuario(String rut) throws NoUsuarioException {
        if (usuarios.containsKey(rut)) {
            return usuarios.get(rut);
        }
        throw new NoUsuarioException("Usuario con rut " + rut + " no encontrado");
    }
    
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios.values());
    }
    
}

