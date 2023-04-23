class Solution
{
    int d=26,h=1,mod=1000000007;
    public void rabinkarp(String s,String pat)
    {
        int m=s.length(),n=pat.length();
        for(int i=0;i<n-1;i++){h=(h*d)%mod;}
        int sc=0,pc=0,j=0;
        for(int i=0;i<n;i++)
        {
            sc=(sc*d+s.charAt(i))%mod;
            pc=(pc*d+pat.charAt(i))%mod;
        }
        for(int i=n;i<m;i++)
        {
            if(sc==pc)
            {
                int l;
                for(int k=j;l=0; k<i && l<pat.length();k++;l++)
                {
                    if(s.charAt(k)!=pat.charAt(l)){break;}
                }
                if(l==pat.length()) System.out.println("pattern found at index "+(j));
            }
            sc=(d*(sc-h*s.charAt(j))%mod+s.charAt(i))%mod;
            j++;
        }
        if(sc==pc)
        {
            int l;
            for(int k=j;l=0; k<i && l<pat.length();k++;l++)
            {
                if(s.charAt(k)!=pat.charAt(l)){break;}
            }
            if(l==pat.length()) System.out.println("pattern found at index "+(j));       
        }
        return ;
    }
}



