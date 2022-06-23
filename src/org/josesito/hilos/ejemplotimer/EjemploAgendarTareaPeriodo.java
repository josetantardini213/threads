package org.josesito.hilos.ejemplotimer;

import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaPeriodo {
    public static void main(String[] args) {


        Timer timer = new Timer();

  timer.schedule(new TimerTask() {
      int contador = 3;

      @Override
    public void run() {
if(contador > 0) {

    contador--;
    System.out.println("Hola");

    // timer.cancel();
}else{
    timer.cancel();
}

    }
  },  1000,2000);






    }
}
