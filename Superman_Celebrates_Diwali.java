import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sys = new Scanner(System.in);
        int n = sys.nextInt();
        int h = sys.nextInt();
        int drop = sys.nextInt();

        int[][] a = new int[n][h + 1];

        for (int i = 0; i < n; i++) {

            int m = sys.nextInt();

            for (int j = 0; j < m; j++) {

                int floor = sys.nextInt();

                a[i][floor]++;
            }
        }
        
        
        int[][] dp = new int[n][h+1];
        int opt[] = new int[h+1];
        
        for(int height =1; height<=h ;height++){
            for(int building=0; building<n; building++){
                
                dp[building][height] = dp[building][height-1] + a[building][height];
                
                if(height >= drop){
                    dp[building][height] = Math.max(dp[building][height], opt[height - drop] + a[building][height]);
                    
                }
                opt[height] = Math.max(dp[building][height], opt[height]);
                   
            }
        }
        
        System.out.println(opt[h]);
    }
}
