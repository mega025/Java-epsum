package epsum.curso.procesos.ejemplo1.clase;

public class mihilo extends  Thread {
    //run()
    //sleep() -> 1000ms(1s)

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hilo " + i);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        }
    }
}
