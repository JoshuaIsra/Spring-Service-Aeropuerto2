
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.CopilotoModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CopilotoService {
    
    public void registrarCopiloto(CopilotoModel copilotoModel);
    public List obtenerCopiloto();
    public CopilotoModel getCopiloto(int id);
    public void actualizarDatosCopiloto(CopilotoModel copilotoModel, int id);
    public void borrarCopiloto(int id);
    public void borrarTodosLosCopilotos();
    
}
