package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import edu.cpp.cs.cs141.WarlocksOfTheBeach.Player;
import edu.cpp.cs.cs141.WarlocksOfTheBeach.GameEngine;

import java.util.Random;

import org.omg.PortableServer.POA;

/**
 * @author edgarchilin pliving mMove mCheckLinezOfSight mCheckKill
 *         mCheckInvincibility fix set from saved games
 */
public class Ninja extends MovingObject {

	private static Player po;

	private int mLiving;
	private int mMove;
	private boolean mCheckLinezOfSight;
	private boolean mCheckKill;
	private boolean mCheckInvicibility;
	private boolean mState;
	
	public Ninja() {

		super();
		mLiving = computeLife();
		mMove = computeMovement();
		mCheckLinezOfSight = findPlayer();
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

	private void computeMovement() {
		int rand= new Random().nextInt(3);
		Ninja.mMove(rand);
	
	}

	// still fixing
	private static boolean findPlayer() {

		return true;
		// if (pGameBoard[po.getpXPosition() + 1][po.getpYPosition()] ==
		// pGameBoard[Ninja.getpXPosition()][n
		// .getpYPosition()]) {
		// return true;
		// } else if (pGameBoard[po.getpXPosition() - 1][po.getpYPosition()] ==
		// pGameBoard[n.getpXPosition()][n
		// .getpYPosition()]) {
		// return true;
		// } else if (pGameBoard[po.getpXPosition()][po.getpYPosition() + 1] ==
		// pGameBoard[n.getpXPosition()][n
		// .getpYPosition()]) {
		// return true;
		// }
		// if (pGameBoard[po.getpXPosition()][po.getpYPosition() + 1] ==
		// pGameBoard[n.getpXPosition()][n
		// .getpYPosition()]) {
		// return true;
		// } else {
		// return false;
		// }
	}

	private static boolean computeKill() {
		return true;
		
	}

	private static boolean computeInvincibility() {
		if (po.mCheckInvincibility() == true) {
			return true;
		} else
			return false;
	}

	public boolean getCheckInvicibility() {
		return mCheckInvicibility;
	}

	public int enemyHealth() {
		return mLiving;
	}

	public boolean enemyStatus() {
		return mState;
	}

	
	public boolean position(int playerPO){
		if(playerPO +1 == ){
			return true;
		}
		else if(playerPO-1== ){
				return true;
		}
		else if(playerPO+9 ==  ){
			return true;
		}
		else if(playerPO-9==  ) {
				return true;
		}
		else {
			return computeKill();
		}
	}

}
