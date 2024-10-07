
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PilotoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.PilotoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.PilotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotoServiceImplements implements PilotoService{
    
    @Autowired
    private PilotoRepository pilotoRepository;
    @Override
    public void registrarPiloto(PilotoModel pilotoModel) {
        pilotoRepository.save(pilotoModel);
    }

    @Override
    public List obtenerPiloto() {
        return pilotoRepository.findAll();
    }

    @Override
    public PilotoModel getPiloto(int id) {
        return pilotoRepository.findById(id);
    }

    @Override
    public void actualizarDatosPiloto(PilotoModel pilotoModel, int id) {
       pilotoModel.setId(id);
       pilotoRepository.save(pilotoModel);
    }

    @Override
    public void borrarPiloto(int id) {
        pilotoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosPilotos() {
        pilotoRepository.deleteAll();
    }
    
}
