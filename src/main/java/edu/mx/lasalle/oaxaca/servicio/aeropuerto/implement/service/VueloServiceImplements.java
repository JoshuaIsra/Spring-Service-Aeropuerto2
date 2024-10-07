
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VueloModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.VueloRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.VueloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloServiceImplements implements VueloService {
    @Autowired
    public VueloRepository vueloRepository;
    
    
    @Override
    public void registrarVuelo(VueloModel vueloModel) {
        vueloRepository.save(vueloModel);
    }

    @Override
    public List obtenerVuelo() {
        return vueloRepository.findAll();
    }

    @Override
    public VueloModel getVuelo(int id) {
        return vueloRepository.findById(id);
    }

    @Override
    public void actualizarDatosVuelo(VueloModel vueloModel, int id) {
       vueloModel.setId(id);
        vueloRepository.save(vueloModel);
    }

    @Override
    public void borrarVuelo(int id) {
        vueloRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosVuelos() {
        vueloRepository.deleteAll();
    }
    
}
