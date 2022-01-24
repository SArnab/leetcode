class Solution {
    public boolean detectCapitalUse(String word) {
        int capCount = 0;
        boolean firstCap = false;
        final char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final boolean isCap = Character.isUpperCase(chars[i]);
            if (isCap) {
                if (i == 0) {
                    firstCap = true;
                }
                capCount++;
            }
        }
        
        return capCount == 0 || (capCount == 1 && firstCap) || capCount == word.length();
    }
}