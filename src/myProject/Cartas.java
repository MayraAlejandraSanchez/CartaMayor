package myProject;

import java.util.Random;
/**
 * Clase Cartas genera un valor random entre 1 y 40
 * @author Mayra Alejandra Sánchez Salinas 202040506
 * @author Brayan Stiven Sánchez León 202043554
 * @version 1.0.0 fecha 15/12/2021
 */
public class Cartas {
    /**
     * Atributos de la carta
     * Valor: 1 al 12, excepto 8 y 9
     * Palo: Bastos, Oros ,Copas, Espadas
     */
    private int valor,palo;

    /**
     * Metodo que genera el numero aleatorio entre 1 y 12 para la carta a exepcion del nm 8 y el 9
     * @return valor de la carta
     */
    public int getValor() {
        Random aleatorio = new Random();
        valor = aleatorio.nextInt(12)+1;
        if (valor==8 ||valor==9){
            getValor();
        }else {
            return valor;
        }
        return 1;
    }
    /**
     * Metodo que genera el numero aleatorio entre 1 y 4 para la carta y determinar que palo salio
     * @return palo de la carta
     */
    public int getPalo() {
        Random aleatorio = new Random();
        palo = aleatorio.nextInt(4)+1;
        return palo;
    }
}