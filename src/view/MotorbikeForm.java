package view;

import controller.ObjectPanel;

import javax.swing.*;

public class MotorbikeForm extends JFrame {
    ObjectPanel objectPanel;
    public MotorbikeForm(){

        objectPanel = new ObjectPanel();

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
