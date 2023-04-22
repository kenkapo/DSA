//it is also a SSP algorithm->single source shortest path algorithm.
//TC-> ElogV.
class Solution
{
    public int djikstra(List<List<int[]>>adj,int src)
    {
        int n=adj.size();
        int []dis=new int [n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->Integer.compare(dis[a],dis[b]));
        pq.add(src);
        while(pq.size()>0)
        {
            int top=pq.remove();
            for(int []e:adj.get(top))
            {
                if(dis[top]+e[1]<dis[e[0]])
                {
                    dis[e[0]]=dis[top]+e[1];
                    pq.add(e[0]);
                }
            }
        }
        return dis;
    }
}
