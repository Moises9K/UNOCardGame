package moises.Cartas;

import moises.Base.Carta;
import moises.Base.Colores;
import moises.Base.Tipo;

public class UNOCard extends Carta {
    private int numero;
    private Colores color;

    public UNOCard(Colores color, int numero) {
        super(color.name() + numero, Tipo.Normal);
        this.color = color;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }
}
