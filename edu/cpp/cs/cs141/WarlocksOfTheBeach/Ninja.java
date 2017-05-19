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

	private int mLiving;
	private int mMove;
	private boolean mCheckLinezOfSight;
	private int mCheckKill;
	private boolean mCheckInvicibility;
	private boolean mState;

	public Ninja() {
		super();
		mLiving = computeLife();
		mMove = computeMovement();
		mCheckLinezOfSight = findPlayer(mCheckLinezOfSight);
		mCheckKill = computeKill();
		mCheckInvicibility = computeInvincibility();
		mState = checkStatus();

	}

	private boolean checkStatus() {
		if (mLiving == 1) {
			return true;
		} else {
			return false;
		}
	}

	private int computeLife() {
		return 1;
	}

	private int computeMovement() {
		int rand = new Random().nextInt(3);
		return super.mMove(rand);
		
	}

	private boolean findPlayer(boolean mCheck) {
		if (mCheck == true) {
			return true;
		} else
			return false;
	}
	private int computeKill() {
		int lifes=0;
		if(mCheckLinezOfSight== true){
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

	public boolean getCheckInvicibility() {
		return mCheckInvicibility;
	}

	public int getEnemyHealth() {
		return mLiving;
	}

	public boolean getEnemyStatus() {
		return mState;
	}
	public int getMovement(){
		return mMove;
	}
	
	public int getmCheckKill() {
		return mCheckKill;
	}

	public boolean position(int playerPO) {
		if (playerPO + 1 == super.mGetXPosition() % 9) {
			return findPlayer(true);
		} else if (playerPO - 1 == super.mGetXPosition() % 9) {
			return findPlayer(true);
		} else if (playerPO + 9 == super.mGetYPosition() * 9) {
			return findPlayer(true);
		} else if (playerPO - 9 == super.mGetYPosition()* 9) {
			return findPlayer(true);
		} else {
			return false;
		}
	}

}
