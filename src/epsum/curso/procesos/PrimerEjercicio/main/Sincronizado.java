package epsum.curso.procesos.PrimerEjercicio.main;


class Contador{
    private int contador = 0;

    public synchronized void incrementar(){
        contador++;
        System.out.println("contador: " + this.contador);
    }
    public synchronized void decrementar(){
        contador--;
        System.out.println("contador: " + this.contador);
    }
}
public class Sincronizado {
        public static void main(String[] args) {
            
            Contador contador = new Contador();

            Thread hilo1 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    contador.incrementar();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Error " + e.getMessage());
                    }
                }
            });
            Thread hilo2 = new Thread(() -> {

                for (int i = 0; i < 5; i++) {
                    contador.decrementar();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Error " + e.getMessage());
                    }

                }
            });

            hilo1.start();
            try {
                hilo1.join();
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
