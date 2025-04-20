public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo po2 = new PowerOfTwo();
        System.out.println("Is 16 a power of two? " + po2.isPowerOfTwo(16));  // true
        System.out.println("Is 18 a power of two? " + po2.isPowerOfTwo(18));  // false
    }
}
