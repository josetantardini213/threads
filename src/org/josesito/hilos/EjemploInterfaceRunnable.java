package org.josesito.hilos;

import org.josesito.hilos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {

    public static void main(String[] args) {


        new Thread(new ViajeTarea("Hola")).start();
        new Thread(new ViajeTarea("MANUELA")).start();
        new Thread(new ViajeTarea("CARLOTA")).start();
        new Thread(new ViajeTarea("YANINA")).start();







    }


}
