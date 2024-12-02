package libs;

import java.util.ArrayList;

/**
 * Helper functions.
 */
public class Helpers {
	/**
	 * Takes an ArrayList of type String and turns it into a String[].
	 * @param list The ArrayList of type String to be turned into a String[].
	 * @return A String[] of the ArrayList that was provided.
	 */
	public static String[] stringArrayListToArray(ArrayList<String> list) {
		if (list != null) {
			String[] array = new String[list.size()];
			
			for (int i = 0; i < array.length; i++) {
				array[i] = list.get(i);
			}
			
			return array;
		}
		
		return null;
	}
	
	/**
	 * Takes an ArrayList of type Integer and turns it into a int[].
	 * @param list The ArrayList of type Integer to be turned into an int[].
	 * @return An int[] of the ArrayList that was provided.
	 */
	public static int[] intArrayListToArray(ArrayList<Integer> list) {
		if (list != null) {
			int[] array = new int[list.size()];
			
			for (int i = 0; i < array.length; i++) {
				array[i] = list.get(i);
			}
			
			return array;
		}
		
		return null;
	}
	
	/**
	 * Sorts an int[] in numerical order.
	 * @param array int[] to be sorted
	 * @return The numerically sorted int[]
	 */
	public static int[] sortIntArray(int[] array) {
		if (array != null) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(array[0]);
			
			for (int i = 1; i < array.length; i++) {
				int indexForInsert = 0;
				for (int j = 0; j < list.size(); j++) {
					if (array[i] > list.get(j)) {
						if (list.size() == j + 1) { // if array[i] should be inserted at the end
							indexForInsert = -1;
						} else {
							indexForInsert++;
						}
					} else { // further searching unnecessary, break for performance
						break;
					}
				}
				
				if (indexForInsert < 0) {
					list.add(array[i]);
				} else {
					list.add(indexForInsert, array[i]);
				}
			}
			
			return intArrayListToArray(list);
		}
		
		return null;
	}
}