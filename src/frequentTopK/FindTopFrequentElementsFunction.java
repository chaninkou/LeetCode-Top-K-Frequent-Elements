package frequentTopK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindTopFrequentElementsFunction {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	// Key as the element and value as the most repeated element
        Map<Integer, Integer> map = new HashMap<>();
        

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
    
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for(int key : map.keySet()){
            int mostRepeated = map.get(key);
            
            if(bucket[mostRepeated] == null){
                bucket[mostRepeated] = new LinkedList<>();
            }
            bucket[mostRepeated].add(key);
        }
        
        List<Integer> solution = new ArrayList<>();
        
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i] != null){
                solution.addAll(bucket[i]);
                 k -= bucket[i].size();
            }
            
        }
        
        return solution;
    }
}
