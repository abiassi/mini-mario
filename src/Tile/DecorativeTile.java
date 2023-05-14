package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionDetector;
import Character.Person;

import java.net.URL;

public class DecorativeTile extends Tile {
    private Picture picture;

    public DecorativeTile() {
        super(TileType.DECORATIVE_TILE);
    }

    @Override // No decorative tile ex
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/decorative_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for Decorative Tile");
        }
    }

    @Override
    public void onCollision(Person person) {
        return; // No special behavior
    }


}