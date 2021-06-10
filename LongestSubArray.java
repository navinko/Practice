package Countsubarraywithequalzeroandone;

import java.util.HashMap;

//The idea is assume 0s as -1 and 1 as 1 itself and calculate the sum . For equal no of 0s and 1s always this way sum wud be zero .so we need to check the element if is 0 add -1 if its is 1 add +1.
//Initially take sum as 0 and put in map with key equal to sum 0 and value as index -1.
//Idea is to store sum vs index in map
//Initially consider sum is 0 and at an index of -1 and put key=sum and value=index=-1 in map
//Take a variable to hold cumulative sum of no of sub array.
public class LongestSubArray {
    public static void main(String as[]) {
        //int arr[] = {1,0,0,1,0,1,1};// ans will be 6
        int arr[] = {1,0,0,1};//ans will be 4 // initially in map{0:-1}, sum 0 at index -1 , on processing ,sum will be 1,0,-1,0 and ans will be 4

        int longestSubArray = longestSubArray(arr);
       System.out.println("Longest sub array :"+longestSubArray);
    }

    private static int longestSubArray(int[] arr) {
        int sum = 0;//initially , before processing any element of the array lets take sum as 0 at index = -1 , put in hashmap of sum vs index as map.put(0,-1)
        int ans = 0; //will set it to 0 initially and every time while processing array element if found in map we check the previous ans > i-index of sum already in map, this way will get longest subarray.
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);//put sum 0 first time in map with index -1.
        for (int i = 0; i < arr.length; i++) {
            //consider 0 as -1 and 1 as 1
            if (arr[i] == 0) {
                sum += -1;
            } else if (arr[i] == 1) {
                sum = sum + 1;
            }
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum); // get previous index
                int length = i-prevIndex;     // this diff will decide longest array
                if(length > ans){
                 ans = length;//update ans
                }
            } else {
                map.put(sum, i);
            }

        }
        return ans;
    }

}

