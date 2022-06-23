package org.josesito.hilos;

import org.josesito.hilos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {


        new Thread(new ImprimirFrases("Hola","quetal")).start();
        new Thread(new ImprimirFrases("quien","eres tu?")).start();
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrases("callate","juan"));
       Thread.sleep(100);
       h3.start();


    }

    public synchronized static void imprimirFrases(String frase,String frase2) {
        System.out.print(frase);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(frase2);
    }
}
