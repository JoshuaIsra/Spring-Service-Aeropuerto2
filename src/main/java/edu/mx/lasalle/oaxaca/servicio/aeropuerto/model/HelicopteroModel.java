package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HELICOPTERO")
public class HelicopteroModel extends VehiculoAereoModel {

    private String helices;
    private String tipo;

    public HelicopteroModel() {}

    public HelicopteroModel(int id, String modelo, String serie, String capacidad, String color, boolean estado, String antiguedad,
                            String tiempoAire, String llantas, String tanque, double distancia, String helices, String tipo) {
        super(id, modelo, serie, capacidad, color, estado, antiguedad, tiempoAire, llantas, tanque, distancia);
        this.helices = helices;
        this.tipo = tipo;
    }

    
    public String getHelices() {
        return helices;
    }

    public void setHelices(String helices) {
        this.helices = helices;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "HelicopteroModel{" +
                "helices='" + helices + '\'' +
                ", tipo='" + tipo + '\'' +
                ", " + super.toString() +
                '}';
    }
}
