package warmup;

import java.util.Arrays;

public class Warmup2 {
    public static void main(String[] args) {
        System.out.println("Warmup2: done");
    }

    /**
     * Решил таким тупым способом, потому что условие задачи было поставленно непонятно
     * Думал что отличие может содержаться в любой позиции 271, а не только в последней
     * Ниже своей первой функции приведу другое решения уже зная, что именно от меня требовалось
     */
    public static boolean has271(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++){
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            int correct1 = first + 5;
            int correct2 = first - 1;
            if (Math.abs(second - correct1)< 1){
                if (second == correct1){
                    if (Math.abs(third - correct2) < 3){
                        return true;
                    }
                }else{
                    if (third == correct2){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean hass271(int[] nums){
        for (int i = 0; i < nums.length - 2; i++){
            int f = nums[i];
            if (nums[i + 1] == (f + 5) && Math.abs((f - 1) - nums[i + 2]) < 2)
                return true;
        }
        return false;
    }

    /**
     * Если одно и то же число встречается три раза подряд в массиве
     * то возвращаем false
     */
    public static boolean noTriples(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++){
            if (nums[i] == nums[i + 1]){
                if (nums[i + 1] == nums[i + 2]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Считаем сколько раз 6 находится рядом с друг другом в массиве
     * вторая шестерка может быть так же заменена на "7"
     */
    public static int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == 6){
                if (nums[i + 1] == 6 || nums[i + 1] == 7)
                    count++;
            }
        }
        return count;
    }

    /**
     * Убираем из исходной строки все yak
     */
    public static String stringYak(String str) {
        String yak = "yak";
        if (str.length() < 3) return str;
        for (int i = 0; i < str.length() - 2; i++){
            if (str.substring(i,i+3).equals(yak)){
                str = str.substring(0,i) + str.substring(i+3,str.length());
            }
        }
        return str;
    }

    /**
     * Возвращаем новую строку состоящую из 0,1 4,5 и т.д.
     * элементов входной строки
     */
    public static String altPairs(String str) {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < str.length(); i+=4){
            if (str.length() > i) {
                sB.append(str.charAt(i));
            }
            if (str.length() > i + 1) {
                sB.append(str.charAt(i + 1));
            }
        }
        return sB.toString();
    }

    /**
     * Возвращаем копию строку с убранными x, но если они на первом
     * и последнем месте то оставляем их
     * @param str входная строка
     */
    public static String stringX(String str) {
        if (str.length() > 2){
            String nStr = str.substring(1,str.length() - 1);
            return str.charAt(0) + nStr.replace("x","") + str.substring(str.length() - 1);
        }else {
            return str;
        }
    }

    /**
     * Находим число совпадающих двойных позиций в строках
     */
    public static int stringMatch(String a, String b) {
        int count = 0;
        int minLength = a.length()<b.length()?a.length():b.length();
        for (int i = 0; i < minLength - 1; i++){
            String strA = a.substring(i, i + 2);
            String strB = b.substring(i, i + 2);
            if (strA.equals(strB)){
                count++;
            }
        }
        return count;
    }

    /**
     * если в массиве встречается комбинация 1, 2, 3 возвращаем true
     * @param nums массив интов
     */
    public static boolean array123(int[] nums) {
        if (nums.length < 3) return false;
        int[] sub = {1, 2, 3};
        for (int i = 0; i < nums.length - 2; i++){
            int[] ints = {nums[i], nums[i + 1], nums[i + 2]};
            if (Arrays.equals(ints, sub)) return true;
        }
        return false;
    }

    /**
     * True если 9 встретилась в первых четырех элементах массива
     * @param nums массив интов
     * @return boolean
     */
    public boolean arrayFront9(int[] nums) {
        int count = 0;
        if (nums.length < 4){
            for (int i: nums){
                if (i == 9) count++;
            }
        }else{
            for (int i = 0; i < 4; i++){
                if (nums[i] == 9) count++;
            }
        }
        return count > 0;
    }

    /**
     * Считаем число 9 в массиве
     */
    public int arrayCount9(int[] nums) {
        int count = 0;
        for(int i: nums){
            if (i == 9) count++;
        }
        return count;
    }

    /**
     * Мой вариант, но можно было записать проще используя equals
     * второй вариант под первой функцией
     * @param str входная строка
     * @return число повторений последних двух символов str
     */
    public static int last2(String str) {
        if(str.length() < 2) return 0;
        String nStr = str.substring(str.length()-2,str.length());
        int count = 0;
        int in = str.indexOf(nStr.charAt(0));
        for (int i = in; i < str.length() - 2; i++){
            if (str.charAt(i+1) == nStr.charAt(1) && str.charAt(i) == nStr.charAt(0)){
                count++;
            }
        }
        return count;
    }
    public static int last2simple(String str) {
        if(str.length() < 2) return 0;
        String newStr = str.substring(str.length()-2);
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++){
            String nStr = str.substring(i, i+2);
            if (nStr.equals(newStr)){
                count++;
            }
        }
        return count;
    }

    /**
     * Превращаем строку "Code" в "CCoCodCode".
     * Возвращаем новую строку в которой записывается первый символ str,
     * Затем первые два, первые три и так по нарастающей пока не дойдем до конца строки
     */
    public static String stringSplosion(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            stringBuilder.append(str.substring(0,i+1));
        }
        return stringBuilder.toString();
    }

    /**
     * Выводим строку состоящую из нечетных символов str
     * @param str входная строка
     * @return новую строку
     */
    public static String stringBits(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i+=2){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**
     * Делаю то, что снизу но проще
     */
    public static boolean doubleXX(String str) {
        int i = str.indexOf('x');
        return (i > -1) && (str.charAt(i) == 'x') && (str.length() > i + 1) && (str.charAt(i + 1) == 'x');
    }
    /**
     * Если за первым x в str стоит x возвращаем true
     * В остальных случаях false
     */
    public static boolean doubleX(String str) {
        boolean flag = false;
        for (int i = 0; i < str.length(); i++){
            if (!flag) {
                if (str.charAt(i) == 'x' && str.length() > i + 1) {
                    flag = true;
                    if (str.charAt(i + 1) == 'x') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Посчитать "хх" в строке, перекрытие разрешено
     * @param str входная строка
     * @return число "хх"
     */
    public static int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'x' && ((i + 1) < str.length())){
                if (str.charAt(i+1) == 'x'){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Выводим новую строку из первых трех букв предыдущей n раз
     * @param str строка
     * @param n число повторений
     * @return новая строка
     */
    public static String frontTimes(String str, int n){
        String nStr;
        if (str.length() > 3){
            nStr = str.substring(0,3);
        }else{
            nStr = str;
        }
        StringBuilder strN = new StringBuilder();
        for (int i = 0; i < n; i++){
            strN.append(nStr);
        }
        return strN.toString();
    }

    /**
     * Реализация с применением предыдущей функции
     */
    public static String frontTimesss(String str, int n) {
        if (str.length() > 3){
            return stringTimes(str.substring(0,3), n);
        }else{
            return stringTimes(str, n);
        }
    }

    /**
     * Нужно вывести n копий строки
     * @param str строка
     * @param n число дублирования строки
     * @return новая строка
     */
    private static String stringTimes(String str, int n) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < n; i++) newString.append(str);
        return newString.toString();
    }

    /**
     * Сравним 4 числа и выведем наибольшее
     */
    public static int matFour(int a, int b, int c, int d){
        if (maxThree(a,b,c) > d){
            return maxThree(a, b, c);
        }else return d;
    }
    private static int maxThree(int a, int b, int c){
        if (maxTwo(a,b) > c){
            return maxTwo(a, b);
        }else return c;
    }
    private static int maxTwo(int a, int b){
        if (a > b){
            return a;
        }else return b;
    }
}
