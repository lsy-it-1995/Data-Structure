package dynamicProgramming;

import java.util.HashMap;

class fibDP{
    
    public static int naiveFib(int n){
        if(n <= 2){
            return 1;
        }
        return naiveFib(n-1) + naiveFib(n-2);
    }
    public static Long dynamicFibMemo(Integer n){
        return dynamicFibMemo(Long.valueOf(n), new HashMap<Long, Long>());
    }
    public static Long dynamicFibMemo(Long n, HashMap<Long, Long> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n <= 2){
            return Long.valueOf(1);
        }
        Long value = dynamicFibMemo(n-1, map) + dynamicFibMemo(n-2, map);
        map.put(n, value);
        return value;
    }
    public static int dynamicFibTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n = 10;
        System.out.println(naiveFib(n));
        // System.out.println(dynamicFibMemo(n));
    }
}