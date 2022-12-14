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
        fenetre.setSize(360, 500);
        fenetre.setLayout(null);

        zoneAffichage = new JTextField();
        zoneAffichage.setBounds(40, 20, 260, 40);
        zoneAffichage.setFont(policeUtilisee);
        zoneAffichage.setEditable(false);

        boutonAddi = new JButton("+"); // instanciation des boutons de fonction
        boutonSous = new JButton("-");
        boutonMult = new JButton("x");
        boutonDivi = new JButton("%");
        boutonDeci = new JButton(".");
        boutonEgal = new JButton("=");
        boutonSupp = new JButton("<-");
        boutonEffa = new JButton("C");

        boutonsFonctions[0] = boutonAddi; // ajout à l'array
        boutonsFonctions[1] = boutonSous;
        boutonsFonctions[2] = boutonMult;
        boutonsFonctions[3] = boutonDivi;
        boutonsFonctions[4] = boutonDeci;
        boutonsFonctions[5] = boutonEgal;
        boutonsFonctions[6] = boutonSupp;
        boutonsFonctions[7] = boutonEffa;

        for(int i = 0; i < 8; i++) { // ajout de l'actionlistener à chaque bouton
            boutonsFonctions[i].addActionListener(this);
            boutonsFonctions[i].setFont(policeUtilisee);
            boutonsFonctions[i].setFocusable(false);
        }

        /*boutonsChiffres[0] = new JButton("0"); // utilisé pour créer les boutons chiffres, mais comme anonymes, peut juste instancier avec un for
        boutonsChiffres[1] = new JButton("1");  // fonctionne très bien car chiffres, donc peut simplement avoir une itération et ++
        boutonsChiffres[2] = new JButton("2");
        boutonsChiffres[3] = new JButton("3");
        boutonsChiffres[4] = new JButton("4");
        boutonsChiffres[5] = new JButton("5");
        boutonsChiffres[6] = new JButton("6");
        boutonsChiffres[7] = new JButton("7");
        boutonsChiffres[8] = new JButton("8");
        boutonsChiffres[9] = new JButton("9");*/

        for(int i = 0; i < 10; i++) { // instanciation + actionlistener sur chaque bouton, comme pas de symbole il suffit de prendre la valeur d'index comme titre
            boutonsChiffres[i] = new JButton(String.valueOf(i));
            boutonsChiffres[i].addActionListener(this);
            boutonsChiffres[i].setFont(policeUtilisee);
            boutonsChiffres[i].setFocusable(false);
        }

        boutonEffa.setBounds(40, 80, 120,40);
        boutonSupp.setBounds(180, 80, 120, 40);

        fenetre.add(boutonEffa);
        fenetre.add(boutonSupp);

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