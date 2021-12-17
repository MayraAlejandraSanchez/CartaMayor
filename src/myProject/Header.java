package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * Clase ModelCartas para generar el modelo de juego
 * @author Mayra Alejandra Sánchez Salinas 202040506
 * @author Brayan Stiven Sánchez León 202043554
 * @version 1.0.0 fecha 15/12/2021
 */
public class Header extends JLabel {
    /**
     * Constructor of the Header class
     * @param title String that contains Header text
     * @param colorBackground Color object to be assigned for the Header background
     */
    public Header(String title, Color colorBackground){
        this.setText(title);
        this.setBackground(colorBackground);
        this.setForeground(new Color(0, 0, 0));
        this.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
