//spfa-> stands for shortest path faster algorithm.
//modification of bellman-ford.
public static void shortestPathFaster(int S, int V)
{
    // Create array d to store shortest distance
    int []d = new int[V + 1];
 
    // Boolean array to check if vertex
    // is present in queue or not
    boolean []inQueue = new boolean[V + 1];
 
    // Initialize the distance from source to
    // other vertex as Integer.MAX_VALUE(infinite)
    for (int i = 0; i <= V; i++)
    {
        d[i] = Integer.MAX_VALUE;
    }
    d[S] = 0;
 
    Queue<Integer> q = new LinkedList<>();
    q.add(S);
    inQueue[S] = true;
 
    while (!q.isEmpty())
    {
 
        // Take the front vertex from Queue
        int u = q.peek();
        q.remove();
        inQueue[u] = false;
 
        // Relaxing all the adjacent edges of
        // vertex taken from the Queue
        for (int i = 0; i < graph[u].size(); i++)
        {
 
            int v = graph[u].get(i).first;
            int weight = graph[u].get(i).second;
 
            if (d[v] > d[u] + weight)
            {
                d[v] = d[u] + weight;
 
                // Check if vertex v is in Queue or not
                // if not then push it into the Queue
                if (!inQueue[v])
                {
                    q.add(v);
                    inQueue[v] = true;
                }
            }
        }
    }
}
