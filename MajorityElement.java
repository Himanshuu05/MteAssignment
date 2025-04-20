public class MajorityElement {

    public int findMajorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = me.findMajorityElement(nums);
        System.out.println("Majority Element: " + result);
    }
}
