import java.util.*;
import java.awt.*;

public class Ball extends Rectangle {
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;

    Ball(int x, int y, int width, int height) {
        super(x,y,width,height);
        random = new Random();
        
        int randomXCoordinate = random.nextInt(2);
        if (randomXCoordinate == 0) {
            randomXCoordinate--;
        }
        setXCoordinate(randomXCoordinate*initialSpeed);
        
        int randomYCoordinate = random.nextInt(2);
        if (randomYCoordinate == 0) {
            randomYCoordinate--;
        }
        setYCoordinate(randomYCoordinate*initialSpeed);
    }

    public void setYCoordinate(int randomYCoordinate) {
        yVelocity = randomYCoordinate;
    }

    public void setXCoordinate(int randomXCoordinate) {
        xVelocity = randomXCoordinate;
    }

    public void move() {
        x+=xVelocity;
        y+=yVelocity;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        
        g2d.setColor(new Color(255, 255, 100));
        g2d.fillOval(x, y, width, height);
        
        // Draw border
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, width, height);
    }
}
