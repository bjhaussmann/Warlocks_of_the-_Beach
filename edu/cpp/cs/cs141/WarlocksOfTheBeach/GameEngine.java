package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.util.Random;

public class GameEngine {
	private UserInterface UI;
	private GameSpace pGameBoard[][];
	private Player pc;
	private Ninja npc[];
	private DocumenControl DocCntrl;
	private boolean	pDebug;
	
	public GameEngine() {
		UI = UserInterface.mCreateInterface(1);
		DocCntrl = new DocumenControl();
		pDebug = false;
	}

	public void mStartDebug() {
		System.out.println("Debug Start");
		mStartGame();
		System.out.println("Debug end");
	}

	public void mStartGame() {

		mSetGame();
		mCoreGameLoop();
	}

	public void mSetGame() {
		boolean tSuccess = false;
		do {
			if (UI.mNew() == true) {
				pGameBoard = mGenerateGame();
				pc = new Player();
				for (int i = 0; i < 6; i++) {
					npc[i] = new Ninja();
				}
				tSuccess = true;
			} else {
				if (mLoadSave() == -1) {
					// UI.mLoadFailed();
				} else {
					// UI.mLoadSuccess();
					tSuccess = true;
				}

			}
		} while (tSuccess = false);
	}

	public GameSpace[][] mGenerateGame() {
		System.out.println("mGenerateGame start");
		pc = new Player();
		npc = new Ninja[6];

		GameSpace tGameBoard[][] = new GameSpace[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tGameBoard[i][j] = new Null();
			}
		}

		for (int i = 1; i < 9; i = i + 3) {
			for (int j = 1; j < 9; j = j + 3) {
				tGameBoard[i][j] = new Room();
			}
		}

		int tX = mRandomNum(3);
		int tY = mRandomNum(3);
		boolean tVC;

		if (tX == 0)
			tX = 1;
		else if (tX == 1)
			tX = 4;
		else if (tX == 2)
			tX = 7;

		if (tY == 0)
			tY = 1;
		else if (tY == 1)
			tY = 4;
		else if (tY == 2)
			tY = 7;

		tGameBoard[tX][tY] = new BriefCase();

		do {
			tX = mRandomNum(9);
			tY = mRandomNum(9);

			System.out.println(tX);
			System.out.println(tY);

			if (tGameBoard[tX][tY].getClass().equals(Null.class)) {
				tGameBoard[tX][tY] = new Bullet();
				tVC = true;
			} else {
				System.out.println(tGameBoard[tX][tY].getClass());
				tVC = false;

			}

			System.out.println(tVC);

		} while (tVC == false);

		do {
			tX = mRandomNum(9);
			tY = mRandomNum(9);

			System.out.println(tX + " " + tY);

			if (tGameBoard[tX][tY].getClass().equals(Null.class)) {
				tGameBoard[tX][tY] = new Radar();
				tVC = true;
			} else
				tVC = false;

			System.out.println(tVC);

		} while (tVC == false);

		do {
			tX = mRandomNum(9);
			tY = mRandomNum(9);

			System.out.println(tX + tY);

			if (tGameBoard[tX][tY].getClass().equals(Null.class)) {
				tGameBoard[tX][tY] = new Invicibility();
				tVC = true;
			} else
				tVC = false;

			System.out.println(tVC);

		} while (tVC == false);

