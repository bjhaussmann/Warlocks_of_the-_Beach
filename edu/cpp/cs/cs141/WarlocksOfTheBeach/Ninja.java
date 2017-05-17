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

	private static GameEngine ge;
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
		mCheckLinezOfSight = findPlayer(ge.pGameBoard);
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
		// call moving object method to move ninja and move towards 
		
		return 0;
	}
//still fixing 
	private static boolean findPlayer(GameSpace[][] pGameBoard) {
		if (pGameBoard[po.getpXPosition() + 1][po.getpYPosition()] == pGameBoard[Ninja.getpXPosition()][n
				.getpYPosition()]) {
			return true;
		} else if (pGameBoard[po.getpXPosition() - 1][po.getpYPosition()] == pGameBoard[n.getpXPosition()][n
				.getpYPosition()]) {
			return true;
		} else if (pGameBoard[po.getpXPosition()][po.getpYPosition() + 1] == pGameBoard[n.getpXPosition()][n
				.getpYPosition()]) {
			return true;
		}
		if (pGameBoard[po.getpXPosition()][po.getpYPosition() + 1] == pGameBoard[n.getpXPosition()][n
				.getpYPosition()]) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean computeKill() {
		//still fixing 
		return false;
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

}
