package string;

public class String2 {
    public static void main(String[] args) {
        System.out.println("String2");

    }

    public static String wordEnds(String str, String word){
        StringBuilder result = new StringBuilder();
        int length = word.length();
        if (word.equals(str))
            return result.toString();
        for (int i = 0; i < str.length() - length + 1; i++){
            if (word.equals(str.substring(i, i + length))){
                if (i == 0){
                    result.append(str.charAt(i + length));
                }else {
                    if (i != str.length() - length){
                        result.append(str.substring(i - 1, i)).append(str.substring(i + length, i + length + 1));
                    }else{
                        result.append(str.substring(i - 1, i));
                    }
                }
            }
        }
        return result.toString();
    }

    public static String plusOut(String str, String word) {
        int length = word.length();
        int outWord = str.lastIndexOf(word) + length;
        for (int i = 0; i < str.length() ; i++){
            if (i >= outWord){
                str = str.substring(0, outWord) + "+" + str.substring(outWord + 1);
                outWord++;
            }else {
                if (!str.substring(i, i + length).equals(word)) {
                    str = str.substring(0, i) + "+" + str.substring(i + 1);
                } else {
                    i += length - 1;
                }
            }
        }
        return str;
    }

    /**
     * Что-то подсказывает, что эту функцию можно было сделать иначе
     * Нужно было убрать все символы окружающие * ( * может быть больше чем одна)
     */
    public static String starOut(String str) {

        if (str.indexOf('*') == -1)
            return str;

        if (str.length() < 2) {
            if (str.equals("*"))
                return "";
            else
                return str;
        }else{
            while(str.indexOf('*') == 0 || str.lastIndexOf('*') == str.length() - 1) {
                if (str.lastIndexOf('*') == str.length() - 1) {
                    if (str.charAt(str.lastIndexOf('*') - 1) == '*') {
                        str = str.substring(0, str.lastIndexOf('*'));
                    }else{
                        str = str.substring(0, str.lastIndexOf('*') - 1);
                    }
                }
                if (str.indexOf('*') == 0) {
                    if (str.charAt(str.indexOf('*') + 1) == '*'){
                        str = str.substring(1);
                    }else{
                        str = str.substring(2);
                    }
                }
                if (str.length() == 0)
                    return str;
            }
        }

        while(str.indexOf('*') != -1){
            if (str.charAt(str.indexOf('*') + 1) != '*'){
                str = str.substring(0, str.indexOf('*') - 1) + str.substring(str.indexOf('*') + 2);
            }else{
                str = str.substring(0, str.indexOf('*')) + str.substring(str.indexOf('*') + 1);
            }
        }

        return str;
    }

    public static String zipZap(String str) {
        for (int i = 0; i < str.length() - 2; i++){
            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                str = str.substring(0,i + 1) + str.substring(i + 2);
            }
        }
        return str;
    }

    public static String oneTwo(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - 2; i+=3){
            String newStr = str.substring(i, i + 3);
            newStr = newStr.substring(1) + newStr.substring(0, 1);
            result.append(newStr);
        }
        return result.toString();
    }


    public static boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++){
            if (str.charAt(i) == '*'){
                if (str.charAt(i - 1) != str.charAt(i + 1))
                    return false;
            }
        }
        return true;
    }

    public static String getSandwich(String str) {
        String bread = "bread";
        int in = str.indexOf("bread");
        int out = str.lastIndexOf("bread");
        if (in == -1 && out == -1)
            return "";
        if (in == out)
            return "";
        return str.substring(in + 5, out);
    }
    /**
     * Решал около часа, задача была достаточно сложной
     * Уверен, что есть другие пути решения
     */
    public static boolean xyzMiddle(String str) {
        int in = str.indexOf("xyz", (str.length() - 3) / 2);
        return in >= 0 && Math.abs(str.substring(0, in).length() - str.substring(in + 3).length()) < 2;
    }

    private static boolean prefixAgain(String str, int n) {
        //String subStr = " ";
        String subStr = str.substring(0,n);
        for (int i = n; i < str.length()- n + 1; i++){
            if (subStr.equals(str.substring(i,i + n)))
                return true;
        }
        return false;
    }


    public static String repeatSeparator(String word, String sep, int count) {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < count; i++){
            sB.append(word);
            if (i < count - 1)
                sB.append(sep);
        }
        return sB.toString();
    }

    public static String repeatFront(String str, int n) {
        StringBuilder sB = new StringBuilder();
        if (n <= str.length()){
            for (int i = n; i >= 0; i--){
                sB.append(str.substring(0,i));
            }
        }
        return sB.toString();
    }

    public static String repeatEnd(String str, int n) {
        StringBuilder sB = new StringBuilder();
        if (n <= str.length()){
            for (int i = 0; i < n; i++){
                sB.append(str.substring(str.length()-n));
            }
        }
        return sB.toString();
    }

    public static String mixString(String a, String b) {
        StringBuilder str = new StringBuilder();
        int minLenth = Math.min(a.length(), b.length());
        for (int i = 0; i < minLenth; i++){
            str.append(a.substring(i, i + 1)).append(b.substring(i, i + 1));
        }
        return str + a.substring(minLenth) + b.substring(minLenth);
    }


    public static boolean xyBalance(String str) {
        int inX = str.lastIndexOf('x');
        int inY = str.lastIndexOf('y');
        return inX == inY || inY > inX;
    }

    public boolean bobThere(String str) {
        if (str.length() < 3)
            return false;
        for (int i = 0; i < str.length() - 2; i++){
            if (str.charAt(i) == 'b' && str.charAt(i+2) == 'b')
                return true;
        }
        return false;
    }

    public static boolean xyzTher (String str){
        int in = str.indexOf("xyz");
        if (in == 0)
            return true;
        if (in > 0){
            for (int i = in; i < str.length() - 2; i++){
                if (str.substring(i, i + 3).equals("xyz")
                    && str.charAt(i - 1) != '.')
                    return true;
            }
        }
        return false;
    }
    public static boolean xyzThere(String str) {
        if (str.length() > 3) {
            if (str.charAt(0) != '.') {
                if (str.substring(0, 3).equals("xyz"))
                    return true;
                for (int i = 1; i < str.length() - 2; i++) {
                    if (str.substring(i, i + 3).equals("xyz")
                            && str.charAt(i - 1) != '.')
                        return true;
                }
            }
        }
        return str.length() == 3 && str.equals("xyz");
    }

    public static boolean endOther(String a, String b) {
        int minLength = Math.min(a.length(),b.length());
        return a.toLowerCase().substring(a.length() - minLength).equals(
                b.toLowerCase().substring(b.length() - minLength));
    }

    public static int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++){
            if (str.substring(i, i + 2).equals("co")){
                if (str.charAt(i + 3) == 'e')
                    count++;
            }
        }
        return count;
    }

    public static boolean dogCat(String str){
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++){
            if (str.substring(i, i + 3).equals("cat"))
                count++;
            if (str.substring(i,i + 3).equals("dog"))
                count--;
        }
        return (count == 0);
    }

    public int countHi(String str) {
        String hi = "hi";
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++){
            if (str.substring(i, i+2).equals(hi)){
                count++;
            }
        }
        return count;
    }


    public static String doubleChar(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            s.append(str.charAt(i)).append(str.charAt(i));
        }
        return s.toString();
    }
}
