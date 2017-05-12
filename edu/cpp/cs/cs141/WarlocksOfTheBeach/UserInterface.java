package edu.cpp.cs.cs141.WarlocksOfTheBeach;
/**
 * 
 */

/**
 * @author bjhau
 *
 */
public class UserInterface {

	
	public static UserInterface mCreateInterface(int tSelection)
	{
		if (tSelection == 0)
			return new GUI();
		else
			return new UserInterface();
	}
}
