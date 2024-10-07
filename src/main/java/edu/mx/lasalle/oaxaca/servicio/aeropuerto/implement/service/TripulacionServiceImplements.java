
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TripulacionModel;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.TripulacionRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.TripulacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TripulacionServiceImplements implements TripulacionService {
    @Autowired
    private TripulacionRepository tripulacionRepository;

    @Override
    public void registrarTripulacion(TripulacionModel tripulacionModel) {
        tripulacionRepository.save(tripulacionModel);
    }

    @Override
    public List<TripulacionModel> obtenerTripulacion() {
        return tripulacionRepository.findAll();
    }

    @Override
    public TripulacionModel getTripulacion(int id) {
            return tripulacionRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarDatosTripulacion(TripulacionModel tripulacionModel, int id) {
        tripulacionModel.setId(id);
        tripulacionRepository.save(tripulacionModel);
    }

    @Override
    public void borrarTripulacion(int id) {
        tripulacionRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLaTripulacion() {
        tripulacionRepository.deleteAll();
    }
    
}
