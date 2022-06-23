package org.josesito.hilos;

import org.josesito.hilos.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Runnable viaje = () -> {

                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("ViajeTarea: " + i + Thread.currentThread().getName());
                        Thread.sleep(500);

                    }
                    System.out.println("finaliza el hilo");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

                }

        };

       Thread v1 = new Thread(viaje,"Hola");

       Thread v2 = new Thread(viaje,"MANUELA");

       Thread v3 = new Thread(viaje,"CARLOTA");

        Thread v4 = new Thread(viaje,"YANINA");

        v1.start();
        v1.join();
        v2.start();
        v2.join();

        v3.start();
        v3.join();

        v4.start();
            v4.join();



        System.out.println("continuando ejecucion del metodo main");







    }
}
