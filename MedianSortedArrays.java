public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is smaller
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n = nums1.length;
        int m = nums2.length;
        int low = 0, high = n;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (n + m + 1) / 2 - i;

            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == n) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == m) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if ((n + m) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = i - 1; // Move left
            } else {
                low = i + 1; // Move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly");
    }

    public static void main(String[] args) {
        MedianSortedArrays ms = new MedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + ms.findMedianSortedArrays(nums1, nums2));
    }
}
