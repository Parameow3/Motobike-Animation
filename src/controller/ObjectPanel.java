package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class ObjectPanel extends JPanel implements ActionListener {
    Timer timer = new Timer(1, this);
    int x1 = 25, velX1 = 2;
    int x2 = 1000, velX2 = 2;
    float[] dashPattern = {10f,2f};
    Image stars;
    int xS1 = 1024;
    int yS1 = 150;
    int xSVel = 2;
    int i;

    // for motorbike
    //Wheel
    double radius = Math.min(125.88, 126.44) / 2;



    public ObjectPanel() {
        setPreferredSize(new Dimension(1024, 768));
        setBackground(Color.DARK_GRAY);
        stars = new ImageIcon("src/image/star.png").getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        // draw stars
        for (i = 0; i < 1924; i+=200) {
            graphics2D.drawImage(stars, xS1 + i, (int)(yS1+ (Math.random() * 5)), null);
        }

        // road for motorbike
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setStroke(new BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                                    1f, dashPattern, 2f));
        g.setColor(Color.white);
        g.drawLine(x1, (int)(490 + (Math.random() * 5)), x2, (int)(490 + (Math.random() * 5)));

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

        // motoHead
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

        // back cover tire
        graphics2D.drawArc(285, (int)(340 + (Math.random() * 5)), 154, 154, -36, 225);
        
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x2 == 4500){
            x2 = 1024;
            x1 = -50;
            xS1 = 1024;
            i = 0;
        }
        else {
            x1 = x1 - velX1;
            x2 = x2 + velX2;
            xS1 = xS1 - xSVel;
        }
        repaint();
    }
}
