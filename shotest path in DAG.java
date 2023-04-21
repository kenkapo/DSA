//we will use TOPO SORT
// it will reduce the TC to O(N+E)
//Intution-> if it is a DAG then in topo sort , all the elements which have an edge coming to st.peek() would already have calculated there distances.
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<N;i++){adj.add(new ArrayList<>());}
		for(int []a:edges)
		{
		    adj.get(a[0]).add(a[1]);
		    adj.get(a[0]).add(a[2]);
		}
		Stack<Integer>st=new Stack<>();
		boolean []vis=new boolean[N];
		for(int i=0;i<N;i++)
		{
		    if(!vis[i]){dfs(i,adj,vis,st);}
		}
		int []dis=new int [N];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[0]=0;
		while(st.size()>0)
		{
		    int node=st.pop();
		    if(dis[node]==Integer.MAX_VALUE){continue;}
		    for(int i=0;i<adj.get(node).size();i+=2)
    	    {
    	        if(dis[node]+adj.get(node).get(i+1)<dis[adj.get(node).get(i)])
    	        {
    	            dis[adj.get(node).get(i)]=dis[node]+adj.get(node).get(i+1);
    	        }
    	    }
		}
		for(int i=0;i<N;i++){if(dis[i]==Integer.MAX_VALUE){dis[i]=-1;}}
		return dis;
	}
	public void dfs(int node,List<List<Integer>>adj,boolean[]vis,Stack<Integer>st)
	{
	    vis[node]=true;
	    for(int i=0;i<adj.get(node).size();i+=2)
	    {
	        if(!vis[adj.get(node).get(i)]){dfs(adj.get(node).get(i),adj,vis,st);}
	    }
	    st.push(node);
	}
}
