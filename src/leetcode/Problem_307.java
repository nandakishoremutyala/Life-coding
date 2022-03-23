class NumArray {
    int[] arr;
    int len;
    public NumArray(int[] nums) {
        len=nums.length;
        arr=new int[len*2];
        
        
        for(int i=0;i<len;i++){
            arr[len+i]=nums[i];
        }
        
        // initialize segment tree
        
        
        int start=len-1;
        while(start>=0){
            int sum=arr[start*2]+arr[start*2+1];
            arr[start]=sum;
            start--;
        }
        
    }
    
    public void update(int index, int val) {
       int prev=arr[len+index];
       int diff=val-prev;
       arr[len+index]=val;
        
       int loc=len+index;
        
       while(loc>0){
        if(loc%2==0){
            loc=loc/2;
            arr[loc]=arr[loc]+diff;
        }else{
            loc=(loc-1)/2;
            arr[loc]=arr[loc]+diff;
        }
       } 
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
           
    }
    
    public int sumRange(int l, int r) {
        int n=len;
       l += n;
    // get leaf with value 'r'
    r += n;
    int sum = 0;
    while (l <= r) {
        if ((l % 2) == 1) {
           sum += arr[l];
           l++;
        }
        if ((r % 2) == 0) {
           sum += arr[r];
           r--;
        }
        l /= 2;
        r /= 2;
    }
    return sum;
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
