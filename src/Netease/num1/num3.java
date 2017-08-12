package Netease.num1;

import java.util.Scanner;

/**
 * Created by zhufx on 2017/7/30.
 */
public class num3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] chars = str.toCharArray();
        //只有两种情况，1.B全在后面，或者2.G全在后面
        boolean falg = true;
        int step1=0,step2 = 0;
        int index = 0;
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i] == 'G' && falg){
                falg = false;
                index = i;
            }
            if(chars[i] == 'B' && !falg){
                int tmp = index - i;
                step1 += tmp;
                index--;
            }
        }
        index = 0;
        falg = true;
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i] == 'B' && falg){
                falg = false;
                index = i;
            }
            if(chars[i] == 'G' && !falg){
                int tmp = index - i;
                step2 += tmp;
                index--;
            }
        }
        System.out.println(Math.min(step1,step2));
    }
}
