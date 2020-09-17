/* 
Minimum No.of swaps required to sort array(Even elements first,Odd elements after even elements)order doesn't matter
*/

class Solution
{
    public int countSwaps(int[] arr)
    {
        int count = 0;
        int left = 0;
        int right = arr.length - 1;
        while(left < right)
        {
            if(arr[left] % 2 == 0 && arr[right] % 2 == 1)
            {
                left++;
                right--;
            }

            if(arr[left] % 2 == 1 && arr[right] % 2 == 0)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                count++;
            } 
        }
        return count;
    }

    public static void main(String[] args) {
        
        Solution obj = new Solution();

        int[] arr = {5,2,5,2,6,83,6};
        System.out.println("Count: " + obj.countSwaps(arr));
        System.out.println("Printing the array");
        for(int i : arr)
            System.out.print(i);
    }
}