
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionetaModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AvionetaService {
    
    public void registrarAvioneta(AvionetaModel avionetaModel);
    public List obtenerAvioneta();
    public AvionetaModel getAvioneta(int id);
    public void actualizarDatosAvioneta(AvionetaModel avionetaModel, int id);
    public void borrarAvioneta(int id);
    public void borrarTodosLasAvionetas();
    
}
