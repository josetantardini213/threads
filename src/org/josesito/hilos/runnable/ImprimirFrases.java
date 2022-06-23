package org.josesito.hilos.runnable;

import org.josesito.hilos.EjemploSincronizacionThread;

public class ImprimirFrases implements Runnable {

    private String frase;
    private String frase2;

    public ImprimirFrases(String frase, String frase2) {
        this.frase = frase;
        this.frase2 = frase2;
    }

    @Override
    public void run() {

            EjemploSincronizacionThread.imprimirFrases(this.frase, this.frase2);
    }
}
