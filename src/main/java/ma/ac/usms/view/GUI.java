package ma.ac.usms.view;


import ma.ac.usms.dao.ProjectDao;
import ma.ac.usms.dto.Project;
import ma.ac.usms.dto.Tache;
import ma.ac.usms.service.ProjectService;
import ma.ac.usms.service.TacheService;
import ma.ac.usms.service.factory.ServiceFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {

    private ProjectService projectService;
    private TacheService tacheService;
    private JTextField ownerField;
    private JTextField titleField;
    private JButton validateButton;

    public GUI() {

        projectService=ServiceFactory.getprojectService();
        tacheService=ServiceFactory.getTacheService();

        setTitle("Fancy Main Frame");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create labels for input fields with custom font
        JLabel ownerLabel = new JLabel("Owner:");
        ownerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Create text fields for input with custom border
        ownerField = new JTextField(20);
        ownerField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        titleField = new JTextField(20);
        titleField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        // Create button for validation with custom appearance
        validateButton = new JButton("Validate");
        validateButton.setBackground(Color.RED);
        validateButton.setForeground(Color.BLACK);
        validateButton.setFocusPainted(false);
        validateButton.setFont(new Font("Arial", Font.BOLD, 14));
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProject();
            }
        });

        // Create panel to organize components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5); // Padding

        // Add components to panel
        panel.add(ownerLabel, constraints);
        constraints.gridy++;
        panel.add(ownerField, constraints);
        constraints.gridy++;
        panel.add(titleLabel, constraints);
        constraints.gridy++;
        panel.add(titleField, constraints);
        constraints.gridy++;
        panel.add(validateButton, constraints);

        // Add panel to frame
        add(panel);
        setVisible(true);
    }

    private void createProject() {
        String owner = ownerField.getText();
        String title = titleField.getText();
        Project project=new Project(owner,title);
        projectService.createProject(project);
        projectService.getProjects().forEach(project1 -> System.out.println(project1.toString()));
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(GUI::new);
    }
}
