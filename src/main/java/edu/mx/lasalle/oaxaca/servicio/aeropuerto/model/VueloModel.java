
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Table(name = "Vuelo")   
public class VueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String aerolinea;
    private int capacidadPasajeros;
    private double distanciaVuelo;
    private Date fechaSalida;
    
    
    private Time horaSalida;
    private Date fechaLlegada;
    private Time horaLlegada;
    
    @ManyToOne
    private AereopuertoModel origen;
    
    @ManyToOne
    private AereopuertoModel destino;
    
    @ManyToOne
    private VehiculoAereoModel vehiculo;
    
    @ManyToOne
    private TerminalModel terminal;
    
    @OneToMany(mappedBy = "vuelo")
    private List<PasajeroModel> pasajeros;
    
    @OneToMany(mappedBy = "vuelo")
    private List<TripulacionModel> tripulacion;
    
    @OneToMany(mappedBy = "vuelo")
    private List<BoletoModel> boletos;

    public VueloModel() {
    }

    public VueloModel(int id, String aerolinea, int capacidadPasajeros, double distanciaVuelo, Date fechaSalida, Time horaSalida, Date fechaLlegada, Time horaLlegada, AereopuertoModel origen, AereopuertoModel destino, VehiculoAereoModel vehiculo, TerminalModel terminal, List<PasajeroModel> pasajeros, List<TripulacionModel> tripulacion) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.capacidadPasajeros = capacidadPasajeros;
        this.distanciaVuelo = distanciaVuelo;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaLlegada = horaLlegada;
        this.origen = origen;
        this.destino = destino;
        this.vehiculo = vehiculo;
        this.terminal = terminal;
        this.pasajeros = pasajeros;
        this.tripulacion = tripulacion;
    }

    
    
    public int getId() {
        return id;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public double getDistanciaVuelo() {
        return distanciaVuelo;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public AereopuertoModel getOrigen() {
        return origen;
    }

    public AereopuertoModel getDestino() {
        return destino;
    }

    public VehiculoAereoModel getVehiculo() {
        return vehiculo;
    }

    public TerminalModel getTerminal() {
        return terminal;
    }

    public List<PasajeroModel> getPasajeros() {
        return pasajeros;
    }

    public List<TripulacionModel> getTripulacion() {
        return tripulacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public void setDistanciaVuelo(double distanciaVuelo) {
        this.distanciaVuelo = distanciaVuelo;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setOrigen(AereopuertoModel origen) {
        this.origen = origen;
    }

    public void setDestino(AereopuertoModel destino) {
        this.destino = destino;
    }

    public void setVehiculo(VehiculoAereoModel vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setTerminal(TerminalModel terminal) {
        this.terminal = terminal;
    }

    public void setPasajeros(List<PasajeroModel> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public void setTripulacion(List<TripulacionModel> tripulacion) {
        this.tripulacion = tripulacion;
    }
    
}
