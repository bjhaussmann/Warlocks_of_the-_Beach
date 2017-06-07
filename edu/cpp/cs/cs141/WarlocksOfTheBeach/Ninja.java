package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.util.Random;
import java.io.Serializable;
/**
 * The Ninja class computes the kill, death, spawning, and movement. 
 * It takes an int as the position within the grid to represent the position.
 * We use this to calculate the kill and spawning.
 * Also declares its property of health and its own death.
 * The position of the Ninja is unique using only one int rather than two
 * 
 * @author Daniel Santana Medina
 */
public class Ninja extends MovingObject {

	private static final long serialVersionUID = -4720248096711044295L;
	/*
	 * The ninja's property health
	 * Used to calculate the death
	 */
	private int pHealth;

	/*
	 * The constructor spawns the ninja in a valid position within the grid 
	 * We multiply by 9 and add the other position to get the number 0-80 of the grid
	 * This will be the single position 
	 * 
	 * It also gives the ninja's health
	 */
	public Ninja() {
		super();
		do {
			int tY = new Random().nextInt(9);
			int tX = new Random().nextInt(9);
			super.pPosition = (tY * 9) + (tX);
		} while ((pPosition == 72) || (pPosition == 73) || (pPosition == 74) || (pPosition == 63) || (pPosition == 65)
				|| (pPosition == 54) || (pPosition == 55) || (pPosition == 56) 
				|| (pPosition == 10) || (pPosition == 13) || (pPosition == 16) 
				|| (pPosition == 37) || (pPosition == 40) || (pPosition == 43) 
				|| (pPosition == 64) || (pPosition == 67) || (pPosition == 70));

		pHealth = 1;

	}
	/*
	 * Uses the single int position of the player which is passed from the game engine to check if it is equal
	 * to the ninjas. We add/subtract 1 to check right/left and add/subtract 9 to check up/down, respectively. 
	 */
	public int mComputeKill(int tPP) {
		if (((tPP == pPosition - 1) || (tPP == pPosition + 1) || (tPP == pPosition - 9) || (tPP == pPosition - 1)) && pHealth > 0)
			return 1;
		else
			return 0;
	}
	/*
	 * The ninja's death method 
	 * If the player shoots the Ninja down 
	 */
	public int mNinjaDeath() {
		return pHealth--;
	}
	/*
	 * We call the moving method in the superclass to compute the movement 
	 * Passes a 0-3 number and checks if valid else tries again 
	 * It checks for edges and corners, including rooms
	 */
	public void mMoveNinja() {
		boolean tVM = false;
		do {
			int tD = new Random().nextInt(4);
			int tMR = super.mMove(tD);
			int tPP = pPosition;

			if (tMR > -1) 
			{
				if ((pPosition != 10) && (pPosition != 13) && (pPosition != 16) && (pPosition != 37)
						&& (pPosition != 40) && (pPosition != 43) && (pPosition != 64) && (pPosition != 67)
						&& (pPosition != 70))

				{
					tVM = true;
				} else
					pPosition = tPP;
			}
		} while (tVM == false);
	}

	/*
	 * These return the health and position of the Ninja
	 * Useful for the game engine 
	 */

	public int mGetEnemyHealth() {
		return pHealth;
	}

	public int mGetNinjaPosition() {
		return pPosition;
	}
}