		pGameBoard = tGameBoard;
		System.out.println("GenerateGameBoard End");
		return tGameBoard; // return type to expedite bug testing
	}

	public int mLoadSave() {

		/*
		 * UI.mLoadGame(DocCntrl.mGetFiles()); if (DocCntrl.mOpenFile() == -1) {
		 * UI.mLoadFailed(); return -1; } else { pGameBoard = DocCntrl.mGetGB();
		 * pc = DocCntrl.mGetPlayer(); npc = DocCntrl.mGetNinja();
		 * DocCntrl.mCloseDoc();
		 */
		return 0;

		// }

	}

	public void mCoreGameLoop() {
		boolean tEnd = false;

		do {
			tEnd = mStartPhase();

			if (tEnd == false) {
				System.out.println("Ninja's moved");
				mNMove();
				tEnd = mCheckGameState();
			}

		} while (tEnd == false);

	}

	/**
	 * @return
	 */

	private boolean mStartPhase() {
		boolean tEnd = false;
		int tMove = 1;
		do {
			mPrintBoard();
			tMove = 1;
			int tSelection = UI.mTurnSelect();
			if (tSelection == 0) {
				// mLook();
				System.out.println("Look");
			} else if (tSelection == 1) {
				mShoot();
				System.out.println("Shoot");
			} else if (tSelection == 2) {
				mPMove();
				System.out.println("Move");
				tMove--;
			} else if (tSelection == 3) {
				System.out.println("Quit");
				tEnd = true;
			} else if (tSelection == 4) {
				System.out.println("Saved");
				// mSave();
			} else if (tSelection == 5)
				{
				pDebug = true;
				mPrintBoard();
				}

		} while (tMove == 1 && tEnd == false);

		return tEnd;
	}

	public void mSave() {
		// String FileName = UI.mSave();
		// DocCntrl.mSave(pGameBoard, pc, npc, FileName);
	}

	public void mLook() {

	}

	public void mShoot() {
		if (pc.mGetBullets() > 0) {
			pc.mShoot();
			int tDirection = UI.mShoot();
			int tBPosition = pc.mGetPosition();
			boolean tBTraveling = true;
			while (tBTraveling == true) {
				if (tDirection == 0) // up
				{
					tBPosition = tBPosition - 9;
					if (tBPosition < 0)
						tBTraveling = false;
					else {
						for (int i = 0; i < 6; i++) {
							if (npc[i].mGetPosition() == tBPosition) {
								npc[i].mDeath();
								tBTraveling = false;
							}
						}
					}
				}

				else if (tDirection == 1) // right
				{
					tBPosition = tBPosition + 1;
					if (tBPosition % 9 == 0)
						tBTraveling = false;
					else {
						for (int i = 0; i < 6; i++) {
							if (npc[i].mGetPosition() == tBPosition) {
								npc[i].mDeath();
								tBTraveling = false;
							}
						}
					}
				}

				else if (tDirection == 2) // down
				{
					tBPosition = tBPosition + 9;
					if (tBPosition > 80)
						tBTraveling = false;
					else {
						for (int i = 0; i < 6; i++) {
							if (npc[i].mGetPosition() == tBPosition) {
								npc[i].mDeath();
								tBTraveling = false;
							}
						}
					}
				}

				else if (tDirection == 0) // left
				{
					tBPosition = tBPosition - 1;
					if (tBPosition % 9 == 8)
						tBTraveling = false;
					else {
						for (int i = 0; i < 6; i++) {
							if (npc[i].mGetPosition() == tBPosition) {
								npc[i].mDeath();
								tBTraveling = false;
							}
						}
					}
				}

			}
		} else
			UI.mOutofAmmo();

	}

	public void mPMove() {
		boolean tVM = false;

		do {

			int tDirection = UI.mPMove();
			if (pc.mMove(tDirection) != -1)
				tVM = true;
			else
				UI.InvalidMove();

		} while (tVM == false);
	}

	public void mNMove() {

		for (int i = 0; i < 6; i++) {
			if (npc[i].mComputeKill(pc.mGetPosition()) == 1)
				pc.mDeath();
			else
				npc[i].mMoveNinja();
		}
	}

	public boolean mCheckGameState() {

		if (pc.mGetLives() <= 0) {
			UI.mGameLoss();
			return true;
		} else if (pGameBoard[(pc.mGetPosition() / 9)][(pc.mGetPosition() % 9)].getClass().equals(BriefCase.class)) {
			UI.mGameWin();
			return true;
		} else
			return false;
	}

	public int mRandomNum(int tUpperLimit) {
		return (new Random().nextInt(tUpperLimit));
	}
	
	public void mPrintBoard()
	{
		int tNP[] = new int[6];
		for (int i = 0; i < 6; i++)
		{
			tNP[i] = npc[i].mGetPosition();
		}
		
		if (pDebug == true)
		{
			UI.mPrintDebugBoard(pGameBoard, pc.mGetPosition(), tNP);
		}
		else
		{
			UI.mPrintBoard(pGameBoard, pc.mGetPosition(), pc.mIsRadar());
		}
	}
}
