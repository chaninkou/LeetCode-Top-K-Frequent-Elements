package leetcode347;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTopFrequentElementsFunction {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);            
        }
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        
        // Add whichever key to the appears bucket
        for(int key : map.keySet()){
            int numOfAppear = map.get(key);
            
            if(buckets[numOfAppear] == null){
                buckets[numOfAppear] = new ArrayList<>();
            }
            
            buckets[numOfAppear].add(key);
        }
        
        List<Integer> solution = new ArrayList<>();
        
        // The last element of the bucket is the most appear
        for(int end = buckets.length - 1; end > 0 && k > 0; end--){
            if(buckets[end] != null){
                solution.addAll(buckets[end]);
                
                k -= buckets[end].size();
            }
        }
        
        // Convert list to array
        int[] result = new int[solution.size()];
        
        for(int i = 0; i < solution.size(); i++){
            result[i] = solution.get(i);
        }
        
        return result;
    }
    
    public List<Integer> topKFrequent2(int[] nums, int k) {
    	// Key as the element and value as the most repeated element
        Map<Integer, Integer> map = new HashMap<>();
        
        // In case there is only one element in the list, just return it right away
        if(nums.length == 1 && k == 1){
        	return Arrays.asList(nums[0]);
        }

        // Storing the element and repeated element number in the map
        for(int i = 0; i < nums.length; i++){
//            if(!map.containsKey(nums[i])){
//                map.put(nums[i], 1);
//            } else {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }
        	// getOrDefault is for when the value is null, it will store as 0 as default
        	map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        System.out.println("Key:values = " + map);
    
        // nums.length + 1 in case there is only one number in nums ex: [1,1,1,1,1]
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        
        for(int key : map.keySet()){
            int mostRepeated = map.get(key);
            
            // If the current index of array is empty, then make a new list inside
            if(bucket[mostRepeated] == null){
                bucket[mostRepeated] = new ArrayList<>();
            }
            
            // Adding the key with the same repeated number of times in the list
            bucket[mostRepeated].add(key);
            System.out.println("" + Arrays.toString(bucket));
        }
        
        List<Integer> solution = new ArrayList<>();
        
        for(int end = bucket.length - 1; end > 0 && k > 0; --end){
        	// Keep looping from the end of the element to not null
        	// Which we know that the most repeated key is in that list
            if(bucket[end] != null){
            	// Add all the elements in the list into the list
                solution.addAll(bucket[end]);
                
                // k will then get subtract by the size of the list that
                // just got added to the solution list
                k = k - bucket[end].size();
            }
            
        }
        
        // This is for unique case where 		
        // int[] nums = {1,1,1,2,2,2};
		// int k = 1;
        // [null, null, null, [1, 2], null, null, null]
        // But we only want one element in the solution, keep removing
        while(k < 0){
        	solution.remove(solution.size() - 1);
        	k++;
        }
        
        return solution;
    }
}
