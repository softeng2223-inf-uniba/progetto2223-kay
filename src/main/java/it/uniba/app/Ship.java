import java.util.Arrays;

public abstract class Ship {
    String nameShip;
    int size;
    int nrShips;
    int shipsPositioned;
    String currentPosition;
    boolean hits[];
    // methods
    Ship(String name, int size, int nr, int shipsPos, String currPos) {
        this.nameShip = name;
        this.size = size;
        this.nrShips = nr;
        this.shipsPositioned = shipsPos;
        this.currentPosition = currPos;
        this.hits = new boolean[size];
        Arrays.fill(hits, false);
    };
}
