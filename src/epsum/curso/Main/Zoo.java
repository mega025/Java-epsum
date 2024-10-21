package epsum.curso.Main;

import epsum.curso.Abstracta.Animal;
import epsum.curso.Class.Ave;
import epsum.curso.Class.Zoologico;
import epsum.curso.Class.mamífero;
import epsum.curso.Interface.Gestionable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {

    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico(new ArrayList<Gestionable>());
        zoologico.agregarAnimal();
        zoologico.output(zoologico.getGestionables());
        zoologico.input();

    }
}