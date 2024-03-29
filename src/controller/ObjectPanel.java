package controller;

import model.Honda;
import model.Suzuki;
import model.Yamaha;
import view.MainForm;
import view.MotorbikeForm;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;

public class ObjectPanel extends JPanel implements ActionListener {
    private JButton backButton;
    private JButton startButton;
    private JButton stopButton;
    private double x1 = 25.0; /////////// x1 for road animation
    private double x2 = 1000.0; ///////// x2 for road animation
    private float[] dashPattern = {10f,2f}; // dash pattern line
    private Image staticSakura; ///////////////////// Image static sakura
    private Image sakura;   ///////////////////// Image sakura along the road
    private Image logo;  //////////////////// logo of motorbike brands
    private double xS1 = 1024.0; //////////////// x for sakura position
    private double velocity = 0; //////////////// velocity for this animation move
    private double space; /////////////////// space between stars
    private int delayTimer = 1;
    Timer timer = new Timer(delayTimer, this); // animation delay
    private MainForm mainForm; ////////// mainForm for object
    private MotorbikeForm motorbikeForm; // call object
    private JLabel messageLabel;
    // call model objects
    private Honda honda = new Honda();
    private Yamaha yamaha = new Yamaha();
    private Suzuki suzuki = new Suzuki();
    private int fontSizeMessage = 22; // dynamic fontsize
    private Clip clip; // Clip object for play music file .wav
    private JCheckBox musicCheckBox; // music on and off
    private ImageIcon playedMusic;  // icon confirm that music played
    private ImageIcon stopMusic;    // icon confirm that music stopped
    private boolean music = true;
    private Timer timerSpeed;
    private int gear = 0;
    private String gearParameter;
    private int rand = 0;

