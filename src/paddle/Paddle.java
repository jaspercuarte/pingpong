package paddle;

import java.awt.*;
import java.awt.event.*;

public abstract class Paddle extends Rectangle {
    protected int id;
    protected int yVelocity;
    protected int speed;
    protected boolean isSinglePlayer = false;

    protected double critChance = 0.05; 
    protected int critSpeedBoost = 0;
    protected int tempSpeedBoost = 0;

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id, int speed) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
        this.speed = speed;
    }

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id, int speed, boolean isSinglePlayer) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
        this.speed = speed;
        this.isSinglePlayer = isSinglePlayer;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getCritChance() { 
        return critChance; 
    }
    public void setCritChance(double critChance) { 
        this.critChance = critChance; 
    }

    public int getCritSpeedBoost() { 
        return critSpeedBoost; 
    }
    public void setCritSpeedBoost(int critSpeedBoost) { 
        this.critSpeedBoost = critSpeedBoost; 
    }

    public int getCurrentSpeed() {
        return speed + tempSpeedBoost;
    }

    public void applyCrit() {
        tempSpeedBoost = critSpeedBoost; 
    }

    public void resetCrit() {
        tempSpeedBoost = 0;
    }

    public void keyPressed(KeyEvent e){
        switch (id) {
            case 1:
                if (isSinglePlayer) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) setYDirection(-speed);
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) setYDirection(speed);
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_W) setYDirection(-speed);
                    if (e.getKeyCode() == KeyEvent.VK_S) setYDirection(speed);
                }
                break;
        
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) setYDirection(-speed);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) setYDirection(speed);
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch (id) {
            case 1:
                if (isSinglePlayer) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) setYDirection(0);
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) setYDirection(0);
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_W) setYDirection(0);
                    if (e.getKeyCode() == KeyEvent.VK_S) setYDirection(0);
                }
                break;
        
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) setYDirection(0);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) setYDirection(0);
                break;
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y += yVelocity + tempSpeedBoost;
        resetCrit();
    }

    public abstract void draw(Graphics g);
}
