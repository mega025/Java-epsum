package epsum.curso.procesos.deber1.main;

import epsum.curso.procesos.deber1.clase.Parking;

public class MainVehiculo {
    public static void main(String[] args) {
        Parking parking = new Parking();

        Thread entrada = new Thread(() ->{

        try {
            int coches = 0;
            while (coches < 5) {
                parking.CochesDentro(coches);
                coches++;
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }
        });
        Thread salida = new Thread(() ->{

            try {
               while (true){
                   parking.CochesSaliendo();
                   Thread.sleep(1000);
               }
            } catch (InterruptedException e) {
                System.out.println("Error " + e.getMessage());
            }
        });
        entrada.start();
        salida.start();
    }
}
