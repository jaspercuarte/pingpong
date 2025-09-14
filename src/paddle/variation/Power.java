package paddle.variation;

import java.awt.*;
import paddle.Paddle;

public class Power extends Paddle {
    public Power(int x, int y, int width, int height, int id, boolean isSinglePlayer) {
        super(x, y, width, height, id, 10, isSinglePlayer);
        this.critChance = 0.03;   
        this.critSpeedBoost = 12;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            g.drawRect(x + i, y + i, width - 2*i, height - 2*i);
        }
    }
}
