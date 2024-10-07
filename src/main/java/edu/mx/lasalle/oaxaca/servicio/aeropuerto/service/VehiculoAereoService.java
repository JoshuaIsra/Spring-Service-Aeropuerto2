
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VehiculoAereoModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface VehiculoAereoService {
    public void registrarVehiculoAereo(VehiculoAereoModel vehiculoAereoModel);
    public List obtenerVehiculoAereo();
    public VehiculoAereoModel getVehiculoAereo(int id);
    public void actualizarDatosVehiculoAereo(VehiculoAereoModel vehiculoAereoModel, int id);
    public void borrarVehiculoAereo(int id);
    public void borrarTodosLosVehiculoAereo();
}
