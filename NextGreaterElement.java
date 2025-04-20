import java.util.*;

public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from end to start
        for (int i = n - 1; i >= 0; i--) {
            // Pop all smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums = {4, 5, 2, 10};
        System.out.println("Next Greater Elements: " + Arrays.toString(nge.nextGreaterElements(nums)));
    }
}
