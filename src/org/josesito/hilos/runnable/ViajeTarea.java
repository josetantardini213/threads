package org.josesito.hilos.runnable;

public class ViajeTarea implements Runnable {

    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {



            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ViajeTarea: " + i + nombre);
                    Thread.sleep(500);

                }
                System.out.println("finaliza el hilo");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }

        }


    }


