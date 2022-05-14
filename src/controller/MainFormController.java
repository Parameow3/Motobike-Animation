package controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MainFormController implements ActionListener, MouseListener{
    private JButton goButton;
    private JPanel mainPanel;
    private JLabel welcomeMessage;
    private JLabel hondaModel;
    private JLabel yamahaModel;
    private JLabel suzukiModel;

    private JCheckBox jCheckBox;
    private JLabel informationLabel;

    public JPanel panelMain() {
        welcomeMessage = new JLabel();
        welcomeMessage.setText("Choose one model of Motorbike:");
        welcomeMessage.setFont(new Font("Nunito Sans", Font.PLAIN, 32));
        welcomeMessage.setBounds(231, 20, 561, 44);

        hondaModel = new JLabel();
        ImageIcon hondaIcon = new ImageIcon("src/image/Honda-logo.png");
        hondaModel.setBounds(99, 100, 213, 220);
        hondaModel.setIcon(hondaIcon);
        hondaModel.addMouseListener(this);

        yamahaModel = new JLabel();
        ImageIcon yamahaIcon = new ImageIcon("src/image/Yamaha-logo.png");
        yamahaModel.setBounds(413, 100, 213, 220);
        yamahaModel.setIcon(yamahaIcon);
        yamahaModel.addMouseListener(this);

        suzukiModel = new JLabel();
        ImageIcon suzukiIcon = new ImageIcon("src/image/Suzuki-logo.png");
        suzukiModel.setIcon(suzukiIcon);
        suzukiModel.setBounds(712, 100, 213, 220);
        suzukiModel.setHorizontalAlignment(SwingConstants.CENTER);
        suzukiModel.addMouseListener(this);

        informationLabel = new JLabel();
        informationLabel.setFont(new Font("Nunito Sans", Font.PLAIN, 24));
        informationLabel.setBounds(99, 410, 430, 266);
        informationLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));


        ImageIcon btnIcon = new ImageIcon("src/image/Arrow-right.png");
        goButton = new JButton();
        goButton.setBounds(755, 468, 166, 150);
        goButton.addActionListener(this);
        goButton.setIcon(btnIcon);
        goButton.setFocusable(false);
        goButton.setBorder(new RoundedBorder(25));
        goButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                goButton.setBackground(Color.GREEN);
                goButton.setBorder(new RoundedBorder(25));
            }
            public void mouseExited(MouseEvent evt) {
                goButton.setBackground(UIManager.getColor("control"));
                goButton.setBorder(new RoundedBorder(25));
            }
        });

        mainPanel = new JPanel();
        mainPanel.setBounds(1024,768, 1024, 768);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(informationLabel);
        mainPanel.setVisible(true);
        mainPanel.add(welcomeMessage);
        mainPanel.add(hondaModel);
        mainPanel.add(yamahaModel);
        mainPanel.add(suzukiModel);
        mainPanel.add(goButton);
        mainPanel.setLayout(null);

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goButton) {
            System.out.println("Hello");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent() == hondaModel) {
            informationLabel.setText("<html>Your Motorbike information:<br><br>Brand: HONDA<br>Model: DREAM<br>ID: 1999888<br>Year: 2022<br>Price: 2499$</html>");
        }
        else if (e.getComponent() == yamahaModel) {
            informationLabel.setText("<html>Your Motorbike information:<br><br>Brand: YAMAHA<br>Model: FZ<br>ID: 16666999<br>Year: 2022<br>Price: 1966$</html>");
        }
        else if (e.getComponent() == suzukiModel) {
            informationLabel.setText("<html>Your Motorbike information:<br><br>Brand: SUZUKI<br>Model: VIVA<br>ID: 17766661<br>Year: 2022<br>Price: 2009$</html>");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent() == hondaModel) {
            hondaModel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
        }
        else if (e.getComponent() == yamahaModel) {
            yamahaModel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
        }
        else if (e.getComponent() == suzukiModel) {
            suzukiModel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getComponent() == hondaModel) {
            hondaModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,0));
        }
        else if (e.getComponent() == yamahaModel) {
            yamahaModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,0));
        }
        else if (e.getComponent() == suzukiModel) {
            suzukiModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,0));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent() == hondaModel) {
            hondaModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        }
        else if (e.getComponent() == yamahaModel) {
            yamahaModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        }
        else if (e.getComponent() == suzukiModel) {
            suzukiModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent() == hondaModel) {
            hondaModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,0));
        }
        else if (e.getComponent() == yamahaModel) {
            yamahaModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,0));
        }
        else if (e.getComponent() == suzukiModel) {
            suzukiModel.setBorder(BorderFactory.createLineBorder(Color.GRAY,0));
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
