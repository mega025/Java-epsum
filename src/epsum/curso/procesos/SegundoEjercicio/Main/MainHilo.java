package epsum.curso.procesos.SegundoEjercicio.Main;

public class MainHilo {
  public void hilopar() throws InterruptedException {
      synchronized (this) {
          while (true){
              wait();
              int par = 0;
              System.out.println("hilo par : " + par);
              Thread.sleep(1000);
              par += 2 ;
              notify();
          }
      }
  }
    public void hiloimpar() throws InterruptedException {
        synchronized (this) {
            while (true){
                wait();
                int impar = 1;
                System.out.println("hilo par : " + impar);
                Thread.sleep(1000);
                impar += 2 ;
                notify();
            }
        }
    }

    public static void main(String[] args) {

      Thread hilopar = new Thread(() ->{
          try {
              int par = 0;
              while (true){
                  System.out.println("hilo par : " + par);
                  par += 2 ;
                  Thread.sleep(1000);
              }
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      });

        Thread hiloimpar = new Thread(() ->{
            try {
                int impar = 1;
                while (true){
                    System.out.println("hilo impar : " + impar);
                    impar += 2 ;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        hilopar.start();
        hiloimpar.start();
    }

    }



