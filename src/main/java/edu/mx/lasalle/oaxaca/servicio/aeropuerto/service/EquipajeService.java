
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.EquipajeModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public interface EquipajeService {
    public void registrarEquipaje(EquipajeModel equipajeModel);
    public List obtenerEquipaje();
    public EquipajeModel getEquipaje(int id);
    public void actualizarDatosEquipaje(EquipajeModel equipajeModel, int id);
    public void borrarEquipaje(int id);
    public void borrarTodosLosEquipajes();
}
