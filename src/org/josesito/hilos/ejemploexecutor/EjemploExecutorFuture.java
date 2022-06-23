package org.josesito.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable tarea = () -> {
            try {
                System.out.println("Hola");
                TimeUnit.SECONDS.sleep(2);
                return "Hola termine";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                throw new RuntimeException(e);

            }

        };

       Future<String> resultado = executor.submit(tarea); //ejecuta de manera secuencial

       executor.shutdown();//apaga una vez que terminan todas las tareas

        System.out.println("continuando ejecucion del metodo main 1");

        executor.awaitTermination(2,TimeUnit.SECONDS);

        System.out.println("continuando ejecucion del metodo main 2");

        while(!resultado.isDone()) {
            System.out.println("esperando");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(resultado.get());//espera a que termine la tarea y retorna el resultado
        System.out.println(resultado.isDone());//si finalizo retorna un valor



    }

}
