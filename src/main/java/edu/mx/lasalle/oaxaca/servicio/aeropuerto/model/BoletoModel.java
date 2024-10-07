
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Boleto")
public class BoletoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String asiento;
    private double costo;
    @ManyToOne
    private PasajeroModel pasajero;
    
    @ManyToOne
    private VueloModel vuelo;

    public BoletoModel() {
    }

    public BoletoModel(int id, PasajeroModel pasajero, VueloModel vuelo, String asiento, double costo) {
        this.id = id;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PasajeroModel getPasajero() {
        return pasajero;
    }

    public void setPasajero(PasajeroModel pasajero) {
        this.pasajero = pasajero;
    }

    public VueloModel getVuelo() {
        return vuelo;
    }

    public void setVuelo(VueloModel vuelo) {
        this.vuelo = vuelo;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
