import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2017华为校园提前批招聘第一题，简单
 * Created by zhufx on 2017/6/29.
 */
public class StringCount {
    public static void main(String[] args){
        ArrayList<String> strs = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        int num = 0,word = 0,other = 0;
        int last_count=0;
        strs.add(scan.nextLine());
        for(int i = 0;i < strs.size(); i++){
            String str = strs.get(i);
            int count = 0;
            for(int j = 0; j< str.length(); j++) {
                count = getClass(str.charAt(j));
                if (count == last_count) {
                    continue;
                } else if (count == 1) {
                    last_count = 1;
                    word++;
                } else if (count == 2) {
                    last_count = 2;
                    num++;
                } else if (count == 3) {
                    last_count = 3;
                    other++;
                }
            }
        }
        System.out.println(word+","+num+","+other);
    }

    public static int getClass(char c){
        if(c >= 'A' && c <= 'Z'){
            return 1;
        }else if(c >= 'a' && c<= 'z'){
            return 1;
        }else if(c > '0' && c <= '9'){
            return 2;
        }else{
            return 3;
        }
    }
}
