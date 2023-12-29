import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // Declaration of GUI components
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    // Font for the calculator display
    Font myFont = new Font("New Times Roman", Font.BOLD, 30);

    // Variables to store numbers and results, and the current operator
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor to set up the calculator GUI
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Initialize buttons for arithmetic operations and other functions
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");
        negButton = new JButton("(-)");

        // Populate the functionButtons array for easy access and configuration
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = decButton;
        functionButtons[4] = equButton;
        functionButtons[5] = divButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Configure listeners, fonts, and focusability for function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Configure listeners, fonts, and focusability for number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Set positions for additional function buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Set up the panel for number and function buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel in a specific order
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame
        frame.add(negButton);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    // Main method to launch the calculator application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator();
        });
    }

    // ActionListener implementation to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle number button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Handle arithmetic operation button clicks
        if (e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton || e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = e.getActionCommand().charAt(0);
            textField.setText("");
        }

        // Handle equals button click
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            // Perform the calculation based on the operator
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            // Display the result and update num1 for further calculations
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        // Handle clear button click
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // Handle negation button click
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}

