package epsum.curso.Main;

import epsum.curso.Class.Empleado;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MainEmpresa {

    public static void main(String[] args) {

        List<Empleado> empleados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Quieres añadir empleado? (S/N)");
        String respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("S")) {
            Empleado emp = new Empleado();
            System.out.print("Nombre: ");
            emp.setNombre(sc.nextLine());
            System.out.print("Edad: ");
            emp.setEdad(sc.nextInt());
            System.out.print("Salario: ");
            emp.setSalario(sc.nextDouble());
            empleados.add(emp);

            System.out.println("Quieres añadir otro empleado? (S/N)");
            sc.nextLine();
            respuesta = sc.nextLine();
        }
       Output(empleados);
        intput();
sc.close();
    }

    public static void Output( List<Empleado> empleados) {

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\empleados.ser");
             ObjectOutputStream salida = new ObjectOutputStream(fos)) {
            salida.writeObject(empleados);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void intput() {
       List<Empleado> empleados = null;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\empleados.ser");
             ObjectInputStream ver = new ObjectInputStream(fis)) {
            empleados = (List<Empleado>) ver.readObject();
            for (Empleado emp : empleados) {
                System.out.println(emp.toString());
            }


        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}


