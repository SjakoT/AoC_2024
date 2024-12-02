package day2;

import java.util.ArrayList;

import libs.InputReader;

public class Part1 {
	private static final String FILEPATH = "input\\day2";
	
	private static ArrayList<ArrayList<Integer>> levels;
	
	// Loads the input data into memory in a usable form.
	private static void readFile() {
		String[] lines = InputReader.readFile(FILEPATH);
		
		levels = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] reports = line.split(" ");
			
			ArrayList<Integer> al = new ArrayList<>();
			for (String report : reports) {
				al.add(Integer.parseInt(report));
			}
			levels.add(al);
		}
	}
		
	private static boolean isSafe(ArrayList<Integer> reports) {
		int order = 0;
		
		for (int i = 0; i < reports.size() - 1; i++) {
			int current = reports.get(i);
			int next = reports.get(i + 1);
			
			int diff = current - next;
			if (!(Math.abs(diff) >= 1 && Math.abs(diff) <= 3)) { // checks rule 2
				return false;
			}
			
			// checks rule 1
			if (diff > 0) {
				if (order < 0) {
					return false;
				}
				
				order = 1;
			} else if (diff < 0) {
				if (order > 0) {
					return false;
				}
				
				order = -1;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		readFile();
		
		int count = 0;
		for (ArrayList<Integer> report : levels) {
			if (isSafe(report)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}