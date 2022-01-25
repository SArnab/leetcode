class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        
        // Must start ascending
        boolean incline = arr[1] > arr[0];
        if (!incline) {
            return false;
        }
        
        for (int i = 1; i < arr.length; i++) {
            // Must be on a slope
            if (arr[i] == arr[i - 1]) {
                return false;
            }
            
            // Switch to decline if this num is less
            if (incline) {
                if (arr[i] < arr[i - 1]) {
                    incline = false;
                }
            // If we're already declining, then every num must be less
            } else if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        
        // Must end on a decline
        return incline == false;
    }
}