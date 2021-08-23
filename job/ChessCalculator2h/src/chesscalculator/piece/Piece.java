package chesscalculator.piece;

import chesscalculator.Chessboard;
import chesscalculator.Position;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Basic representation of a chess chesscalculator.piece.
 *
 * @author Mikael KROK
 *         22 juin 2016
 */
public class Piece {
    /**
     * position(X,Y) starting from upper left corner at 0,0
     *
     * @param posX
     * @param posY
     */
    public Piece(int posX, int posY) {
        super();
        this.posX = posX;
        this.posY = posY;
    }

    public String type;
    public Position pos;
    public int posX;
    public int posY;

    public void calculateMovements(Chessboard cb) {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (posX != piece.posX) return false;
        if (posY != piece.posY) return false;
        if (type != null ? !type.equals(piece.type) : piece.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + posX;
        result = 31 * result + posY;
        return result;
    }
}
