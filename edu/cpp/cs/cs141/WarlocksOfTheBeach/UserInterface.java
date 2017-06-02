package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.io.Serializable;
import java.util.Scanner;

public class UserInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5883456823542350470L;
	/**
	 * 
	 */

	private Scanner pKeyboard;

	public UserInterface() {
		pKeyboard = new Scanner(System.in);
	}

	public static UserInterface mCreateInterface(int tSelection) {
		if (tSelection == 0)
			return new GUI();
		else
			return new UserInterface();
	}

	public void mPrintDebugBoard(GameSpace[][] tGB, int tPlayer, int tNinja[]) {
		System.out.println(tPlayer);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print("[");

				if (i == (tPlayer / 9) && j == (tPlayer % 9))
					System.out.print("P");
				else if ((i == tNinja[0] / 9 && j == tNinja[0] % 9) || (i == tNinja[1] / 9 && j == tNinja[1] % 9)
						|| (i == tNinja[2] / 9 && j == tNinja[2] % 9) || (i == tNinja[3] / 9 && j == tNinja[3] % 9)
						|| (i == tNinja[4] / 9 && j == tNinja[4] % 9) || (i == tNinja[5] / 9 && j == tNinja[5] % 9))
					System.out.print("N");
				else if (tGB[i][j].getClass().equals(Null.class))
					System.out.print(" ");
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

	}

	public boolean mNew() {

		System.out.println("Would you like to start a new game or continue from a saved file?");
		System.out.println("Enter N for new game\nOr L to load a saved game");
		boolean tVI = false;
		boolean tOutput = true;
		do {
			String tIN = pKeyboard.nextLine();
			if (tIN.equals("N")) {
				tOutput = true;
				tVI = true;
			} else if (tIN.equals("L")) {
				tOutput = false;
				tVI = true;
			}

		} while (tVI = false);
		return tOutput;
	}

	public void mPauseScript() {
		System.out.println("Press enter to continue.");
		pKeyboard.nextLine();
	}

	public int mTurnSelect() {
		int tSelection;

		do {
			System.out.println(
					"Please make a selection. \nType in: \nL to look \nS to Shoot \nM to move \nQ to quit \nF to save");
			String tInput = pKeyboard.nextLine();
			if (tInput.equals("L"))
				tSelection = 0;
			else if (tInput.equals("S"))
				tSelection = 1;
			else if (tInput.equals("M"))
				tSelection = 2;
			else if (tInput.equals("Q"))
				tSelection = 3;
			else if (tInput.equals("F"))
				tSelection = 4;
			else if (tInput.equals("Debug"))
				tSelection = 5;
			else
				tSelection = -1;
		} while (tSelection < 0);

		return tSelection;
	}

	public int mShoot() {
		boolean tVI = false;
		int tOutput = -1;
		do {
			System.out.println("Enter U to shoot up, D to shoot down, L to shoot left and R to shoot right.");
			String tInput = pKeyboard.nextLine();
			if (tInput.equals("U")) {
				tOutput = 0;
				tVI = true;
			} else if (tInput.equals("R")) {
				tOutput = 1;
				tVI = true;
			} else if (tInput.equals("D")) {
				tOutput = 2;
				tVI = true;
			} else if (tInput.equals("L")) {
				tOutput = 3;
				tVI = true;
			}
		} while (tVI = false);
		return tOutput;
	}

	public int mPMove() {
		boolean tVI = false;
		int tOutput = -1;
		do {
			System.out.println("Enter U to move up, D to move down, L to move left and R to move right.");
			String tInput = pKeyboard.nextLine();
			if (tInput.equals("U")) {
				tOutput = 0;
				tVI = true;
			} else if (tInput.equals("R")) {
				tOutput = 1;
				tVI = true;
			} else if (tInput.equals("D")) {
				tOutput = 2;
				tVI = true;
			} else if (tInput.equals("L")) {
				tOutput = 3;
				tVI = true;
			}
		} while (tVI = false);

		return tOutput;

	}

	public void InvalidMove() {
		System.out.println("You cannot move in that direction");

	}

	public void mGameLoss() {
		System.out.println("You are out of Lives and have lost the game.\nBetter luck next time!");

	}

	public void mGameWin() {
		System.out.println("You have found the briefcase!\nVictory is yours!");

	}

	/**
	 * 
	 */
	public void mOutofAmmo() {
		System.out.println("You are out of Ammo!");

	}

	public void mPrintBoard(GameSpace[][] pGameBoard, int tPlayer, boolean tRadar) {
		System.out.println("PrintGameBoard start");
		System.out.println(tPlayer);
		for (int i = 0; i < 9; i++) {
			// System.out.println("Y = " + i);
			for (int j = 0; j < 9; j++) {
				System.out.print("[");

				if (i == (tPlayer / 9) && j == (tPlayer % 9))
					System.out.print("P");
				else if (tRadar == true && pGameBoard[i][j].getClass().equals(BriefCase.class))
					System.out.print("B");
				else if (pGameBoard[i][j].getClass().equals(Room.class) || pGameBoard[i][j].getClass().equals(BriefCase.class)) 
					System.out.print("r");
				else
					System.out.print("*");
				System.out.print("]");
				;
			}
			System.out.println("");
		}
		System.out.println("PrintGameBoard end");

	}

	public void mPrintBoard(GameSpace[][] tGB, int tPlayer, boolean tRadar, int tDirection, int tNinja[]) {
		System.out.println(tPlayer);
		int tSP1 = tPlayer;
		int tSP2 = tPlayer;
		if (tDirection == 0) // up
		{
			if (tPlayer / 9 > 0)
				tSP1 = tPlayer - 9;
			else
				tSP1 = tPlayer;

			if (tPlayer / 9 > 1)
				tSP2 = tPlayer - 18;
			else
				tSP2 = tPlayer;
		} else if (tDirection == 1) // right
		{
			if (tPlayer % 9 < 8)
				tSP1 = tPlayer + 1;
			else
				tSP1 = tPlayer;

			if (tPlayer % 9 < 7)
				tSP2 = tPlayer + 2;
			else
				tSP2 = tPlayer;
		} else if (tDirection == 2) // down
		{
			if (tPlayer / 9 < 8)
				tSP1 = tPlayer + 9;
			else
				tSP1 = tPlayer;

			if (tPlayer / 9 < 7)
				tSP2 = tPlayer + 18;
			else
				tSP2 = tPlayer;
		} else if (tDirection == 3) // left
		{
			if (tPlayer % 9 > 0)
				tSP1 = tPlayer - 1;
			else
				tSP1 = tPlayer;

			if (tPlayer % 9 > 1)
				tSP2 = tPlayer - 2;
			else
				tSP2 = tPlayer;
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print("[");

				if (i == (tPlayer / 9) && j == (tPlayer % 9))
					System.out.print("P");
				else if (tRadar == true && tGB[i][j].getClass().equals(BriefCase.class))
					System.out.print("B");
				else if (tSP1 == ((i * 9) + j)) {
					if ((i == tNinja[0] / 9 && j == tNinja[0] % 9) || (i == tNinja[1] / 9 && j == tNinja[1] % 9)
							|| (i == tNinja[2] / 9 && j == tNinja[2] % 9) || (i == tNinja[3] / 9 && j == tNinja[3] % 9)
							|| (i == tNinja[4] / 9 && j == tNinja[4] % 9) || (i == tNinja[5] / 9 && j == tNinja[5] % 9))
						System.out.print("N");
					else if (tGB[i][j].getClass().equals(Null.class))
						System.out.print(" ");
					else if (tGB[i][j].getClass().equals(Room.class))
						System.out.print(" ");
					else if (tGB[i][j].getClass().equals(BriefCase.class))
						System.out.print("B");
					else if (tGB[i][j].getClass().equals(Bullet.class))
						System.out.print("b");
					else if (tGB[i][j].getClass().equals(Radar.class))
						System.out.print("R");
					else if (tGB[i][j].getClass().equals(Invicibility.class))
						System.out.print("I");
				} else if (tSP2 == ((i * 9) + j)) {
					if ((i == tNinja[0] / 9 && j == tNinja[0] % 9) || (i == tNinja[1] / 9 && j == tNinja[1] % 9)
							|| (i == tNinja[2] / 9 && j == tNinja[2] % 9) || (i == tNinja[3] / 9 && j == tNinja[3] % 9)
							|| (i == tNinja[4] / 9 && j == tNinja[4] % 9) || (i == tNinja[5] / 9 && j == tNinja[5] % 9))
						System.out.print("N");
					else if (tGB[i][j].getClass().equals(Null.class))
						System.out.print(" ");
					else if (tGB[i][j].getClass().equals(Room.class))
						System.out.print(" ");
					else if (tGB[i][j].getClass().equals(BriefCase.class))
						System.out.print("B");
					else if (tGB[i][j].getClass().equals(Bullet.class))
						System.out.print("b");
					else if (tGB[i][j].getClass().equals(Radar.class))
						System.out.print("R");
					else if (tGB[i][j].getClass().equals(Invicibility.class))
						System.out.print("I");
				} else if (tGB[i][j].getClass().equals(Room.class) || tGB[i][j].getClass().equals(BriefCase.class)) 
						System.out.print("r");
				else
					System.out.print("*");
				System.out.print("]");
			}
			System.out.println("");
		}

	}

	/**
	 * @return
	 */
	public int mGetLookD() {
		boolean tVI = false;
		int tOutput = -1;
		do {
			System.out.println("Enter U to look up, D to look down, L to look left and R to look right.");
			String tInput = pKeyboard.nextLine();
			if (tInput.equals("U")) {
				tOutput = 0;
				tVI = true;
			} else if (tInput.equals("R")) {
				tOutput = 1;
				tVI = true;
			} else if (tInput.equals("D")) {
				tOutput = 2;
				tVI = true;
			} else if (tInput.equals("L")) {
				tOutput = 3;
				tVI = true;
			}
		} while (tVI = false);

		return tOutput;
	}

	/**
	 * @return
	 */
	public String mSave() {
		System.out.println("Please enter a name for the save file.");
		String tFileName = pKeyboard.nextLine();
		return tFileName;
	}

	/**
	 * @return
	 */
	public String mLoad() {
		System.out.println("What file would you like to load?");
		String tOP = pKeyboard.nextLine();
		return tOP;
	}

	/**
	 * 
	 */
	public void mLoadFailed() {
		System.out.println("Loading the file failed, please try again or start a new game");

	}

	/**
	 * 
	 */
	public void mIntro() {
		System.out.println(
				"          _______  _______  _        _______  _______  _        _______    _______  _______   _________          _______    ______   _______  _______  _______          ");
		System.out.println(
				"|\\     /|(  ___  )(  ____ )( \\      (  ___  )(  ____ \\| \\    /\\(  ____ \\  (  ___  )(  ____ \\  \\__   __/|\\     /|(  ____ \\  (  ___ \\ (  ____ \\(  ___  )(  ____ \\|\\     /|");
		System.out.println(
				"| )   ( || (   ) || (    )|| (      | (   ) || (    \\/|  \\  / /| (    \\/  | (   ) || (    \\/     ) (   | )   ( || (    \\/  | (   ) )| (    \\/| (   ) || (    \\/| )   ( |");
		System.out.println(
				"| | _ | || (___) || (____)|| |      | |   | || |      |  (_/ / | (_____   | |   | || (__         | |   | (___) || (__      | (__/ / | (__    | (___) || |      | (___) |");
		System.out.println(
				"| |( )| ||  ___  ||     __)| |      | |   | || |      |   _ (  (_____  )  | |   | ||  __)        | |   |  ___  ||  __)     |  __ (  |  __)   |  ___  || |      |  ___  |");
		System.out.println(
				"| || || || (   ) || (\\ (   | |      | |   | || |      |  ( \\ \\       ) |  | |   | || (           | |   | (   ) || (        | (  \\ \\ | (      | (   ) || |      | (   ) |");
		System.out.println(
				"| () () || )   ( || ) \\ \\__| (____/\\| (___) || (____/\\|  /  \\ \\/\\____) |  | (___) || )           | |   | )   ( || (____/\\  | )___) )| (____/\\| )   ( || (____/\\| )   ( |");
		System.out.println(
				"(_______)|/     \\||/   \\__/(_______/(_______)(_______/|_/    \\/\\_______)  (_______)|/            )_(   |/     \\|(_______/  |/ \\___/ (_______/|/     \\|(_______/|/     \\|");
		System.out.println("Welcome brave hero.");
		System.out.println("You are one of the esteemed agents of the well known game making company Warlocks of the beach");
		System.out.println("You have been sent to steal the prized, legendary, black, spectacular lotus from the depths of your competitors R&D department");
		System.out.println("Beware though, they have used there otherworldly powers to summon rat ninja's from the plane of Kamigawa to protect their secrets");
		System.out.println("Find the briefcase containing the prized, legendary, black, spectacular lotus without getting caught and killed");
		System.out.println("You only have one bullet and three chances for success or we will banish you with our oblivious ring");
		System.out.println("Good Luck");

	}

}
