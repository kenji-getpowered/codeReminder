package chesscalculator.piece;

import chesscalculator.Chessboard;
import chesscalculator.Movement;
import chesscalculator.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(int posX, int posY) {
			super(posX, posY);
			this.type = "T";
		}
		
		/**
		 * calculate movements specifically for Kings
		 * 
		 */
        @Override
		public void calculateMovements(Chessboard cb) {
            List<Movement> movs = new ArrayList<Movement>();
			boolean canGoNext = true;
			// Left direction
			// X is changing, Y remains

			if(this.posX - 1>0){
                for (int i = 3; i > 0; i--) {
                    Position pos = new Position(this.posX - 1, this.posY-i);
                    if( this.posY - i > 0){
                        canGoNext = cb.canGoNext(pos);
                        boolean eat = cb.doEatNext(pos);
                        if (canGoNext || eat){
                            movs.add(new Movement(this, pos, eat));
                        }
                        cb.printMovement(this.type, this.posX, this.posY, this.posX - 1, this.posY-i, eat);
                    }
                }
			}
			// Right direction
			// X is changing, Y remains
			canGoNext = true;
			if(this.posX - 1<8){
                for (int i = 3; i > 0; i--) {
                    if( this.posY - i > 0){
                        Position pos = new Position(this.posX + 1, this.posY-i);
                        canGoNext = cb.canGoNext(pos);
                        boolean eat = cb.doEatNext(pos);
                        if (canGoNext || eat)
                            cb.printMovement(this.type, this.posX, this.posY, this.posX + 1, this.posY-i, eat);
                    }
                }
			}
			
			// Up direction
			// Y is changing, X remains
			canGoNext = true;
			if(this.posY - 1>0){
                Position pos = new Position(this.posX,  this.posY-1);
                canGoNext = cb.canGoNext(pos);
                boolean eat = cb.doEatNext(pos);
				if (canGoNext || eat)
                    cb.printMovement(this.type, this.posX, this.posY, this.posX, this.posY - 1, eat);
			}
			// Down direction
			// Y is changing, X remains
			canGoNext = true;
			if(this.posY + 1 < 8){
                Position pos = new Position(this.posX,  this.posY+1);
                canGoNext = cb.canGoNext(pos);
                boolean eat = cb.doEatNext(pos);
				if (canGoNext || eat)
                    cb.printMovement(this.type, this.posX, this.posY, this.posX, this.posY + 1, eat);
			}
		}

	}
	