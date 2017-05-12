package edu.cpp.cs.cs141.WarlocksOfTheBeach;


public class GameEngine {
	UserInterface UI = new UserInterface();
	GameSpace pGameBoard[][] = new GameSpace[9][9];
	
	public void mStartGame()
	{
		UI = UserInterface.mCreateInterface(1);
		mGenerateGameBoard();
		mCoreGameLoop();
	}
	
	public void mGenerateGameBoard()
	{
		
	}
	
	public void mLoadSave()
	{
		
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
	
	
}
