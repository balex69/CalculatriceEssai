import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{

    JFrame fenetre;
    JTextField zoneAffichage;
    JButton[] boutonsChiffres = new JButton[10];
    JButton[] boutonsFonctions = new JButton[9];
    JButton boutonAddi, boutonSous, boutonMult, boutonDivi;
    JButton boutonDeci, boutonEgal, boutonSupp, boutonEffa, boutonRset;
    JPanel panneau;

    Font policeUtilisee = new Font("Calibri",Font.BOLD,20);

    double num1 = 0, num2 = 0, resultat = 0;
    char operateur;

    Main(){

        fenetre = new JFrame("Calculatrice basique");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(360, 440);
        fenetre.setLayout(null);

        zoneAffichage = new JTextField();
        zoneAffichage.setHorizontalAlignment(SwingConstants.RIGHT);
        zoneAffichage.setBounds(40, 20, 260, 40);
        zoneAffichage.setFont(policeUtilisee);
        zoneAffichage.setEditable(false);

        boutonAddi = new JButton("+"); // instanciation des boutons de fonction
        boutonSous = new JButton("-");
        boutonMult = new JButton("x");
        boutonDivi = new JButton("/");
        boutonDeci = new JButton(".");
        boutonEgal = new JButton("=");
        boutonSupp = new JButton("<-");
        boutonEffa = new JButton("CE");
        boutonRset = new JButton("C");

        boutonsFonctions[0] = boutonAddi; // ajout à l'array
        boutonsFonctions[1] = boutonSous;
        boutonsFonctions[2] = boutonMult;
        boutonsFonctions[3] = boutonDivi;
        boutonsFonctions[4] = boutonDeci;
        boutonsFonctions[5] = boutonEgal;
        boutonsFonctions[6] = boutonSupp;
        boutonsFonctions[7] = boutonEffa;
        boutonsFonctions[8] = boutonRset;

        for(int i = 0; i < 9; i++) { // ajout de l'actionlistener à chaque bouton
            boutonsFonctions[i].addActionListener(this);
            boutonsFonctions[i].setFont(policeUtilisee);
            boutonsFonctions[i].setHorizontalAlignment(SwingConstants.CENTER);
            boutonsFonctions[i].setVerticalAlignment(SwingConstants.BOTTOM);
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
            boutonsChiffres[i].setHorizontalAlignment(SwingConstants.CENTER);
            boutonsChiffres[i].setVerticalAlignment(SwingConstants.BOTTOM);
            boutonsChiffres[i].setFocusable(false);
        }

        boutonEffa.setBounds(40, 80, 70,40);
        boutonRset.setBounds(135, 80, 70, 40);
        boutonSupp.setBounds(230, 80, 70, 40);

        fenetre.add(boutonEffa);
        fenetre.add(boutonRset);
        fenetre.add(boutonSupp);

        JPanel positionTouches = new JPanel();
        positionTouches.setBounds(40, 140, 260, 240);
        //positionTouches.setBackground(Color.gray); //aidait à positionner correctement le panel
        positionTouches.setLayout(new GridLayout(4,4,20,25));
        positionTouches.add(boutonsChiffres[1]);
        positionTouches.add(boutonsChiffres[2]);
        positionTouches.add(boutonsChiffres[3]);
        positionTouches.add(boutonsFonctions[3]);
        positionTouches.add(boutonsChiffres[4]);
        positionTouches.add(boutonsChiffres[5]);
        positionTouches.add(boutonsChiffres[6]);
        positionTouches.add(boutonsFonctions[2]);
        positionTouches.add(boutonsChiffres[7]);
        positionTouches.add(boutonsChiffres[8]);
        positionTouches.add(boutonsChiffres[9]);
        positionTouches.add(boutonsFonctions[1]);
        positionTouches.add(boutonsChiffres[0]);
        positionTouches.add(boutonsFonctions[4]);
        positionTouches.add(boutonsFonctions[5]);
        positionTouches.add(boutonsFonctions[0]);

        fenetre.add(positionTouches);
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

        for(int i = 0 ; i < 10 ; i++) {
            if(e.getSource() == boutonsChiffres[i]) {
                zoneAffichage.setText(zoneAffichage.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == boutonDeci) {
            zoneAffichage.setText(zoneAffichage.getText().concat("."));
        }
        if(e.getSource() == boutonAddi) {
            num1 = Double.parseDouble(zoneAffichage.getText());
            operateur = '+';
            zoneAffichage.setText("");
        }
        if(e.getSource() == boutonSous) {
            num1 = Double.parseDouble(zoneAffichage.getText());
            operateur = '-';
            zoneAffichage.setText("");
        }
        if(e.getSource() == boutonMult) {
            num1 = Double.parseDouble(zoneAffichage.getText());
            operateur = 'x';
            zoneAffichage.setText("");
        }
        if(e.getSource() == boutonDivi) {
            num1 = Double.parseDouble(zoneAffichage.getText());
            operateur = '/';
            zoneAffichage.setText("");
        }
        if(e.getSource() == boutonEgal) {
            num2 = Double.parseDouble(zoneAffichage.getText());

            switch(operateur) {
                case '+':
                    resultat = num1 + num2;
                    break;
                case '-':
                    resultat = num1 - num2;
                    break;
                case 'x':
                    resultat = num1 * num2;
                    break;
                case '/':
                    resultat = num1 / num2;
                    break;
            }
            zoneAffichage.setText(String.valueOf(resultat));
            num1 = resultat;
        }
        if(e.getSource() == boutonEffa) {
            zoneAffichage.setText("");
        }
        if(e.getSource() == boutonSupp) {
            String string = zoneAffichage.getText();
            zoneAffichage.setText("");
            for(int i = 0 ; i < string.length()-1 ; i++) {
                zoneAffichage.setText(zoneAffichage.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == boutonRset) {
            zoneAffichage.setText("");
            num1 = 0;
            num2 = 0;
            resultat = 0;
        }
    }
}