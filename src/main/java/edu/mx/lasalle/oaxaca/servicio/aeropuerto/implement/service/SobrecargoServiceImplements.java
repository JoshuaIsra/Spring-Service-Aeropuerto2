
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.SobrecargoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.SobreCargoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.SobrecargoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SobrecargoServiceImplements implements SobrecargoService{
    @Autowired
    private SobreCargoRepository sobreCargoRepository; 
    @Override
    public void registrarsobrecargo(SobrecargoModel sobrecargoModel) {
        sobreCargoRepository.save(sobrecargoModel);
    }

    @Override
    public List obtenersobrecargo() {
        return sobreCargoRepository.findAll();
    }

    @Override
    public SobrecargoModel getsobrecargo(int id) {
        return sobreCargoRepository.findById(id);
    }

    @Override
    public void actualizarDatossobrecargo(SobrecargoModel sobrecargoModel, int id) {
       sobrecargoModel.setId(id);
       sobreCargoRepository.save(sobrecargoModel);
    }

    @Override
    public void borrarsobrecargo(int id) {
       sobreCargoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLossobrecargo() {
        sobreCargoRepository.deleteAll();
    }
    
}
