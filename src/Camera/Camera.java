package Camera;

public class Camera {
    private int x;
    private int y;
    private int width = 272;
    private int height = 240;
    private int maxScrollBackward = 16;

    public Camera() {
        this.x = 0;
        this.y = 0;
    }

    public void update (int playerX, int playerY, int levelWidth, int levelHeight) {
        // Player reaches middle of the screen
        if (playerX - x > width / 2) {
            x = playerX - width / 2;
        }

        // Player moves backwards
        if (playerX - x < width / 2 - maxScrollBackward && x > 0) {
            x -= maxScrollBackward;
        }

        // Limit camera to level bounds
        if (x <= 0) {
            x = 0;
        }
        if (x + width > levelWidth) {
            x = levelWidth - width;
        }
        if (y < 0) {
            y = 0;
        }
        if (y + height > levelHeight) {
            y = levelHeight - height;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
