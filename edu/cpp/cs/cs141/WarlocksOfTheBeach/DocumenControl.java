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

	private static GameEngine cGameBoard;
	
	/**
	 * @param mSave
	 *            This will store the current objects into memory so the game
	 *            could be saved.It will all be stored in a file. Has to follow
	 *            specific order: mGetGameBoard, mGetPlayer, mGetNinja,
	 *            mCloseDoc
	 */

	public static File mCreateFile() {
        String fName = null;
        File file = null;
        System.out.println("Please choose file name:");
        while (true) {
            try (Scanner in = new Scanner(System.in)) {
                fName = in.nextLine();
                file = new File(fName);
                if (!file.createNewFile()) {
                    throw new RuntimeException("File already exist");
                }
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + ", please try again:");
            }
        }

        return file;
    }
	
	
	private static File mFilePath(){
		File sourceFile =  new File("mCreateFile()");
		File destinationFile = new File("");
		try{
			Files.copy(sourceFile.toPath(),destinationFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void mSave() {
		try {
			FileOutputStream fileOut = new FileOutputStream("FileName.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(cGameBoard);
			out.close();
			fileOut.close();
			System.out.println("Game Saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @param Deserialize
	 *            This will be used to call a file that'll pull out the
	 *            different objects from the last occurrence that a player saved
	 *            the game. return -1 if there an error
	 */

	@SuppressWarnings("unchecked")

	public static void mOpenDoc() throws FileNotFoundException {
	
		try {
			FileInputStream fileIn = new FileInputStream("ObjectStorage.dat");
			ObjectInputStream ois = new ObjectInputStream(fileIn);
			(ObjectStorage)ois.read();
			ois.close();
			fileIn.close();
		} catch (IOException e) {
			System.out.printf("-1", e);
			e.printStackTrace();
		}
	
		  
	}

	public static void mSearchFile() {

		File file = new File(
				"/Users/edgarchilin/git/Warlocks_of_the_Beach/edu/cpp/cs/cs141/WarlocksOfTheBeach");
		String[] str = file.list();
		for (String string : str) {
			if (string.endsWith(".ser")) {
				System.out.println(string);
			}

		}

	}

}
