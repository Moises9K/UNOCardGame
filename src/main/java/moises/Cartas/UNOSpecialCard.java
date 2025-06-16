package moises.Cartas;

import moises.Base.Carta;
import moises.Base.Colores;
import moises.Base.SpecialCard;
import moises.Base.Tipo;

public class UNOSpecialCard extends Carta {
    Colores color;
    SpecialCard specialCard;

    public UNOSpecialCard(Colores color, SpecialCard specialCard) {
        super(color.name() + specialCard.name(), Tipo.Special);
        this.specialCard = specialCard;
        this.color = color;

    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public SpecialCard getSpecialCard() {
        return specialCard;
    }

    public void setSpecialCard(SpecialCard specialCard) {
        this.specialCard = specialCard;
    }
}
