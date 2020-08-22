/*
 * 378. Kth Smallest Element in a Sorted Matrix
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13
*/

class Solution
{
	public int kthSmallest(int[][] matrix, int k)
	{
		int left = matrix[0][0];
		int right = matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] + 1;

		while(left < right)
		{
			int count = 0;
			int col = matrix[0].length - 1;
			int mid = left + (right - left) / 2;
			for(int row = 0; row < matrix.length; row++)
			{
				while(col >= 0 && matrix[row][col] > mid )
					col--;

				count += col + 1;
			}

			if(count >= k)
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}
}
