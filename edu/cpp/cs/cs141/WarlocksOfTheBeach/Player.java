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
 * Class to define the PLayer and all of its capabilities. Keeps track of Bullets, Lives, Invincibility,
 * and Radar. 
 */
public class Player extends MovingObject {
	// How many bullets the player has.
	private int bullets;

	//How many lives the player has.
	private int lives;
	
	//How many turns of invincibility the player has left.
	private int invincibility;
	
	// Whether or not the player had radar capabilities.
	private boolean radar;
	
	// Constructor for new Player instance.
	public Player() {
		super();
		bullets = 1;
		lives = 3;
		invincibility = 0;
		radar = false;
	}
	
	//Check if the player currently has invincibility regardless of turns left.
	public boolean mCheckInvincibility() {
		if ( invincibility > 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Called by the game engine every turn to count down the turns of invincibility left.
	public void mCountInvicibility() {
		invincibility --;
	}
	
	// If the player gets the invincibility pack, this sets the turns left to 5.
	public void mSetInvincibility() {
		invincibility = 5;
	}

	// Return the number of bullets the player has left.
	public int mGetBullets() {
		return bullets;
	}

	// Return the number of lives the player has left.
	public int mGetLives() {
		return lives;
	}

	// Return how many turns of invincibility the player has left.
	public int mGetInvincibility() {
		return invincibility;
	}

	// Returns whether or not the player has Radar capabilities.
	public boolean mIsRadar() {
		return radar;
	}
	
	

}
