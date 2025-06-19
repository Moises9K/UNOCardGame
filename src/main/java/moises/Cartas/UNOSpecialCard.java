package moises.Cartas;

import moises.Base.*;
import moises.GameLogic.Juego;

public class UNOSpecialCard extends Carta {
    SpecialCard specialCard;

    public UNOSpecialCard(Colores color, SpecialCard specialCard) {
        super(color.name() + specialCard.name(), Tipo.Special);
        this.specialCard = specialCard;
        this.setColor(color);
    }


    public SpecialCard getSpecialCard() {
        return specialCard;
    }

    @Override
    public boolean jugadaValida(Carta cartaEnMesa) {

        if (this.getColor() == cartaEnMesa.getColor()) {
            return true;
        }
        else if (cartaEnMesa.getTipo() == Tipo.Special) {
            UNOSpecialCard cartaenmesa = (UNOSpecialCard) cartaEnMesa;
            return this.specialCard == cartaenmesa.getSpecialCard();
        }
        return false;

    }

    @Override
    public void realizarEfecto(Juego juego) {
        if (this.getSpecialCard() == SpecialCard.Draw_Two){
            Baraja baraja = new Baraja();
            Carta[] cartas = {baraja.aleatorizarCarta(), baraja.aleatorizarCarta()};
            juego.drawCardsPlayer(cartas);
        }
        else if (this.getSpecialCard() == SpecialCard.Reverse){
            juego.reverseFunction();
        }
        else if (this.getSpecialCard() == SpecialCard.Skip){
            juego.skipFunction();
        }
    }
}
