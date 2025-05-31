package ATM;

import java.awt.*;
import javax.swing.*;

/**
 * classe que representa a parte grafica do teclado do ATM
 */
public class ATM_GUI{
    public static void main(String[] args){
        JFrame atmWindow = new JFrame("ATM");
        atmWindow.getContentPane().setBackground(new Color(104, 104, 104));
        atmWindow.setSize(new Dimension(700,700));
        atmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        atmWindow.setLayout(new BorderLayout());

        JButton b1= new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6= new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");

        JButton bCancel = new JButton("CANCEL");
        JButton bClear = new JButton("CLEAR");
        JButton bEnter = new JButton("ENTER");

        //Painel de botões numerico no formato de 4 linhas e 3 colunas
        JPanel numberPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        numberPanel.add(b1);
        numberPanel.add(b2);
        numberPanel.add(b3);
        numberPanel.add(b4);
        numberPanel.add(b5);
        numberPanel.add(b6);
        numberPanel.add(b7);
        numberPanel.add(b8);
        numberPanel.add(b9);
        numberPanel.add(new JLabel()); 
        numberPanel.add(b0);
        numberPanel.add(new JLabel());

        //Painel de botões de ação no formato de 3 linhas e 1 coluna
        JPanel actionPanel = new JPanel(new GridLayout(3, 1, 10, 20));
        actionPanel.add(bCancel);
        actionPanel.add(bClear);
        actionPanel.add(bEnter);

        atmWindow.add(numberPanel, BorderLayout.CENTER);
        atmWindow.add(actionPanel, BorderLayout.EAST);

        atmWindow.setVisible(true);
    }
}