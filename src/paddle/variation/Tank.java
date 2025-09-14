package paddle.variation;

import paddle.Paddle;
import java.awt.*;

public class Tank extends Paddle {
    public Tank(int x, int y, int width, int height, int id, boolean isSinglePlayer) {
        super(x, y, width *3/2, height * 3/2, id, 4, isSinglePlayer); 
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);

        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            g.drawRect(x + i, y + i, width - 2*i, height - 2*i);
        }
    }
}
