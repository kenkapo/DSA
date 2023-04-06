//only works for directed graphs
//can work on negative edge weights 
//can detect negative cycle
//why N-1 iterations->because in the worst case, all the nodes will take N-1 iterations to update distance array
//negative cycle detection->try Nth iteration and if distance array gets upadtes means it has a negative cycle.
//negative cycle-> if a graph has path weight < 0.
//TC->O(V*E)
class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int s=0;
        int []dist=new int [n];
        Arrays.fill(dist,(int)1e9);
        dist[s]=0;
        for(int i=0;i<n-1;i++)
        {
            func(edges,dist);
        }
        if(func(edges,dist)){return 1;}
        return 0;
    }
    public boolean func(int[][]edges,int []dist)
    {
        boolean flag=false;
        for(int[]e:edges)
        {
            if(dist[e[1]]>dist[e[0]]+e[2])
            {
                dist[e[1]]=dist[e[0]]+e[2];
                flag=true;
            }
        }
        return flag;
    }
}
