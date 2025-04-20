import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));

        for (int num : countMap.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        System.out.println("Top K Frequent: " + Arrays.toString(obj.topKFrequent(nums, 2)));
    }
}
