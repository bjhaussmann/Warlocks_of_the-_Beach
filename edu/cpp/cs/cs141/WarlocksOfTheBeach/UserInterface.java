package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.util.Scanner;

public class UserInterface {

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
		System.out.println("PrintGameBoard start");
		System.out.println(tPlayer);
		for (int i = 0; i < 6; i++) {
			System.out.println(tNinja[i]);
		}
		for (int i = 0; i < 9; i++) {
			// System.out.println("Y = " + i);
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
		System.out.println("PrintGameBoard end");

	}

	public boolean mNew() {
		// needs real code
		return true;
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
			System.out
					.println("Enter Up to shoot up, Down to shoot down, Left to shoot left and Right to shoot right.");
			String tInput = pKeyboard.nextLine();
			if (tInput.equals("Up")) {
				tOutput = 0;
				tVI = true;
			} else if (tInput.equals("Right")) {
				tOutput = 1;
				tVI = true;
			} else if (tInput.equals("Down")) {
				tOutput = 2;
				tVI = true;
			} else if (tInput.equals("Left")) {
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
			System.out.println("Enter Up to move up, Down to move down, Left to move left and Right to move right.");
			String tInput = pKeyboard.nextLine();
			if (tInput.equals("Up")) {
				tOutput = 0;
				tVI = true;
			} else if (tInput.equals("Right")) {
				tOutput = 1;
				tVI = true;
			} else if (tInput.equals("Down")) {
				tOutput = 2;
				tVI = true;
			} else if (tInput.equals("Left")) {
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

	/**
	 * @param pGameBoard
	 * @param mGetPosition
	 */
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
		System.out.println("PrintGameBoard start");
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
				} else
					System.out.print("*");
				System.out.print("]");
			}
			System.out.println("");
		}
		System.out.println("PrintGameBoard end");

	}

}
