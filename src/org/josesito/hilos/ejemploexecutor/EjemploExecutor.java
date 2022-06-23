package org.josesito.hilos.ejemploexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            try {
                System.out.println("Hola");
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                throw new RuntimeException(e);
            }

        };

        executor.submit(tarea);
        executor.shutdown();//apaga una vez que terminan todas las tareas

        System.out.println("continuando ejecucion del metodo main 1");

        executor.awaitTermination(2,TimeUnit.SECONDS);

        System.out.println("continuando ejecucion del metodo main 2");


    }

}
