package org.josesito.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(3); //se ejecutan al mismo tiempo en paralelo

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

        Callable<Integer> tarea2 =()->{
            try {
                System.out.println("Iniciando tarea2");
                TimeUnit.SECONDS.sleep(3);
                return 2;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                throw new RuntimeException(e);

            }
        };


       Future<String> resultado = executor.submit(tarea);
       Future<String> resultado2 = executor.submit(tarea);
       Future<Integer> resultado3 = executor.submit(tarea2);

       executor.shutdown();//apaga una vez que terminan todas las tareas

        System.out.println("continuando ejecucion del metodo main 1");

        executor.awaitTermination(2,TimeUnit.SECONDS);

        System.out.println("continuando ejecucion del metodo main 2");

        while(!resultado.isDone() && resultado2.isDone() && resultado3.isDone()) {
            System.out.println(String.format("esperando %s %s %s",resultado.isDone(),resultado2.isDone(),resultado3.isDone(),
                            resultado.isDone()? "Finalizo" : "En proceso",
                            resultado2.isDone()? "Finalizo" : "En proceso",
                            resultado3.isDone()? "Finalizo" : "En proceso")

                    );


            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(resultado.get());//espera a que termine la tarea y retorna el resultado
        System.out.println(resultado.isDone());//si finalizo retorna un valor

        System.out.println(resultado2.get());//espera a que termine la tarea y retorna el resultado
        System.out.println(resultado2.isDone());//si finalizo retorna un valor

        System.out.println(resultado3.get());//espera a que termine la tarea y retorna el resultado
        System.out.println(resultado3.isDone());//si finalizo retorna un valor


    }

}
