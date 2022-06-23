package org.josesito.hilos.ejemplosync.runnable;

import org.josesito.hilos.ejemplosync.Panaderia;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {


        Panaderia p = new Panaderia();

        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();

    }

}
