/**
 * ask about serialize could be useful for saving and loading ???
 * would i reference the game board for the current items and positions
 * would the ui be called to read the information 
 * 
 */

package edu.cpp.cs.cs141.WarlocksOfTheBeach;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * 
 * @author bjhau
 *
 * 
 * 
 */
public class DocumenControl {

	
	/**
	 * 
	 */
	

	/**
	 * 
	 */
	

	/**
	 * @param mSave
	 *            This will store the current objects into memory so the game
	 *            could be saved.It will all be stored in a file. Has to follow
	 *            specific order: mGetGameBoard, mGetPlayer, mGetNinja,
	 *            mCloseDoc
	 */

	
	
	
	public void mSave(GameSpace tGS[][], Player tPC, Ninja tNJ[], String tFileOut) {
		try {
			FileOutputStream fileOut = new FileOutputStream(tFileOut + ".dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject((Object)tGS);
			out.writeObject(tPC);
			out.writeObject(tNJ);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println(e.toString());
		}
		System.out.println("Save Successful");
	}

	/**
	 * @param Deserialize
	 *            This will be used to call a file that'll pull out the
	 *            different objects from the last occurrence that a player saved
	 *            the game. return -1 if there an error
	 */

	@SuppressWarnings("unchecked")

	public GameEngine mOpenDoc(String tFileIn)  {
	 GameEngine GE;
	 GameSpace tGS[][];
	 Player tPC;
	 Ninja tNPC[];
		try {
			FileInputStream fileIn = new FileInputStream(tFileIn + ".dat");
			ObjectInputStream ois = new ObjectInputStream(fileIn);
			tGS = (GameSpace[][])ois.readObject();
			tPC = (Player)ois.readObject();
			tNPC = (Ninja[])ois.readObject();
			GE = new GameEngine(tGS, tPC, tNPC);
			ois.close();
			fileIn.close();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	return GE; 
		  
	}

	public void mSearchFile() {

		File file = new File(
				"/Users//git/Warlocks_of_the_Beach/edu/cpp/cs/cs141/WarlocksOfTheBeach");
		String[] str = file.list();
		for (String string : str) {
			if (string.endsWith(".dat")) {
				System.out.println(string);
			}

		}

	}

}

