package org.josesito.hilos.ejemplosync.runnable;

import org.josesito.hilos.ejemplosync.Panaderia;

public class Consumidor implements Runnable {

    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Consumidor: " + i + panaderia.getPan());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
