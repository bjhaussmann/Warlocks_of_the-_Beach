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
	public void mPrintBoard(GameSpace[][] tGB, int tPlayer, int tNinja[]) {
		System.out.println("PrintGameBoard start");
		int tNinjaXY[][] = new int[6][2];
		for (int i = 0; i<tNinja.length; i++ )
		{ tNinjaXY[i][0] = tNinja[i]/9;
			tNinjaXY[i][1] = tNinja[i]%9;
			}
		for (int i = 0; i<9; i++)
			{
			//System.out.println("Y = " + i);
			for (int j = 0; j<9; j++)
			{
				System.out.print("[");
				if (tGB[i][j].getClass().equals(Null.class))
					System.out.print(" ");
				else if ((i == tNinjaXY[1][0] && j == tNinjaXY[1][1]) || (i == tNinjaXY[2][0] && j == tNinjaXY[2][1]) ||(i == tNinjaXY[3][0] && j == tNinjaXY[3][1]) || (i == tNinjaXY[4][0] && j == tNinjaXY[4][1]) || (i == tNinjaXY[5][0] && j == tNinjaXY[5][1]) || (i == tNinjaXY[0][0] && j == tNinjaXY[0][1]))
					System.out.print("N");
				else if (i == tPlayer/9 && j == tPlayer%9)
					System.out.println("P");
				else if (tGB[i][j].getClass().equals(Room.class))
					System.out.print("r");
				else if (tGB[i][j].getClass().equals(BriefCase.class))
					System.out.print("B");
				else if (tGB[i][j].getClass().equals(Bullet.class))
					System.out.print("b");
				else if (tGB[i][j].getClass().equals(Radar.class))
					System.out.print("R");
				else if (tGB[i][j].getClass().equals(Invicibility.class))
					System.out.print("I");
				
				else
					System.out.print("*");
				System.out.print("]");
				;
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

	/**
	 * @return
	 */
	public int mTurnSelect() {
		int tSelection;
		
		do{
			System.out.println("Please make a selection. \nType in: \nL to look \nS to Shoot \nM to move \nQ to quit \nF to save");
			String tInput = pKeyboard.nextLine();
			if (tInput.equals("L"))
				tSelection = 0;
			else if(tInput.equals("S"))
				tSelection = 1;
			else if(tInput.equals("M"))
				tSelection = 2;
			else if(tInput.equals("Q"))
				tSelection = 3;
			else if(tInput.equals("F"))
				tSelection = 4;
			else
				tSelection = -1;
		}while(tSelection < 0);
		
		return tSelection;
	}

	/**
	 * @return
	 */
	
	}
