package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.util.Random;

public class GameEngine {
	UserInterface UI = new UserInterface();
	GameSpace pGameBoard[][] = new GameSpace[9][9];
	
	public GameEngine()
	{
		
	}
	
	public void mStartDebug()
	{
		System.out.println("Debug Start");
		UI = UserInterface.mCreateInterface(1);
		//mSetGameBoard();
		UI.mPrintBoard(mGenerateGameBoard());
		UI.mPauseScript();
		System.out.println("Debug end");
	}
	
	public void mStartGame()
	{
		UI = UserInterface.mCreateInterface(1);
		mSetGameBoard();
		mCoreGameLoop();
	}
	
	public void mSetGameBoard()
	{
		if (UI.mNew() == true)
			pGameBoard = mGenerateGameBoard();
		else
			pGameBoard = mLoadSave();
	}
	
	public GameSpace[][] mGenerateGameBoard()
	{
		System.out.println("mGenerateGameBoard start");
		GameSpace tGameBoard[][] = new GameSpace[9][9];
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j<9; j++)
			{
				tGameBoard[i][j] = new Null();
			}
		}
		
		for (int i = 1; i < 9; i = i+3)
		{
			for (int j = 1; j<9; j=j+3)
			{
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
	
		do{
			tX = mRandomNum(9);
			tY = mRandomNum(9);
			
			System.out.println(tX);
			System.out.println(tY);
			
			if (tGameBoard[tX][tY].equals(Null.class))
				{
				tGameBoard[tX][tY] = new Bullet();
				tVC = true;
				}
			else
			{
				System.out.println(tGameBoard[tX][tY].getClass());
				tVC = false;
				
			}
				
			System.out.println(tVC);
			
		}while (tVC == false);
		
		do{
			tX = mRandomNum(9);
			tY = mRandomNum(9);
			
			System.out.println(tX + " " + tY);
			
			if (tGameBoard[tX][tY].equals(Null.class))
				{
				tGameBoard[tX][tY] = new Radar();
				tVC = true;
				}
			else
				tVC = false;
			
			System.out.println(tVC);
				
		}while (tVC == false);
		
		do{
			tX = mRandomNum(9);
			tY = mRandomNum(9);
			
			System.out.println(tX + tY);
			
			if (tGameBoard[tX][tY].equals(Null.class))
				{
				tGameBoard[tX][tY] = new Invicibility();
				tVC = true;
				}
			else
				tVC = false;
			
			System.out.println(tVC);
				
		}while (tVC == false);
		
		System.out.println("GenerateGameBoard End");
		return tGameBoard;
	}
	
	public GameSpace[][] mLoadSave()
	{
		GameSpace tGameBoard[][] = new GameSpace[9][9]; 
		
		return tGameBoard;
	}
	
	public void mNewGameBoard()
	{
		
	}
	
	public void mCoreGameLoop()
	{
		mStartPhase();
	}
	
	private void mStartPhase() {
		
		
	}

	public void mQuit()
	{
		
	}
	
	public void mSave()
	{
		
	}
	
	public void mLook()
	{
		
	}
	
	public void mShoot()
	{
		
	}
	
	public void mPMove()
	{
		
	}
	
	public void mNMove()
	{
		
	}
	
	public void mCheckGameState()
	{
		
	}
	
	public int mRandomNum(int tUpperLimit)
	{
		return (new Random().nextInt(tUpperLimit));
	}
}
