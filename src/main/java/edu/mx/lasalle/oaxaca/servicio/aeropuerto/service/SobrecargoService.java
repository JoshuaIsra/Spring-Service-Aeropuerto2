
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.SobrecargoModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SobrecargoService {
    
    public void registrarsobrecargo(SobrecargoModel sobrecargoModel);
    public List obtenersobrecargo();
    public SobrecargoModel getsobrecargo(int id);
    public void actualizarDatossobrecargo(SobrecargoModel sobrecargoModel, int id);
    public void borrarsobrecargo(int id);
    public void borrarTodosLossobrecargo();
    
}
