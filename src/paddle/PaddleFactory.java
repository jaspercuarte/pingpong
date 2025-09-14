package paddle;

import paddle.variation.*;

public class PaddleFactory {
    public static Paddle createPaddle(PaddleType type, int x, int y, int width, int height, int id, boolean isSinglePlayer) {
        switch (type) {
            case SWIFT: return new Swift(x, y, width, height, id, isSinglePlayer);
            case TANK:  return new Tank(x, y, width, height, id, isSinglePlayer);
            case LUCKY:  return new Lucky(x, y, width, height, id, isSinglePlayer);
            case POWER:  return new Power(x, y, width, height, id, isSinglePlayer);
            default:    return new Default(x, y, width, height, id, isSinglePlayer);
        }
    }
}
