package com.hackerank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i])+1);
            }else{
                hm.put(nums[i], 1);
            }
        }

        Integer result1[] = new Integer[hm.keySet().size()];

        int count = 0;
        for(Integer i : hm.keySet()){
            result1[count++] = hm.get(i);
        }
        Arrays.sort(result1, Collections.reverseOrder());

        int finalResult[] = new int[k];
        for(int i=0; i<k; i++){
            finalResult[i] = result1[i];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,2,2,3,7,8,8};
        int k = 2;
        System.out.println(solution.topKFrequent(nums, k));

        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(solution.topKFrequent(nums1, k1));
    }
}
