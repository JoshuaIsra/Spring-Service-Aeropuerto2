
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils;

import org.springframework.http.HttpStatus;

public class CustomResponse {
    
    private HttpStatus hhtpCode;
    private Object data;
    private Object massege;
    private int code;
    
    public CustomResponse(){
    
    
    }

    public CustomResponse(HttpStatus hhtpCode, Object data, Object massege, int code) {
        this.hhtpCode = hhtpCode;
        this.data = data;
        this.massege = massege;
        this.code = code;
    }
    
    

    public HttpStatus getHhtpCode() {
        return hhtpCode;
    }

    public Object getData() {
        return data;
    }

    public Object getMassege() {
        return massege;
    }

    public int getCode() {
        return code;
    }

    public void setHhtpCode(HttpStatus hhtpCode) {
        this.hhtpCode = hhtpCode;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMassege(Object massege) {
        this.massege = massege;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
}
