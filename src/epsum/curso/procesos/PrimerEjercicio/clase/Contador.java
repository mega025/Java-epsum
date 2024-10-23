package epsum.curso.procesos.PrimerEjercicio.clase;

public class Contador {
        private int Contador = 0;

        public synchronized void incrementar(){
            Contador++;
            System.out.println("Contador " + Contador);
        }
}
