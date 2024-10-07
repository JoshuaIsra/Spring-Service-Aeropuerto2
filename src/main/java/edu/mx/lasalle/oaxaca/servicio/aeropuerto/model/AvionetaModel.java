package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AVIONETA")
public class AvionetaModel extends VehiculoAereoModel {

    private int numeroMotores;
    private String tipoPista;
    private String clasificacion;
    private String tipoConcesion;
    
    public AvionetaModel() {}

    public AvionetaModel(int id, String modelo, String serie, String capacidad, String color, boolean estado, String antiguedad,
                         String tiempoAire, String llantas, String tanque, double distancia, int numeroMotores, String tipoPista,
                         String clasificacion, String tipoConcesion) {
        super(id, modelo, serie, capacidad, color, estado, antiguedad, tiempoAire, llantas, tanque, distancia);
        this.numeroMotores = numeroMotores;
        this.tipoPista = tipoPista;
        this.clasificacion = clasificacion;
        this.tipoConcesion = tipoConcesion;
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    public void setNumeroMotores(int numeroMotores) {
        this.numeroMotores = numeroMotores;
    }

    public String getTipoPista() {
        return tipoPista;
    }

    public void setTipoPista(String tipoPista) {
        this.tipoPista = tipoPista;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipoConcesion() {
        return tipoConcesion;
    }

    public void setTipoConcesion(String tipoConcesion) {
        this.tipoConcesion = tipoConcesion;
    }

    @Override
    public String toString() {
        return "AvionetaModel{" +
                "numeroMotores=" + numeroMotores +
                ", tipoPista='" + tipoPista + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", tipoConcesion='" + tipoConcesion + '\'' +
                ", " + super.toString() +
                '}';
    }
}
