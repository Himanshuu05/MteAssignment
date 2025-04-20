public class UniqueDigitNumbers {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int result = 10; // f(1)
        int uniqueDigits = 9;
        int availableDigits = 9;

        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueDigits *= availableDigits;
            result += uniqueDigits;
            availableDigits--;
        }

        return result;
    }

    public static void main(String[] args) {
        UniqueDigitNumbers ud = new UniqueDigitNumbers();
        System.out.println("Unique digit count (n=2): " + ud.countNumbersWithUniqueDigits(2));
    }
}
