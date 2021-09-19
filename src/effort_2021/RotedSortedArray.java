package effort_2021;

public class RotedSortedArray {
    public int findMin(int[] nums) {
        //  5 1 2 3 4
        int left=0;
        int right=nums.length-1;
        if(nums[left]<nums[right]) return nums[0];
        int mid=0;
        while(left<right){
            mid=left+(right-left)/2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if(nums[mid]>nums[left]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return nums[mid];
    }
}
