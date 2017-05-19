package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import edu.cpp.cs.cs141.WarlocksOfTheBeach.Player;
import edu.cpp.cs.cs141.WarlocksOfTheBeach.MovingObject;
import java.util.Random;

import org.omg.PortableServer.POA;

/**
 * @author edgarchilin pliving mMove mCheckLinezOfSight mCheckKill
 *         mCheckInvincibility fix set from saved games
 * 
 */
public class Ninja extends MovingObject {

	private static Player po;

	private int pLiving;
	private int pMove;
	private int pCheckLinezOfSight;
	private int pCheckKill;
	private boolean pCheckInvicibility;
	private boolean pState;

	public Ninja() {
		super();
		pLiving = computeLife();
		pMove = computeMovement();
		pCheckLinezOfSight = mFindPosition(pCheckLinezOfSight);
		pCheckKill = computeKill();
		pCheckInvicibility = computeInvincibility();
		pState = checkStatus();
	}

	private boolean checkStatus() {
		if (pLiving == 1) {
			return true;
		} else {
			return false;
		}
	}

	private int computeLife() {
		return 1;
	}

	private int computeMovement() {
		if(super.mGetXPosition() != 1  && super.mGetYPosition() != 4 ) 
			if( super.mGetXPosition() != && super.mGetYPosition() != )
				if( super.mGetXPosition() != && super.mGetYPosition() != )
				if ( super.mGetXPosition() != && super.mGetYPosition() != )	
				if ( super.mGetXPosition() != && super.mGetYPosition() != )	
					
		int rand = new Random().nextInt(3);
		return super.mMove(rand);
		
	}

	private int computeKill() {
		int lifes = 0;
		if (pCheckLinezOfSight == (1 | 2 | 3 | 4) ) {
			lifes++;
		}
		return lifes;

	}

	private boolean computeInvincibility() {
		if (po.mCheckInvincibility() == true) {
			return true;
		} else

			return false;
	}

	public boolean mCheckInvicibility() {
		return pCheckInvicibility;
	}

	public int mEnemyHealth() {
		return pLiving;
	}

	public boolean mEnemyStatus() {
		return pState;
	}

	public int mMovement() {
		return pMove;
	}

	public int mCheckKill() {
		return pCheckKill;
	}

	public int mFindPosition(int playerPO) {
		if (playerPO + 1 == super.mGetXPosition() % 9) {
			pCheckLinezOfSight= 1;
			return pCheckLinezOfSight;
		} else if (playerPO - 1 == super.mGetXPosition() % 9) {
			pCheckLinezOfSight= 2;
			return pCheckLinezOfSight;
		} else if (playerPO + 9 == super.mGetYPosition() * 9) {
			pCheckLinezOfSight= 3;
			return pCheckLinezOfSight;
		} else if (playerPO - 9 == super.mGetYPosition() * 9) {
			pCheckLinezOfSight= 4;
			 return pCheckLinezOfSight;
		} else {
			pCheckLinezOfSight= -1;
			return pCheckLinezOfSight;
		}
	}
}
