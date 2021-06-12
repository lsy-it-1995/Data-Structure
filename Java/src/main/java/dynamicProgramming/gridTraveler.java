package dynamicProgramming;

import java.util.HashMap;

public class gridTraveler {
    public static int naiveTravel(int m, int n){
        if(m == 1 && n == 1){
            return 1;
        }
        if(m == 0 || n == 0){
            return 0;
        }
        return naiveTravel(m-1, n) + naiveTravel(m, n-1);
    }

    public static Long dynamicTravelMemo(int m, int n){
        return dynamicTravelMemo(m, n, new HashMap<>());
    }
    public static Long dynamicTravelMemo(int m, int n, HashMap<String, Long> map){
        if(m == 1 && n == 1){
            return Long.valueOf(1);
        }
        if(m == 0 || n == 0){
            return Long.valueOf(0);
        }
        String key = m + "," + n;
        if(map.containsKey(key)){
            return map.get(key);
        }
        Long value = dynamicTravelMemo(m-1,n,map) + dynamicTravelMemo(m, n-1, map);
        map.put(key, value);
        return value;
    }
    public static void main(String[] args){
        int m = 57, n = 10;
        System.out.println(dynamicTravelMemo(m,n));
    }
}
