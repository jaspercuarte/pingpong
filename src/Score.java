import java.awt.*;

public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int playerOne;
    int playerTwo;

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Monospaced", Font.BOLD, 60));
        

        String scoreOne = (playerOne < 100) ? String.valueOf(playerOne/10) + String.valueOf(playerOne%10): "99";
        String scoreTwo = (playerTwo < 100) ? String.valueOf(playerTwo/10) + String.valueOf(playerTwo%10): "99";
        
        g.setColor(Color.BLACK);
        g.drawString(scoreOne, (GAME_WIDTH/2)-85 + 2, 50 + 2); 
        g.drawString(scoreTwo, (GAME_WIDTH/2)+20 + 2, 50 + 2); 
        
        g.setColor(Color.WHITE);
        g.drawString(scoreOne, (GAME_WIDTH/2)-85, 50);
        g.drawString(scoreTwo, (GAME_WIDTH/2)+20, 50);
    }
}
