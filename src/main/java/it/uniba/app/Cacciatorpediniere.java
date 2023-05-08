import java.util.Arrays;

public class Cacciatorpediniere extends Ship {

    Cacciatorpediniere() {
        this.nameShip = "Cacciatorpediniere";
        this.size = 2;
        this.nrShips = 4;
        this.shipsPositioned = 0;
        this.hits = Arrays.fill(hits, "false");
    }


}