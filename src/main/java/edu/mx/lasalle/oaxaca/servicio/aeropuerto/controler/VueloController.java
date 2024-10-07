
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controler;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VueloModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.VueloService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vl/Vuelo")
public class VueloController {
  
    @Autowired 
    private VueloService vueloService; 

    @PostMapping("/registro")
    public CustomResponse registrarVuelo(@RequestBody VueloModel vueloModel){
        CustomResponse customResponse = new CustomResponse();
        vueloService.registrarVuelo(vueloModel);
        customResponse.setHhtpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMassege("Vuelo Registrado Correctamente");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<VueloModel>> getAllVuelos(){
        List<VueloModel> vuelos = vueloService.obtenerVuelo();
        if (vuelos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVuelo(@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponse(HttpStatus.OK, vueloService.getVuelo(id), "Show all matches", 200)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, null, "ERROR: " + e, 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateVuelo(
            @RequestBody VueloModel vueloModel,
            @PathVariable(value = "id") int id){
        CustomResponse customResponse = new CustomResponse();
        try {
            if (vueloService.getVuelo(id)== null){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, null, "This action can't execute, not found with id = " + id, 204)
                );
            }
            vueloService.actualizarDatosVuelo(vueloModel, id);
            customResponse.setHhtpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMassege("Update Success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMassege("Error: "+ e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteVuelo(@PathVariable int id){
        CustomResponse customResponse = new CustomResponse();
        try {
            vueloService.borrarVuelo(id);
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
