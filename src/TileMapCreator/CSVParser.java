package TileMapCreator;

import Tile.Tile;
import Tile.TileType;
import Tile.TileFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static TileMap parse(String filename) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        int width = lines.get(0).split(",").length;
        int height = lines.size();
        TileMap tileMap = new TileMap(width, height);

        for (int y = 0; y < height; y++) {
            String[] tileValues = lines.get(y).split(",");
            for (int x = 0; x < width; x++) {
                TileType type = TileType.fromValue(Integer.parseInt(tileValues[x]));
                Tile tile = TileFactory.createTile(type);
                tileMap.setTile(x, y, tile);
            }
        }
        return tileMap;
    }
}
