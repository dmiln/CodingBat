package array;

public class Array1 {

    public static void main(String[] args) {

    }

    public static int[] rotateLeft3(int[] nums) {
        return new int[]{nums[1], nums[2], nums[0]};
    }


    public static int sum3(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }


    public boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
    }

    public boolean firstLast6(int[] nums) {
        return nums[0] == 6 || nums[nums.length-1] == 6;
    }

    public boolean sameFirstLast(int[] nums) {
        return nums.length > 0 && nums[0] == nums[nums.length - 1];
    }

    int[] makePi(){
        return new int[]{3, 1, 4};
    }
}


