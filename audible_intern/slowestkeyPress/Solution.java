/*
Alex wants to be a faster typist and is taking a typing test to find out which key takes the longest time to press. 
Input: [[0,2],[1,5],[0,9],[2,15]]

Complete the function slowestKey in the editor below. The function must return a character, the slowest key that Alex presses.
*/

class Solution
{
    public char slowestKey(int[][] keyTimes)
    {
        char result = (char) 0;
        int delta = Integer.MIN_VALUE;
        int[] temp = keyTimes[0];
        for(int[] key : keyTimes)
        {
            int diff = Math.abs(temp[1] - key[1]);
            if(diff > delta)
            {
                delta = diff;
                result = (char)(key[0] + 'a');

            }

            temp = key;
        }

        return result;
    }

    public static void main(String[] args) {
        
        Solution obj = new Solution();

        int[][] arr = {{0,2},{1,5},{0,9},{2,15}};

        System.out.println(obj.slowestKey(arr));
    }
}
