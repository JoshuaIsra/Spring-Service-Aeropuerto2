
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.HelicopteroModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.HelicopteroRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.HelicopteroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class HelicopteroServiceImplements implements HelicopteroService {
    @Autowired
    public HelicopteroRepository helicopteroRepository;
    @Override
    public void registrarHelicoptero(HelicopteroModel helicopteroModel) {
        helicopteroRepository.save(helicopteroModel);
    }

    @Override
    public List obtenerHelicopteros() {
        return helicopteroRepository.findAll();
    }

    @Override
    public HelicopteroModel getHelicoptero(int id) {
         return helicopteroRepository.findById(id);
    }

    @Override
    public void actualizarDatosHelicoptero(HelicopteroModel helicopteroModel, int id) {
       helicopteroModel.setId(id);
       helicopteroRepository.save(helicopteroModel);
    }

    @Override
    public void borrarHelicoptero(int id) {
       helicopteroRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosHelicoptero() {
        helicopteroRepository.deleteAll();
    }
    
}
