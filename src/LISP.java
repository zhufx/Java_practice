import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhufx on 2017/6/29.
 * 2017华为提前批校园招聘初试第三题
 * 这一题主要思路是将题目中的中缀表达式变化成后缀表达式，再计算表达式值。思路用堆栈来做。
 * 有如下的坑点：
 * 1. 参数的字符串中"..."可能包括括弧"(",")"
 * 2. 参数的字符串中"..."可能包括操作码字符，所以压入堆栈的参数引号不能去掉
 * 3. 字符串分割比较复杂，匹配做括弧和空格来匹配操作吗。匹配双引号来匹配参数。
 * 4. 参数先入栈后出栈，注意操作函数的参数顺序。
 */
public class LISP {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        Stack<String> stack_val = new Stack<String>();

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        boolean flag = false;
        int leftkuohu = 0;
        int rightwhite = 0;
        int quoteCount = 0;
        int leftQuoteIndex = 0;
        int rightQuoteIndex = 0;
        for( int i = 0;i < str.length(); i++ ){
            //判断做括弧是否在引号内部
            str.trim();
            if(str.charAt(i) == '(' && quoteCount %2 == 0){
                leftkuohu = i;
                flag = true;
            }else if(str.charAt(i) == ' ' && flag == true){
                rightwhite = i;
                String op = str.substring(leftkuohu+1,rightwhite);
                stack.push(op);
                flag = false;
            }else if(str.charAt(i) == '"'){
                quoteCount++;
                if(quoteCount % 2 == 1){
                    leftQuoteIndex = i;
                }else if(quoteCount % 2 == 0){
                    rightQuoteIndex = i;
                    //这里必须要加上引号
                    String val = str.substring(leftQuoteIndex,rightQuoteIndex+1);
                    stack.push(val);
                }
            }
        }
        ArrayList<String> parms = new ArrayList<String>();
        String result = "";
        while(!stack.empty()){
            String ele = stack.pop();
            if(ele.equals("quote")){
                stack.push(doQuote(parms));
                parms.clear();
            }else if(ele.equals("reverse")){
                stack.push(doReverse(parms));
                parms.clear();
            }else if(ele.equals("search")){
                stack.push(doSearch(parms));
                parms.clear();
            }else if(ele.equals("combine")){
                stack.push(doCombine(parms));
                parms.clear();
            }else{
                parms.add(ele);
                result = ele;
            }
        }
        System.out.println(result);

    }

    public static String doQuote(ArrayList<String> strs){
        return strs.get(0);
    }

    public static String doReverse(ArrayList<String> strs){
        return new StringBuilder(strs.get(0)).reverse().toString();
    }

    public static String doCombine(ArrayList<String> strs){
        String result = "";
        for(int i = strs.size()-1 ; i>=0 ; i--){
            result += removeQuote(strs.get(i));
        }
        return addQuote(result);
    }

    public static  String doSearch(ArrayList<String> strs){
        String str1 = removeQuote(strs.get(1));
        String str2 = removeQuote(strs.get(0));
        int index = str1.indexOf(str2);
        if(index == -1){
            return "\"\"";
        }else{
            return addQuote(str1.substring(index));
        }
    }

    public static String removeQuote(String str){
        return str.substring(1,str.length()-1);
    }

    public static String addQuote(String str){
        return "\"" + str + "\"";
    }
}
