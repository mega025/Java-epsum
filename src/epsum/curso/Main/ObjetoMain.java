package epsum.curso.Main;

import epsum.curso.Class.Persona;

import java.io.*;

public class ObjetoMain {

    public static void main(String[] args) {

        Persona persona = new Persona("Juan", 27);

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\persona.ser");
             ObjectOutputStream salida = new ObjectOutputStream(fos)) {

            salida.writeObject(persona);

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        leerArchivo();
    }

        public static void leerArchivo(){
            Persona persona2 = null;

            try(InputStream fis = new FileInputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\persona.ser");
            ObjectInputStream entrada = new ObjectInputStream(fis)){
                persona2 = (Persona) entrada.readObject();
                System.out.println(persona2.toString());
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }

        }


}
