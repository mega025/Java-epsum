package epsum.curso.Class;

import epsum.curso.Interface.Gestionable;

import java.io.Serializable;

public class cuidadores implements Gestionable, Serializable {

   protected String nombre;
   protected String apellido;
   protected int edad;
   protected String tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public cuidadores(String apellido, String nombre, int edad, String tipo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    public cuidadores() {
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public String toString() {
        return "El nombre del cuidador es: " + nombre + " apelldio " + apellido + " edad " + edad + " tipo " + tipo;
    }
}
