class Solution {
    public static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {

        if(s.length() == 1) return 1;
        int count = 0;
        int maxcount = Integer.MIN_VALUE;
        
        for(int i=0; i<k;i++){
            if (isVowel(s.charAt(i))){
                count++;
            }
        }
        maxcount = Math.max(maxcount, count);

        int left = 0;

        for(int right=k; right<s.length(); right++){
            if(isVowel(s.charAt(right))){
                count++;
            }

            if(isVowel(s.charAt(left))){
                count--;
            }
            left++;

            maxcount = Math.max(maxcount, count);
        }

        return maxcount;
    }
}
