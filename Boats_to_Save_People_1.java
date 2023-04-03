class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count=0;
        int left=0,right=people.length-1;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:people)
        {
            arr.add(i);
        }
        Collections.sort(arr);
        while(true)
        {
        while(left<right&&arr.get(left)+arr.get(right)>limit)
        {
            right--;
        }
        if(left>=right)
        {
            count=count+1;
            left++;
        }
        else
        {
            count=count+1;
            int ele=arr.get(right);
            arr.remove(right);
            arr.set(left,arr.get(left)+ele);
            left++;
        }
            if(left>=arr.size())
                break;
            right=arr.size()-1;
        }
        return count;
    }
}
