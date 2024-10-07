
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AereopuertoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AereopuertoRepository extends JpaRepository<AereopuertoModel, Integer>{
     public AereopuertoModel findById (int id);
}
