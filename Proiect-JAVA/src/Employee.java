import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee {
    private JPanel Main;
    private JButton saveButton;
    private JTable table1;
    private JButton updateButton;
    private JButton deleteButton1;
    private JButton searchButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField employeeRegistrationTextField;
    private JTextField txtid;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee");
        frame.setContentPane(new Employee().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Employee() {
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
