package view;

import controller.MainFormController;

import javax.swing.*;
import java.awt.event.ActionListener;


public class MainForm {

    public void generateInterface(){
        MainFormController mainFormController = new MainFormController();

        JFrame jFrame = new JFrame();
        jFrame.setContentPane(mainFormController.panelMain());
        jFrame.setTitle("Motorbike Animation");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(1024, 768);
        jFrame.setVisible(true);
        jFrame.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("src/image/Akara-logo.jpg");
        jFrame.setIconImage(imageIcon.getImage());
    }

}
