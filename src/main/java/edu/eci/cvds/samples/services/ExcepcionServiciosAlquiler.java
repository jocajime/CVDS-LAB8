package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception {
    public ExcepcionServiciosAlquiler(String message){
        super(message);
    }
    public ExcepcionServiciosAlquiler(String message, Exception e){
        super(message+e.toString());
    }
}
