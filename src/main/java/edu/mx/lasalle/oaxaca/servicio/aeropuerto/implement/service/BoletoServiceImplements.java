
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.BoletoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.BoletoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.BoletoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletoServiceImplements implements BoletoService{
    @Autowired
    public BoletoRepository boletoRepository;
    @Override
    public void registrarBoleto(BoletoModel boletoModel) {
        boletoRepository.save(boletoModel);
    }

    @Override
    public List obtenerBoleto() {
        return boletoRepository.findAll();
    }

    @Override
    public BoletoModel getBoleto(int id) {
        return boletoRepository.findById(id);
    }

    @Override
    public void actualizarDatosBoleto(BoletoModel boletoModel, int id) {
        boletoModel.setId(id);
        boletoRepository.save(boletoModel);
    }

    @Override
    public void borrarBoleto(int id) {
        boletoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLasBoletos() {
        boletoRepository.deleteAll();
    }
    
}
