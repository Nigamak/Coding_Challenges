class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                sum = sum + customers[i];
            }
        }
        int extra = 0;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extra = extra + customers[i];
            }
        }

        int maxExtra = extra;
        int left = 0;

        for (int right = minutes; right < customers.length; right++) {
            if (grumpy[right] == 1) {
                extra = extra + customers[right];
            }
          
            if (grumpy[left] == 1) {
                extra = extra - customers[left];
            }
            left++;
            maxExtra = Math.max(maxExtra, extra);
        }

        return sum + maxExtra;
    }
}
