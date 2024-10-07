package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pasajero")   
@Inheritance(strategy = InheritanceType.JOINED)
public class PasajeroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Date fechaNacimiento;
    private boolean discapacidad;
    private String nacionalidad;
    
     @OneToMany(mappedBy="pasajero")
     private List<BoletoModel> boletos;
    
    @ManyToOne
    private  VueloModel vuelo; 
    @OneToMany(mappedBy="pasajero")
    private List<EquipajeModel> equipajes;
    public PasajeroModel() {}

    public PasajeroModel(int id, String nombre, String apellido, String direccion, Date fechaNacimiento, boolean discapacidad, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.nacionalidad = nacionalidad;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "PasajeroModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", discapacidad=" + discapacidad +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
