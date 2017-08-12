package Netease.num1;

import java.util.Scanner;

/**
 * Created by zhufx on 2017/7/31.
 */
public class num5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] nums = new int[n];
        int[][] matrix = new int[n][n];
        int[][] result_matrix = new int[n][n];
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++){
            matrix[i][i] = 1;
            if(i+1<n){
                matrix[i][i+1] = 1;
            }else {
                matrix[i][0] = 1;
            }
        }
        boolean flag = true;
        String str = Integer.toBinaryString(k);
        int tmp[][] = new int[n][n];
        for(int i=str.length()-1;i>=0;i--){
            if(i==str.length()-1){
                tmp = matrix.clone();
            }
            else {
                tmp = matrix_chen(tmp,tmp,n);
            }
            if(str.charAt(i) == '0'){
                continue;
            }else{
                if(flag){
                    result_matrix = tmp.clone();
                    flag = false;
                }else {
                    result_matrix = matrix_chen(result_matrix,tmp,n);
                }
            }
        }

        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                result[i] += result_matrix[i][j]*nums[j];
                if(result[i] >= 100){
                    result[i] = result[i] % 100;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(i != n-1){
                System.out.print(result[i] + " ");
            }else {
                System.out.print(result[i]);
            }
        }
    }


    public static int[][] matrix_chen(int[][]x,int[][] y,int n){
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp = 0;
                for(int p=0;p<n;p++){
                    temp += x[i][p]*y[p][j];
                }
                result[i][j] = temp;
                if(result[i][j] >= 100){
                    result[i][j] = result[i][j] % 100;
                }
            }
        }
        return result;
    }


}
