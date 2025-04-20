import java.util.*;

public class SubsetsGenerator {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        SubsetsGenerator sg = new SubsetsGenerator();
        System.out.println("Subsets: " + sg.subsets(new int[]{1, 2}));
    }
}
