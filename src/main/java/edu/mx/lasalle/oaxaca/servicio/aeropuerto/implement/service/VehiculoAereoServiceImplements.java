package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VehiculoAereoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.VehiculoAereoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.VehiculoAereoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoAereoServiceImplements implements VehiculoAereoService{

    @Autowired
    private VehiculoAereoRepository vehiculoAereoRepository;
    @Override
    public void registrarVehiculoAereo(VehiculoAereoModel vehiculoAereoModel) {
        vehiculoAereoRepository.save(vehiculoAereoModel);
    }

    @Override
    public List obtenerVehiculoAereo() {
        return vehiculoAereoRepository.findAll();
    }

    @Override
    public VehiculoAereoModel getVehiculoAereo(int id) {
        return vehiculoAereoRepository.findById(id);
    }

    @Override
    public void actualizarDatosVehiculoAereo(VehiculoAereoModel vehiculoAereoModel, int id) {
        vehiculoAereoModel.setId(id);
        vehiculoAereoRepository.save(vehiculoAereoModel);
    }

    @Override
    public void borrarVehiculoAereo(int id) {
       vehiculoAereoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosVehiculoAereo() {
       vehiculoAereoRepository.deleteAll();
    }
    
}
