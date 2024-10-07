
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroModel;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public interface PasajeroService {
    public void registrarPasajero(PasajeroModel pasajeroModel);
    public List obtenerPasajeros();
    public PasajeroModel getPasajero(int id);
    public void actualizarDatosPasajero(PasajeroModel pasajeroModel, int id);
    public void borrarPasajero(int id);
    public void borrarTodosLosPasajero();
    
    
}
