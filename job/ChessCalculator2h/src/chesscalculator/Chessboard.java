package chesscalculator;

import chesscalculator.piece.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chessboard {
    List<Piece> whites = new ArrayList<Piece>(16);
    List<Piece> blacks = new ArrayList<Piece>(16);

    private static Map<Integer, String> xCoordinates = new HashMap<Integer, String>();

    static {
        xCoordinates.put(0, "a");
        xCoordinates.put(1, "b");
        xCoordinates.put(2, "c");
        xCoordinates.put(3, "d");
        xCoordinates.put(4, "e");
        xCoordinates.put(5, "f");
        xCoordinates.put(6, "g");
        xCoordinates.put(7, "h");
    }

    private static Map<Integer, String> yCoordinates = new HashMap<Integer, String>();

    static {
        yCoordinates.put(0, "8");
        yCoordinates.put(1, "7");
        yCoordinates.put(2, "6");
        yCoordinates.put(3, "5");
        yCoordinates.put(4, "4");
        yCoordinates.put(5, "3");
        yCoordinates.put(6, "2");
        yCoordinates.put(7, "1");
    }

    public static String getChessboardX(int posX) {
        return xCoordinates.get(posX);
    }

    public static String getChessboardY(int posY) {
        return yCoordinates.get(posY);
    }

    /**
     * is the position given as parameter contains an ennemy to eat
     *
     * @param pos
     * @return
     */
    public boolean doEatNext(Position pos) {
        boolean eatNext = false;
        // is next case taken by an enemy chesscalculator.piece
        for (Piece black : blacks) {
            if (pos.getX() == black.posX && pos.getY() == black.posY) {
                eatNext = true;
            }
        }
        return eatNext;
    }

    /**
     * receive the position and determine if it can go there
     *
     * @param pos
     * @return
     */
    public boolean canGoNext(Position pos) {
        boolean canGoNext = true;
        // is next case taken by a fellow chesscalculator.piece
        for (Piece white : whites) {
            if (pos.getX() == white.posX && pos.getY() == white.posY) {
                canGoNext = false;
            }
        }

        // is next case taken by an enemy chesscalculator.piece
        for (Piece black : blacks) {
            if (pos.getX() == black.posX && pos.getY() == black.posY ) {
                canGoNext = false;
            }
        }
        return canGoNext;
    }

    public void printMovement(String type, int posXStart, int posYStart, int posXEnd, int posYEnd, boolean eat) {
        // print type
        System.out.print(type);
        // print start
        System.out.print(Chessboard.getChessboardX(posXStart) + "" + Chessboard.getChessboardY(posYStart));
        if (eat) {
            System.out.print("x");
        } else {
            System.out.print("-");
        }
        // print end
        System.out.println(Chessboard.getChessboardX(posXEnd) + "" + Chessboard.getChessboardY(posYEnd));

    }

    public void addWhite(Piece p) {
        whites.add(p);
    }

    public void addBlack(Piece p) {
        blacks.add(p);
    }
}