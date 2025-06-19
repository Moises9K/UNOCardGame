package moises.Cartas;


import moises.Base.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baraja {
    private int numcartas;

    public Baraja(){
        this.numcartas = 7;
    }

    public void setNumcartas(int numcartas) {
        this.numcartas = numcartas;
    }

    public Carta aleatorizarCarta(){
        Colores[] colores = Colores.values();
        SpecialCard[] specialCards = SpecialCard.values();
        WildCard[] wildCards = WildCard.values();

        Random rand = new Random();

        int chance = rand.nextInt(100);
        Tipo chosenType;

        if (chance < 75) {
            chosenType = Tipo.Normal;
        } else if (chance < 95) {
            chosenType = Tipo.Special;
        } else {
            chosenType = Tipo.Wild;
        }

        if (chosenType == Tipo.Normal) {
            Colores randomColor = colores[rand.nextInt(colores.length)];
            int randomNumber = rand.nextInt(10);
            return new UNOCard(randomColor, randomNumber);

        } else if (chosenType == Tipo.Special) {
            Colores randomColor = colores[rand.nextInt(colores.length)];
            SpecialCard randomSpecial = specialCards[rand.nextInt(specialCards.length)];
            return new UNOSpecialCard(randomColor, randomSpecial);

        } else {
            WildCard randomWild = wildCards[rand.nextInt(wildCards.length)];
            return new UNOWildCard(randomWild);
        }
    }

    public void aleatorizarCartas(Player[] jugadores){
        for (Player player : jugadores){
            System.out.println("Dando cartas a jugador: " + player.getName());
            List<Carta> cartas = new ArrayList<>();
            for (int i=0; i<numcartas; i++){
                cartas.add(aleatorizarCarta());
                player.setCartas(cartas);
            }
        }
    }

}
