package string;

public class String3 {
    public static void main(String[] args) {
        System.out.println(notReplace("This is not isabell is"));
    }

    /**
     * Добавить к is - not, если is отдельное слово
     */
    private static String notReplace(String str) {
        StringBuilder sB = new StringBuilder();
        int k = 0;
        for (int i = 0; i < str.length(); i++){
            if (!Character.isLetter(str.charAt(i)) || (i == str.length() - 1)){
                String prov = str.substring(k, i);
                if (prov.equals("is")){
                    sB.append("is not").append(str.charAt(i));
                    k = i + 1;
                }else if(i == str.length() - 1 && str.substring(k, i + 1).equals("is")){
                    sB.append("is not");
                }else{
                    String s = str.substring(k, i + 1);
                    sB.append(s);
                    k = i + 1;
                }
            }
        }
        return sB.toString();
    }

    /**
     * Сумма любых чисел в строке
     */
    private static int sumNumbers(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sB = new StringBuilder();
            if (!Character.isDigit(str.charAt(i))) {
                continue;
            }
            sB.append(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                i = j;
                if (Character.isDigit(str.charAt(j))) {
                    sB.append(str.charAt(j));
                } else {
                    break;
                }
            }
            result += Integer.parseInt(sB.toString());
        }
        return result;
    }

    /**
     * Выводим длину самого большого блока из одинаковых символов
     */
    private static int maxBlock(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > result) {
                result = count;
            }
        }
        return result;
    }

    /**
     * По приколу решил из раздела логики
     * Можно ли построить стену длинной goal из кирпичей длиной small = 1, big = 5
     * входные значения количество кирпичей
     */
    private static boolean makeBricks(int small, int big, int goal) {
        return (goal - small) <= big * 5 && (goal % 5) <= small;
    }

    /**
     * Находим максимальную строку в зеркальном отображении в начале и конце
     */
    private static String mirrorEnds(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(string.length() - 1 - i)) {
                result.append(string.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    /**
     * Возвращаем самую длинную подстроку, которая появляется как в начале так и в конце
     */
    private static String sameEnds(String string) {
        String result = "";
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.substring(0, i + 1).equals(string.substring(string.length() - 1 - i))) {
                result = string.substring(0, i + 1);
            }
        }
        return result;
    }

    /**
     * Считаем сумму всех чисел(0,1,...,9) в строке
     */
    private static int sumDigits(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                result += Integer.parseInt(str.substring(i, i + 1));
            }
        }
        return result;
    }

    /**
     * Количество повторений трех символов идущих подряд в строке
     */
    private static int countTriple(String str) {
        int countTrip = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i + 1) == str.charAt(i) && str.charAt(i + 2) == str.charAt(i)) {
                countTrip++;
            }
        }
        return countTrip;
    }

    /**
     * Проверяем есть ли у любой 'g' в строке соседи 'g'
     */
    private static boolean gHappy(String str) {
        if (!str.contains("g")) return true;
        for (int i = 0; i < str.length(); i++) {
            int countG = 1;
            for (int j = str.indexOf("g", i); j < str.length() - 1; j++) {
                if (j == -1) return true;
                if (str.charAt(j + 1) != 'g') {
                    break;
                }
                countG++;
                i = j + 1;
            }
            if (countG == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean equalIsNot(String str) {
        int countIs = 0;
        int countNot = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'i' && str.charAt(i + 1) == 's') {
                countIs++;
            }
        }
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'o' && str.charAt(i + 2) == 't') {
                countNot++;
            }
        }
        return countIs == countNot;
    }

    /**
     * Считает сколько в строке слов заканчивающихся на Y или Z
     */
    private static int countYZ(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) == 'z' || str.toLowerCase().charAt(i) == 'y') {
                if (i == str.length() - 1) {
                    count++;
                } else {
                    if (!Character.isLetter(str.charAt(i + 1))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Удаляет из строки во всех местах, где есть вхождения другую строку
     */
    private static String withoutString(String base, String remove) {
        for (int i = 0; i < base.length(); i++) {
            for (int j = 0; j < remove.length(); j++) {
                if (!(remove.toLowerCase().charAt(j) == base.toLowerCase().charAt(i + j)))
                    break;
                if (j == remove.length() - 1) {
                    base = base.substring(0, i) + base.substring(i + j + 1);
                    --i;
                }
            }
            if (remove.length() > base.length()) {
                break;
            }
        }
        return base;
    }
}
