class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0;
        int[] pow=new int[nums.length];
        int mod=(int)1e9 + 7;
        pow[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            pow[i]=pow[i-1]*2%mod;
        }
        int l=0,r=nums.length-1;
        while(l<=r)
        {
            if(nums[l]+nums[r]>target)
            {
                r--;
            }
            else
            {
                count=(count+pow[r-l++])%mod;
            }
        }
        return count;
    }
}
