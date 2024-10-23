package epsum.curso.procesos.PrimerEjercicio.main;

public class MainHilo {

    public static void main(String[] args) {

        Thread hilo = new Thread(()->{
            for (int i = 1; i < 6; i++) {
                System.out.println("Hilo 1 " + i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("Error " + e.getMessage());
                }
            }

        });

        Thread hilo2 = new Thread(()->{
            for (int i = 6; i < 11; i++) {
                System.out.println("Hilo 2 " + i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("Error " + e.getMessage());
                }
            }

        });
        hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
