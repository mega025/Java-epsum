package epsum.curso.Abstracta;

import java.io.Serializable;

public abstract class Animal implements Serializable {

    protected String nombre;
    protected int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Animal() {}

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", edad=" + edad
                ;
    }
}
