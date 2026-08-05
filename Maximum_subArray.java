import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        int n = sys.nextInt();
        int k = sys.nextInt();
        int[] nums = new int[n];
        
        for(int i=0; i<n; i++){
            nums[i] = sys.nextInt();
        }
        
        HashMap<Integer, Integer> map =  new HashMap<>();
        
        
        int left =0;
        long max = Integer.MIN_VALUE;
        long sum =0;
        
        for(int right=0; right<n; right++){
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            
            while(map.size() >k ){
                sum -=nums[left];
                map.put(nums[left],map.get(nums[left])-1);
                
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            
            max = Math.max(sum, max);
        }
        
        if(sum < 0 || nums.length == 0){
            System.out.print(0);
        }
        else{
            System.out.print(max);
        }
        
    }
}
