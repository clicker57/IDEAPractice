package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

public class BasicPractice {

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

        Calendar now = Calendar.getInstance();
        System.out.println("month: " + now.get(Calendar.MONTH));

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
