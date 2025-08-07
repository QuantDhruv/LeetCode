public class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;

        String[] segments = s.trim().split("\\s+");
        return segments[0].isEmpty() ? 0 : segments.length;
    }
}
