class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // We want first arg to be the smaller list
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);    
        }
        
        final int[] smallList = nums1;
        final int[] bigList = nums2;
        final int totalLen = smallList.length + bigList.length;
        final int midPoint = totalLen / 2;
        
        // Select left-halves of both arrays until the selection is <= the remaining right halves
        // We can use binary search on the shortest array to optimize and then take the remaining elements from the bigList
        
        int left = 0;
        int right = smallList.length;
        
        while (left < right) {
            // i = endpoint of the half from the smaller list
            // j = endpoint of the half from the bigger list
            final int i = (left + right) / 2;
            
            // j will be the remaining number of elements we need from the bigger list to complete the smaller half of the final array
            final int j = midPoint - i;
            
            // All elements from the half of the smallerList should be <= to all elements in the second half of the largerList
            // We keep incrementing until this no longer holds true, after which we know the last element of the first half = smallList[left]
            if (smallList[i] < bigList[j - 1]) {
                left = i + 1;
            } else {
                right = i;
            }
        }
        
        final int smallCount = left;
        final int bigCount = midPoint - smallCount;
        
        final int smallLeft = smallCount == 0 ? Integer.MIN_VALUE : smallList[smallCount - 1];
        final int smallRight = smallCount == smallList.length ? Integer.MAX_VALUE : smallList[smallCount];
        
        final int bigLeft = bigCount == 0 ? Integer.MIN_VALUE : bigList[bigCount - 1];
        final int bigRight = bigCount == bigList.length ? Integer.MAX_VALUE : bigList[bigCount];
        
        if (totalLen % 2 == 1) {
            // For odd numbers, the median is the smaller of the last elements
            return Math.min(smallRight, bigRight);
        } else {
            // For even numbers, the median is the average of the two last elements
            return Math.max(smallLeft, bigLeft) * 0.5 + Math.min(smallRight, bigRight) * 0.5;
        }
    }
}