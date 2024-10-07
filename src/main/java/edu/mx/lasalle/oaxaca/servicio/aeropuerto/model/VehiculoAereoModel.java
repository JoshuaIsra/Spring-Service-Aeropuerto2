package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "VehiculoAereo")
@Inheritance(strategy = InheritanceType.JOINED)
public class VehiculoAereoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String modelo;
    private String serie;
    private String capacidad;
    private String color;
    private boolean estado;
    private String antiguedad;
    private String tiempoAire;
    private String llantas;
    private String tanque;
    private double distancia;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<VueloModel> vuelos;
    public VehiculoAereoModel() {}

   
    public VehiculoAereoModel(int id, String modelo, String serie, String capacidad, String color, boolean estado, String antiguedad,
                              String tiempoAire, String llantas, String tanque, double distancia) {
        this.id = id;
        this.modelo = modelo;
        this.serie = serie;
        this.capacidad = capacidad;
        this.color = color;
        this.estado = estado;
        this.antiguedad = antiguedad;
        this.tiempoAire = tiempoAire;
        this.llantas = llantas;
        this.tanque = tanque;
        this.distancia = distancia;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getTiempoAire() {
        return tiempoAire;
    }

    public void setTiempoAire(String tiempoAire) {
        this.tiempoAire = tiempoAire;
    }

    public String getLlantas() {
        return llantas;
    }

    public void setLlantas(String llantas) {
        this.llantas = llantas;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "VehiculoAereoModel{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", serie='" + serie + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", color='" + color + '\'' +
                ", estado=" + estado +
                ", antiguedad='" + antiguedad + '\'' +
                ", tiempoAire='" + tiempoAire + '\'' +
                ", llantas='" + llantas + '\'' +
                ", tanque='" + tanque + '\'' +
                ", distancia=" + distancia +
                '}';
    }
}
