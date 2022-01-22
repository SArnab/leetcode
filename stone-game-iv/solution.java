class Solution {
        
    public boolean winnerSquareGame(int n) {
        // n + 1 because 0 is a valid number of stones
        final boolean[] history = new boolean[n + 1];
        
        // Bottom up, i = number of stones on the turn
        for (int i = 1; i <= n; i++) {
            // j = sqrt of how many stones we're taking
            // k = j squared, how many stones we're taking
            int k = 1;
            int j = 1;
            while (k <= i) {
                // Look behind for memoized values
                if (!history[i - k]) {
                    history[i] = true;
                    break;
                }
                k = (++j) * j;
            }
        }
        
        return history[n];
    }    
}