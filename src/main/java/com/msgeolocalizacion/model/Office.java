package com.msgeolocalizacion.model;

public class Office {

    private double lat;
    private double lon;
    private String displayName;
    private String provincia;
    private String unidadEjecutora;


    public Office(double lat, double lon, String displayName, String provincia, String unidadEjecutora) {
        this.lat = lat;
        this.lon = lon;
        this.displayName = displayName;
        this.provincia = provincia;
        this.unidadEjecutora = unidadEjecutora;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getUnidadEjecutora() {
        return unidadEjecutora;
    }

    public void setUnidadEjecutora(String unidadEjecutora) {
        this.unidadEjecutora = unidadEjecutora;
    }
}
