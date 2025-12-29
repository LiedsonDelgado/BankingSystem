package ui;
import java.awt.*;
import javax.swing.*;

public class ATM_GUI extends JFrame{
        public ATM_GUI(){
            super("ATM");
            setSize(new Dimension(800,600));
            setLayout(new BorderLayout());

            JButton b0 = new JButton("0");
            JButton b1 = new JButton("1");
            JButton b2 = new JButton("2");
            JButton b3 = new JButton("3");
            JButton b4 = new JButton("4");
            JButton b5 = new JButton("5");
            JButton b6 = new JButton("6");
            JButton b7 = new JButton("7");
            JButton b8 = new JButton("8");
            JButton b9 = new JButton("9");
            JButton bOk = new JButton("Ok");
            JButton bCancel = new JButton("Cancel");

            JPanel buttonArea = new JPanel();
            buttonArea.add(b1);
            buttonArea.add(b2);
            buttonArea.add(b3);
            buttonArea.add(b4);
            buttonArea.add(b5);
            buttonArea.add(b6);
            buttonArea.add(b7);
            buttonArea.add(b8);
            buttonArea.add(b9);
            buttonArea.add(b0);
            buttonArea.add(bOk);
            buttonArea.add(bCancel);

            add(buttonArea,BorderLayout.SOUTH);

            setVisible(true);
        }
}