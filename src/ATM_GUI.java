import java.awt.*;
import javax.swing.*;

public class ATM_GUI{
    public static void main(String[] args){
        JFrame atmWindow = new JFrame("ATM");
        atmWindow.getContentPane().setBackground(new Color(104, 104, 104));
        atmWindow.setSize(new Dimension(700,700));

        FlowLayout atmLayout = new FlowLayout();
        atmWindow.setLayout(atmLayout);

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
        JButton bEnter = new JButton("ENTER");

        atmWindow.add(b1);
        atmWindow.add(b2);
        atmWindow.add(b3);
        atmWindow.add(b4);
        atmWindow.add(b5);
        atmWindow.add(b6);
        atmWindow.add(b7);
        atmWindow.add(b7);
        atmWindow.add(b8);
        atmWindow.add(b9);
        atmWindow.add(b0);
        atmWindow.add(bCancel);
        atmWindow.add(bEnter);


        atmWindow.setVisible(true);
    }
}