package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = " Equipaje")  
public class EquipajeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private float peso;
    private float altura;
    private float ancho;
    private String tipo;
    @ManyToOne
    private PasajeroModel pasajero;
    public int getId() {
        return id;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public float getAncho() {
        return ancho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "EquipajeModel{" + "id=" + id + ", peso=" + peso + ", altura=" + altura + ", ancho=" + ancho + ", tipo=" + tipo + '}';
    }

}
