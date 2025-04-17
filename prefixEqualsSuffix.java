import java.util.*;
public class prefixEqualsSuffix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean canSplit = canBeSplit(arr);
        if (canSplit) {
            System.out.println("Array can be split into two parts with equal sum.");
        } else {
            System.out.println("Array cannot be split into two equal sum parts.");
        }
    }

    static boolean canBeSplit(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length - 1; i++) { // Exclude last index
            leftSum += arr[i];
            int rightSum = totalSum - leftSum;
            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }
}
// Time Complexity = O(N)
// Space Complexity = O(1)