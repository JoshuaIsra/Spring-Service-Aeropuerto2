package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TerminalModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TerminalService {
    public void registrarTerminal(TerminalModel terminalModel);
    public List obtenerTerminal();
    public TerminalModel getTerminal(int id);
    public void actualizarDatosTerminal(TerminalModel terminalModel, int id);
    public void borrarTerminal(int id);
    public void borrarTodosLasTerminales();
}
