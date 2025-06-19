package moises;

import moises.Base.Player;
import moises.Cartas.Baraja;
import moises.GameLogic.ConsoleGame;
import moises.GameLogic.Juego;
import moises.Jugadores.ComputerPlayer;
import moises.Jugadores.HumanPlayer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Objetivo del juego: Ser el primer jugador en remover todas las cartas que le tocaron
        //Se reparten 7 cartas a cada uno
        //Cuando se tiene una carta en la mano, gritar UNO
        Baraja baraja = new Baraja();
        Player[]  players = {new HumanPlayer("Jugador Humano"), new HumanPlayer("Jugador Computer1"), new HumanPlayer("Jugador Computer2")};

        Juego juego = new Juego(baraja, players);
        ConsoleGame console = new ConsoleGame(juego);
        console.iniciarJuego();



    }
}