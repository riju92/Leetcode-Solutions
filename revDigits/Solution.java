import java.util.*;

class Solution
{
    private static int rev(int n)
    {
        //System.out.println("Number: " + n);
        int result = 0;
        while(n != 0)
        {

            int rem = n % 10;
            int temp = result * 10 + rem;
            if((temp - rem) / 10 != result)
                return 0;
            result = temp;
            n = n / 10;
        }
        //System.out.println("Reverse: " + result);
        return result;
    }

    public int countPairs(int[] arr)
    {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
        {
            int temp = i - rev(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        // System.out.println("Displaying map");
        // for(int i : map.keySet())
        //     System.out.println("Key: " + i + "Value: " + map.get(i));

        for(int k : map.keySet())
            count += map.get(k) * (map.get(k) + 1) / 2;

        return count;
    }

    public static void main(String[] args) {
        
        Solution obj = new Solution();
        int[] arr = {1, 20, 2, 11};

        int count = obj.countPairs(arr);
        System.out.println(count);
    }

}