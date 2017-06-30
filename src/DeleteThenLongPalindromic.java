import java.util.Scanner;

/**
 *  * 腾讯2017年实习生机试第一题
 * Created by zhufx on 2017/6/29.
 */
public class DeleteThenLongPalindromic {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = new StringBuilder(str1).reverse().toString();
        int length = str1.length();

        //求两个字符串的公共子串 动态规划
        int[][] dp = new int[length+1][length+1];
        for(int i = 1; i <= length ; i++){
            for(int j = 1; j <= length ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        System.out.println(length - dp[length][length]);


    }
}
