package epsum.curso.procesos.deber1.main;

class PuenteCoches {
    private boolean cocheNorte = false;
    private boolean cocheSur = false;

    public void cocheNorte() throws InterruptedException{
        synchronized (this) {
            while (cocheSur){
                    System.out.println("Coche del norte espera");
                    wait();
            }
            cocheNorte = true;
            System.out.println("Coche norte esta pasando");
            Thread.sleep(3000);
            System.out.println("Coche del norte paso");
            cocheNorte = false;
            notify();
            Thread.sleep(1500);

        }
    }
    public void cocheSur() throws InterruptedException{
        synchronized (this) {
            while (cocheNorte){
                    System.out.println("Coche del Sur espera");
                    wait();
            }
            cocheSur = true;
            System.out.println("Coche Sur esta pasando");
            Thread.sleep(3000);
            System.out.println("Coche del Sur paso");
            cocheSur = false;
            notify();
            Thread.sleep(1000);

        }
    }
}

public class MainPuenteCoches {
    public static void main(String[] args) {
        PuenteCoches p = new PuenteCoches();

        Thread Norte1 = new Thread(() ->{
            try{
                p.cocheNorte();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread Norte2 = new Thread(() ->{
            try{
                p.cocheNorte();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread Sur1 = new Thread(() ->{
            try{
                p.cocheSur();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread Sur2 = new Thread(() ->{
            try{
                p.cocheSur();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Norte1.start();
        Norte2.start();
        Sur1.start();
        Sur2.start();
    }
}
