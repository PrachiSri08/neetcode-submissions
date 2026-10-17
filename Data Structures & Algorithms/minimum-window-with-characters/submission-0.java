public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = t.length(); 
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map[rightChar] > 0) {
                count--;
            }
            map[rightChar]--;
            while (count == 0) {
                int currentWindowLen = right - left + 1;
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    count++; 
                }
                left++;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}

