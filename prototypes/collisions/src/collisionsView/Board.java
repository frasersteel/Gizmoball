package collisionsView;

import collisionsModel.Ball;
import collisionsModel.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Board extends JPanel implements Observer {

    private Model model;
    private int width;
    private int height;

    public Board(int x, int y,Model m) {
        width = x;
        height = y;
        m.addObserver(this);
        model = m;
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);

        Graphics2D g2d = (Graphics2D) graphic;

        Ball ball = model.getBall();

        if (ball != null) {
            g2d.setColor(Color.BLACK);
            int x = (int) (ball.getXPos() - ball.getRadius());
            int y = (int) (ball.getYPos() - ball.getRadius());
            int ballWidth = (int) (2 * ball.getRadius());
            g2d.fillOval(x, y, ballWidth, ballWidth);
        } else {
            System.out.println("Error with ball");
        }

        //for (Circle circle : )
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
