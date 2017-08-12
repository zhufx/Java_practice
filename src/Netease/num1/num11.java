package Netease.num1;

import java.util.Scanner;

/**
 * Created by zhufx on 2017/8/4.
 */
public class num11 {
    public static int sum = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int tmp = scan.nextInt();
            v[i] = tmp;
            sum += tmp;
        }
        int result = dp_solution(v);
        System.out.print(result);
    }

    public static int dp_solution(int[] v){
        int n = v.length;
        int[][] dp = new int[n][sum+1];
        for (int i = 1; i < n; i++) {
            dp[i][0] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j+v[i] <= sum && j >= v[i]){
                    dp[i][j] = Math.max(dp[i-1][j+v[i]] + v[i],dp[i][j]);
                }else if(j < v[i]){
                    //这里有难度
                    dp[i][j] = Math.max(dp[i-1][v[i]-j] + v[i] - j,dp[i][j]);
                }else if(j >= v[i]){
                    dp[i][j] = Math.max(dp[i-1][j-v[i]],dp[i][j]);
                }
            }
        }

        if(dp[n-1][0] == 0){
            return -1;
        }else{
            return dp[n-1][0];
        }
    }
}
