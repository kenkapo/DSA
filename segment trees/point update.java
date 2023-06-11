//TC is O(logN)
// here node is the index we want to update and val is the value by which we will increment the value at that index by.
public void pointUpdate(int i,int low,int high,int node,int val)
{
	if(low==high)
	{
		seg[i]+=val;
		return;
	}
	int mid=(low+high)/2;
	if(node>=low && node<=mid) {pointUpdate(2*i+1,low,mid,node,val);}
	else {pointUpdate(2*i+2,mid+1,high,node,val);}
	seg[i]=seg[2*i+1]+seg[2*i+2];
}

