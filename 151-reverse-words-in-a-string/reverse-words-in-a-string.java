public class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces and split by one or more spaces using regex
        String[] words = s.trim().split("\\s+");

        // Use StringBuilder for efficient string manipulation
        StringBuilder sb = new StringBuilder();

        // Loop through the array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);

            // Add space if it's not the last word
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
