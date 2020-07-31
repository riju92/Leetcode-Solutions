    /*
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
*/

// This solution involves quick sorting the input points array until the pivot matches K in O(n) time
class Solution
{
    public int[][] kClosest(int[][] points, int k)
    {
        int left = 0, right = points.length - 1;
        while(left <= right)
        {
            int mid = helper(points, left, right);
            if(mid == k)
                break;
            else if(mid < k)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    public int helper(int[][] arr, int left, int right)
    {
        int[] pivot = arr[left];
        while(left < right)
        {
            while(left < right && compare(arr[right], pivot) >= 0)
                right--;
            arr[left] = arr[right];
            
            while(left < right && compare(arr[left], pivot) <= 0) 
                left++;
            arr[right] = arr[left];
            
            arr[left] = pivot;
        }
        return left;
    }

    public int compare(int[] p1, int[] p2)
    {
        return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
    }
}