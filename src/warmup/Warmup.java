package warmup;

public class Warmup {

    public static void main(String[] args) {
        System.out.println("Warmup1: done");
    }

    /**
     * task everyNth
     * выводим каждый n-ый символ в строку
     * @return строку
     */
    public static String everyNth(String str, int n){
        int len = str.length();
        StringBuilder newStr = new StringBuilder();
        for (int i = n; i < len; i+=n){
            newStr.append(str.charAt(i));
        }
        return str.charAt(0) + newStr.toString();
    }

    /**
     * На вход подаётся строка и число, каждый n*=2 символ удаляется из строки
     * Написал так, потому что неправильно прочитал задание
     * @param str входной набор символов
     * @param n номер символа, который исключается из предложения
     * @return новую строку
     */
    public static String everyNthDel(String str, int n) {
        int count = 0;
        int len = str.length();
        for (int i = n; i <= len; i += i){
            str = str.substring(0, i - 1 - count) + str.substring(i - count);
            count++;
        }
        return str;
    }

    /**
     * Переводим три последние буквы в верхний регистр
     * @return строку
     */
    public static String endUp(String str) {
        if (str.length() > 3){
            String newStr = str.substring(str.length() - 3).toUpperCase();
            return str.substring(0, str.length() - 3) + newStr;
        }else return str.toUpperCase();
    }
    /**
     * task lastDigit
     * @return если последние числа одниковы то true
     */
    public static boolean lastDigit(int a, int b) {
        return a % 10 == b % 10;
    }

    /**
     * task stringE
     * Если в слове меньше трех е то true
     */
    public static boolean stringE(String str) {
        String newStr = str.replace("e", "");
        return str.length() > 0 && str.length() != newStr.length() && str.length() - newStr.length() < 4;
    }

    /**
     * Находим наибольшее число в диапазоне от 10 до 20, или 0
     * @return число 0, либо от 10 до 20
     */
    public static int max1020(int a, int b) {
        boolean a1020 = a >= 10 && a <= 20;
        boolean b1020 = b >= 10 && b <= 20;
        if (a1020 && b1020){
            return Math.max(a,b);
        }
        if (a1020){
            return a;
        }
        if (b1020){
            return b;
        }
        return 0;
    }

    /**
     * Если два числа лежат между 30 и 40 либо 40 и 50 одновременно, то вовращаем истину
     * @return булевое значение
     */
    public static boolean in3050(int a, int b) {
        boolean a3040 = a >= 30 && a <= 40;
        boolean b3040 = b >= 30 && b <= 40;
        boolean a4050 = a >= 40 && a <= 50;
        boolean b4050 = b >= 40 && b <= 50;

        return a3040 && b3040 || a4050 && b4050;
    }

    /**
     * task close10
     * Возвращаем ближайшее к 10 число, если они не равны
     * @return 0 либо ближайшее к 10
     */
    public int close10(int a, int b) {
        int aClose = Math.abs(a - 10);
        int bClose = Math.abs(b - 10);

        if (aClose != bClose){
            if (aClose > bClose)
                return b;
            else
                return a;
        }else{
            return 0;
        }
    }

    /**
     * task intMax
     * даны три числа
     * @return максимальное из трех чисел
     */
    public static int intMax(int a, int b, int c) {
        if (a >= b) {
            if (a >= c){
                return a;
            }else{
                return c;
            }
        }else{
            if (b >= c){
                return b;
            }else{
                return c;
            }
        }
    }

    /**
     * Если строка начинается с oz возвращаем либо oz либо o, либо z
     * в зависимости от того какие буквы есть
     * @param str строка
     * @return строку
     */
    public static String startOz(String str) {
        if (str.length() >= 2){
            if (str.substring(0,2).equals("oz")){
                return "oz";
            }else if (str.substring(0,1).equals("o")){
                return "o";
            }else if (str.substring(1,2).equals("z")){
                return "z";
            }else
                return "";
        }else{
            if (str.equals("o")){
                return "o";
            }else{
                return "";
            }
        }
    }

    /**
     * Если строка начинается с .ix возвращаем true
     * @param str строка
     * @return булевое значение
     */
    public static boolean mixStart(String str) {
        return (str.length() >= 3 && str.substring(1,3).equals("ix"));
    }

    /**
     * Если вначале строки с 1 индекса стоит del то, возвращаем новую строку без del
     * @param str строка
     * @return новую или ту же строку
     */
    public static String delDel(String str){
        String del = "del";
        if (str.length() > 3 && str.substring(1,del.length()+1).equals(del)){
            return str.charAt(0)+str.substring(del.length()+1,str.length());
        }else {
            return str;
        }
    }

    /**
     * task loneTeen
     * @return true если только одно из чисел teen
     */
    public static boolean loneTeen(int a, int b) {
        return a >= 13 && a <= 19 && (b < 13 || b > 19) || (b >= 13 && b <= 19 && (a < 13 || a > 19));
    }

    /**
     * Тот же in1020 для 3х чисел
     */
    public static boolean hasTeen(int a, int b, int c){
        return a >= 13 && a <= 19 || b >= 13 && b <= 19 || c >= 13 && c <= 19;
    }

