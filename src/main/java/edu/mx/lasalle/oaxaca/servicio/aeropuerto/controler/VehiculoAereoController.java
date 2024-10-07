
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controler;


import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VehiculoAereoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.VehiculoAereoService;
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
@RequestMapping("/api/vl/VehiculoAereo")
public class VehiculoAereoController {
  @Autowired 
  private VehiculoAereoService vehiculoAereoService; 
  
  @PostMapping("/registor")
    public CustomResponse registrarVehiculoAereo (@RequestBody VehiculoAereoModel vehiculoAereoModel){
    
        CustomResponse customResponse = new CustomResponse();
        vehiculoAereoService.registrarVehiculoAereo(vehiculoAereoModel);
        customResponse.setHhtpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMassege("Pasajero Registrado Correctamente");
        return customResponse;
        
    }

    @GetMapping("/registros")
    public ResponseEntity<List<VehiculoAereoModel>> getAllVehiculoAereos(){
        List<VehiculoAereoModel> VehiculoAereo = vehiculoAereoService.obtenerVehiculoAereo();
        if (VehiculoAereo.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    
        }
        return new ResponseEntity<>(VehiculoAereo, HttpStatus.OK);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getVehiculoAereo (@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, vehiculoAereoService.getVehiculoAereo(id), "Show all matches", 200)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, vehiculoAereoService.getVehiculoAereo(id),"ERROR: "+e,422)
            );
        }
        
    }
    
     @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updatevehiculoAereo(
            @RequestBody VehiculoAereoModel vehiculoAereoModel,
            @PathVariable(value = "id") int id){
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            if (vehiculoAereoService.getVehiculoAereo(id) == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
            new CustomResponse(HttpStatus.NO_CONTENT,
            "","This acction can´t execute, not found with id ="+id, 204)
            );
            };
            
            vehiculoAereoService.actualizarDatosVehiculoAereo(vehiculoAereoModel, id);
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
    public ResponseEntity<Object> deletePasajero(@PathVariable int id){
    ResponseEntity <Object> responseEntity = null;
    CustomResponse customResponse = new CustomResponse();
        try {
            vehiculoAereoService.borrarVehiculoAereo(id);
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
