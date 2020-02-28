import java.util.Scanner;


class Solution
{
    public static void main (String[] args)
    {
        Scanner in1 = new Scanner(System.in);
        System.out.println("Please enter total number of houses: ");
        int n = in1.nextInt();

        int[] arr = new int[n];

        for(int i =0; i < n; i++)
        {
            System.out.println("Enter value for " + i + "th element: ");
            Scanner in2 = new Scanner(System.in);
            arr[i] = in2.nextInt();
        }
        System.out.println("The maximum amount of money to be robbed:" + " " + house_robber(arr));
    }

    public static int house_robber( int[] nums)
    {
        if (nums.length == 0 || nums == null)
        {
            return 0;
        }
        if (nums.length == 1) return nums[0];

        if (nums.length == 2) return Math.max(nums[0],nums[1]);

        int[] house = new int[nums.length];

        house[0] = nums[0];
        house[1] = Math.max(nums[0],nums[1]);
        
        for(int i =2; i < nums.length; i++)
        {
                house[i] = Math.max((nums[i] + house [i -2]),house[i -1]);
        }
        return house[nums.length -1];
    }
}