    /**
     * Если одно из чисел лежит в диапазоне от 10 до 20 возвращаем истину
     * @param a первое число
     * @param b второе число
     * @return boolean
     */
    public static boolean in1020(int a, int b){
        return a >= 10 && a <= 20 || b >= 10 && b <= 20;
    }

    /**
     * Если одна из температур меньше нуля, а вторая больше 100 вернем истину
     * @param temp1 первая температура
     * @param temp2 вторая температура
     * @return булевое значение
     */
    public static boolean icyHot(int temp1, int temp2){
        return temp1 > 100 && temp2 < 0 || temp1 < 0 && temp2 > 100;
    }

    /**
     * task hi
     * @param str строка
     * @return истину если начинается с hi
     */
    public static boolean startHi(String str) {
        return str.length() >= 2 && str.substring(0, 2).equals("hi");
    }

    /**
     * аналог backAround, только для 2х первых символов
     * @param str строка
     * @return ноую строку
     */
    public static String front22(String str) {
        if (str.length() > 2){
            return str.substring(0,2) + str + str.substring(0,2);
        }else{
            return str + str + str;
        }
    }

    /**
     * проверяем кратно ли число 3 или 5
     * @param n число
     * @return истину если кратно
     */
    public static boolean or35(int n) {
        return (n % 3) == 0 ||  (n % 5) == 0;
    }

    /**
     * task backAround
     * возвращаем строку добавляя последний символ str в начало и конец str
     * @param str строка
     * @return новую строку
     */
    public static String backAround(String str) {
        return str.charAt(str.length()-1) + str + str.charAt(str.length()-1);
    }

    /**
     *  task front3
     * @param str строка
     * @return три раза по три первых символа из str
     */
    public static String front3(String str) {
        if (str.length() >= 3){
            String s = str.substring(0,3);
            return s + s +s;
        }else{
            return str + str + str;
        }
    }

    /**
     * task frontBack
     * меняем местами первую и последнюю букву
     * @param str строка
     * @return строку с поменяными буквами
     */
    public static String frontBack(String str) {
        if (str.length() > 1)
            return str.substring(str.length()-1) + str.substring(1,str.length() - 1) + str.substring(0, 1);
        else return str;
    }


    /**
     * task missingChar
     * @param str строка
     * @param n номер удаляемого элемента в строке
     * @return строку с удаленным элементом
     */
    public static String missingChar(String str, int n) {
        return str.substring(0, n) + str.substring(n+1,str.length());
    }


    /**
     * Добавление not к строке(решено двумя способами)
     * @param str входная строка
     * @return строку если она начинается с not, либо прибавляем not
     */
    public static String notString(String str) {
        StringBuilder not = new StringBuilder();
        if (str.length() >= 3){
            for (int i = 0; i < 3; i++)
                not.append(str.charAt(i));
        }
        //if (str.startsWith("not")){
        if (not.toString().equals("not")){
            return str;
        }else{
            return "not " + str;
        }
    }
    /**
     * task posNeg
     * @param a первое число
     * @param b второе число
     * @param negative отвечает за комбинацию чисел
     * @return истину если negative и отрицательны,
     *         либо истину если !negative и только одно отрицательно
     */
    public static boolean posNeg(int a, int b, boolean negative) {
        return negative && ((a < 0) && (b < 0)) || !negative && (a > 0) && (b < 0) || !negative && (a < 0) && (b > 0);
    }

    /**
     * nearHundred
     * @param n входное число
     * @return истину если число вблизи 100 или 200 на 10
     */
    public static boolean nearHundred(int n) {
        return (Math.abs(n-100) <= 10 || Math.abs(n-200) <= 10);
    }

    /**
     * makes10 task
     * @param a первое число
     * @param b второе число
     * @return истину, если одно из чисел равно 10, либо их сумма равна 10
     */
    public static boolean makes10(int a, int b) {
        return ((a == 10) || (b == 10) || ((a + b) == 10));
    }

    /**
     * Мы находимся в беде, если попугай говорит, а час до 7 или после 20
     * @param talking отвечает за разговор попугая
     * @param hour диапазон часов от 0 до 23
     * @return истину, если мы в беде.
     */
    public static boolean parrotTrouble(boolean talking, int hour) {
        return (talking && ((hour < 7) || (hour > 20)));
    }

    /**
     * возвращаем удвоенное значение разницы n и 21, если n >= 21
     * иначе возвращаем разницу между n и 21
     * @param n входные данные
     * @return число
     */
    public static int diff21(int n) {
        if (n >= 21){
            return 2*(n - 21);
        }else{
            return 21 - n;
        }
    }

    /**
     *
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return возвращаем сумму a и b, если они не равны
     *         иначе возвращаем удвоенную сумму
     */
    public static int sumDouble(int a, int b) {
        if (a == b){
            return (a + b)  * 2;
        }else{
            return a + b;
        }
    }

    /**
     * monkeyTrouble task
     * @param aSmile первая обезьяна
     * @param bSmile вторая обезьяна
     * @return true если никто не улыбается, или оба улыбаются
     */
    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return ((aSmile && bSmile)||(!aSmile &&!bSmile));
    }

    /**
     * SleepIn task
     * @param weekday день недели
     * @param vacation отпуск
     * @return true, если не день недели или отпуск, fasle в остальных случаях
     */
    static boolean sleepIn(boolean weekday, boolean vacation) {
        return (!weekday || vacation);
    }
}
