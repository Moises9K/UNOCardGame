package moises.Cartas;

import moises.Base.Carta;
import moises.Base.Colores;
import moises.Base.Tipo;
import moises.Base.WildCard;
import moises.GameLogic.Juego;

public class UNOWildCard extends Carta {
    WildCard wildCard;
    public UNOWildCard(WildCard wildCard) {
        super(wildCard.name(), Tipo.Wild);
        this.wildCard = wildCard;
    }

    public WildCard getWildCard() {
        return wildCard;
    }

    @Override
    public boolean jugadaValida(Carta cartaEnMesa) {
        return true;
    }

    @Override
    public void realizarEfecto(Juego juego) {

        if (this.wildCard == WildCard.Wild_Draw_Four){
            Baraja baraja = new Baraja();
            Carta[] cartas = {baraja.aleatorizarCarta(), baraja.aleatorizarCarta(),baraja.aleatorizarCarta(), baraja.aleatorizarCarta()};
            juego.drawCardsPlayer(cartas);
        }
    }
}
