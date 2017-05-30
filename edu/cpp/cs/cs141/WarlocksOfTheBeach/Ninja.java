package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.util.Random;

/**
 * @author edgarchilin pliving mMove mCheckLinezOfSight mCheckKill
 *         mCheckInvincibility fix set from saved games
 * 
 */
public class Ninja extends MovingObject {

	private int pHealth;

	public Ninja() {
		super();
		do {
			int tY = new Random().nextInt(9);
			int tX = new Random().nextInt(9);
			super.pPosition = (tY * 9) + (tX);
		} while ((pPosition == 0) || (pPosition == 1)|| (pPosition == 2) 
				|| (pPosition == 9) || (pPosition == 10) || (pPosition == 11)
				|| (pPosition == 18) || (pPosition == 19) || (pPosition == 20) 
				|| (pPosition == 10) || (pPosition == 13) || (pPosition == 16)
				|| (pPosition == 37) || (pPosition == 40) ||(pPosition == 43) 
				|| (pPosition == 64) || (pPosition ==67) || (pPosition == 70));
				

		pHealth = mComputeLife();

	}

	private int mComputeLife() {
		return 1;
	}

	public int mComputeInvincibility(int invincibilty) {
		if (invincibilty >= 1) {
			return 1;
		} else
			return 0;
	}

	public int mComputeKill(int tPP) {
		if ((tPP == pPosition - 1) || (tPP == pPosition + 1) || (tPP == pPosition - 9) || 
				(tPP == pPosition - 1))
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
				
				//Ninjas will not go into room but jump over instead. fixing
			if(tMR > -1)
				if ((pPosition != 10) || (pPosition != 13)
						|| (pPosition != 16) || (pPosition != 37) || (pPosition != 40) ||
						(pPosition != 43) || (pPosition != 64) || (pPosition !=67) 
						|| (pPosition != 70))
					tVM= true;
			
		} while (tVM == false);
	}

	// Setters for the properties

	public void setpLiving(int tLiving) {
		pHealth = tLiving;
	}

	public void setPosition(int tposition) {
		pPosition = tposition;
	}
	// Getter for the properties

	public int mGetEnemyHealth() {
		return pHealth;
	}

	public int mGetNinjaPosition() {
		return pPosition;
	}
}
