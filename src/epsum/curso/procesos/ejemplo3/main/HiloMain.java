package epsum.curso.procesos.ejemplo3.main;

public class HiloMain {
    public static void main(String[] args) {
        Thread hilo = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo 1 " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        });
        Thread hilo2 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo 2 " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        });
        // se ejecutan a la vez
        hilo.start();
        hilo2.start();

        // Aqui se ejecuta primero el hilo y cuando termine empieza el hilo2
        try {
            hilo.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
