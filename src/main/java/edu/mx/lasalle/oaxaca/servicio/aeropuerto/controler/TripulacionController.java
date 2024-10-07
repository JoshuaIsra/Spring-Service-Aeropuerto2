
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controler;


import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TripulacionModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.TripulacionService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import java.util.List;
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


@RestController
@RequestMapping("/api/vl/tripulacion")
public class TripulacionController {
    
    @Autowired
    private TripulacionService tripulacionService;
    @PostMapping("/registor")
    public CustomResponse registrarTripulacion (@RequestBody TripulacionModel tripulacionModel){
    
        CustomResponse customResponse = new CustomResponse();
        tripulacionService.registrarTripulacion(tripulacionModel);
        customResponse.setHhtpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMassege("Pasajero Registrado Correctamente");
        return customResponse;
        
    }
    
    @GetMapping("/registros")
    public ResponseEntity<List<TripulacionModel>> getAllTripulacion(){
        List<TripulacionModel> tripulacion = tripulacionService.obtenerTripulacion();
        if (tripulacion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    
        }
        return new ResponseEntity<>(tripulacion, HttpStatus.OK);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTripulacion (@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, tripulacionService.getTripulacion(id), "Show all matches", 200)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, tripulacionService.getTripulacion(id),"ERROR: "+e,422)
            );
        }
        
    }
    
      @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateTripulacion(
            @RequestBody TripulacionModel tripulacionModel,
            @PathVariable(value = "id") int id){
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            if (tripulacionService.getTripulacion(id) == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
            new CustomResponse(HttpStatus.NO_CONTENT,
            "","This acction can´t execute, not found with id ="+id, 204)
            );
            };
            
            tripulacionService.actualizarDatosTripulacion(tripulacionModel, id);
            customResponse.setHhtpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMassege("Update Success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
            
        } catch (Exception e) {
            customResponse.setMassege("Error: "+ e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
            
        }
    
    

}
    
    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteTripulacion(@PathVariable int id){
    ResponseEntity <Object> responseEntity = null;
    CustomResponse customResponse = new CustomResponse();
        try {
            tripulacionService.borrarTripulacion(id);
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
