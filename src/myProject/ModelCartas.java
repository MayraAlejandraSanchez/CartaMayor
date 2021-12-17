package myProject;
/**
 * Clase ModelCartas para generar el modelo de juego
 * @author Mayra Alejandra Sánchez Salinas 202040506
 * @author Brayan Stiven Sánchez León 202043554
 * @version 1.0.0 fecha 15/12/2021
 */
public class ModelCartas {
    /**
     * Variables creadas para la realizacion del ModelCartas
     */
    private Cartas carta1, carta2;
    private int estado, flag;
    private int[] cartas;
    private int[] palos;
    private String estadoToString;
    private String[] palosString;

    /**
     * Inicializar variables
     */
    public ModelCartas() {
        carta1 = new Cartas();
        carta2 = new Cartas();
        cartas = new int[2];
        palos = new int[2];
        palosString = new String[2];
        flag = 0;
    }
    /**
     * Funcion tiro, sirve para obtener el valor de la carta con su palo correpondiente
     */
    public void tiro() {
        cartas[0] = carta1.getValor();
        palos[0] = carta1.getPalo();
        cartas[1] = carta2.getValor();
        palos[1] = carta2.getPalo();

        if (flag == 0) {
            flag = 1;
        } else {
            flag = 0;
        }

        switch (palos[0]) {
            case 1:
                palosString[0] = "oro";
                break;
            case 2:
                palosString[0] = "copas";
                break;
            case 3:
                palosString[0] = "espadas";
                break;
            case 4:
                palosString[0] = "bastos";
                break;
            default:
                break;
        }

        switch (palos[1]) {
            case 1:
                palosString[1] = "oro";
                break;
            case 2:
                palosString[1] = "copas";
                break;
            case 3:
                palosString[1] = "espadas";
                break;
            case 4:
                palosString[1] = "bastos";
                break;
            default:
                break;
        }
    }
    /**
     * Esta funcion determina el juego.
     * si carta jugador > carta maquina, lo dirige a un estado=1, el cual se encargara mas adelante de decir el resultado ya en String
     * si carta jugador < carta maquina, lo dirige a un estado=2, el cual se encargara mas adelante de decir el resultado ya en String
     * si carta jugador == carta maquina, donde tendra que entrar en juego el valor del palo obtenido de la carta
     * si el valor del palo de la carta del jugador es < al palo de la maquina entonces lo dirige a un estado =3
     * si el valor del palo de la carta del jugador es > al palo de la maquina entonces lo dirige a un estado =4
     * y si no a un estado = 5, el cual vendria siendo un "empate" porque sacaria igual numero e igual palo
     */
    public void determinarJuego() {
        if (cartas[0] > cartas[1]) {
            estado = 1;
        } else {
            if (cartas[0] < cartas[1]) {
                estado = 2;
            } else {
                if (cartas[0] == cartas[1]) {
                    if (palos[0] < palos[1]) {
                        estado = 3;
                    } else {
                        if (palos[0] > palos[1]) {
                            estado = 4;
                        } else {
                            estado = 5;
                        }
                    }
                }
            }
        }
        if (flag == 0) {
            flag = 1;
        } else {
            flag = 0;
        }
    }

    /**
     * Switch el cual sirve para darle uso a la variable estado y hacer mas reducido el codigo
     * @return String del resultado
     */
    public String getEstadoToString() {
        switch (estado) {
            case 1:
                estadoToString = "                 Has sacado la carta con mayor valor\n" +
                        "\n" +
                        "                                           ¡Has ganado!";
                break;
            case 2:
                estadoToString = "         La maquina ha sacado la carta con mayor valor\n" +
                        "\n" +
                        "                                            ¡Has pérdido!";
                break;
            case 3:
                estadoToString = "Has sacado el mismo valor de carta que la máquina, pero tu \n" +
                        "                      sacaste un palo mejor que la máquina.\n" +
                        "\n" +
                        "                                                ¡Has ganado!";
                break;
            case 4:
                estadoToString = "Has sacado el mismo valor de carta que la máquina, pero la \n" +
                        "                         máquina sacó un palo mejor que tú.\n" +
                        "\n" +
                        "                                                ¡Has pérdido!";
                break;
            case 5:
                estadoToString = "   Has sacado el mismo valor y palo de carta que la máquina.\n" +
                        "\n" +
                        "                                      ¡Ha sido un empate!\n";
                break;

            default:
                break;

        }
        return estadoToString;
    }

    public int[] getCartas() {
        return cartas;
    }

    public int[] getPalos() {
        return palos;
    }

    public String[] getPalosString() {
        return palosString;
    }

    public int getFlag() {
        return flag;
    }

}
