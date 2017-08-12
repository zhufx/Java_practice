package Netease.num1;

import java.util.*;

/**
 * Created by zhufx on 2017/7/30.
 */
public class num4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] num = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            num[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++){
            map.put(num[i],i);
        }
        //LinkedHashMap<Integer,Integer>  sortedMap = new LinkedHashMap<>();
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        ArrayList<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer,Integer> m:entryList){
            result.add(m.getKey());
        }
        for(int i=0;i<result.size();i++){
            if(i == result.size() - 1){
                System.out.print(result.get(i));
            }else {
                System.out.print(result.get(i) + " ");
            }
        }

    }

}
