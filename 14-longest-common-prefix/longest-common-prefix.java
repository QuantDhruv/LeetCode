class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Take the first string as a reference
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // While the current string doesn't start with the prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Remove the last character from prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If no common prefix
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
