package epsum.curso.procesos.deber1.clase;

import java.util.LinkedList;

public class Parking {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public void CochesDentro(int coches) throws InterruptedException {
        synchronized (this) {
            while (list.size() == CAPACIDAD) {
                wait();
            }
            list.addLast(coches);
            System.out.println("Coches que estan dentro " + coches);
            Thread.sleep(1000);
            notify();
        }
    }

    public void CochesSaliendo() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                wait();
            }
            int coches = list.removeFirst();
            System.out.println("Coches que han salido " + coches);
            Thread.sleep(1000);
            notify();
        }
    }
}
