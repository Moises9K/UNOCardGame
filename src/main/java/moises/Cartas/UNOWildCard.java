package moises.Cartas;

import moises.Base.Carta;
import moises.Base.Tipo;
import moises.Base.WildCard;

public class UNOWildCard extends Carta {
    WildCard wildCard;
    public UNOWildCard(WildCard wildCard) {
        super(wildCard.name(), Tipo.Wild);
        this.wildCard = wildCard;

    }

    public WildCard getWildCard() {
        return wildCard;
    }
}
