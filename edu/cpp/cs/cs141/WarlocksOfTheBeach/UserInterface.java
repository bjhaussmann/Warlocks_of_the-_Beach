package edu.cpp.cs.cs141.WarlocksOfTheBeach;
/**
 * 
 */

import java.util.Scanner;

/**
 * @author bjhau
 *
 */
public class UserInterface {
	
	private Scanner pKeyboard;
	
	public UserInterface()
	{
		pKeyboard = new Scanner(System.in);
	}
	
	public static UserInterface mCreateInterface(int tSelection)
	{
		if (tSelection == 0)
			return new GUI();
		else
			return new UserInterface();
	}

	/**
	 * @param pGameBoard
	 */
	public void mPrintBoard(GameSpace[][] tGB) {
		System.out.println("PrintGameBoard start");
		for (int i = 0; i<9; i++)
			{
			for (int j = 0; j<9; i++)
			{
				System.out.print("[");
				if (tGB[i][j].equals(Null.class))
					System.out.print("0");
				else if (tGB[i][j].equals(Room.class))
					System.out.print("r");
				else if (tGB[i][j].equals(BriefCase.class))
					System.out.print("B");
				else if (tGB[i][j].equals(Bullet.class))
					System.out.print("b");
				else if (tGB[i][j].equals(Radar.class))
					System.out.print("R");
				else if (tGB[i][j].equals(Invicibility.class))
					System.out.print("I");
				else
					System.out.print("*");
				System.out.print("]");
			}
			System.out.println("");
			}
		System.out.println("PrintGameBoard end");
		
	}

	/**
	 * @return
	 */
	public boolean mNew() {
		// needs real code
		return true;
	}

	/**
	 * 
	 */
	public void mPauseScript() {
		System.out.println("Press enter to continue.");
		pKeyboard.nextLine();
		}
	}