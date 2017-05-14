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
		mCoreGameLoop();
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
			
			if (tGameBoard[tX][tY].getClass().equals(Null.class) )
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
			
			if (tGameBoard[tX][tY].getClass().equals(Null.class))
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
			
			if (tGameBoard[tX][tY].getClass().equals(Null.class))
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
		boolean tEnd = false;
		
		do{
			tEnd = mStartPhase();
			
			if (tEnd == false)
			{
				System.out.println("Ninja's moved");
				mNMove();
				tEnd = mCheckGameState();
			}
			
		} while(tEnd == false);
		
	}
	
	/**
	 * @return
	 */
	private int mSelect() {
		
		return UI.mTurnSelect();
	}

	private boolean mStartPhase() {
		boolean tEnd =  false;
		int tMove = 1;
		do{
			tMove = 1;
			int tSelection = mSelect();
				if (tSelection == 0)
				{
					mLook();
					System.out.println("Look");
				}
				else if (tSelection == 1)
					{
					mShoot();
					System.out.println("Shoot");
					}
				else if (tSelection == 2)
					{
					mPMove();
					System.out.println("Move");
					tMove--;
					}
				else if (tSelection == 3)
					{
					System.out.println("Quit");
					tEnd = true;
					}
				else if (tSelection == 4)
					{
					System.out.println("Saved");
					mSave();
					}
					
		} while (tMove == 1 && tEnd == false);
		
		
		return tEnd;
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
	
	public boolean mCheckGameState()
	{
		return false;
		
	}
	
	public int mRandomNum(int tUpperLimit)
	{
		return (new Random().nextInt(tUpperLimit));
	}
}
