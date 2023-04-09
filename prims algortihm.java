//used for minimum spanning tree.
//spanning tree->graph with N nodes and N-1 edges.
//MST->spanning tree with minimum weight.
class Solution{
    public static class Pair implements Comparable<Pair>
    {
        int wt,node,par;
        Pair(int node,int wt)
        {
            this.node=node;this.par=par;this.wt=wt;
        }
        public int compareTo(Pair o)
        {
            return this.wt-o.wt;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    boolean []mst=new boolean [V];
	    List<List<int[]>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++){adj.add(new ArrayList<>());}
	    for(int[]e:edges)
	    {
	        adj.get(e[0]).add(new int []{e[1],e[2]});
	        adj.get(e[1]).add(new int []{e[0],e[2]});
	    }
	    PriorityQueue<Pair>pq=new PriorityQueue<>();
	    pq.add(new Pair(0,0,-1));
	    int ans=0;
	    while(pq.size()>0)
	    {
	        Pair top=pq.remove();
	        if(mst[top.node]){continue;}
	        ans+=top.wt;
	        mst[top.node]=true;
	        for(int []e:adj.get(top.node))
	        {
	            if(!mst[e[0]]){pq.add(new Pair(e[0],e[1],top.node));}
	        }
	    }
	    return ans;
	}
}
