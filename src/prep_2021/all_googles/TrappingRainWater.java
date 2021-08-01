package prep_2021.all_googles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrappingRainWater {
    TrappingRainWater trappingRainWater;
    @BeforeEach
    public void init(){
        trappingRainWater=new TrappingRainWater();
    }
    @Test
    public void firstTest(){
        trappingRainWater.trap(new int[]{4,2,0,3,2,5});
    }
    public int trap(int[] height) {
        int lMax=0;
        int rMax=0;
        int l=0;
        int res=0;
        int r=height.length-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>=lMax){
                    lMax=height[l];
                }else{
                    res+=lMax-height[l];
                }
                l++;
            }else{
                if (height[r] >= rMax) {
                    rMax = height[r];
                } else {
                    res += rMax - height[r];
                }
                r--;
            }
        }
        return res;
    }
}
