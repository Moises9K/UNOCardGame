import moises.Base.Carta;
import moises.Base.Player;
import moises.GameLogic.Juego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UNOGameTests {

    @Test
    public void inicializarjuegoNumeroDeJugadoresCorrectosTest(){
        int numJugadores = 4;
        Juego juego = new Juego(numJugadores);
        Player[] players = juego.getJugadores();
        Assertions.assertEquals(numJugadores, players.length);
    }

    @Test
    public void jugadoresTienenCartasTest(){
        Juego juego = new Juego(4);
        Player[] players = juego.getJugadores();
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
