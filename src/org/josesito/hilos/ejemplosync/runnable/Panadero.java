package org.josesito.hilos.ejemplosync.runnable;

import org.josesito.hilos.ejemplosync.Panaderia;

public class Panadero implements Runnable {

    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0;i<10;i++) {
            panaderia.setPan("pan" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
