package view;

import controller.ObjectPanel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class MotorbikeForm extends JFrame {
    private ObjectPanel objectPanel; // object panel
    public MotorbikeForm(MainForm mainForm) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        // create object panel
        objectPanel = new ObjectPanel(mainForm, this);

        // when user click on close window, program will exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add panel to the frame
        add(objectPanel);
        pack();
        setTitle("Motorbike Animation");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // set icon for this program
        ImageIcon imageIcon = new ImageIcon("src/image/Akara-logo.jpg");
        setIconImage(imageIcon.getImage());



    }
}
