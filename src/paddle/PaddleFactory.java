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
    public static int getWidthForType(PaddleType type) {
    switch (type) {
        case TANK: return 25*3/2;
        case SWIFT: return 25*3/4;
        case DEFAULT: return 25;
        case LUCKY: return 25;
        case POWER: return 25;
        default: return 25; 
    }
}
}
