import java.util.Scanner;

/**
 * Created by zhufx on 2017/6/29.
 * 2017华为校园提前批招聘第二题，简单
 */
public class ReverseWord {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        //String str = "the blue   is       white";
        String[] strs = str.split(" ");
        String result = "";
        for(int i=strs.length-1;i>=0;i--){
            String s = strs[i];
            if(!s.equals("")){
                result += s;
                result += " ";
            }
        }
        result = result.trim();
        System.out.println(result);
    }
}
