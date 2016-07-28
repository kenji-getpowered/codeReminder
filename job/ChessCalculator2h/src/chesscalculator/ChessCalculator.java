package chesscalculator;

import chesscalculator.piece.*;

/**
 * 
 * @author Mikael KROK
 * 22 juin 2016
 */
public class ChessCalculator {

	public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        final Piece tower = new Tower(3, 3);
        final Piece king = new King(3, 2);
        final Horse horse = new Horse(3, 6);
        chessboard.addWhite(horse);
        chessboard.addWhite(king);
        chessboard.addWhite(tower);
        final Piece p = new Pawn(3,1);
        chessboard.addBlack(p);

        System.out.println("TOWER");
        tower.calculateMovements(chessboard);
        System.out.println("KING");
		king.calculateMovements(chessboard);
	}
}
