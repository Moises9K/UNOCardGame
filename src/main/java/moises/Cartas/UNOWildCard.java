package moises.Cartas;

import moises.Base.Carta;
import moises.Base.Colores;
import moises.Base.Tipo;
import moises.Base.WildCard;

public class UNOWildCard extends Carta {
    Colores color;
    WildCard wildCard;
    public UNOWildCard(WildCard wildCard) {
        super(wildCard.name(), Tipo.Wild);
        this.wildCard = wildCard;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public WildCard getWildCard() {
        return wildCard;
    }
}
