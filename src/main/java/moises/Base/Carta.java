package moises.Base;

import moises.GameLogic.Juego;

public abstract class Carta {
    private final String name;
    private final Tipo tipo;
    Colores color;

    public Carta(String name, Tipo tipo, Colores color) {
        this.name = name;
        this.tipo = tipo;
        this.color = color;
    }

    public Carta(String name, Tipo tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public Tipo getTipo() {
        return tipo;
    }


    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public abstract boolean jugadaValida(Carta cartaEnMesa);

    public abstract void realizarEfecto(Juego juego);


    @Override
    public String toString() {
        return "Carta{" +
                "name='" + name + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
