package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import edu.cpp.cs.cs141.WarlocksOfTheBeach.Player;
import java.util.Random;

/**
 * @author edgarchilin pliving mMove mCheckLinezOfSight mCheckKill
 *         mCheckInvincibility fix set from saved games
 * 
 *         need to add movement in the 0-80 or X & Y also cannot go into rooms
 * 
 */
public class Ninja extends MovingObject {

	private static Player po;

	
	private int pHealth;
	private int pMove;
	private int pCheckLinezOfSight;
	private int pCheckKill;
	private boolean pCheckInvicibility;
	private boolean pState;

	public Ninja() {
		super();
		do
		{
		int tY = new Random().nextInt(9);
		int tX = new Random().nextInt(9);
		super.pPosition = (tY*9)+(tX);
		}while ((((super.pPosition == 0) && (super.pPosition == 1)) && (((pPosition == 2) && (pPosition == 9)) && ((pPosition == 10) && (pPosition == 11)))) && (((pPosition == 18) && (pPosition == 19)) && (pPosition == 20)));
		
		
		
		/*pHealth = mComputeLife();
		pMove = mComputeMovement();
		pCheckLinezOfSight = mFindPosition(pCheckLinezOfSight);
		pCheckKill = mComputeKill();
		pCheckInvicibility = mComputeInvincibility();
		pState = mCheckStatus();*/
	}

	private int mRandPosition() {
		int rand = new Random().nextInt(80);
		if (rand == 73) {
			mRandPosition();
		}
		return rand;
	}

	private int mComputeLife() {
		return 1;
	}

	public boolean mCheckStatus() {
		if (pHealth == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean mComputeInvincibility() {
		if (po.mCheckInvincibility() == true) {
			return true;
		} else
			return false;
	}

	public void mComputeMovement() {
		
		boolean tVM = false;
		do{
		int rand = new Random().nextInt(4);
		super.mMove(rand);
		} while (tVM = false);
	}

	public int mComputeKill(int tPP) {
		if ((tPP == pPosition-1) || (tPP == pPosition+1) || (tPP == pPosition-9) || (tPP == pPosition-1))
			return 1;
		else
			return 0;

	}

	public int mDeath() {
		return pHealth--;
	}

	public int mFindPosition(int playerPO) {
		if (playerPO + 1 == super.mGetXPosition() * 9) {
			pCheckLinezOfSight = 1;
			return pCheckLinezOfSight;
		} else if (playerPO - 1 == super.mGetXPosition() * 9) {
			pCheckLinezOfSight = 2;
			return pCheckLinezOfSight;
		} else if (playerPO + 9 == super.mGetYPosition() * 9) {
			pCheckLinezOfSight = 3;
			return pCheckLinezOfSight;
		} else if (playerPO - 9 == super.mGetYPosition() * 9) {
			pCheckLinezOfSight = 4;
			return pCheckLinezOfSight;
		} else {
			pCheckLinezOfSight = -1;
			return pCheckLinezOfSight;
		}
	}

	// Setters for the properties

	public void setpLiving(int tLiving) {
		pHealth = tLiving;
	}

	public void setpMove(int tMove) {
		pMove = tMove;
	}

	public void setpCheckLinezOfSight(int tCheckLinezOfSight) {
		pCheckLinezOfSight = tCheckLinezOfSight;
	}

	public void setpCheckKill(int tCheckKill) {
		pCheckKill = tCheckKill;
	}

	public void setpCheckInvicibility(boolean tCheckInvicibility) {
		pCheckInvicibility = tCheckInvicibility;
	}

	public void setpState(boolean tState) {
		pState = tState;
	}
	public void mMoveNinja()
	{
		boolean tVM = false;
		do
		{
			int tD = new Random().nextInt(4);
			int tMR = super.mMove(tD);
			if (tMR > -1)
				tVM = true;
							
		}while (tVM == false);
	}
	public void setPosition(int tposition) {
		pPosition = tposition;
	}
	// Getter for the properties

	public boolean mCheckInvicibility() {
		return pCheckInvicibility;
	}

	public int mEnemyHealth() {
		return pHealth;
	}

	public boolean mEnemyStatus() {
		return pState;
	}

	public int mMovement() {
		return pMove;
	}

	public int mPosition() {
		return pPosition;
	}

	public int mCheckKill() {
		return pCheckKill;
	}

	public boolean mCheckState() {
		return pState;
	}
}
