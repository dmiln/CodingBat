package array;


import java.util.Arrays;

public class Array1 {

    public static void main(String[] args) {
        int[] a = {12, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(new int[8]));

        Array1 a1 = new Array1();

    }

    public int[] front11(int[] a, int[] b) {
        if (a.length == 0 && b.length != 0){
            return new int[]{b[0]};
        }
        if (b.length == 0 && a.length != 0){
            return new int[]{a[0]};
        }
        if (a.length == 0){
            return new int[]{};
        }
        return new int[]{a[0],b[0]};
    }

    public int[] make2(int[] a, int[] b) {
        if (a.length > 1){
            return new int[]{a[0],a[1]};
        }else if (a.length == 1){
            return new int[]{a[0],b[0]};
        }else{
            return new int[]{b[0],b[1]};
        }
    }

    public boolean unlucky1(int[] nums) {
        if (nums.length > 1) {
            if (nums[0] == 1) {
                if (nums[1] == 3)
                    return true;
            }
            if (nums.length > 2) {
                if (nums[1] == 1) {
                    if (nums[2] == 3)
                        return true;
                }
                if (nums[nums.length - 2] == 1) {
                    return nums[nums.length - 1] == 3;
                }
            }
        }
        return false;
    }


    public int[] frontPiece(int[] nums) {
        if (nums.length > 1) {
            return new int[]{nums[0], nums[1]};
        } else {
            return nums;
        }
    }


    public int maxTriple(int[] nums) {
        return Math.max(Math.max(nums[0], nums[nums.length - 1]), nums[nums.length / 2]);
    }


    public int maxValue(int[] nums) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        return max;
    }

    public int[] midThree(int[] nums) {
        int d = nums.length / 2;
        return new int[]{nums[d - 1], nums[d], nums[d + 1]};
    }


    public int[] swapEnds(int[] nums) {
        if (nums.length > 1) {
            int tmp = nums[0];
            nums[0] = nums[nums.length - 1];
            nums[nums.length - 1] = tmp;
        }
        return nums;
    }


    public int[] plusTwo(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }


    public int[] makeMiddle(int[] nums) {
        return new int[]{nums[nums.length / 2 - 1], nums[nums.length / 2]};
    }


    public int[] biggerTwo(int[] a, int[] b) {
        return a[0] + a[1] < b[0] + b[1] ? b : a;
    }

    public int start1(int[] a, int[] b) {
        int count = 0;
        if (a.length > 0) {
            if (a[0] == 1) {
                count++;
            }
        }
        if (b.length > 0) {
            if (b[0] == 1) {
                count++;
            }
        }
        return count;
    }


    public int[] fix23(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 3) {
                nums[i + 1] = 0;
            }
        }
        return nums;
    }


    public boolean double23(int[] nums) {
        return nums.length == 2 && (nums[0] == 2 && nums[1] == 2 || nums[0] == 3 && nums[1] == 3);
    }


    public int[] makeLast(int[] nums) {
        int[] result = new int[nums.length * 2];
        result[result.length - 1] = nums[nums.length - 1];
        return result;
    }


    public boolean no23(int[] nums) {
        for (int num : nums) {
            if (num == 2 || num == 3) {
                return false;
            }
        }
        return true;
    }


    public boolean has23(int[] nums) {
        for (int num : nums) {
            if (num == 2 || num == 3) {
                return true;
            }
        }
        return false;
    }


    public int[] makeEnds(int[] nums) {
        return new int[]{nums[0], nums[nums.length - 1]};
    }


    public int[] middleWay(int[] a, int[] b) {
        return new int[]{a[1], b[1]};
    }


    public static int sum2(int[] nums) {
        int result = 0;
        if (nums.length > 1) {
            result = nums[0] + nums[1];
        }
        if (nums.length == 1) {
            result = nums[0];
        }
        return result;
    }

    /**
     * Заполняет массив максимальным крайним числом
     */
    public static int[] maxEnd3(int[] nums) {
        int max = Math.max(nums[0], nums[nums.length - 1]);
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = max;
        }
        return result;
    }

    /**
     * Переворачивает массив
     */
    public static int[] reverse3(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0 && j < nums.length; i--, j++) {
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
        return nums[0] == 6 || nums[nums.length - 1] == 6;
    }

    public boolean sameFirstLast(int[] nums) {
        return nums.length > 0 && nums[0] == nums[nums.length - 1];
    }

    static int[] makePi() {
        return new int[]{3, 1, 4};
    }
}


