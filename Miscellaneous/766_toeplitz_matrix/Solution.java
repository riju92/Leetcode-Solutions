/*
766. Toeplitz Matrix
Easy

828

74

Add to List

Share
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
*/






class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int r = 0; r < matrix.length; r++)
        {
            for(int c = 0; c < matrix[0].length; c++)
            {
                if(r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c]) return false;
            }
        }
        return true;
    }
}