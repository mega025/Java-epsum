package epsum.curso.procesos.SegundoEjercicio.Main;

class Contador{
    private int par = 0;
    private  int impar = 1;
    public void hilopar() throws InterruptedException {
        synchronized (this) {
            while (true){

                System.out.println("hilo par : " + par);
                Thread.sleep(1000);
                par += 2 ;
                notify();
                wait();
            }
        }
    }
    public void hiloimpar() throws InterruptedException {
        synchronized (this) {
            while (true){

                System.out.println("hilo impar : " + impar);
                Thread.sleep(1000);
                impar += 2 ;
                notify();
                wait();
            }
        }
    }
}
public class MainHilo {

    public static void main(String[] args) {
        Contador contador = new Contador();

      Thread hilopar = new Thread(() ->{
          try {
            contador.hilopar();
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      });

        Thread hiloimpar = new Thread(() ->{
            try {
               contador.hiloimpar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        hilopar.start();
        hiloimpar.start();
    }

    }



