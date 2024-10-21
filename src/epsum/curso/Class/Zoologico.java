package epsum.curso.Class;

import epsum.curso.Abstracta.Animal;
import epsum.curso.Interface.Gestionable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoologico {

    ArrayList<Gestionable> gestionables = new ArrayList<>();

    public ArrayList<Gestionable> getGestionables() {
        return gestionables;
    }

    public void setGestionables(ArrayList<Gestionable> gestionables) {
        this.gestionables = gestionables;
    }

    public Zoologico(ArrayList<Gestionable> gestionables) {
        this.gestionables = gestionables;
    }

    public void agregarAnimal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que quieres añadir animal o cuidador (A/C)");
        String saber = sc.nextLine();
        if (saber.equalsIgnoreCase("A")) {
            System.out.println("¿Quieres añadir otro animal: (S/N)");
            String input = sc.nextLine();
            while (input.equalsIgnoreCase("S")) {

                System.out.println("Es un mamífero o un ave (M/A)");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("M")) {
                    mamífero ero = new mamífero();
                    System.out.println("Nombre del mamífero: ");
                    ero.setNombre(sc.next());
                    System.out.println("Edad del mamífero");
                    ero.setEdad(sc.nextInt());
                    System.out.println("¿Tiene pelo? (s/n)");
                    String pelo = sc.next();

                    if (pelo.equalsIgnoreCase("S")) {
                        ero.setTienePelo(true);
                    }else if (pelo.equalsIgnoreCase("N")) {
                        ero.setTienePelo(false);
                    }
                    gestionables.add(ero);
                }else if (input.equalsIgnoreCase("A")) {
                    Ave ave = new Ave();
                    System.out.println("Nombre del ave: ");
                    ave.setNombre(sc.next());
                    System.out.println("Edad del ave");
                    ave.setEdad(sc.nextInt());
                    System.out.println("Puede volar (s/n)");
                    String respuestaVolar = sc.next();

                    if (respuestaVolar.equalsIgnoreCase("S")) {
                        ave.setPuedeVolar(true);
                    }else if (respuestaVolar.equalsIgnoreCase("M")) {
                        ave.setPuedeVolar(false);
                    }
                    gestionables.add(ave);
                }
                System.out.println("¿Quieres añadir otro animal: (S/N)");
                sc.nextLine();
                input = sc.nextLine();
        }


            }else if (saber.equalsIgnoreCase("C")) {
            System.out.println("¿Quieres añadir a un trabajador?: (S/N)");
            String trabajador = sc.nextLine();
            while (trabajador.equalsIgnoreCase("S")) {
                cuidadores cuida = new cuidadores();
                System.out.println("El nombre del cuidador ");
                cuida.setNombre(sc.next());
                System.out.println("Apellido del cuidador");
                cuida.setApellido(sc.next());
                System.out.println("Edad del cuidador");
                cuida.setEdad(sc.nextInt());
                System.out.println("Tipo de cuidador");
                cuida.setTipo(sc.next());

                gestionables.add(cuida);

                System.out.println("¿Quieres añadir a un trabajador?: (S/N)");
                sc.nextLine();
                 trabajador = sc.nextLine();
        }
        }

        sc.close();
    }

    public static void output(List <Gestionable> gestionables) {

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\animales.ser");
             ObjectOutputStream salida = new ObjectOutputStream(fos)){
            salida.writeObject(gestionables);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void input(){
        List<Gestionable> gestionable = null;
        try(FileInputStream fis = new FileInputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\animales.ser");
            ObjectInputStream entrada = new ObjectInputStream(fis)){
            gestionable = (List<Gestionable>) entrada.readObject();
            for (Gestionable gestionables : gestionable) {
                System.out.println(gestionables);
            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

