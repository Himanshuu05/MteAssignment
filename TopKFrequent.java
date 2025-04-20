import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2: Use min-heap to keep top K elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        for (int num : freqMap.keySet()) {
            heap.offer(num);
            if (heap.size() > k)
                heap.poll();  // remove least frequent
        }

        // Step 3: Extract from heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--)
            result[i] = heap.poll();

        return result;
    }

    public static void main(String[] args) {
        TopKFrequent tkf = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("Top K Frequent Elements: " + Arrays.toString(tkf.topKFrequent(nums, k)));
    }
}
