import java.util.Arrays;

public class CountBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

    public static void main(String[] args) {
        CountBits cb = new CountBits();
        int[] result = cb.countBits(5);
        System.out.println("Count of 1s: " + Arrays.toString(result));
    }
}
