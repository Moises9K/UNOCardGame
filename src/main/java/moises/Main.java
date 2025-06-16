package moises;

import moises.GameLogic.Juego;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Objetivo del juego: Ser el primer jugador en remover todas las cartas que le tocaron
        //Se reparten 7 cartas a cada uno
        //Cuando se tiene una carta en la mano, gritar UNO
        Juego juego = new Juego(2);

    }
}