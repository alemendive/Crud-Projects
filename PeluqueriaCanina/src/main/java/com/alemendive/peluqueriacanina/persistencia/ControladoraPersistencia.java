
package com.alemendive.peluqueriacanina.persistencia;

import com.alemendive.peluqueriacanina.logica.Duenio;
import com.alemendive.peluqueriacanina.logica.Mascota;
import com.alemendive.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        
        //crear en la BD el dueño
        duenioJpa.create(duenio);
        
        //crear en la BD la mascota
        mascoJpa.create(masco);
        
    } 

    public List<Mascota> traerMascotas() {       
        return mascoJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Mascota traerMascota(int num_cliente) {
       return mascoJpa.findMascota(num_cliente);  
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }
   
    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
