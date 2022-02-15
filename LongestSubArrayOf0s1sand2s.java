package Countsubarraywithequalzeroandone;

import java.util.HashMap;
//The idea is assume 0s as -1 and 1 as 1 itself and calculate the count for 0s 1s and 2s .
//Initially take count0s,count1s and count2s  as 0 and calculate delta , delta10 and delta21 , from this generate key as delta21#delta10 and put in map with index =-1 and then process for each element..
//Idea is to store delta vs index in map - if at two different index delta remain unchanged between 10 and 21 it means equal no of 1 or 0 being added also equal no od 2 and 1 being added.
//Take a variable to hold cumulative sum of no of sub array as ans.
public class LongestSubArrayOf0s1sand2s {
    public static void main(String as[]) {
        int arr[] = {0,1,0,2,0,1,0};// ans will be 8
        int longestSubArraysOf0s1sAnd2s = longestSubArray(arr);
       System.out.println("Longest sub arrays of 0s 1s and 2s  :"+longestSubArraysOf0s1sAnd2s);
    }

    private static int longestSubArray(int[] arr) {
        int sum = 0;
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int count0s=0;
        int count1s=0;
        int count2s=0;
        int delta10=count1s-count0s;
        int delta21=count2s-count1s;
        String key = delta21+"#"+delta10;
        map.put(key,-1);//assume key at -1 initially.

        for (int i = 0; i < arr.length; i++) {
            //consider 0 as -1 and 1 as 1
            if (arr[i] == 0) {
                count0s=count0s+1;
            } else if (arr[i] == 1) {
               count1s=count1s+1;
            }else{
                count2s=count2s+1;
            }
            delta10 =count1s-count0s;
            delta21 = count2s-count1s;
            key =delta21+"#"+delta10;
            if (map.containsKey(key)) {
               int prevIndex = map.get(key);
               int length =i-prevIndex;
                if(length > ans){
                 ans = length;//update ans
                }
            } else {
                map.put(key, i);
            }

        }
        return ans;
    }

}


