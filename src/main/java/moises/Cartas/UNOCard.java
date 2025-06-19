package moises.Cartas;

import moises.Base.Carta;
import moises.Base.Colores;
import moises.Base.Tipo;
import moises.GameLogic.Juego;

public class UNOCard extends Carta {
    private int numero;

    public UNOCard(Colores color, int numero) {
        super(color.name() + numero, Tipo.Normal);
        this.numero = numero;
        super.setColor(color);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean jugadaValida(Carta cartaEnMesa) {


        if(this.getColor() == cartaEnMesa.getColor()) {
            return true;
        }

        else if( cartaEnMesa.getTipo() == Tipo.Normal) {
            UNOCard cartaenmesa =  (UNOCard) cartaEnMesa;
            return this.getColor() == cartaenmesa.getColor() || this.getNumero() == cartaenmesa.getNumero();
        }

        return false;
    }

    @Override
    public void realizarEfecto(Juego juego) {
        System.out.println("Esta carta no realiza efectos especiales");
    }
}
