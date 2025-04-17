import java.util.*;
public class equilibriumIndex {
    public static int equilibriumIndex(int[] nums){
        int rightSum=0;
        for(int num: nums){
            rightSum+=num;
        }
        int leftSum=0;
        for(int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={1,2,4,2,1};
        System.out.println("equilibrium Index is = " + equilibriumIndex(arr));
    }
}
//Time Complexity = O(N)
//Space Complexity = O(1)