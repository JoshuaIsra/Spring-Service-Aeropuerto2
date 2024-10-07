
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = " Aereopuerto")   
public class AereopuertoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String claveAeropuerto;
    private String nombre;
    private int numeroPistas;
    private String tipoAvion;
    private String ciudad;
    @OneToMany(mappedBy="aereopuerto")
    private List<TerminalModel> terminales;
    
    @OneToMany(mappedBy ="origen")
    private List<VueloModel> vuelosOrigen;
    

    @OneToMany(mappedBy = "destino")
    private List<VueloModel> vuelosDestino;
    
    public int getId() {
        return id;
    }

    public String getClaveAeropuerto() {
        return claveAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPistas() {
        return numeroPistas;
    }

    public String getTipoAvion() {
        return tipoAvion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClaveAeropuerto(String claveAeropuerto) {
        this.claveAeropuerto = claveAeropuerto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroPistas(int numeroPistas) {
        this.numeroPistas = numeroPistas;
    }

    public void setTipoAvion(String tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "AereopuertoModel{" + "id=" + id + ", claveAeropuerto=" + claveAeropuerto + ", nombre=" + nombre + ", numeroPistas=" + numeroPistas + ", tipoAvion=" + tipoAvion + ", ciudad=" + ciudad + '}';
    }
    
}
