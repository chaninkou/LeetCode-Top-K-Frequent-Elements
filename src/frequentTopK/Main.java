package frequentTopK;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		// Rare case if the element are all the same
		// int[] nums = {1,1,1,1,1,1};
		int k = 2;
		
		System.out.println("nums: " + Arrays.toString(nums) + " k: " + k);
		
		FindTopFrequentElementsFunction solution = new FindTopFrequentElementsFunction();
		
		System.out.println("Solution: " + Arrays.toString(solution.topKFrequent(nums, k)));
	}
}
