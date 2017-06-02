package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.util.Random;
import java.io.Serializable;
/**
 * @author edgarchilin pliving mMove mCheckLinezOfSight mCheckKill
 *         mCheckInvincibility fix set from saved games
 * 
 */
public class Ninja extends MovingObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4720248096711044295L;
	private int pHealth;

	public Ninja() {
		super();
		do {
			int tY = new Random().nextInt(9);
			int tX = new Random().nextInt(9);
			super.pPosition = (tY * 9) + (tX);
		} while ((pPosition == 72) || (pPosition == 73) || (pPosition == 74) || (pPosition == 63) || (pPosition == 65)
				|| (pPosition == 54) || (pPosition == 55) || (pPosition == 56) 
				|| (pPosition == 10) || (pPosition == 13) || (pPosition == 16) 
				|| (pPosition == 37) || (pPosition == 40) || (pPosition == 43) 
				|| (pPosition == 64) || (pPosition == 67) || (pPosition == 70));

		pHealth = 1;

	}

	public int mComputeKill(int tPP) {
		if (((tPP == pPosition - 1) || (tPP == pPosition + 1) || (tPP == pPosition - 9) || (tPP == pPosition - 1)) && pHealth > 0)
			return 1;
		else
			return 0;
	}

	public int mNinjaDeath() {
		return pHealth--;
	}

	public void mMoveNinja() {
		boolean tVM = false;
		do {
			int tD = new Random().nextInt(4);
			int tMR = super.mMove(tD);
			int tPP = pPosition;
			// Ninjas will not go into room but jump over instead. fixing

			if (tMR > -1) // Check valid movement if yes check Position not
							// equal rooms
			{
				if ((pPosition != 10) && (pPosition != 13) && (pPosition != 16) && (pPosition != 37)
						&& (pPosition != 40) && (pPosition != 43) && (pPosition != 64) && (pPosition != 67)
						&& (pPosition != 70))

				{
					tVM = true;
				} else
					pPosition = tPP;
			}
		} while (tVM == false);
	}

	// Getter for the properties

	public int mGetEnemyHealth() {
		return pHealth;
	}

	public int mGetNinjaPosition() {
		return pPosition;
	}
}
