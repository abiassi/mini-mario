package Tile;

public enum TileType {
    SKY(0),
    GROUND_BRICK(1),
    MYSTERY_BOX(2),
    BREAKABLE_BRICK(3),
    DECORATIVE_TILE(4),
    COIN(5),
    END_TILE(6),
    LIMIT(9);

    private final int value;

    TileType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TileType fromValue(int value) {
        for (TileType type : TileType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value for Tile.TileType: " + value);
     }
}
