
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = " Terminal")   
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class TerminalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private double capacidad;
    private boolean disponible;
    @ManyToOne
    private AereopuertoModel aereopuerto;
    
    @OneToMany(mappedBy = "terminal")
    private List<VueloModel> vuelos;
    public int getClaveTerminal() {
        return id;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setClaveTerminal(int id) {
        this.id = id;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "TerminalModel{" + "claveTerminal=" + id + ", capacidad=" + capacidad + ", disponible=" + disponible + '}';
    }
    
    

}
