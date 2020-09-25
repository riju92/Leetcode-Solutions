import java.util.*;
/*
Given an array of unique integers, determine the minimum absolute difference between any two elements. print all the element pairs with that minimal absolute difference in ascending order

For example, numbers = [6,2,4,10]. The minimal absolute difference is 2. Pairs with that difference are (2,4) and (4,6). If a pairs elements are (i,j), they are listed in ascending order
*/

class Solution
{
    public List<List<Integer>> function(int[] arr)
    {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        int delta = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++)
        {
            List<Integer> temp = new ArrayList<>();
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if(diff <= delta)
            {
                delta = diff;
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        
        Solution obj = new Solution();
        int[] arr = {6,2,4,10};
        //List<int[]> result = obj.function(arr);
        //for(int[] i : result)
        System.out.println(obj.function(arr));
    }
}