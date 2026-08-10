class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            max = Math.max(max, maxlen(s, k, ch));
        }
        return max;
    }

    public int maxlen(String s, int k, char ch) {
        int left = 0;
        int count = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) != ch) {
                count++;
            }
            while (count > k) {

                if (s.charAt(left) != ch) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
