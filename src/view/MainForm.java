package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class MainForm implements ActionListener {
    JButton goButton;
    public void generateInterface(){
        JLabel jLabel = new JLabel();
        jLabel.setText("Choose one model of Motorbike:");
        jLabel.setFont(new Font("Nunito Sans", Font.PLAIN, 32));
        jLabel.setBounds(231, 20, 561, 44);

        ImageIcon btnIcon = new ImageIcon("src/image/arrow-icon-right.png");
        goButton = new JButton();
        goButton.setBounds(709, 468, 166, 150);
        goButton.addActionListener(this);
        goButton.setFocusable(false);
        goButton.setIcon(btnIcon);
        goButton.setBorder(new RoundedBorder(25));
        goButton.setBackground(new Color(97, 255, 122));

        JFrame jFrame = new JFrame();
        jFrame.setTitle("Motorbike Animation");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(1024, 768);
        jFrame.setVisible(true);
        jFrame.setLayout(null);

        jFrame.add(jLabel);
        jFrame.add(goButton);
        ImageIcon imageIcon = new ImageIcon("src/image/Akara-logo.jpg");
        jFrame.setIconImage(imageIcon.getImage());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goButton) {
            System.out.println("Hello");
        }
    }

    private record RoundedBorder(int radius) implements Border {
        public Insets getBorderInsets(Component c) {
                return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
            }

        public boolean isBorderOpaque() {
                return true;
            }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            }
        }
}
