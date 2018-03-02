package array;


public class Array1 {

    public static void main(String[] args) {
        int[] a = {12, 2, 3, 4, 5, 6, 7, 8};
    }

    public static int sum2(int[] nums) {
        int result = 0;
        if (nums.length > 1){
            result = nums[0] + nums[1];
        }
        if (nums.length == 1){
            result = nums[0];
        }
        return result;
    }

    /**
     * Заполняет массив максимальным крайним числом
     */
    public static int[] maxEnd3(int[] nums) {
        int max = Math.max(nums[0],nums[nums.length - 1]);
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++){
            result[i] = max;
        }
        return result;
    }

    /**
     * Переворачивает массив
     */
    public static int[] reverse3(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0 && j < nums.length; i--, j++ ){
            result[j] = nums[i];
        }
        return result;
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

    static int[] makePi(){
        return new int[]{3, 1, 4};
    }
}


