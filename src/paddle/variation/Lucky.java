package paddle.variation;

import java.awt.*;
import paddle.Paddle;

public class Lucky extends Paddle {
    public Lucky(int x, int y, int width, int height, int id, boolean isSinglePlayer) {
        super(x, y, width, height, id, 10, isSinglePlayer);
        this.critChance = 0.3;   
        this.critSpeedBoost = 0;
    }
   
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            g.drawRect(x + i, y + i, width - 2*i, height - 2*i);
        }
    }
}
