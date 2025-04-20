public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxProd;
            if (nums[i] < 0) {
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(nums[i], nums[i] * maxProd);
            minProd = Math.min(nums[i], nums[i] * minProd);
            result = Math.max(result, maxProd);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProductSubarray mp = new MaxProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + mp.maxProduct(nums));
    }
}