    public ObjectPanel(MainForm mainForm, MotorbikeForm motorbikeForm) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.mainForm = mainForm;
        this.motorbikeForm = motorbikeForm;
        File file = new File("src/music/Weathering-With-You.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        // set panel preference
        setPreferredSize(new Dimension(1024, 768));
        setBackground(new Color(128, 170, 255));
        staticSakura = new ImageIcon("src/image/sakura-static.png").getImage();
        sakura = new ImageIcon("src/image/sakura.png").getImage();
        setLayout(null);
        // hello

        // set motorbike logo
        switch (mainForm.getIndex()) {
            case 0 -> logo = new ImageIcon("src/image/Honda-logo - OnMotorBike.png").getImage();
            case 1 -> logo = new ImageIcon("src/image/Yamaha-logo - OnMotorBike.png").getImage();
            case 2 -> logo = new ImageIcon("src/image/Suzuki-logo - OnMotorBike.png").getImage();
        }

        // back button
        ImageIcon btnIcon = new ImageIcon("src/image/Arrow-left.png");
        backButton = new JButton();
        backButton.setBounds(50, 30, 90, 80);
        backButton.addActionListener(this);
        backButton.setIcon(btnIcon);
        backButton.setFocusable(false);
        backButton.setBackground(null);
        backButton.setBorder(new RoundedBorder(15));
        backButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                backButton.setBackground(Color.PINK);
                backButton.setBorder(new RoundedBorder(15));
            }
            public void mouseExited(MouseEvent evt) {
                backButton.setBackground(UIManager.getColor("control"));
                backButton.setBorder(new RoundedBorder(15));
            }
        });
        add(backButton);

        // start button
        startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(new Font("Nunito Sans", Font.PLAIN, 22));
        startButton.setBounds(830, 614, 120, 90);
        startButton.setFocusable(false);
        startButton.setBorder(new RoundedBorder(25));
        startButton.setBackground(null);
        startButton.setForeground(Color.GREEN);
        startButton.addActionListener(this);
        add(startButton);

        // stop button
        stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.setFont(new Font("Nunito Sans", Font.PLAIN, 22));
        stopButton.setBounds(700, 614, 120, 90);
        stopButton.setFocusable(false);
        stopButton.setBorder(new RoundedBorder(25));
        stopButton.setBackground(null);
        stopButton.setForeground(Color.RED);
        stopButton.addActionListener(this);
        add(stopButton);

        // message show that motor is start or stop
        messageLabel = new JLabel();
        messageLabel.setFont(new Font("Nunito Sans", Font.PLAIN, 50));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setBounds(333, 614, 350, 90);
        messageLabel.setBorder(new RoundedBorder(25));
        messageLabel.setForeground(Color.darkGray);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(null);
        messageLabel.setLayout(null);
        add(messageLabel);
        timerSpeed = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (gear >= 0 && gear <= 125) {
                        rand = -8;
                        gear += (5 + (Math.random() * rand));
                    }
                    else if (gear > 125 && gear <= 150){
                        rand = -9;
                        gear += (5 + (Math.random() * rand));
                    }
                    else {
                        rand = -10;
                        gear += (5 + (Math.random() * rand));
                    }

                    gearParameter = String.format("%03d", gear);
                    messageLabel.setText(gearParameter + " Km/h");
            }
        });

        // play romantic music
        playedMusic = new ImageIcon("src/image/music.png");
        stopMusic = new ImageIcon("src/image/musicOff.png");
        musicCheckBox = new JCheckBox();
        musicCheckBox.setBounds(850, 500, 100, 100);
        musicCheckBox.setForeground(Color.pink);
        musicCheckBox.setBackground(null);
        musicCheckBox.setFocusable(false);
        musicCheckBox.setSelected(true);
        musicCheckBox.setSelectedIcon(playedMusic);
        musicCheckBox.setIcon(stopMusic);
        musicCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    music = true;
                    clip.start();
                }
                else {
                    music = false;
                    clip.stop();
                }
            }
        });
        add(musicCheckBox);
    }

    // paint function
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        // draw sakura
        for (space = 0; space < 5000; space +=1500) {
            graphics2D.drawImage(sakura, (int)(xS1 + space + 200), (int)(-10+ (Math.random() * 5)), null);
        }
        // static sakura
        g.drawImage(staticSakura, -15, (int)(512+ (Math.random() * 5)), null);

        // road for motorbike
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setStroke(new BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                                    1f, dashPattern, 2f));
        g.setColor(Color.white);
        g.drawLine((int) x1, (int)(490 + (Math.random() * 5)), (int) x2, (int)(490 + (Math.random() * 5)));

        //back tire
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 0, 45);
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 45, 90);
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 90, 135);
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 135, 180);
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 180, 225);
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 225, 270);
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 270, 315);
        graphics2D.drawArc(296, (int)(355 + (Math.random() * 5)), 126, 126, 315, 360);

        // front tire
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 0, 45);
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 45, 90);
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 90, 135);
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 135, 180);
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 180, 225);
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 225, 270);
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 270, 315);
        graphics2D.drawArc(623, (int)(355 + (Math.random() * 5)), 126, 126, 315, 360);

        // front connect to tire
        g.drawLine(696, (int)(420 + (Math.random() * 5)), 600, (int)(285 + (Math.random() * 5)));
        g.drawLine(705, (int)(415 + (Math.random() * 5)), 612, (int)(285 + (Math.random() * 5)));

        // center body motorbike
        g.drawLine(567, (int)(459 + (Math.random() * 5)), 612, (int)(295 + (Math.random() * 5)));
        g.drawLine(567, (int)(459 + (Math.random() * 5)), 425, (int)(459 + (Math.random() * 5)));

        //lamp
        Path2D.Double motorLamp = new Path2D.Double();
        motorLamp.moveTo(655, (int)(295+ (Math.random() * 5)));
        motorLamp.curveTo(612, (int)(285+ (Math.random() * 5)), 612, (int)(255+ (Math.random() * 5)),
                        655, (int)(245+ (Math.random() * 5)));
        graphics2D.draw(motorLamp);
        g.drawLine(655, (int)(295 + (Math.random() * 5)), 655, (int)(245 + (Math.random() * 5)));

        // speed Meter
        Path2D.Double motoHead = new Path2D.Double();
        motoHead.moveTo(600, (int)(285 + (Math.random() * 5)));
        motoHead.curveTo(612, (int)(285+ (Math.random() * 5)), 612, (int)(255+ (Math.random() * 5)),
                        600, (int)(245 + (Math.random() * 5)));
        graphics2D.draw(motoHead);
        g.drawLine(605, (int)(245 + (Math.random() * 5)), 580, (int)(255 + (Math.random() * 5)));
        g.drawLine(580, (int)(250 + (Math.random() * 5)), 600, (int)(285 + (Math.random() * 5)));

        //body motor
        Path2D.Double bodyMotor = new Path2D.Double();
        // gas place
        bodyMotor.moveTo(600, (int)(285 + (Math.random() * 5)));
        bodyMotor.curveTo(560, (int)(289 + (Math.random() * 5)), 529, (int)(311 + (Math.random() * 5)),
                        529, (int)(341 + (Math.random() * 5)));
        //seat place
        bodyMotor.moveTo(529, (int)(341 + (Math.random() * 5)));
        bodyMotor.curveTo(508, (int)(359 + (Math.random() * 5)), 465, (int)(363 + (Math.random() * 5)),
                        422, (int)(342 + (Math.random() * 5)));
        // back seat
        bodyMotor.moveTo(422, (int)(342 + (Math.random() * 5)));
        bodyMotor.curveTo(382, (int)(332 + (Math.random() * 5)), 332, (int)(332 + (Math.random() * 5)),
                282, (int)(385 + (Math.random() * 5)));
        graphics2D.draw(bodyMotor);

        //under the seat
        graphics2D.drawImage(logo, 460, (int)(360+ (Math.random() * 5)), null);

        // back cover tire
        graphics2D.drawArc(285, (int)(340 + (Math.random() * 5)), 154, 154, -36, 225);
    }

    // for animation
    @Override
    public void actionPerformed(ActionEvent e) {
        if (x2 == 9500){
            x2 = 1024;
            x1 = -50;
            xS1 = 1024;
            space = 0;
        }
        else {
            x1 = x1 - velocity;
            x2 = x2 + velocity;
            xS1 = xS1 - velocity;
        }
        repaint();

        if (e.getSource() == startButton) {
            delayTimer = 1;
            timer.start();
            timerSpeed.start();
            while (velocity != 2) {
                velocity += 0.5;
            }
            if (music)
                clip.start();
        }

        if (e.getSource() == stopButton) {
            delayTimer = 1000;
            while (velocity != 0) {
                velocity -= 0.5;
            }
            timerSpeed.stop();
            gearParameter = String.format("%03d", 0);
            messageLabel.setText(gearParameter + " Km/h");

            clip.stop();
            timer.stop();
        }

        if (e.getSource() == backButton) {
            clip.stop();
            new MainForm();
            motorbikeForm.dispose();
        }
    }

    // rounded border method
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
