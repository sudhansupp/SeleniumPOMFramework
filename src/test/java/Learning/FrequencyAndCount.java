package Learning;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyAndCount {
	static void arrayElementCount(int inputArray[]) {

		HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

		for (int i : inputArray) {
			if (elementCountMap.containsKey(i)) {

				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {

				elementCountMap.put(i, 1);
			}
		}

		System.out.println("Element Count : " + elementCountMap.toString());
	}

	public static void main(String[] args) {
		arrayElementCount(new int[] { 0, 0, 0, 1, 1, 1, 5, 5, 5, 4, 0, 0, 04, 5, 6, 6, 7, 7, 8, 3, 9, 9, 9, 9, 5, 6, 7,
				7, 0, 0, 0 });

	}
}
