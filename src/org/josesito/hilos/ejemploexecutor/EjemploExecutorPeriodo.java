package org.josesito.hilos.ejemploexecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploExecutorPeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);



        System.out.println("Alguna tarea en el main ...");

        CountDownLatch lock = new CountDownLatch(5); //indicamos la cantidad de veces que va ejecutar la tarea

        executor.scheduleAtFixedRate(() -> {

            try {
                System.out.println("Hola");
                TimeUnit.SECONDS.sleep(2);
                lock.countDown();//va a descontando la cantidad de veces que se va a ejecutar la tarea

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }, 1, 1, TimeUnit.SECONDS);

        //TimeUnit.SECONDS.sleep(2); esta manera se ejecuta esta tarea repetidamente durante una cantidad de tiempo

        lock.await();//espera a que se cumpla la cantidad de veces que se indica

        executor.shutdown(); //con el shotdown nunca va frenar la tarea y se va a ejecutar infinitamente

    }
}
