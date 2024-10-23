package epsum.curso.procesos.Ejemplo5.main;

import epsum.curso.procesos.Ejemplo5.clase.Almacen;

import java.util.LinkedList;

public class HiloMain {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(100);
        lista.add(200);
        lista.add(300);
        lista.add(400);
        lista.add(500);
        almacen.setElementoLista(lista);
        Thread productor = new Thread(()->{
            try {
                int valor = 1;
                while (true){
                    almacen.producir(valor);
                    valor++;
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("Error al crear el almacen  " + e.getMessage());
            }
        });

        Thread consumidor = new Thread(()->{
            try {
                while (true){
                    almacen.consumir();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Error al crear el almacen  " + e.getMessage());
            }
        });

        productor.start();
        consumidor.start();
    }
}
