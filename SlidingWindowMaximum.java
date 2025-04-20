import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices of out-of-window elements
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1)
                dq.pollFirst();

            // Remove all elements smaller than the current
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offerLast(i); // Add current index

            // Window has at least k elements
            if (i >= k - 1)
                result[i - k + 1] = nums[dq.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = sw.maxSlidingWindow(nums, 3);
        System.out.println("Sliding window max: " + Arrays.toString(result));
    }
}
