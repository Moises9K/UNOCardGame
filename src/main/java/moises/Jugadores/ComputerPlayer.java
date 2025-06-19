package moises.Jugadores;

import moises.Base.Player;

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
}
