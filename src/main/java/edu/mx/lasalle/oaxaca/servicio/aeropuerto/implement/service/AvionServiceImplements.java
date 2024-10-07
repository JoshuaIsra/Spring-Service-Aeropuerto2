
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.AvionRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AvionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionServiceImplements implements AvionService{
    @Autowired
    public AvionRepository avionRepository;
    
    @Override
    public void registrarAvion(AvionModel avionModel) {
        avionRepository.save(avionModel);
    }

    @Override
    public List obtenerAvion() {
        return avionRepository.findAll();
    }

    @Override
    public AvionModel getAvion(int id) {
        return avionRepository.findById(id);
    }

    @Override
    public void actualizarDatosAvion(AvionModel avionModel, int id) {
       avionModel.setId(id);
       avionRepository.save(avionModel);        
    }

    @Override
    public void borrarAvion(int id) {
        avionRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosAvion() {
      avionRepository.deleteAll();
    }
    
}
