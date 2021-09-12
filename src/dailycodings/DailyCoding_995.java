package dailycodings;

public class DailyCoding_995 {
    public static void main(String[] args) {
        DailyCoding_995 dailyCoding_995=new DailyCoding_995();
        dailyCoding_995.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(i==0){
                left[i]=nums[i];
            }else{
                left[i]=left[i-1]*nums[i];
            }
        }

        for(int i=len-1;i>=0;i--){
            if(i==len-1){
                right[i]=nums[i];
            }else{
                right[i]=right[i+1]*nums[i];
            }
        }

        int[] result=new int[len];
        for(int i=0;i<len;i++){
            if(i==0){
                result[i]=right[i+1];
            }else if(i==len-1){
                result[i]=left[len-2];
            }else{
                result[i]=left[i-1]*right[i+1];
            }
        }
        return result;
    }
}
