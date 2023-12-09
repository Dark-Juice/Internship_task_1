 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[]numberButtons = new JButton[10];
    JButton[]functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton;
    JPanel panel;

    Font myFont = new Font("New Times Roman",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont( myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("_");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");


        functionButtons[0] =addButton;
        functionButtons[1] =subButton;
        functionButtons[2] =mulButton;
        functionButtons[3] =decButton;
        functionButtons[4] =equButton;
        functionButtons[5] =divButton;
        functionButtons[6] =delButton;
        functionButtons[7] =clrButton;

       for(int i =0; i<8;i++) {
           functionButtons[i].addActionListener(this);
           functionButtons[i].setFont(myFont);
           functionButtons[i].setFocusable(false);


       }

        for(int i =0; i<10;i++) {
        numberButtons[i] = new JButton(String.valueOf(i));


        }



        frame.add(textField);
        frame.setVisible(true);


    }
    public static void main(String[] args) {

      Calculator calc = new Calculator ();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
