package org.josesito.hilos.ejemplosync;

import org.josesito.hilos.ejemplosync.runnable.Consumidor;
import org.josesito.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {


        Panaderia p = new Panaderia();

        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();

    }

}
