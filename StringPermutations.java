public class StringPermutations {

    public void permute(char[] str, int index) {
        if (index == str.length - 1) {
            System.out.println(new String(str));
            return;
        }

        for (int i = index; i < str.length; i++) {
            swap(str, index, i);                  // Swap to fix one character
            permute(str, index + 1);              // Recur for the rest
            swap(str, index, i);                  // Backtrack
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        String input = "ABC";
        StringPermutations sp = new StringPermutations();
        sp.permute(input.toCharArray(), 0);
    }
}
//Time Complexity: O(n!)
//
//For a string of length n, there are n! permutations.
//
//Space Complexity: O(n) (ignoring output)
//
//Due to recursion stack and character ar
