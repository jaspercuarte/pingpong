import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH*(0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 40;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    SoundManager soundManager;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddleOne;
    Paddle paddleTwo;
    Ball ball;
    Score score;

    GamePanel() {
        newPaddle();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new KL());
        this.setPreferredSize(SCREEN_SIZE);

        soundManager = new SoundManager();
        soundManager.setVolume(2.0f);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(GAME_HEIGHT/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddle() {
        paddleOne = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddleTwo = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void drawCenterLine(Graphics g) {
        int thickness = 10;
        int dashLength = 20;
        int gapLength = 15; 

        int y = 0;
        g.setColor(new Color(40, 60, 40));
        while (y < GAME_HEIGHT) {
            g.fillRect(GAME_WIDTH/2 - thickness/2, y, thickness, dashLength);
            y += dashLength + gapLength;
        }
    }

    public void draw(Graphics g) {
        drawCenterLine(g);

        paddleOne.draw(g);
        paddleTwo.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void move() {
        paddleOne.move();
        paddleTwo.move();
        ball.move();
    }

    public void checkCollision() {
        if (ball.y <= 0) ball.setYCoordinate(-ball.yVelocity);
        if (ball.y >= GAME_HEIGHT-BALL_DIAMETER) ball.setYCoordinate(-ball.yVelocity);

        if (ball.intersects(paddleOne)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;

            if (ball.yVelocity > 0) ball.yVelocity++;
            else ball.yVelocity--;

            ball.setXCoordinate(ball.xVelocity);
            ball.setYCoordinate(ball.yVelocity);
            soundManager.playHitSound();
        }

        if (ball.intersects(paddleTwo)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; 

            if (ball.yVelocity > 0) ball.yVelocity++;
            else ball.yVelocity--;

            ball.setXCoordinate(-ball.xVelocity);
            ball.setYCoordinate(ball.yVelocity);
            soundManager.playHitSound();
        }

        if (paddleOne.y <= 0) paddleOne.y = 0;
        if (paddleOne.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) paddleOne.y = GAME_HEIGHT-PADDLE_HEIGHT;
        
        if (paddleTwo.y <= 0) paddleTwo.y = 0;
        if (paddleTwo.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) paddleTwo.y = GAME_HEIGHT-PADDLE_HEIGHT;

        if (ball.x <= 0) {
            soundManager.playScoreSound();
            score.playerTwo++;
            newPaddle();
            newBall();
            System.out.println("Player 2: "+score.playerTwo);
        }

        if (ball.x >= (GAME_WIDTH-BALL_DIAMETER)) {
            soundManager.playScoreSound();
            score.playerOne++;
            newPaddle();
            newBall();
            System.out.println("Player 1: " + score.playerOne);
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double nanoSeconds = 1000000000 / amountOfTicks;
        double delta = 0;
        
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/nanoSeconds;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }


    public class KL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddleOne.keyPressed(e);
            paddleTwo.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddleOne.keyReleased(e);
            paddleTwo.keyReleased(e);
        }
    }
    
}
