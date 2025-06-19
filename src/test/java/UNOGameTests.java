import moises.Base.Carta;
import moises.Base.Player;
import moises.Cartas.Baraja;
import moises.GameLogic.Juego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UNOGameTests {

    @Test
    public void inicializarjuegoNumeroDeJugadoresCorrectosTest(){
        Baraja baraja = new Baraja();
        Player[] players = new Player[2];
        for(int i = 0; i < players.length; i++){
            players[i] = new Player("Jugador "+(i+1));
        }

        Juego juego = new Juego(baraja, players);
        Assertions.assertEquals(players.length, juego.getJugadores().length);
    }

    @Test
    public void jugadoresTienenCartasTest(){
        Baraja baraja = new Baraja();
        Player[] players = new Player[2];
        for(int i = 0; i < players.length; i++){
            players[i] = new Player("Jugador "+(i+1));
        }
        Juego juego = new Juego(baraja, players);
        //players[1].eliminarCarta(2);
        boolean tienenCartas = true;
        for(Player p : players){
            for (Carta c : p.getCartas()){
                if(c == null){
                    tienenCartas = false;
                }
            }
        }
        Assertions.assertTrue(tienenCartas);
    }

}
