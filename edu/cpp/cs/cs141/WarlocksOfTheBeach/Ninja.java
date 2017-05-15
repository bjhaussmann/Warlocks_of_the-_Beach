package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import edu.cpp.cs.cs141.WarlocksOfTheBeach.Player;
import edu.cpp.cs.cs141.WarlocksOfTheBeach.GameEngine;

import java.util.Random;

import org.omg.PortableServer.POA;

/**
 * @author edgarchilin pliving mMove mCheckLinezOfSight mCheckKill
 *         mCheckInvincibility
 *
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
		mMove = computeMovement(ge.pGameBoard);
		mCheckLinezOfSight = findPlayer();
		mCheckKill = computeKill();
		mCheckInvicibility = computeInvincibility();
		mState = checkStatus();
	}

	/**
	 * @return
	 */
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

	private int computeMovement(GameSpace[][] pGameBoard) {
		int chance= new Random().nextInt(3);
		if (chance== 0){
			moveUp();
		}
		else if(chance== 1){
			moveDown();
		}
		else if(chance==2){
			moveLeft();
		}
		if(chance==3){
			moveRight();
		}
		return 0;
	}

	private static boolean findPlayer() {
		return false;
	}

	private static boolean computeKill() {
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
	public int enemyHealth(){
		return mLiving;
	}
	public boolean enemyStatus(){
		return mState;
	}

}
