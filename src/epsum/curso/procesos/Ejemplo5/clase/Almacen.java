package epsum.curso.procesos.Ejemplo5.clase;

import java.util.LinkedList;

public class Almacen {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public void setElementoLista(LinkedList<Integer> lista) {
        this.list = lista;
    }
    public void producir(int valor) throws InterruptedException {
        synchronized (this) {
            while (list.size() == CAPACIDAD) {
                wait();
            }
            this.list.add(valor);
            System.out.println("Produciendo: " + valor);
            notify();
        }
    }
    public void consumir() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                wait();
            }
            int valor = this.list.removeFirst();

            System.out.println("Consumiendo: " + valor);
            notify();
        }
    }
}
