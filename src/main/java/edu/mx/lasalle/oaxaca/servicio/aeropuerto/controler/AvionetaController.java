
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controler;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionetaModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AvionetaService;
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
@RequestMapping("/api/v1/avioneta")
public class AvionetaController {

    @Autowired
    private AvionetaService avionetaService;

    @PostMapping("/registro")
    public CustomResponse registrarAvioneta(@RequestBody AvionetaModel avionetaModel) {
        CustomResponse customResponse = new CustomResponse();
        avionetaService.registrarAvioneta(avionetaModel);
        customResponse.setHhtpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMassege("Avioneta Registrada Correctamente");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<AvionetaModel>> getAllAvionetas() {
        List<AvionetaModel> avionetas = avionetaService.obtenerAvioneta();
        if (avionetas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(avionetas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAvioneta(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, avionetaService.getAvioneta(id), "Show all matches", 200)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, avionetaService.getAvioneta(id), "ERROR: " + e, 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateAvioneta(@RequestBody AvionetaModel avionetaModel, @PathVariable(value = "id") int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (avionetaService.getAvioneta(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "", "This action can't execute, not found with id = " + id, 204)
                );
            }

            avionetaService.actualizarDatosAvioneta(avionetaModel, id);
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
    public ResponseEntity<Object> deleteAvioneta(@PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            avionetaService.borrarAvioneta(id);
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
