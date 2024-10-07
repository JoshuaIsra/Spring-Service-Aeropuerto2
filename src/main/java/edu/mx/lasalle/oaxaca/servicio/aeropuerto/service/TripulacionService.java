
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TripulacionModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TripulacionService {
    
    public void registrarTripulacion(TripulacionModel tripulacionModel);
    public List obtenerTripulacion();
    public TripulacionModel getTripulacion(int id);
    public void actualizarDatosTripulacion(TripulacionModel tripulacionModel, int id);
    public void borrarTripulacion(int id);
    public void borrarTodosLaTripulacion();
}
