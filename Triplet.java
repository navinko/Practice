package tripletSum;
// Java program to find triplets in a given
// array whose sum is equal to given sum.
//Complexity Analysis:
//Time Complexity: O(n2).
//Use of a nested for loop brings the time complexity to n^2
//Auxiliary Space: O(n).
//As an unordered_set data structure has been used for storing values.
//Time complexity-O(n^2)
//Space complexity-O(n)
import java.util.*;
 
class Triplet {
    //Dry run 1- { 0, -1,1}, 3, 0
    //Dry run 2- { 0, 2,4,-3,5 ,1} , 6, 3
    // function to print triplets with given sum
    static void findTriplets(int arr[], int n, int sum)
    {      // from i=0 to i=1
        for (int i = 0; i < n - 1; i++) {
            //Here idea is will subtract arr[i] from sum (which starts from i+1) -> subtract arr[j] from curr_sum , the residual if available in set we can say triplet exists and will add arr[j] in set.
            int curr_sum = sum - arr[i]; // curr_sum = 0-0=0 ,
            HashSet<Integer> s = new HashSet<>();
            //from j=1 to j=5 the last element of array
            for (int j = i + 1; j < n; j++) {
                int x = curr_sum - arr[j]; //x=0--1=1 , x=0-1=-1
                if (s.contains(x)) //true for j=2
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                else
                    s.add(arr[j]);//[-1]
            }
        }
    }
 

    public static void main(String[] args)
    {
        int arr[] = { 0, -1,1};
        //int arr[] = { 0, 2,4,-3,5 ,1};
        //int sum = 3;
        int sum = 0;
        int n = arr.length;
        findTriplets(arr, n, sum);
    }
}
 /*
 Output
-----
case1:

2 0 1
4 2 -3
5 -3 1

case2:

-1 0 1

 */
