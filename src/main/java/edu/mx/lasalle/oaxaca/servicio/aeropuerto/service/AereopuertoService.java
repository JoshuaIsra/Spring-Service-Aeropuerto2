
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AereopuertoModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AereopuertoService {
    public void registrarAereopuerto(AereopuertoModel aereopuertoModel);
    public List obtenerAereopuerto();
    public AereopuertoModel getAereopuerto(int id);
    public void actualizarDatosAereopuerto(AereopuertoModel aereopuertoModel, int id);
    public void borrarAereopuerto(int id);
    public void borrarAereopuerto();
    
}
