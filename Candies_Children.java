import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static long candies(int n, List<Integer> arr) {
    // Write your code here
    
    if(arr.size() == 0){
        return 0;
    }
    
    if(arr.size() == 1 ){
        return 1;
    }
    int[] dp = new int[arr.size()];
    Arrays.fill(dp, 1);
    if( arr.size() >1  && arr.get(0) > arr.get(1)){
        dp[0] += 1;
        
    }
    for(int i=1 ; i<arr.size(); i++){
        if(arr.get(i) > arr.get(i-1)){
            dp[i] = dp[i-1] + 1;
    }
    }
    
    for(int i= arr.size()-2; i >=0; i--){
        if(arr.get(i) > arr.get(i+1)){
             dp[i] = Math.max(dp[i], dp[i + 1] + 1);
        }
    }
        
    long sum = 0;
    
    for(long num:dp){
       sum += num; 
    }
    return sum;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
