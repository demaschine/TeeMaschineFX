package com.example.teemaschinefx;

public class SensorData{
    /*Diese Klasse simuliert die Sensordaten und Werte, die später von der
    * Seriellen Schnittstelle an die GUI uebergeben werden.
    */
    public int temperatur;

    public SensorData(){
        this.temperatur = 22;
    }

    public int getTemperatur() {
        return this.temperatur;
    }

    public void setTemperatur(int temperatur) {
        this.temperatur = temperatur;
    }
}
