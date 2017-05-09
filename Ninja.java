package edu.cpp.cs.cs141.incharge_ninja;

/**
 * @author edgarchilin  
 * pliving 
 * mMove 
 * mCheckLinezOfSight
 *  mCheckKill
 * mCheckInvincibility
 *
 */
public class Ninja extends MovingObject {
	private int pLiving;
	private int mMove;
	private boolean mCheckLinezOfSight;
	private boolean mCheckKill;
	private boolean mCheckInvicibility;

	public Ninja() {
		pLiving = computeLife();
		mMove = computeMovement();
		mCheckLinezOfSight = findPlayer();
		mCheckKill = computeKill();
		mCheckInvicibility = computeInvincibility();
	}

	public int computeLife() {
		return 0;
	}

	public static int computeMovement() {
		return 0;
	}

	private static boolean findPlayer() {
		return false;
	}

	private static boolean computeKill() {
		return false;
	}

	private static boolean computeInvincibility() {
		return false;
	}

}
