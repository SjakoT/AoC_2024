package libs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads from text file.
 */
public class InputReader {
	/**
	 * Reads a text file and returns an array of the lines in the file.
	 * @param filePath Path of the file to be read.
	 * @return Array of the lines of the file.
	 */
	public static String[] readFile(String filePath) {
		ArrayList<String> lines = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(new File(filePath));

			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return Helpers.stringArrayListToArray(lines);
	}
}