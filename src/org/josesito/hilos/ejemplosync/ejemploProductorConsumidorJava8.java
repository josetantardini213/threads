package org.josesito.hilos.ejemplosync;

public class ejemploProductorConsumidorJava8 {
    public static void main(String[] args) {

        Panaderia p = new Panaderia();

       new Thread(() -> {
            for (int i = 0;i<10;i++) {
                p.setPan("pan" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();



        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Consumidor: " + i + p.getPan());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
