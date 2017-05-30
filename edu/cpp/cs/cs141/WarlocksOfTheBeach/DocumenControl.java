/**
 * ask about serialize could be useful for saving and loading ???
 * would i reference the game board for the current items and positions
 * would the ui be called to read the information 
 * 
 */
package edu.cpp.cs.cs141.WarlocksOfTheBeach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author bjhau
 *
 */
public class DocumenControl {
	private Player cPlayer;
	private Ninja cNinja;
	private GameEngine cGameBoard;
	ArrayList<GameEngine> zGameboard = new ArrayList<GameEngine>();
	ArrayList<Player> zPlayer = new ArrayList<Player>();
	ArrayList<Ninja> zNinja = new ArrayList<Ninja>();

//	GameEngine[] gBoard = new GameEngine[10];
//	Player[] gPlayer = new Player[10];
//	Ninja[] gNinja = new Ninja[10];

	private void currentData() {
		inputGameBoard();
		inputPlayer();
		inputNinja();
//		Player[] gPlayer = new Player[10];
		
	}

	/**
	 * 
	 */
	private void inputGameBoard() {

	}
	//there error because the paramenter in player are just Player() 
	private void inputPlayer() {
		zPlayer.add(new Player(cPlayer.mGetBullets(), cPlayer.mGetInvincibility(), cPlayer.mGetLives(), cPlayer.mIsRadar()));
	}

	/**
	 * this will hold all the player current status
	 */
	private void inputNinja() {
		zNinja.add(new Ninja(cNinja.mGetXPosition(), cNinja.mGetYPosition()));

	}

	/**
	 * this will hold all of the ninjas current status
	 */

	/**
	 * 
	 * @param mSave
	 *            This will store the current objects into memory so the game
	 *            could be saved.It will all be stored in a file. Has to follow
	 *            specific order: mGetGameBoard, mGetPlayer, mGetNinja,
	 *            mCloseDoc
	 */
	public void mSave(File Name) {
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(zGameboard);
		data.add(zPlayer);
		data.add(zNinja);

		try {
			FileOutputStream fileOut = new FileOutputStream("data.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(data);
			out.close();
			fileOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param Deserialize
	 *            This will be used to call a file that'll pull out the
	 *            different objects from the last occurrence that a player saved
	 *            the game. return -1 if there an error
	 */
	public static void mOpenDoc(File Name) throws FileNotFoundException {

		ArrayList<Object> deserialize = new ArrayList<Object>();

		try {
			FileInputStream fileIn = new FileInputStream("data.ser");
			ObjectInputStream ois = new ObjectInputStream(fileIn);
			deserialize = (ArrayList<Object>) ois.readObject();
			ois.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.printf("-1", e);
			e.printStackTrace();
		}

	}

	public static void mSearchFile() {
		File file = new File(
				"/Users/edgarchilin/eclipse/java-neon/Eclipse.app/Contents/MacOS/https:/github.com/bjhaussmann/Warlocks_of_the_Beach.git");
		String[] str = file.list();
		for (String string : str) {
			if (string.endsWith(".ser")) {
				System.out.println(string);
			}

		}
	}

}
