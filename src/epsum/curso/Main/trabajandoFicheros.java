package epsum.curso.Main;

import java.io.*;

public class trabajandoFicheros {
    public static void main(String[] args) {
       File file = new File("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\Alumnos");

       if (isExists(file)){
           //long sizeBits = getBits(file.length());
           //System.out.println("tamaño de bits " + sizeBits);
            leerArchivoInputStream();
            //readFileAndGetSize();
           //escribirArchivoFileInputStream();
       }

    }


    public static boolean isExists(File file) {
        return file.exists();
    }

    public static long getBits(long fileLength) {
        return fileLength * 8;
    }

    public static void leerArchivoInputStream(){
        File file = new File("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\Alumnos");

        if (isExists(file)) {
            long bits = getBits(file.length());

            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\Alumnos");

                int byteLeido;
                while ((byteLeido = fis.read()) != -1){
                    System.out.print((char)byteLeido);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void readFileAndGetSize(){
        FileInputStream fis = null;

        try{
            File file = new File("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\Alumnos");
            if (isExists(file)) {
                fis = new FileInputStream(file);
                long sizeFile = file.length();
                byte [] contenido = new byte[(int) sizeFile];

                fis.read(contenido);
                System.out.print(contenido.length);
            }

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escribirArchivoFileInputStream(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\Alumnos");
            String contenido ="Hola mundo";

            byte[] byteContenido = contenido.getBytes();
            fos.write(byteContenido);



        }catch (IOException e){
            System.out.println(e);
        }
    }
}