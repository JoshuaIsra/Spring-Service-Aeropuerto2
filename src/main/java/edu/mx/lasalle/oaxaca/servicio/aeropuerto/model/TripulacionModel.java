package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Tripulacion")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)

public class TripulacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private double antiguedad;
    private String turno;
    private double horasVuelo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;

    @ManyToOne
    private VueloModel vuelo;
    public TripulacionModel() {}

    public TripulacionModel(int id, double antiguedad, String turno, double horasVuelo, String nombre, String apellido,
                            Date fechaNacimiento, String genero) {
        this.id = id;
        this.antiguedad = antiguedad;
        this.turno = turno;
        this.horasVuelo = horasVuelo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(double antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "TripulacionModel{" +
                "id=" + id +
                ", antiguedad=" + antiguedad +
                ", turno='" + turno + '\'' +
                ", horasVuelo=" + horasVuelo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero='" + genero + '\'' +
                '}';
    }
}
