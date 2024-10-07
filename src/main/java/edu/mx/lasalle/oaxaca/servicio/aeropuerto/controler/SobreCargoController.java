package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controler;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.SobrecargoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.SobrecargoService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/sobrecargo")
public class SobreCargoController {
    
    @Autowired
    private SobrecargoService sobrecargoService;

        @PostMapping("/registro")
        public CustomResponse registrarSobrecargo(@RequestBody SobrecargoModel sobrecargoModel) {
            CustomResponse customResponse = new CustomResponse();
            sobrecargoService.registrarsobrecargo(sobrecargoModel);
            customResponse.setHhtpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMassege("Sobrecargo Registrado Correctamente");
            return customResponse;
        }

    @GetMapping("/registros")
    public ResponseEntity<List<SobrecargoModel>> getAllSobrecargos() {
        List<SobrecargoModel> sobrecargos = sobrecargoService.obtenersobrecargo();
        if (sobrecargos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sobrecargos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSobrecargo(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, sobrecargoService.getsobrecargo(id), "Show all matches", 200)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, sobrecargoService.getsobrecargo(id), "ERROR: " + e, 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateSobrecargo(@RequestBody SobrecargoModel sobrecargoModel, @PathVariable(value = "id") int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (sobrecargoService.getsobrecargo(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "", "This action can't execute, not found with id = " + id, 204)
                );
            }

            sobrecargoService.actualizarDatossobrecargo(sobrecargoModel, id);
            customResponse.setHhtpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMassege("Update Success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMassege("Error: " + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteSobrecargo(@PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            sobrecargoService.borrarsobrecargo(id);
            customResponse.setHhtpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMassege("Delete Success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMassege(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
