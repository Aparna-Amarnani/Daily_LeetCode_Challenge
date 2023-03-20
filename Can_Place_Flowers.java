/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0)
        return true;
        if(flowerbed.length==1)
        {
            if(flowerbed[0]==0)
            return true;
            else
            return false;
        }
        
        for(int i=0;i<flowerbed.length&&n>0;i++)
        {
            if(flowerbed[i]==0)
            {
                if(i>0 && i<flowerbed.length-1)
                {
                    if(flowerbed[i-1]==0&&flowerbed[i+1]==0)
                    {
                        flowerbed[i]=1;
                        n--;
                    }
                }
                else if(i==0)
                {
                    if(flowerbed[i+1]==0)
                    {
                        flowerbed[i]=1;
                        n--;
                    }
                }
                else if(i==flowerbed.length-1)
                {
                    if(flowerbed[i-1]==0)
                    {
                        flowerbed[i]=1;
                        n--;
                    }
                }
            }
        }
        if(n==0)
            return true;
        else
            return false;
    }
}
