package org.josesito.hilos.ejemplotimer;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTarea {
    public static void main(String[] args) {
        Timer timer = new Timer();

  timer.schedule(new TimerTask() {
    @Override
    public void run() {
      System.out.println("Hola");

      timer.cancel();
    }
  },  1000);






    }
}
