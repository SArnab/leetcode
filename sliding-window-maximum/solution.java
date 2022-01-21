class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // There will be n - k + 1 windows
        final int[] results = new int[nums.length - k + 1];
        int index = 0;
        
        // dq will track the indexes of max numbers per window
        final ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            final int currentValue = nums[i];
            
            // Pop elements that do not fit in the window
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.removeFirst();
            }
            
            // Remove smaller elements in this window, we only want the max
            while (!dq.isEmpty() && nums[dq.peekLast()] < currentValue) {
                dq.removeLast();
            }
            
            // Add to end of dq
            dq.offerLast(i);
            
            // If we're at the end of a window, add the head (max) to the result
            // i is 0-based, k is 1-based so we add 1
            // We don't need to worry about removing the element here, that will happen
            // on the next iteration of the loop
            if (i + 1 >= k) {
                results[index++] = nums[dq.peekFirst()];
            }
        }
        
        return results;
    }
}