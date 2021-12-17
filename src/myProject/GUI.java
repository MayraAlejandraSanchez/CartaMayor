package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase Dado genera un valor random entre 1 y 40
 * @author Mayra Alejandra Sánchez Salinas 202040506
 * @author Brayan Stiven Sánchez León 202043554
 * @version 1.0.0 fecha 15/12/2021
 */
public class GUI extends JFrame {
    public  static final String MENSAJE_INICIO="                                          Baraja Española\n" +
            "\n" +
            "- Quien saque la carta de mayor valor gana\n" +
            "\n" +
            "- Si jugador y máquina  sacan cartas de igual valor el \n" +
            "ganador será definido por el Palo, teniendo en cuenta \n" +
            "que Oros es mayor que Copas, Copas es mayor que \n" +
            "Espadas y Espadas es mayor que Bastos";

    private Header headerProject;
    private Escucha escucha;
    private ModelCartas modelCartas;
    private ImageIcon imagePortada ;
    private JLabel carta1,carta2 ;
    private JButton tirar;
    private JPanel panelCartas, panelResultados,panelCartasJugador, panelCartasMaquina ;
    private JTextArea mensajesSalida,resultadosCartas;
    private JSeparator separator;


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle(" CARDS GAME ");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        modelCartas = new ModelCartas();
        //Set up JComponents
        headerProject = new Header("Baraja española", Color.yellow);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
        imagePortada = new ImageIcon(getClass().getResource("/portada/portada.jpg"));
        carta1 = new JLabel(imagePortada);
        carta2 = new JLabel(imagePortada);

        tirar = new JButton("TIRAR");
        tirar.addMouseListener(escucha);
        tirar.setBackground(Color.CYAN);
        tirar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));

        panelCartasJugador = new JPanel();
        panelCartasJugador.setPreferredSize(new Dimension(150,210));
        panelCartasJugador.setBorder(BorderFactory.createTitledBorder("Carta jugador "));
        panelCartasJugador.add(carta1);
        panelCartasJugador.setBackground(Color.yellow);

        panelCartasMaquina = new JPanel();
        panelCartasMaquina.setPreferredSize(new Dimension(150,210));
        panelCartasMaquina.setBorder(BorderFactory.createTitledBorder("Carta maquina "));
        panelCartasMaquina.add(carta2);
        panelCartasMaquina.setBackground(Color.yellow);

        panelCartas = new JPanel();
        panelCartas.add(tirar);
        panelCartas.setBackground(Color.yellow);

        this.add(panelCartas,BorderLayout.SOUTH);
        this.add(panelCartasJugador,BorderLayout.WEST);
        this.add(panelCartasMaquina,BorderLayout.EAST);

        mensajesSalida= new JTextArea(7,31);
        mensajesSalida.setText(MENSAJE_INICIO);
        JScrollPane scroll = new JScrollPane(mensajesSalida);

        panelResultados= new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("¿Como se juega?"));
        panelResultados.add(scroll);
        panelResultados.setPreferredSize(new Dimension(370,180));
        panelResultados.setBackground(Color.yellow);

        this.add(panelResultados,BorderLayout.CENTER);

        resultadosCartas = new JTextArea(4,31);
        separator= new JSeparator();
        separator.setPreferredSize(new Dimension(320,7));
        separator.setBackground(Color.black);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements  MouseListener {
        private ImageIcon image;

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource()==tirar & (e.getClickCount()==1 ||e.getClickCount()==2)){

                int[] cartas = modelCartas.getCartas();
                String[] palosString = modelCartas.getPalosString();

                if (modelCartas.getFlag() == 0) {
                    tirar.setText("Turno máquina");

                    modelCartas.tiro();

                    image = new ImageIcon(getClass().getResource("/recursos/" + palosString[0]+cartas[0]+ ".png"));
                    carta1.setIcon(image);
                    panelCartasJugador.add(carta1);

                    imagePortada = new ImageIcon(getClass().getResource("/portada/portada.jpg"));
                    carta2.setIcon(imagePortada);

                } else {
                    tirar.setText("Tu turno");

                    image = new ImageIcon(getClass().getResource("/recursos/" + palosString[1]+cartas[1]+ ".png"));
                    carta2.setIcon(image);
                    panelCartasMaquina.add(carta2);


                    modelCartas.determinarJuego();

                    panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
                    resultadosCartas.setText(modelCartas.getEstadoToString());
                    resultadosCartas.setRows(4);
                    resultadosCartas.setColumns(30);
                    panelResultados.add(resultadosCartas);
                }

                revalidate();
                repaint();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
