package moises.Jugadores;

import moises.Base.Carta;
import moises.Base.Colores;
import moises.Base.Player;
import moises.Base.Tipo;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name){
        super(name);
    }

    @Override
    public int jugarCarta() {
        Random rand = new Random();
        System.out.println("Turno de " + getName());
        return rand.nextInt(super.getCartas().size());
    }

    @Override
    public void darColorCartaWild(Carta carta) {
        if (carta.getTipo() == Tipo.Wild){
            Random rand = new Random();
            Colores[] colores = Colores.values();
            carta.setColor(colores[rand.nextInt(colores.length)]);
        }
    }
}
