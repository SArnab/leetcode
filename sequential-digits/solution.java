class Solution {
    
    private static int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    
    public List<Integer> sequentialDigits(int low, int high) {
        final int minWindowSize = getMaxPlaceValue(low);
        final int maxWindowSize = getMaxPlaceValue(high);
        final List<Integer> results = new ArrayList<>();
        
        // n = size of window
        for (int n = minWindowSize; n <= maxWindowSize; n++) {
            // j = starting index for each window
            for (int j = 0; j <= values.length - n; j++) {
                // Combine digits to create a value within this window that starts at j
                int seqNumber = 0;
                for (int i = 0; i < n; i++) {
                    final int digit = values[j + i];
                    seqNumber += Math.pow(10, n - i -1) * digit;                   
                }
                if (seqNumber >= low && seqNumber <= high) {
                    results.add(seqNumber);
                }
            }
        }
        
        return results;
    }
    
    private int getMaxPlaceValue(int value) {
        int n = 1;
        int x = value;
        while (x > 9) {
            x = x / 10;
            n++;
        }
        return n;
    }
}