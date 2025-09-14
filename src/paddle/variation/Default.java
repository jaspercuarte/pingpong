package paddle.variation;

import paddle.Paddle;
import java.awt.*;

public class Default extends Paddle {

    public Default(int x, int y, int width, int height, int id, boolean isSinglePlayer) {
        super(x, y, width, height, id, 10, isSinglePlayer); 
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(225, 225, 225));
        g.fillRect(x, y, width, height);

        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            g.drawRect(x + i, y + i, width - 2*i, height - 2*i);
        }
    }
}
