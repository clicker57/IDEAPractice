package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class BasicPractice {
    public boolean equalIsNot(String str) {
        if (str==null || "".equals(str) || str.length()==1) { return true; }

        int isNum=0, notNum=0;
        for (int i=0; i<str.length()-1; i++) {
            if (i+2<=str.length() && str.substring(i,i+2).equals("is")) {
                isNum++;
            }
            if (i+3<=str.length() && str.substring(i,i+3).equals("not")) {
                notNum++;
            }
        }

        return isNum == notNum;
    }

    public static void main(String[] args) {
        long beginT;
        System.currentTimeMillis();
        long endT;
        System.currentTimeMillis();

        BasicPractice obj = new BasicPractice();
        obj.parseDoc("/Users/Philip/workspaces/jdkprac/l.man");


        double dd = 1234.5993;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("decimalformat: " + df.format(dd));
    }

    private void parseDoc(String fileName) {
        try (Scanner in = new Scanner(new FileInputStream(fileName))) {
            while (in.hasNext()) {
                System.out.println(in.next());
            }
            System.out.println("***** try ends *****");
        } catch (FileNotFoundException e) {
            System.out.println("---> " + e.getMessage());
            e.printStackTrace();
            System.out.println("---> catch ends");
        }
    }
}
