package practice.arrays;

/**
 * Created by Philip on 7/5/16.
 */
public class ArrPractice {
    public boolean has23(int[] nums) {
        Math.max(nums[0], nums[nums.length-1]);

        for (int i: nums) {
            System.out.print(" "+nums[i]);
        }
        System.out.println();
        return true;
    }

    public static void main(String[] args) {
        ArrPractice obj = new ArrPractice();

        obj.has23(new int[] {0});
    }
}
