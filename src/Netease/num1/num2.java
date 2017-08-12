package Netease.num1;

import java.util.Scanner;

/**
 * Created by zhufx on 2017/7/30.
 */
public class num2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0;i<n;i++){
            x[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++){
            y[i] = scan.nextInt();
        }
        int dst_x = scan.nextInt();
        int dst_y = scan.nextInt();
        int walk_time = scan.nextInt();
        int taxi_time = scan.nextInt();

        //我到每个的士点的距离
        int[] me2taxi = new int[n];
        //每个的士到终点的距离
        int[] taxi2dst = new int[n];
        //总时间
        int[] time = new int[n];
        for(int i=0;i<n;i++){
            me2taxi[i] = Math.abs(x[i]) + Math.abs(y[i]);
        }
        for(int i=0;i<n;i++){
            taxi2dst[i] = Math.abs(dst_x-x[i]) + Math.abs(dst_y - y[i]);
        }
        for(int i=0;i<n;i++){
            time[i] = me2taxi[i] * walk_time + taxi2dst[i] * taxi_time;
        }

        int min_time = (Math.abs(dst_x) + Math.abs(dst_y))*walk_time;
        for(int i=0;i<n;i++){
            min_time = Math.min(time[i],min_time);
        }
        System.out.println(min_time);
    }
}
