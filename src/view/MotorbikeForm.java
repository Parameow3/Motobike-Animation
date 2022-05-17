package view;

import controller.ObjectPanel;

import javax.swing.*;

public class MotorbikeForm extends JFrame {
    ObjectPanel objectPanel;
    MainForm mainForm;
    public MotorbikeForm(MainForm mainForm){

        objectPanel = new ObjectPanel(mainForm);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(objectPanel);
        pack();
        setTitle("Motorbike Animation");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon("src/image/Akara-logo.jpg");
        setIconImage(imageIcon.getImage());
    }
}
