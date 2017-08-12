package Netease.num1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zhufx on 2017/7/30.
 * 0-1背包问题
 */
public class num1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] length = new int[n+1];
        length[0] = 0;
        int sum = 0;
        for(int i=1;i<=n;i++){
            length[i] = scan.nextInt()/1024;
            sum += length[i];
        }
        int[][] f = new int[n+1][sum/2 + 1];
        for(int i=0;i<f.length;i++){
            for(int j=0;j<f[i].length;j++){
                f[i][j] = 0;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum/2 + 1;j++){
                //注意这里要先赋值
                f[i][j] = f[i-1][j];
                if(j >= length[i]) f[i][j] = Math.max(f[i-1][j-length[i]] + length[i],f[i-1][j]);

            }
        }
        System.out.println((sum - f[n][sum/2])*1024);

    }
}
