package practice;

/**
 * Created by Philip on 10/19/16.
 */
public class Student extends Person {
    private String major;
    private int grade;

    /**
     * @param n name of student
     * @param m major of student
     */
    public Student(String n, String m, int g) {
        super(n);
        major = m;
        grade = g;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String getDiscription() {

        return null;
    }

    public void changeGrade(int oldG, int newG) {
        System.out.println(super.getName()+" is changed from grade "+oldG+" to grade "+newG);
    }

    public void changeGrade(int newG) {
        changeGrade(grade, newG);
    }

    public String scoreToLevel(double myScore, double... allScores) {
        double averageScore = 0;
        double sum = 0;

        for (double s : allScores) {
            sum += s;
        }
        averageScore = sum / allScores.length;

        return scoreToLevel(myScore, averageScore);
    }

    public String scoreToLevel(double myScore, double avgScore) {
        System.out.println(this.getName()+"'s score is "+myScore+".");
        return (myScore>avgScore)?"excellent":"good";
    }

    public static void show() {
        System.out.println("This is a static method.");
    }
}
