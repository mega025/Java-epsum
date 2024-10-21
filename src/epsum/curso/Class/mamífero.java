package epsum.curso.Class;

import epsum.curso.Abstracta.Animal;

public class mamífero extends Animal {


    protected boolean tienePelo;

    public boolean isTienePelo() {
        return tienePelo;
    }

    public void setTienePelo(boolean tienePelo) {
        this.tienePelo = tienePelo;
    }

    public mamífero(){
    super();
    }
    public mamífero( String nombre, int edad, boolean tienePelo ){
        super(nombre,edad );
        this.tienePelo = tienePelo;
    }



    @Override
    public String toString() {
        String Tienepelo;
        if (tienePelo){
            Tienepelo = "Si";
        }else {
            Tienepelo = "No";
        }
        return "Los datos del mamífero son: " + super.toString() +  " tiene pelo  " + Tienepelo + " }";
    }
}
