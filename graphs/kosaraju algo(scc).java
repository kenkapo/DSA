//this algo is used to find SCC in a graph.
//SCC stands for strongly connected components.
//AN SCC is that component in a graph in which each node can visit every other node.
class Solution
{
    //Function to find number of strongly connected components in the graph.
    Stack<Integer>st=new Stack<>();//contains the node soted in order of there finishing times.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[]vis=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(adj,i,vis,0);
            }
        }
        ArrayList<ArrayList<Integer>> rev=new ArrayList<>();//to store the reversed graph.
        for(int i=0;i<V;i++){rev.add(new ArrayList<>());}
        for(int i=0;i<V;i++)
        {
            for(int nbr:adj.get(i)){rev.get(nbr).add(i);}
        }
        Arrays.fill(vis,false);
        int scc=0;
        while(st.size()>0)
        {
            int i=st.pop();
            if(!vis[i])
            {
                scc++;
                dfs(rev,i,vis,1);//to find all the nodes of a scc.
            }
        }
        return scc;
    }
    public void dfs(ArrayList<ArrayList<Integer>>adj,int node,boolean[]vis,int opcode)
    {
        vis[node]=true;
        for(int nbr:adj.get(node))
        {
            if(!vis[nbr])
            {
                dfs(adj,nbr,vis,opcode);
            }
        }
        if(opcode==0) st.push(node);
    }
}
