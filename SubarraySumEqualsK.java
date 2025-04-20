import java.util.*;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // To handle subarrays starting at index 0

        int count = 0, currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        System.out.println("Count of subarrays: " + obj.subarraySum(nums, 2));
    }
}
