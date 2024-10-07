package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.EquipajeModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.EquipajeRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.EquipajeService;


@Service
public class EquipajeServiceImplements implements EquipajeService{

     @Autowired
    private EquipajeRepository equipajeRepository;
    @Override
    public void registrarEquipaje(EquipajeModel equipajeModel) {
       equipajeRepository.save(equipajeModel);
    }

    @Override
    public EquipajeModel getEquipaje(int id) {
        return equipajeRepository.findById(id);
    }

    @Override
    public void actualizarDatosEquipaje(EquipajeModel equipajeModel, int id) {
        equipajeModel.setId(id);
       equipajeRepository.save(equipajeModel);
    }

    @Override
    public void borrarEquipaje(int id) {
        equipajeRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosEquipajes() {
        equipajeRepository.deleteAll();
    }

    @Override
    public List obtenerEquipaje() {
         return equipajeRepository.findAll();
    }
    
}
