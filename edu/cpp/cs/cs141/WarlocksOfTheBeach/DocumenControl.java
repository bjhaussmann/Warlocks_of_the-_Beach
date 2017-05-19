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
public class DocumenControl implements Serializable {
	
	

	
	private ClassLoader mGetGameBoard(){
		return ;
		}
	private void mGetPlayer(){
		return player.
	}
	private void mGetNinja(){
		
	}
	private void mGetFiles(){
		
	}
	
	/**
	 * 
	 * @param mSave
	 *            This will store the current objects into memory so the game
	 *            could be saved.It will all be stored in a file.
	 *            Has to follow specific order: mGetGameBoard, mGetPlayer, mGetNinja,
	 *            mCloseDoc
	 */
	public void mSave(File Name) {
//		ArrayList<ContainObjects> pieces = new ArrayList<ContainObjects>();
//		ContainObjects gBoard = new ContainObjects(mGetGameBoard());
//		ContatinObjects gPlayer =  new ConatinObject(mGetPlayer());
//		ContainObjects gNinja =  new ContainObject(mGetNinja());
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FileName));
			pieces.add(gBoard);
			pieces.add(gPlayer);
			pieces.add(gNinja);
			out.writeObject(pieces);
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param Deserialize
	 *            This will be used to call a file that'll pull out the
	 *            different objects from the last occurrence that a player saved
	 *            the game.
	 *            return -1 if there an error 
	 */
	public static void mOpenDoc(File Name) throws FileNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FileName));
			ois.readObject();
			ois.close();
		} catch (IOException e) {
			System.out.printf("-1", e);
			e.printStackTrace();
		}
		
	}

}
