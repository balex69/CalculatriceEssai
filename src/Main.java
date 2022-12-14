import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{

    JFrame fenetre;
    JTextField zoneAffichage;
    JButton[] boutonsChiffres = new JButton[10];
    JButton[] boutonsFonctions = new JButton[8];
    JButton boutonAddi, boutonSous, boutonMult, boutonDivi;
    JButton boutonDeci, boutonEgal, boutonSupp, boutonEffa;
    JPanel panneau;

    Font policeUtilisee = new Font("Calibri",Font.BOLD,25);

    double num1 = 0, num2 = 0, result = 0;
    char operateur;

    Main(){

        fenetre = new JFrame("Calculatrice basique");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(380, 500);
        fenetre.setLayout(null);

        zoneAffichage = new JTextField();
        zoneAffichage.setBounds(40, 20, 280, 40);
        zoneAffichage.setFont(policeUtilisee);
        zoneAffichage.setEditable(false);

        fenetre.setResizable(false);
        fenetre.add(zoneAffichage);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

    }
    public static void main(String[] args) {

        Main calculatrice = new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}