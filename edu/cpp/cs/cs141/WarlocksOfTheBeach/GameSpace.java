package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.io.Serializable;

/**
 * @author bjhau
 *	author Cesar
 *	GameSpace is a parent object of the four types of items. They will have the mReturnType method to return
 *	its String name. The children objects call upon the super constructor to assign the appropriate String name.
 *	The idea is to have the class as a super class for which to make objects on the game board under these circumstances.
 */
public class GameSpace implements Serializable{

	
	/**
	 * This will later us help us save the object in document control
	 */
	private static final long serialVersionUID = -2535505126098186389L;

	public GameSpace() {
	
	}
}
