import java.awt.*;
import javax.swing.*;

import sound.SoundManager;

public class GameFrame extends JFrame {
    MenuPanel menuPanel;
    GamePanel gamePanel;
    SoundManager soundManager;

    GameFrame() {
        this.setTitle("ping_pong");
        this.setResizable(false);
        this.setBackground(new Color(20, 40, 20));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        soundManager = new SoundManager();
        soundManager.setVolume(1.0f);
        soundManager.playMenuMusic();

        menuPanel = new MenuPanel(this, soundManager);
        this.add(menuPanel);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void startGame(boolean isSinglePlayer, Difficulty difficulty) {
        if (menuPanel != null) this.remove(menuPanel);
        soundManager.stopMenuMusic();

        System.out.println("Loading Sound Effects...");
        SoundManager soundManager = new SoundManager();
        soundManager.setVolume(1.0f);
        
        System.out.println("Loading Sound Effects Successfully Loaded");
        gamePanel = new GamePanel(isSinglePlayer, difficulty, soundManager, this);
        this.add(gamePanel);
        this.revalidate();
        this.repaint();
        gamePanel.requestFocus();
    }

    public void goBackToMenu() {
        if (gamePanel != null) {
            this.remove(gamePanel);
            gamePanel = null;
        }

        menuPanel = new MenuPanel(this, soundManager);
        this.add(menuPanel);
        soundManager.playMenuMusic();

        this.revalidate();
        this.repaint();
        menuPanel.requestFocus();
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

}
