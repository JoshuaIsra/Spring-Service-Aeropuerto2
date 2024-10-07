package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("PILOTO")

public class PilotoModel extends TripulacionModel{

    private String rango;
    private String licencia;
    private String tipoAeronaves;
    private String saludMental;

    public PilotoModel() {}

    public PilotoModel(int id, double antiguedad, String turno, double horasVuelo, String nombre, String apellido,
                       Date fechaNacimiento, String genero, String rango, String licencia, String tipoAeronaves,
                       String saludMental) {
        super(id, antiguedad, turno, horasVuelo, nombre, apellido, fechaNacimiento, genero);
        this.rango = rango;
        this.licencia = licencia;
        this.tipoAeronaves = tipoAeronaves;
        this.saludMental = saludMental;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTipoAeronaves() {
        return tipoAeronaves;
    }

    public void setTipoAeronaves(String tipoAeronaves) {
        this.tipoAeronaves = tipoAeronaves;
    }

    public String getSaludMental() {
        return saludMental;
    }

    public void setSaludMental(String saludMental) {
        this.saludMental = saludMental;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "rango='" + rango + '\'' +
                ", licencia='" + licencia + '\'' +
                ", tipoAeronaves='" + tipoAeronaves + '\'' +
                ", saludMental='" + saludMental + '\'' +
                ", " + super.toString() +
                '}';
    }
}
