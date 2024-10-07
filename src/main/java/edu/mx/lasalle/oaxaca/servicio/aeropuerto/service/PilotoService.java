
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PilotoModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PilotoService {
    public void registrarPiloto(PilotoModel pilotoModel);
    public List obtenerPiloto();
    public PilotoModel getPiloto(int id);
    public void actualizarDatosPiloto(PilotoModel pilotoModel, int id);
    public void borrarPiloto(int id);
    public void borrarTodosLosPilotos();    
    
}
