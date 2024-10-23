package epsum.curso.procesos.ejemplo2.main;

import epsum.curso.procesos.ejemplo2.clase.MiRunnable;

public class runnableMain {
    public static void main(String[] args) {
        MiRunnable miRunnable = new MiRunnable();
        Thread hilo = new Thread(miRunnable);
        hilo.start();
    }
}
