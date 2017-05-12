/**
 * 
 */
package edu.cpp.cs.cs141.WarlocksOfTheBeach;

/**
 * @author Cesar
 *
 */
public class Player extends MovingObject {

	private int bullets;
	
	private int lives;
	
	private int invincibility;
	
	private boolean radar;
	/**
	 * 
	 */
	public Player() {
		super();
		bullets = 1;
		lives = 3;
		invincibility = checkInvincibility();
		radar = false;
	}
	
	public int checkInvincibility() {
		return 0;
	}
	
	

}
