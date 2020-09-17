import java.util.*;

/*
Q) Given an array arr[] of positive integers, the task is to count the maximum possible number of pairs (arr[i], arr[j]) such that arr[i] + arr[j] is a power of 2.
Note: One element can be used at most once to form a pair.

Approach:
An Efficient Approach: is to find the largest element from the array say X then find the largest element from the rest of the array elements Y such that Y ≤ X and X + Y is a power of 2.
 This is an optimal selection of pair because even if Y makes a valid pair with some other element say Z then Z will be left to pair with an element other than Y (if possible) to maximize the 
 number of valid pairs.

 */

 class Solution
 {
    public int countPairs(int[] arr)
    {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr)
            map.put(i, 1);
        
        for(int i : map.keySet())
            System.out.println("Key: " + i + "Value: " + map.get(i) + " ");

        for(int i = 0; i < arr.length; i++)
        {
            //System.out.print(arr[i] + " ");
            if(map.get(arr[i]) < 1)
                continue;
            int curr = 1;
            while(curr <= arr[i])
                curr *= 2;
            
            if(map.containsKey(curr - arr[i]))
            {
                if(curr - arr[i] == arr[i] && map.get(arr[i]) == 1)
                    continue;
                count++;
                System.out.println("For element: " + arr[i]);

                map.put(curr - arr[i], map.get(curr - arr[i]) - 1);
                map.put(arr[i], map.get(arr[i]) - 1);
            }
            System.out.println("Inside for" + i);
            for(int k : map.keySet())
            {
                
                System.out.println("Key: " + k + "Value: " + map.get(k) + " ");
            }
        
        }
        return count;
        
    }
    public static void main(String[] args) {
            
        Solution obj = new Solution();

        int[] arr = {3, 2, 1, 0, 1};

        int count = obj.countPairs(arr);
        System.out.println(count);
    }
 }


