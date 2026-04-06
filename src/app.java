import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JTextField nameField, totalClassesField, attendedField;
    private JTextArea resultArea;

    public App() {
        setTitle("Student Attendance Analyzer");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // UI Components
        add(new JLabel("Student Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Total Classes Held:"));
        totalClassesField = new JTextField(20);
        add(totalClassesField);

        add(new JLabel("Classes Attended:"));
        attendedField = new JTextField(20);
        add(attendedField);

        JButton analyzeButton = new JButton("Analyze Attendance");
        add(analyzeButton);

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        // Logic for Button Click
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAttendance();
            }
        });
    }

    private void calculateAttendance() {
        try {
            String name = nameField.getText();
            double total = Double.parseDouble(totalClassesField.getText());
            double attended = Double.parseDouble(attendedField.getText());

            if (attended > total) {
                JOptionPane.showMessageDialog(this, "Attended classes cannot exceed total classes.");
                return;
            }

            double percentage = (attended / total) * 100;
            String status = (percentage >= 75) ? "Satisfactory" : "Low Attendance - Action Required";

            resultArea.setText("--- Attendance Report ---\n" +
                             "Student: " + name + "\n" +
                             "Percentage: " + String.format("%.2f", percentage) + "%\n" +
                             "Status: " + status);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for classes.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
