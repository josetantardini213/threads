package org.josesito.hilos.thread;

public class NombreThread extends Thread {

    public NombreThread(String nombre) {
        super(nombre);
    }

    @Override
    public void run(){
        System.out.println("NombreThread: " + getName());

        for (int i = 0; i < 10; i++) {
            System.out.println("NombreThread: " + i);
        }

        System.out.println("finaliza el hilo");



    }

}
