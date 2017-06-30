import java.util.Scanner;

/**
 *  * 腾讯2017年实习生机试第二题
 * Created by zhufx on 2017/6/29.
 */
public class PutStringUppercaseEnd {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String result = getResult(str);
            System.out.println(result);
        }
    }

    public static String getResult(String str){
        char[] chars = str.toCharArray();
        int firstUpperCase = str.length();
        int point = 0;
        for(int i=chars.length - 1 ;  i >= 0 ; i--){
            char c = chars[i];
            if(c >= 'a' && c <= 'z'){
                continue;
            }else if(c >= 'A' && c <= 'Z'){
                firstUpperCase--;
                int temp = i;
                while(temp != firstUpperCase){
                    chars[temp] = chars[temp+1];
                    temp++;
                }
                chars[firstUpperCase] = c;

            }
        }
        return String.valueOf(chars);
    }

}
