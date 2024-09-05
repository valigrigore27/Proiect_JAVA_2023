import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class DashboardForm {

    private JPanel dashboardPanel;
    private JTextField txtName;
    private JTextField txtSalary;
    private JTextField txtMobile;
    private JButton saveButton;
    private JTable table1;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton updateButton;
    private JTextField txtId;
    private JScrollPane table_1;

    Connection con;
    PreparedStatement pstmt;

    void table_load(){

        try {
            pstmt = con.prepareStatement("select * from employee");
            ResultSet rs = pstmt.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public DashboardForm() {
        connect();
        table_load();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String empname, salary, mobile;
                empname = txtName.getText();
                salary = txtSalary.getText();
                mobile = txtMobile.getText();

                try{
                    pstmt = con.prepareStatement("insert into employee(empname, salary, mobile) values (?,?,?)");
                    pstmt.setString(1,empname);
                    pstmt.setString(2, salary);
                    pstmt.setString(3,mobile);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record added!");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String empid = txtId.getText();

                    pstmt = con.prepareStatement("select empname, salary, mobile from employee where id = ?");
                    pstmt.setString(1, empid);
                    ResultSet rs = pstmt.executeQuery();

                    if(rs.next()==true)
                    {
                        String empname = rs.getString(1);
                        String emsalary = rs.getString(2);
                        String emmobile = rs.getString(3);
                        JOptionPane.showMessageDialog(null, "Employee Name: "+empname+ ", with salary: "+emsalary+ " and phone number: " + emmobile);

                    }
                    else {
                        txtName.setText("");
                        txtSalary.setText("");
                        txtMobile.setText("");
                        JOptionPane.showMessageDialog(null, "Invalid Employee Id");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String empid;

                empid = txtId.getText();
                try {
                    pstmt = con.prepareStatement("delete from employee where id = ?");
                    pstmt.setString(1,empid);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "The employee with id "+ empid + " was deleted.");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DashboardForm");
        frame.setContentPane(new DashboardForm().dashboardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void connect() {
        final String DB_URL = "jdbc:mysql://localhost/company";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
