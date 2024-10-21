package epsum.curso.Class;

import epsum.curso.Abstracta.Animal;

public class Ave extends Animal {

    protected boolean puedeVolar;

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    public Ave(){
        super();
    }
    public Ave(String name, int edad, boolean puedeVolar){
        super(name, edad);
        this.puedeVolar = puedeVolar;
    }


    @Override
    public String toString() {
        String Puedevolar;
        if (puedeVolar) {
            Puedevolar = "SI";
        }else {
            Puedevolar = "NO";
        }
        return "Los datos del ave son: " + super.toString() + " puede volar " + Puedevolar + " }";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getTipo() {
        return "";
    }
}
