class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

public class MaximumXOR {
    TrieNode root = new TrieNode();

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }

    public int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppBit = 1 - bit;
            if (node.children[oppBit] != null) {
                maxXor |= (1 << i);
                node = node.children[oppBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        for (int num : nums)
            insert(num);
        int max = 0;
        for (int num : nums)
            max = Math.max(max, findMaxXOR(num));
        return max;
    }

    public static void main(String[] args) {
        MaximumXOR mx = new MaximumXOR();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR: " + mx.findMaximumXOR(nums));
    }
}
