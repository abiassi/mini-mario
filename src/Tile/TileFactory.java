// TileFactory.java
package Tile;

public class TileFactory {
    public static Tile createTile(TileType type) {
        return switch (type) {
            case SKY -> null; // Sky is an empty tile
            case GROUND_BRICK -> new SolidTile();
            case MYSTERY_BOX -> new MysteryBoxTile();
            case BREAKABLE_BRICK -> new BreakableTile();
            case DECORATIVE_TILE -> new DecorativeTile();
            case COIN -> new CoinTile();
            default -> throw new IllegalArgumentException("Unsupported tile type: " + type);
        };
    }
}
