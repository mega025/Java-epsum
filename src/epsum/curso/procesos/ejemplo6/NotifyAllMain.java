package epsum.curso.procesos.ejemplo6;

 class Carrrera {

    private boolean CarreraIniciada = false;

    public synchronized  void esperarInicio(String corredor) throws InterruptedException {
        while (!CarreraIniciada) {
            System.out.println(corredor + "eSTE ESPERANDO EL INICIO DE LA CARRERA");
            wait();
        }
        System.out.println( corredor + " ha comenzado a correr");
    }
    public synchronized  void iniciarCarrera() throws InterruptedException {
        this.CarreraIniciada = true;
        System.out.println("El juez ha dado la señal. La carrera comienza");
        notifyAll();
    }
}

public class NotifyAllMain{
    public static void main(String[] args) throws InterruptedException {
        Carrrera carrrera = new Carrrera();

        Runnable corredor = () -> {
            String nombre = Thread.currentThread().getName();
            try {
                carrrera.esperarInicio(nombre);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread corredor1 = new Thread(corredor, "Corredor 1");
        Thread corredor2 = new Thread(corredor, "Corredor 2");
        Thread corredor3 = new Thread(corredor, "Corredor 3");

    corredor1.start();
    corredor2.start();
    corredor3.start();

    try{
        Thread.sleep(1000);

    }catch(InterruptedException e){
        e.printStackTrace();
    }
    carrrera.iniciarCarrera();
    }


}