
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TerminalModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.TerminalRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.TerminalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalServiceImplements implements TerminalService {
    @Autowired
    private TerminalRepository terminalRepository;
    
    @Override
    public void registrarTerminal(TerminalModel terminalModel) {
         terminalRepository.save(terminalModel);
    }
    @Override
    public List obtenerTerminal() {
        return terminalRepository.findAll();
    }

    @Override
    public TerminalModel getTerminal(int id) {
        return terminalRepository.findById(id);
    }

    @Override
    public void actualizarDatosTerminal(TerminalModel terminalModel, int id) {
       terminalModel.setClaveTerminal(id);
       terminalRepository.save(terminalModel);
    }

    @Override
    public void borrarTerminal(int id) {
    terminalRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLasTerminales() {
         terminalRepository.deleteAll();
    }
    
}
