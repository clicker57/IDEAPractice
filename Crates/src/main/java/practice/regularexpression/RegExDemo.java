package practice.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {
    public static void main(String[] args) {
        String regex = "word|pwd(.*?)$";
        String s1 = "myword123abc";
        String s2 = "mypwd123abc";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(s1);
        while(matcher.find()){
            String group = matcher.group();
            System.out.print(group + " , ");
        }
        System.out.println("\n---------------\n");
        matcher = compile.matcher(s2);
        while(matcher.find()){
            String group = matcher.group();
            System.out.print(group + " , ");
        }
    }
}
