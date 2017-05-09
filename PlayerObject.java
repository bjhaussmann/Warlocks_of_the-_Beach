/**
 * 
 */
package edu.cpp.cs.cs141;

/**
 * @author Cesar
 *
 */
public class PlayerObject extends MovingObject {

	private int bullets;
	
	private int lives;
	
	private int invincibility;
	
	private boolean radar;
	/**
	 * 
	 */
	public PlayerObject() {
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
