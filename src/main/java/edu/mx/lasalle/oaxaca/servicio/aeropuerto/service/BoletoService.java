
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.BoletoModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BoletoService {
    public void registrarBoleto(BoletoModel boletoModel);
    public List obtenerBoleto();
    public BoletoModel getBoleto(int id);
    public void actualizarDatosBoleto(BoletoModel boletoModel, int id);
    public void borrarBoleto(int id);
    public void borrarTodosLasBoletos();
     
}
