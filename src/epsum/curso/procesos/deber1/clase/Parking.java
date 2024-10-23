package epsum.curso.procesos.deber1.clase;

import java.util.LinkedList;

public class Parking {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public void CochesDentro(int coches) throws InterruptedException {
        Synchronized(this){
            while (list.size() < CAPACIDAD) {
                wait();
            }
            list.addLast(coches);
            System.out.println("Coches que estan dentro " + coches);
            notify();
        }
    }
}
