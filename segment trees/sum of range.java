// maximum space segment trees take = 4*N.
// TC for query=O(logN)
// TC for build=O(N)

class Solution
{
	int n;
	int []seg=new int [4*n];
	public void build(int i,int low,int high,int []nums)
	{
		if(low==high){return seg[i]=nums[low];}
		int mid=(low+high)/2;
		build(2*i+1,low,mid,nums);
		build(2*i+2,mid+1,high,nums);
		seg[i]=seg[2*i+1]+seg[2*i+2];
	}
	public int queries(int i,int low,int high,int l,int r)
	{
		if(low>=l && high<=r)//if the query contains the complete interval
		{
			return seg[i];
		}
		else if (low>r || high<l){return 0;}// query does not contain the range
		else// means the range either completely overlaps the query or partially overlaps the query
		{
			int mid=(low+high)/2;
			int left=queries(2*i+1,low,mid,l,r);
			int right=queries(2*i+2,mid+1,high,l,r);
			return left+right;
		}
	}
	public int[] func(int []nums,int [][]query)
	{
		n=nums.length;
		build(0,0,n-1,nums);
		int []ans=new int [query.length];
		int i=0;
		for(int []q:query)
		{
			ans[i++]=queries(0,0,n-1,q[0],q[1]);
		}
		return ans;
	}
}
