package org.josesito.hilos.ejemplosync;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void setPan(String pan) {
while(disponible){
    try {
        wait();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        }
        this.pan = pan;
        System.out.println( "panadero hornea el pan");

        this.disponible = true;
        this.notify();

    }


    public synchronized String getPan() {
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("panadero le da el pan");
        this.disponible = false;
        this.notify();
        return pan;
    }



}

