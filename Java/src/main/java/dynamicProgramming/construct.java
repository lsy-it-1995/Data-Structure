package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class construct{
    public static boolean naiveCanConstruct(String word, List<String> words){
        if(word.length() == 0){
            return true;
        }
        for(String subWord: words){
            if(word.indexOf(subWord) == 0){
                if(naiveCanConstruct(word.substring(subWord.length()), words)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean memoCanConstruct(String word, List<String> words){
        return memoCanConstruct(word, words, new HashMap<>());
    }
    public static boolean memoCanConstruct(String word, List<String> words, HashMap<String, Boolean> map){
        if(word.length() == 0){
            return true;
        }
        if(map.containsKey(word)){
            return map.get(word);
        }
        for(String subWord: words){
            if(word.indexOf(subWord) == 0){
                if(memoCanConstruct(word.substring(subWord.length()), words, map)){
                    map.put(word, true);
                    return true;
                }
            }
        }
        map.put(word, false);
        return false;
    }
    public static int naiveCountConstruct(String word, List<String> words){
        if(word.length() == 0){
            return 1;
        }
        int sum = 0;
        for(String w: words){
            if(word.indexOf(w) == 0){
                sum += naiveCountConstruct(word.substring(w.length()), words);
            }
        }
        return sum;
    }
    public static int memoCountConstruct(String word, List<String> words){
        return memoCountConstruct(word, words, new HashMap<>());
    }
    public static int memoCountConstruct(String word, List<String> words, HashMap<String, Integer> memo){
        if(word.length() == 0){
            return 1;
        }
        if(memo.containsKey(word)){
            return memo.get(word);
        }
        int sum = 0;
        for(String w: words){
            if(word.indexOf(w) == 0){
                sum += memoCountConstruct(word.substring(w.length()), words, memo);
            }
        }
        memo.put(word, sum);
        return sum;
    }
    public static boolean countConstructTabulation(String word, List<String> words){
        List<Boolean> tabulation = new ArrayList();
        tabulation.add(true);
        for(int i = 0; i < word.length(); i++){
            tabulation.add(false);
        }
        for(int i = 0; i < word.length(); i++){
            if(!tabulation.get(i)){
                continue;
            }
            String subWord = word.substring(i);
            for(String w: words){
                if(subWord.indexOf(w) == 0){
                    tabulation.set(i+w.length(), true);
                }
                if(tabulation.get(word.length())){
                    return true;
                }
            }
        }
        return false;
    }
    public static List<List<String>> naiveAllConstruct(String word, List<String> words){
        if(word.length() == 0){
            return Arrays.asList(new ArrayList());
        }
        List<List<String>> list = new ArrayList();
        for(String prefix: words){
            if(word.indexOf(prefix) == 0){
                List<List<String>> sufixWays = naiveAllConstruct(word.substring(prefix.length()), words);
                sufixWays.forEach(a -> a.add(0, prefix));
                list.addAll(sufixWays);
            }
        }
        return list;
    }
    public static void main(String[] args){
        String word = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        List<String> words =Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee");
        System.out.println(memoCountConstruct(word, words));
    }
}