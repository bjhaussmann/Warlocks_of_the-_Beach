package edu.cpp.cs.cs141.WarlocksOfTheBeach;
/**
 * @author bjhau
 *	author Cesar
 *	GameSpace is a parent object of the four types of items. They will have the mReturnType method to return
 *	its String name. The children objects call upon the super constructor to assign the appropriate String name.
 */
public class GameSpace {

	final private String pName;
	
//	private int pXPosition;
//	
//	private int pYPosition;
	
	public GameSpace(String tName) {
		this.pName = tName;
	}
	
	public String mReturnType () {
		return pName;
	}
	
//	public void setXPosition(int tXPosition) {
//		this.pXPosition = tXPosition;
//	}
//	
//	public void setYPosition(int tYPosition) {
//		this.pYPosition = tYPosition;
//	}
//	
//	public int getPosition() {
//		int tPosition = ((this.pYPosition * 9) + this.pXPosition);
//		return tPosition;
//	}
}
