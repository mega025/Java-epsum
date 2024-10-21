package epsum.curso.Class;

import epsum.curso.Abstracta.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoologico {

    ArrayList<Animal> animals = new ArrayList<>();

    public Zoologico(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    public void agregarAnimal() {
        Scanner sc = new Scanner(System.in);

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
                animals.add(ero);
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
                animals.add(ave);
            }
            System.out.println("¿Quieres añadir otro animal: (S/N)");
            sc.nextLine();
            input = sc.nextLine();
        }

        sc.close();
    }

    public static void output(List <Animal> animals) {

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\animales.ser");
             ObjectOutputStream salida = new ObjectOutputStream(fos)){
            salida.writeObject(animals);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void input(){
        List<Animal> animals = null;
        try(FileInputStream fis = new FileInputStream("C:\\Users\\ALUMNO\\IdeaProjects\\Java\\java-xinjie\\src\\txt\\animales.ser");
            ObjectInputStream entrada = new ObjectInputStream(fis)){
            animals = (List<Animal>) entrada.readObject();
            for (Animal animal : animals) {
                System.out.println(animal);
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

