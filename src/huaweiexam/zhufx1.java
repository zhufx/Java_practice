package huaweiexam;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhufx on 2017/7/12.
 */
public class zhufx1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(getResult(str));
        }
    }
    public static boolean getResult(String str){
        Stack<Character> stack = new Stack<Character>();
        char[] ca = str.toCharArray();
        for(int i=0;i<ca.length;i++){
            char c = ca[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if(c == ')'){
                char tmp = stack.pop();
                if(tmp != '('){
                    return false;
                }
            }else if( c == ']'){
                char tmp = stack.pop();
                if(tmp != '['){
                    return  false;
                }
            }else if(c == '}'){
                char tmp = stack.pop();
                if(tmp != '{'){
                    return false;
                }
            }
        }
        return true;
    }
}
