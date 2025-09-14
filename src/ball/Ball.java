package ball;
import java.util.*;
import java.awt.*;

public class Ball extends Rectangle {
    Random random;
    public int xVelocity;
    public int yVelocity;
    public int initialSpeed = 2;
    public int critBoost = 4;
    public boolean isCritActive = false;

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();

        int dirX = random.nextBoolean() ? 1 : -1;
        setXCoordinate(dirX * initialSpeed);

        int dirY = random.nextBoolean() ? 1 : -1;
        setYCoordinate(dirY * initialSpeed);
    }

    public void setYCoordinate(int velocity) {
        yVelocity = velocity;
    }

    public void setXCoordinate(int velocity) {
        xVelocity = velocity;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void activateCrit() {
        if (!isCritActive) {
            if (xVelocity > 0) xVelocity += critBoost;
            else xVelocity -= critBoost;
            isCritActive = true;
        }
    }

    public void deactivateCrit() {
        if (isCritActive) {
            if (xVelocity > 0) xVelocity -= critBoost;
            else xVelocity += critBoost;
            isCritActive = false;
        }
    }

    public boolean isCrit() {
        return isCritActive;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 

        if (isCritActive) g2d.setColor(new Color(255, 140, 0)); 
        else g2d.setColor(new Color(255, 255, 100));          
        g2d.fillOval(x, y, width, height);

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, width, height);
    }
}
