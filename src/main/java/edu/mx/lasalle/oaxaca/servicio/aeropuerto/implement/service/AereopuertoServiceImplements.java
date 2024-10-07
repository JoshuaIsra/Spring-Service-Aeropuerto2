
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AereopuertoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.AereopuertoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AereopuertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AereopuertoServiceImplements implements AereopuertoService{
    @Autowired
    private AereopuertoRepository aereopuertoRepository;

    @Override
    public void registrarAereopuerto(AereopuertoModel aereopuertoModel) {
        aereopuertoRepository.save(aereopuertoModel);
    }

    @Override
    public List obtenerAereopuerto() {
        return aereopuertoRepository.findAll();
    }

    @Override
    public AereopuertoModel getAereopuerto(int id) {
        return aereopuertoRepository.findById(id);
    }

    @Override
    public void actualizarDatosAereopuerto(AereopuertoModel aereopuertoModel, int id) {        
       aereopuertoModel.setId(id);
       aereopuertoRepository.save(aereopuertoModel);
    }

    @Override
    public void borrarAereopuerto(int id) {
        aereopuertoRepository.deleteById(id);
    }

    @Override
    public void borrarAereopuerto() {
         aereopuertoRepository.deleteAll();
    }
    
}
