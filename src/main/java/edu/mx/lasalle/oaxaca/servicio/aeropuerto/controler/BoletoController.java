

package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controler;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.BoletoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.BoletoService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/vl/Boleto")
public class BoletoController {
  
    @Autowired 
    private BoletoService boletoService;

    @PostMapping("/registro")
    public CustomResponse registrarBoleto(@RequestBody BoletoModel boletoModel){
        CustomResponse customResponse = new CustomResponse();
        boletoService.registrarBoleto(boletoModel);
                customResponse.setHhtpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMassege("Boleto Registrado Correctamente");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<BoletoModel>> getAllBoletos(){
        List<BoletoModel> boletos = boletoService.obtenerBoleto();
        if (boletos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(boletos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBoleto(@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponse(HttpStatus.OK, boletoService.getBoleto(id), "Show all matches", 200)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, boletoService.getBoleto(id), "ERROR: " + e, 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateBoleto(
            @RequestBody BoletoModel boletoModel,
            @PathVariable(value = "id") int id){
        CustomResponse customResponse = new CustomResponse();
        try {
            if (boletoService.getBoleto(id) ==null){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, null, "This action can't execute, not found with id = " + id, 204)
                );
            }
            boletoService.actualizarDatosBoleto(boletoModel, id);
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
    public ResponseEntity<Object> deleteBoleto(@PathVariable int id){
        CustomResponse customResponse = new CustomResponse();
        try {
            boletoService.borrarBoleto(id);
            customResponse.setHhtpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMassege("Delete Success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMassege("Error: " + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}

