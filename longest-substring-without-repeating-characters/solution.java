class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        
        final Map<Character, Integer> tracking = new HashMap<>();
        int maxLen = 1;
        int start = 0;
        int end = 0;
        
        for (; end < s.length(); end++) {
            final char curr = s.charAt(end);
            final int lastSeen = tracking.getOrDefault(curr, -1);
            tracking.put(curr, end);
            
            // If this current char is a dupe, we calculate the maxlen up to this char
            // And we move the left edge of the window forward
            if (lastSeen >= start) {
                maxLen = Math.max(maxLen, end - start);
                start = lastSeen + 1;
            }
        }
        
        return Math.max(maxLen, end - start);
    }
}