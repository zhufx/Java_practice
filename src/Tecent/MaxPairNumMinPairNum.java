package Tecent;

import java.util.*;

/**
 * 腾讯2017年实习生机试第三题
 * Created by zhufx on 2017/6/29.
 */
public class MaxPairNumMinPairNum {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            HashMap<Integer,Integer> map = new HashMap<>();
            int size = scan.nextInt();
            int[] nums = new int[size];
            for(int i=0;i<size;i++){
                nums[i] = scan.nextInt();
            }
            for(int i = 0;i < size ;i++){
                if (map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }else {
                    map.put(nums[i],1);
                }
            }
            if(map.size() == 1){
                //所有元素相同的情况
                int result = size*(size-1)/2;
                System.out.println(result + " " + result);
                continue;
            }else if(map.size() < size){
                int min_result = 0;
                int max_result = 0;
                int max_key = 0;
                int min_key = Integer.MAX_VALUE;
                for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                    int value = entry.getValue();
                    int key = entry.getKey();
                    if( value > 1){
                        min_result += value*(value-1)/2;
                    }
                    max_key = Math.max(key,max_key);
                    min_key = Math.min(key,min_key);
                }
                max_result = map.get(max_key) * map.get(min_key);
                System.out.println(min_result + " " + max_result);
                continue;
            }else{
                int min_result = 0;
                int max_result = 1;
                int min = Integer.MAX_VALUE;
                Arrays.sort(nums);
                for(int i = 0; i < size - 1;i++){
                    int diff = Math.abs(nums[i+1] - nums[i]);
                    if(min > diff){
                        min = diff;
                        min_result = 1;
                    }else if(diff == min){
                        min_result++;
                    }
                }
                System.out.println(min_result + " " + max_result);
            }
        }

    }


}
