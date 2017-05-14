/**
 * 
 */
package edu.cpp.cs.cs141.WarlocksOfTheBeach;

/**
 * @author Cesar
 *
 */
/**
 * @author bjhau
 * Class to define the PLayer and all of its capabilities.
 * Keeps track of Bullets, Lives, Invincibility, and Radar.
 */
public class Player extends MovingObject {
	// How many bullets the player has.
	private int pBullets;

	//How many turns of invincibility the player has left.
	private int pInvincibility;

	//How many lives the player has.
	private int pLives;

	// Whether or not the player had radar capabilities.
	private boolean pRadar;

	// Constructor for new Player instance.
	public Player() {
		super();
		pBullets = 1;
		pLives = 3;
		pInvincibility = 0;
		pRadar = false;
	}

	//Check if the player currently has invincibility regardless of turns left.
	public boolean mCheckInvincibility() {
		if ( pInvincibility > 0 ) {
			return true;
		}
		else {
			return false;
		}
	}

	// Set invincibility from a saved game
	public void mSetInvincibility(int tInvincibility) {
		pInvincibility = tInvincibility;
	}
	
	// Set bullets from a saved game.
	public void mSetBullets(int tBullets) {
		pBullets = tBullets;
	}
	
	// Set lives from a saved game.
	public void mSetLives(int tLives) {
		pLives = tLives;
	}
	
	// Set radar from a saved game.
	public void mSetRadar(boolean tRadar) {
		pRadar = tRadar;
	}
	
	// Called by the game engine every turn to count down the turns of invincibility left.
	public void mCountInvicibility() {
		pInvincibility --;
	}

	// Takes away one life from the player.
	public void mDeath() {
		pLives --;
	}

	// Return the number of bullets the player has left.
	public int mGetBullets() {
		return pBullets;
	}

	// Return how many turns of invincibility the player has left.
	public int mGetInvincibility() {
		return pInvincibility;
	}

	// Return the number of lives the player has left.
	public int mGetLives() {
		return pLives;
	}

	// Returns whether or not the player has Radar capabilities.
	public boolean mIsRadar() {
		return pRadar;
	}

	// If the player gets the invincibility pack, this sets the turns left to 5.
	public void mSetInvincibility() {
		pInvincibility = 5;
	}

	//Reduce the number of bullets by one when the player shoots.
	public void mShoot() {
		pBullets --;
	}
}
