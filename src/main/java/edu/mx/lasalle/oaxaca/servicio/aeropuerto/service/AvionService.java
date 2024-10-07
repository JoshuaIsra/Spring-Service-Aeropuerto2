
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AvionService {
    public void registrarAvion(AvionModel avionModel);
    public List obtenerAvion();
    public AvionModel getAvion(int id);
    public void actualizarDatosAvion(AvionModel avionModel, int id);
    public void borrarAvion(int id);
    public void borrarTodosLosAvion();    
}
