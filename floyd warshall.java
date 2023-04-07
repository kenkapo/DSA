//can be used to detect negative cycle as well
//if matrix[i][i]<0,it contains a negative cycle
//it is a multisource shortest path algorithm
//used for directed graph and undirected graphs.
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            func(matrix,i,n);
        }
    }
    public void func(int[][]matrix,int via,int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int sum;
                if(matrix[i][via]==-1||matrix[via][j]==-1){sum=Integer.MAX_VALUE;}
                else{sum=matrix[i][via]+matrix[via][j];}
                matrix[i][j]=Math.min(matrix[i][j]==-1?Integer.MAX_VALUE:matrix[i][j],sum);
                if(matrix[i][j]==Integer.MAX_VALUE){matrix[i][j]=-1;}
            }
        }
    }
}
