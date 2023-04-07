class Solution {
    public int closedIsland(int[][] grid) {
        int count=0;
        if(grid.length<3||grid[0].length<3)
        return 0;

        for(int i=1;i<grid.length-1;i++)
        {
            for(int j=1;j<grid[i].length-1;j++)
            {
                if(grid[i][j]==0)
                {
                    if(dfs(grid,i,j))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid,int i,int j)
    {
        //when should we stop
        if(grid[i][j]==1||grid[i][j]==-1)
        {
            return true;
        }
        if(i==0||j==0||i==grid.length-1||j==grid[0].length-1)
        //if we have reached to the edge of the matrix
        {
            return false;
        }
        grid[i][j]=-1;
        boolean left=dfs(grid,i-1,j);
        boolean right=dfs(grid,i+1,j);
        boolean top=dfs(grid,i,j-1);
        boolean bottom=dfs(grid,i,j+1);
        return left&&right&&top&&bottom;
    }
    
}
