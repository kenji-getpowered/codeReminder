package chesscalculator.piece;

import chesscalculator.Chessboard;
import chesscalculator.Position;

public class Tower extends Piece {

    public Tower(int posX, int posY) {
			super(posX, posY);
			this.type = "T";
		}
		
		/**
		 * calculate movements specifically for a tower
		 * 
		 */
        @Override
		public void calculateMovements(Chessboard cb) {
			boolean canGoNext = true;
			// Left direction
			// X is changing, Y remains
			for (int i = this.posX - 1; (i >= 0 && canGoNext ); i--) {
				// get the next case
                Position nextPos = new Position(i, this.posY);
                canGoNext = cb.canGoNext(nextPos);
				boolean eat = cb.doEatNext(nextPos);
				if (canGoNext || eat)
                    cb.printMovement(this.type, this.posX, this.posY, i, this.posY, eat);
			}

			// Right direction
			// X is changing, Y remains
			canGoNext = true;
			for (int i = this.posX + 1; (i < 8 && canGoNext); i++) {
				// get the next case
                Position nextPos = new Position(i, this.posY);
				canGoNext = cb.canGoNext(nextPos);
				boolean eat = cb.doEatNext(nextPos);
				if (canGoNext || eat)
                    cb.printMovement(this.type, this.posX, this.posY, i, this.posY, eat);
			}

			// Up direction
			// Y is changing, X remains
			canGoNext = true;
			for (int i = this.posY - 1; (i >= 0 && canGoNext); i--) {
				// get the next case
                Position nextPos = new Position(this.posX, i);
				canGoNext = cb.canGoNext(nextPos);
                boolean eat = cb.doEatNext(nextPos);
                if (canGoNext || eat) {
                    cb.printMovement(this.type, this.posX, this.posY, this.posX, i, eat);
                }
            }

            // Down direction
            // Y is changing, X remains
            canGoNext = true;
            for (int i = this.posY + 1; (i < 8 && canGoNext); i++) {
                // get the next case
                Position nextPos = new Position(this.posX, i);
				canGoNext = cb.canGoNext(nextPos);
				boolean eat = cb.doEatNext(nextPos);
				if (canGoNext || eat)
                    cb.printMovement(this.type, this.posX, this.posY, this.posX, i, eat);
			}
		}

	}