
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VueloModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface VueloService {
    public void registrarVuelo(VueloModel vueloModel);
    public List obtenerVuelo();
    public VueloModel getVuelo(int id);
    public void actualizarDatosVuelo(VueloModel vueloModel, int id);
    public void borrarVuelo(int id);
    public void borrarTodosLosVuelos();
}
