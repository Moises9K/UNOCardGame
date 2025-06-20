package moises.Jugadores;

import moises.Base.Carta;
import moises.Base.Colores;
import moises.Base.Player;
import moises.Base.Tipo;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int jugarCarta() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Turno de " + getName());
        System.out.println("Escoga una carta para jugar:");
        int i;
        for (i = 0; i < super.getCartas().size(); i++) {
            StringBuffer sb = new StringBuffer();
            sb.append("Carta ").append(i + 1).append(" : ").append(super.getCartas().get(i).getName());
            System.out.println(sb);
        }
        System.out.println("Aleatorizar Carta: " + (i + 1));
        int choice;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt() - 1;
                if (choice > super.getCartas().size()) {
                    System.out.println("Numero invalido para jugar");
                    sc.next();
                } else {
                    if (choice == super.getCartas().size()) {
                        System.out.println("Aleatorizando Carta");
                        break;
                    }

                    Carta carta = super.getCartas().get(choice);
                    if (carta.getTipo() == Tipo.Wild){
                        darColorCartaWild(carta);
                    }
                    break;
                }
            } else {
                System.out.println("Ingrese un numero valido");
                sc.next();
            }
        }
        return choice;
    }

    @Override
    public void darColorCartaWild(Carta carta) {
        if(carta.getColor() == null){
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Ingrese color para esta carta: ");
            for(int z = 0; z<Colores.values().length; z++){
                System.out.println("Color " + (z+1) + ": " + Colores.values()[z]);
            }
            Colores color;
            int colorindex;
            while (true){
                if (sc2.hasNextInt()) {
                    colorindex = sc2.nextInt() - 1;
                    if(colorindex >= Colores.values().length){
                        System.out.println("Numero invalido para escoger color");
                        sc2.next();
                    }
                    else{
                        color = Colores.values()[colorindex];
                        carta.setColor(color);
                        break;
                    }
                }
                else{
                    System.out.println("Ingrese un numero valido");
                    sc2.next();
                }

            }
        }
        else{
            System.out.println("Ya tiene Color");
        }
    }
}
