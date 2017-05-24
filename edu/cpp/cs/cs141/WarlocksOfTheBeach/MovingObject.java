package edu.cpp.cs.cs141.WarlocksOfTheBeach;

//Daniel 
//Cesar
/**
 * Has fields for x and y position and methods to return those values. Has a
 * move method to change the x and y position based on the integer argument
 * given. Checks if Positions are near the edge before moving
 *
 * @author Cesar
 *
 */
public class MovingObject {

	private int pXPosition;

	private int pYPosition;

	// test

	public MovingObject() {
	}

	public int mMove(int tMove) {
		int tResult = 0;

		if (tMove >= 0 && tMove <= 3) {
			if (tMove == 0 && pYPosition != 0) {
				pYPosition--;
			} else if (tMove == 1 && pXPosition != 8) {
				pXPosition++;
			} else if (tMove == 2 && pYPosition != 8) {
				pYPosition++;
			} else if (tMove == 3 && pXPosition != 0) {
				pXPosition--;
			} else {
				tResult = -1;
			}
		} else {
			tResult = -1;
		}

		return tResult;
	}
	
	public int mGetPosition() {
		int tPosition = ((this.pYPosition * 9) + this.pXPosition);
		return tPosition;
	}

	public int mGetXPosition() {
		return pXPosition;
	}

	public int mGetYPosition() {
		return pYPosition;
	}

	public void mSetXPosition(int tXPosition) {
		pXPosition = tXPosition;
	}

	public void mSetYPosition(int tYPosition) {
		pYPosition = tYPosition;
	}

}
