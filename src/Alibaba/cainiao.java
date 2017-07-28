package Alibaba;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhufx on 2017/7/28.
 * 阿里笔试题
 * 先选择开始点 再深度优先搜索就可以了
 */
public class cainiao {
    public static int max = 1;
    public static Stack<int[]> steps = new Stack<>();
    public static Stack<int[]> maxSteps = new Stack<>();
    public static void main(String[] args){
        int[][] source = {{32,34,7,33,21,2},{13,12,3,2,26,36},{16,30,22,1,24,14},{20,23,25,5,19,29},{27,15,9,17,31,4},
                {6,18,8,10,35,28}};
        ArrayList<int[]>cord = getCordinate(source);
        for(int i = 0;i<cord.size();i++){
            int cord_x = cord.get(i)[0];
            int cord_y = cord.get(i)[1];
            steps.push(new int[]{cord_x,cord_y});
            search(source,cord_x,cord_y);
            steps.clear();
        }
        System.out.println(max);
        printStack(maxSteps);

    }

    public static void printStack(Stack<int[]> steps){
        int[] cord = steps.pop();
        if(!steps.isEmpty()){
            printStack(steps);
        }
        System.out.print(cord[0] + "," +cord[1] + "->");

    }

    //找最大点的坐标
    public static ArrayList<int[]> getCordinate(int[][] source){
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0;i<source.length;i++){
            for(int j=0;j<source[i].length;j++){
                if(i != 0){
                    if(source[i][j] < source[i-1][j]) continue;
                }
                if(i != source.length - 1){
                    if(source[i][j] < source[i+1][j]) continue;
                }
                if(j != 0){
                    if(source[i][j] < source[i][j-1]) continue;
                }
                if(j != source[i].length - 1){
                    if(source[i][j] < source[i][j+1]) continue;
                }
                int[] tmp = {i,j};
                result.add(tmp);
            }
        }
        return result;
    }

    public static void search(int[][] source,int cord_x,int cord_y){
        if(cord_x != 0){
            if(source[cord_x][cord_y] > source[cord_x-1][cord_y]) {
                steps.push(new int[]{cord_x - 1, cord_y});
                if(max < steps.size()) {
                    max = steps.size();
                    maxSteps = (Stack<int[]>) steps.clone();
                }
                search(source,cord_x-1,cord_y);
                steps.pop();
            }
        }
        if(cord_x != source.length - 1){
            if(source[cord_x][cord_y] > source[cord_x+1][cord_y]) {
                steps.push(new int[]{cord_x + 1, cord_y});
                if (max < steps.size()) {
                    max = steps.size();
                    maxSteps = (Stack<int[]>) steps.clone();
                }
                search(source, cord_x + 1, cord_y);
                steps.pop();
            }
        }
        if(cord_y != 0){
            if(source[cord_x][cord_y] > source[cord_x][cord_y - 1]) {
                steps.push(new int[]{cord_x, cord_y - 1});
                if (max < steps.size()) {
                    max = steps.size();
                    maxSteps = (Stack<int[]>) steps.clone();
                }
                search(source, cord_x, cord_y - 1);
                steps.pop();
            }
        }
        if(cord_y != source[cord_x].length - 1){
            if(source[cord_x][cord_y] > source[cord_x][cord_y + 1]) {
                steps.push(new int[]{cord_x, cord_y + 1});
                if (max < steps.size()) {
                    max = steps.size();
                    maxSteps = (Stack<int[]>) steps.clone();
                }
                search(source, cord_x, cord_y + 1);
                steps.pop();
            }
        }
    }
}