// program to write topo sort in java
// 1.bfs 
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []colors=new int [n];
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(colors[i]==0){
                q.add(i);
                colors[i]=1;
                while(q.size()>0)
                {
                    int top=q.poll();
                    for(int nbr:graph[top])
                    {
                        if(colors[nbr]==0)
                        {
                            if(colors[top]==1)
                            {
                                colors[nbr]=2;
                            }
                            else{colors[nbr]=1;}
                            q.add(nbr);
                        }
                        else if (colors[nbr]==colors[top]){return false;}
                    }
                }
            }
        }
        return true;
    }
}

// 2.dfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []color=new int [n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                color[i]=1;
                if(dfs(graph,i,color)){return false;}
            }
        }
        return true;
    }
    public boolean dfs(int [][]graph,int node,int []color)
    {
        for(int nbr:graph[node])
        {
            if(color[nbr]==-1)
            {
                color[nbr]=color[node] ^ 1;
                if(dfs(graph,nbr,color)){return true;}
            }
            else if (color[nbr]==color[node]){return true;}
        }
        return false;
    }
}
