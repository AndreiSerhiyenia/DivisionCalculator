import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculator extends JFrame implements ActionListener {

    private JTextField dividendField;
    private JTextField divisorField;
    private JButton divisionButton;

    public DivisionCalculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel dividendLabel = new JLabel("Dividend:");
        dividendField = new JTextField();
        JLabel divisorLabel = new JLabel("Divisor:");
        divisorField = new JTextField();
        divisionButton = new JButton("Divide");
        divisionButton.addActionListener(this);

        panel.add(dividendLabel);
        panel.add(dividendField);
        panel.add(divisorLabel);
        panel.add(divisorField);
        panel.add(divisionButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == divisionButton) {
            try {
                double dividend = Double.parseDouble(dividendField.getText());
                double divisor = Double.parseDouble(divisorField.getText());

                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }

                double quotient = dividend / divisor;
                JOptionPane.showMessageDialog(this, "The quotient is: " + quotient, "Division Result", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DivisionCalculatorVersion2 calculator = new DivisionCalculatorVersion2();
                calculator.setVisible(true);
            }
        });
    }
}
