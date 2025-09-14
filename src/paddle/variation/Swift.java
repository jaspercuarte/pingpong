package paddle.variation;

import paddle.Paddle;
import java.awt.*;

public class Swift extends Paddle {
    public Swift(int x, int y, int width, int height, int id, boolean isSinglePlayer) {
        super(x, y, width * 3/4, height * 3/4, id, 19, isSinglePlayer); 
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, width, height);

        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            g.drawRect(x + i, y + i, width - 2*i, height - 2*i);
        }
    }
}
