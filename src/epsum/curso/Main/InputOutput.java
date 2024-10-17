package epsum.curso.Main;

import java.io.*;


public class InputOutput {
    public static void main(String[] args) {

        InputStream();

    }

    public static boolean isExists(File file) {
        return file.exists();
    }

    public static long getBits(long fileLength) {
        return fileLength * 8;
    }

    public static void InputStream() {
        File file = new File("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\entrada.txt");
        File file1= new File("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\salida.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        if (isExists(file)) {
            long leer = getBits(file.length());
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(file1);
                byte[] contenido = new byte[(int) leer];
                fis.read(contenido);
                fos.write(contenido);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

}