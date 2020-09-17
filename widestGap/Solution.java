import java.util.*;

class Solution
{
    public int widestGap(int length, int[] start, int[] end)
    {
        int[][] cars = new int[start.length][2];
        int result = 0;
        for(int i = 0; i < start.length; i++)
        {
            cars[i][0] = start[i];
            cars[i][1] = end[i]; 
        }
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        int[] prev = cars[0];
        result = cars[0][0] - 1;
        for(int[] car: cars)
        {
            if(Math.max(prev[0], car[0]) < Math.min(prev[1], car[1]))
                prev[1] = Math.max(car[1], prev[1]);
            
            else
            {
                result = Math.max(result, Math.abs(prev[1] - car[0]) - 1);
                prev = car;
            }
        }

        if(prev[1] < length)
            result = Math.max(result, Math.abs(length - prev[1]));

        return result;
    }

    public static void main(String[] args) {
        int l1 = 10;
        int[] start1 = {3, 8}, end1 = {4, 9};

        int l2 = 10;

        int[] start2 = {1, 2, 6, 6}, end2 = {4, 4, 10, 8};

        Solution obj = new Solution();

        System.out.println(obj.widestGap(l2, start2, end2));
    }
}