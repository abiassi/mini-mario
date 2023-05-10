package TileMapCreator;

public enum TileType {
    SKY(0),
    GROUND(1),
    BRICK(2),
    PIPE(3),
    ENEMY(4),
    COIN(5);

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
