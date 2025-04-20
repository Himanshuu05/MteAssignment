import java.util.*;

public class MaxFrequencyElement {

    public int findMaxFrequencyElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int maxElem = nums[0];

        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);

            if (freq > maxFreq) {
                maxFreq = freq;
                maxElem = num;
            }
        }

        return maxElem;
    }

    public static void main(String[] args) {
        MaxFrequencyElement mf = new MaxFrequencyElement();
        int[] nums = {1, 3, 2, 1, 4, 1, 3, 3, 3};
        System.out.println("Element with maximum frequency: " + mf.findMaxFrequencyElement(nums));
    }
}
