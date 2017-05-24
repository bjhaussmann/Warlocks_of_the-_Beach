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
	protected int pPosition;
	private int pYPosition;

	// test

	public MovingObject() {
	}

	public int mMove(int tMove) {

			if (tMove == 0 && pPosition/9 != 0) {
				pPosition = pPosition - 9;
				return 0;
			} else if (tMove == 1 && pPosition%9 != 8) {
				pPosition = pPosition + 1;
				return 0;
			} else if (tMove == 2 && pPosition/9 != 8) {
				pPosition = pPosition + 9;
				return 0;
			} else if (tMove == 3 && pPosition%9 != 0) {
				pPosition = pPosition - 1;
				return 0;
			} else 
				{return -1;}

		
	}
	
	public int mGetPosition() {
		return pPosition;
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
