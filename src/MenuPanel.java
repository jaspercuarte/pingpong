import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import sound.SoundManager;

public class MenuPanel extends JPanel implements ActionListener {
    JButton onePlayerButton, twoPlayerButton, aboutButton, exitButton;
    GameFrame frame;

    MenuPanel(GameFrame frame, SoundManager soundManager) {
        this.frame = frame;
        this.setPreferredSize(new Dimension(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT));
        this.setBackground(new Color(100, 130, 100));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(10, 20, 0, 20); 
        gBC.fill = GridBagConstraints.HORIZONTAL;

        Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 28); 
        Dimension buttonSize = new Dimension(500, 50); 

        onePlayerButton = createStyledButton("one player", buttonFont, buttonSize);
        twoPlayerButton = createStyledButton("two players", buttonFont, buttonSize);
        aboutButton = createStyledButton("about", buttonFont, buttonSize);
        exitButton = createStyledButton("exit", buttonFont, buttonSize);

        onePlayerButton.addActionListener(this);
        twoPlayerButton.addActionListener(this);
        aboutButton.addActionListener(this);
        exitButton.addActionListener(this);

        gBC.gridy = 0;
        gBC.weighty = 0;
        this.add(Box.createVerticalStrut(100), gBC);

        gBC.weighty = 0;
        gBC.gridy = 1;
        this.add(onePlayerButton, gBC);
        gBC.gridy = 2;
        this.add(twoPlayerButton, gBC);
        gBC.gridy = 3;
        this.add(aboutButton, gBC);
        gBC.gridy = 4;
        this.add(exitButton, gBC);

        if (soundManager != null) {
            soundManager.playMenuMusic();
        }
    }

    private JButton createStyledButton(String text, Font font, Dimension size) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setPreferredSize(size);
        button.setBackground(new Color(150, 170, 150));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(Color.BLACK, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 255, 100));
                button.revalidate(); 
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(150, 170, 150)); 
                button.revalidate();
            }
        });

        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        String title = "ping_pong";

        Font titleFont = new Font(Font.MONOSPACED, Font.BOLD, 100);
        g2d.setFont(titleFont);

        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(title)) / 2;
        int y = fm.getAscent() + 60; 

        g2d.setColor(Color.BLACK);
        g2d.drawString(title, x + 4, y + 4);

        g2d.setColor(new Color(255, 255, 100));
        g2d.drawString(title, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == onePlayerButton) {
            Difficulty[] options = Difficulty.values();

            int choice = JOptionPane.showOptionDialog(
                this,
                "Choose Difficulty:",
                "Difficulty",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice >= 0) frame.startGame(true, options[choice]);
        }
        if (e.getSource() == twoPlayerButton) {
            frame.startGame(false, null); 
        }
        if (e.getSource() == aboutButton) {
            JOptionPane.showMessageDialog(
                this,
                "Created By: \njaspercuarte\n\nGame Instruction: \nThe ping_pong game consist of 2 modes (1 player, 2 players)\nThe 1 player have 3 types of difficulty (easy, medium, hard) \nThe program keeps track of the ball with different paddle speed\n\nControls:\n1PLAYER: UP_KEY, DOWN_KEY\n2PLAYER: 1P(W_KEY,S_KEY), 2P(UP_KEY, DOWN_KEY)\n\nAbout Game: \nIt consist of 2 paddles where when the ball comes contact its velocity increases by (8 initially then 1)\nThere is 5% probability to have a temporary hit velocity incremented by 4 \n(turning the ball into orangist color)",
                "About",
                JOptionPane.INFORMATION_MESSAGE
            );
        } 
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
