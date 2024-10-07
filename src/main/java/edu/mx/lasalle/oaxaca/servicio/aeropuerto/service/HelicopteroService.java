
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.HelicopteroModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface HelicopteroService {
    public void registrarHelicoptero(HelicopteroModel helicopteroModel);
    public List obtenerHelicopteros();
    public HelicopteroModel getHelicoptero(int id);
    public void actualizarDatosHelicoptero(HelicopteroModel helicopteroModel, int id);
    public void borrarHelicoptero(int id);
    public void borrarTodosLosHelicoptero();
}
