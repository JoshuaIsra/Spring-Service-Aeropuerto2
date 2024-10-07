
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controler;


import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AereopuertoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AereopuertoService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vl/aereopuerto")
public class AereopuertoController {
    @Autowired
    private AereopuertoService aereopuertoService;
    
    @PostMapping("/registor")
    public CustomResponse registrarAereopuero(@RequestBody AereopuertoModel aereopuertoModel){
    
        CustomResponse customResponse = new CustomResponse();
        aereopuertoService.registrarAereopuerto(aereopuertoModel);
        customResponse.setHhtpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMassege("Aereopuero Registrado Correctamente");
        return customResponse;
        
    }
    @GetMapping("/registros")
    public ResponseEntity<List<AereopuertoModel>> getAllAereopuero(){
        List<AereopuertoModel> aereopuerto = aereopuertoService.obtenerAereopuerto();
        if (aereopuerto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    
        }
        return new ResponseEntity<>(aereopuerto, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAereopuero (@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, aereopuertoService.getAereopuerto(id), "Show all matches", 200)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, aereopuertoService.getAereopuerto(id),"ERROR: "+e,422)
            );
        }
        
    }
    
    
    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateAereopuerto(
            @RequestBody AereopuertoModel aereopuertoModel,
            @PathVariable(value = "id") int id){
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            if (aereopuertoService.getAereopuerto(id) == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
            new CustomResponse(HttpStatus.NO_CONTENT,
            "","This acction can´t execute, not found with id ="+id, 204)
            );
            };
            
            aereopuertoService.actualizarDatosAereopuerto(aereopuertoModel, id);
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
            aereopuertoService.borrarAereopuerto(id);
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
