// DSU stands for Disjoint Set Union data structure.
// it basically helps us to compute if two nodes are in same component in O(4*a) a->alpha,which is nearly about constant time.
class Solution
{
    List<Integer>par,rank,size;
    public void Disjoint_Set(int n)
    {
        for(int i=0;i<=n;i++)
        {
            par.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findPar(int u)
    {
        if(par.get(u)==u)
        {
            return u;
        }
        int p=findPar(par.get(u));
        par.set(u,p);//path compression
        return p;
    }
    public void ubr(int u,int v) // union by rank
    {
        int pu=findPar(u),pv=findPar(v);
        if(pu==pv){return;}
        else if (rank.get(pv)>rank.get(pu))
        {
            par.set(pu,pv);
        }
        else if (rank.get(pu)>rank.get(pv))
        {
            par.set(pv,pu);
        } 
        else
        {
            par.set(pv,pu);
            rank.set(pu,rank.get(pu)+1);
        }
    }
    public void ubs(int u,int v)//union by size
    {
        int pu=findPar(u),pv=findPar(v);
        if(pu==pv){return;}
        else if (size.get(pv)> size.get(pu))
        {
            par.set(pu,pv);
            size.set(pv, size.get(pv)+ size.get(pu));
        }
        else
        {
            par.set(pv,pu);
            size.set(pu, size.get(pu)+ size.get(pv));
        }
    }
}
