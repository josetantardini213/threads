package org.josesito.hilos;

import org.josesito.hilos.thread.NombreThread;

public class EjemploExtenderThread {

    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Hilo 1");

        hilo.start();


        Thread hilo2 = new NombreThread("Hilo 2");

        hilo2.start();


        Thread hilo3 = new NombreThread("Hilo 3");

        hilo3.start();

        System.out.println(hilo.getState());



    }




}
