
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.SobrecargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SobreCargoRepository extends JpaRepository<SobrecargoModel, Integer>{
    public SobrecargoModel findById (int  id);
    
}
