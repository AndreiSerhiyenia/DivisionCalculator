import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculatorVersion2 extends JFrame implements ActionListener {

    private JTextField divisionField;
    private JButton divisionButton;
    private JPanel mainPanel;

    public DivisionCalculatorVersion2() {
        setTitle("Division Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel divisionLabel = new JLabel("Enter two numbers for division (separated by a comma):");
        divisionField = new JTextField();
        divisionButton = new JButton("Divide");
        divisionButton.addActionListener(this);

        mainPanel.add(divisionLabel);
        mainPanel.add(divisionField);
        mainPanel.add(divisionButton);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == divisionButton) {
            try {
                String divisionText = divisionField.getText();
                String[] numbers = divisionText.split(",");

                if (numbers.length != 2) {
                    throw new IllegalArgumentException("Please enter two numbers separated by a comma.");
                }

                double dividend = Double.parseDouble(numbers[0]);
                double divisor = Double.parseDouble(numbers[1]);

                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }

                double quotient = dividend / divisor;
                JOptionPane.showMessageDialog(this, "The quotient is: " + quotient, "Division Result", JOptionPane.INFORMATION_MESSAGE);

                // Reset the window color if there were no errors
                mainPanel.setBackground(null);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                // Set the window color to bright red when division by zero occurs
                mainPanel.setBackground(Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DivisionCalculator calculator = new DivisionCalculator();
                calculator.setVisible(true);
            }
        });
    }
}
