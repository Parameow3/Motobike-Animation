package view;

import controller.ObjectPanel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class MotorbikeForm extends JFrame {
    ObjectPanel objectPanel;
    MainForm mainForm;
    public MotorbikeForm(MainForm mainForm) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        objectPanel = new ObjectPanel(mainForm, this);

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
