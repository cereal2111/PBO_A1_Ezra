import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class HRISGUI extends JFrame {
    private JFrame frame;
    private JComboBox<String> departmentComboBox;
    private JComboBox<String> positionComboBox;
    private JTextField nameField;
    private JTextField dobField;
    private JButton addEmployeeButton;
    private JButton cancelButton;
    private JTextArea displayArea;
    private JTextField findIdField;
    private JButton addButton;
    private JButton showAllButton;
    private ArrayList<Employee> employees = new ArrayList<>();

    public HRISGUI() {
        frame = new JFrame("HRIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(showMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JPanel showMainPanel() {
        addButton = new JButton("Add Data");
        showAllButton = new JButton("Show Data");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showInputPanel());
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showAllDataPanel());
            }
        });

        return buttonPanel;
    }

    private JPanel showAllDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(1, 2));

        findIdField = new JTextField(15);
        topPanel.add(findIdField);

        cancelButton = new JButton("Cancel");
        topPanel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        displayArea = new JTextArea(20, 50);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        StringBuilder strBuilder = new StringBuilder();
        for (Employee emp : employees) {
            strBuilder.append(emp.toString()).append("\n");
        }
        displayArea.setText(strBuilder.toString());

        return panel;
    }

    private void repaintPanel(JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(newPanel);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel showInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));  // Mengubah dari 6 ke 7 untuk menambahkan tombol cancel

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel dobLabel = new JLabel("Date of Birth (DDMMYYYY):");
        dobField = new JTextField(15);

        JLabel departmentLabel = new JLabel("Department:");
        String[] departments = Employee.getDepartment();
        departmentComboBox = new JComboBox<>(departments);

        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);

        addEmployeeButton = new JButton("Add Data");
        cancelButton = new JButton("Cancel");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentComboBox);
        inputPanel.add(positionLabel);
        inputPanel.add(positionComboBox);
        inputPanel.add(cancelButton);  // Menambahkan tombol cancel
        inputPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String dob = dobField.getText();
                String department = departmentComboBox.getSelectedItem().toString();
                String position = positionComboBox.getSelectedItem().toString();

                if (name.isEmpty() || dob.isEmpty() || department.isEmpty() || position.isEmpty()) {
                    JOptionPane.showMessageDialog(HRISGUI.this, "Please fill all fields.");
                    return;
                }

                String id = generateUniqueId(department, dob);
                Employee employee;

                switch (position) {
                    case "Manager":
                        employee = new Manager(name, dob, id);
                        break;
                    case "Developer":
                        employee = new Developer(name, dob, id);
                        break;
                    case "HR Staff":
                        employee = new HRStaff(name, dob, id);
                        break;
                    default:
                        JOptionPane.showMessageDialog(HRISGUI.this, "Invalid position selected.");
                        return;
                }

                employees.add(employee);
                JOptionPane.showMessageDialog(HRISGUI.this, "Employee added: " + employee);
                repaintPanel(showMainPanel());
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        return inputPanel;
    }

    private String generateUniqueId(String department, String dob) {
        String depCode = department.equals("Product") ? "PROD" : "HR";
        int randomNum = new Random().nextInt(1000);
        return String.format("000%s%s%03d", depCode, dob, randomNum);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}
