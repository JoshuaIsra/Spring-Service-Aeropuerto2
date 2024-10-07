package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AVION")
public class AvionModel extends VehiculoAereoModel {

    private String aerolinea;
    private String tipoMotor;
    private boolean puertas;
    private String tipo;

    
    public AvionModel() {}

    
    public AvionModel(int id, String modelo, String serie, String capacidad, String color, boolean estado, String antiguedad,
                      String tiempoAire, String llantas, String tanque, double distancia, String aerolinea, String tipoMotor,
                      boolean puertas, String tipo) {
        super(id, modelo, serie, capacidad, color, estado, antiguedad, tiempoAire, llantas, tanque, distancia);
        this.aerolinea = aerolinea;
        this.tipoMotor = tipoMotor;
        this.puertas = puertas;
        this.tipo = tipo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public boolean isPuertas() {
        return puertas;
    }

    public void setPuertas(boolean puertas) {
        this.puertas = puertas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "AvionModel{" +
                "aerolinea='" + aerolinea + '\'' +
                ", tipoMotor='" + tipoMotor + '\'' +
                ", puertas=" + puertas +
                ", tipo='" + tipo + '\'' +
                ", " + super.toString() +
                '}';
    }
}
