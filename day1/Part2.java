package day1;

import libs.Helpers;
import libs.InputReader;

public class Part2 {
	private static final String FILEPATH = "input\\day1";
	
	private static int[] left;
	private static int[] right;
	
	// Loads the input data into memory in a usable form.
	private static void readFile() {
		String[] lines = InputReader.readFile(FILEPATH);
		
		left = new int[lines.length];
		right = new int[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			
			left[i] = Integer.parseInt(line.substring(0, 5));
			right[i] = Integer.parseInt(line.substring(8));
		}
	}
	
	public static void main(String[] args) {
		readFile();
		
		int totalSimilarityScore = 0;
		for (int i = 0; i < left.length; i++) {
			int value = left[i];
			int valueCountRight = Helpers.countIntOccurrences(value, right);
			int similarityScore = value * valueCountRight;
			totalSimilarityScore += similarityScore;
		}
		
		System.out.println(totalSimilarityScore);
	}
}