class Solution {
    /* 
    Problem: Find out no of 1's that are not connected to 1 on boundary
    Solution: Find all the 1's on the edges and the 1's connected to them. Make all   those cells 0 using dfs
    Then after the loop count the number of cells with value 1. Return this value*/
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i*j==0||i==grid.length-1||j==grid[0].length-1)//edge cell
                    if(grid[i][j]==1)
                    {
                        dfs(grid,i,j);
                    }
            }
        }
        int res=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int[][] A,int i,int j)
    {
        if(i<0||i==A.length||j<0||j==A[0].length)
        {
            return ;
        }
        if(A[i][j]==0)
            return;
        A[i][j]=0;
        dfs(A,i+1,j);
        dfs(A,i-1,j);
        dfs(A,i,j+1);
        dfs(A,i,j-1);
    }
}
