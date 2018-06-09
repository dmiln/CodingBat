package string;

public class String3 {

    /**
     * Считает сколько в строке слов заканчивающихся на Y или Z
     */
    private static int countYZ(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.toLowerCase().charAt(i) == 'z' || str.toLowerCase().charAt(i) == 'y'){
                if (i == str.length() - 1){
                    count++;
                }else{
                    if (!Character.isLetter(str.charAt(i+1))){
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
        for (int i = 0; i < base.length(); i++){
            for (int j = 0; j < remove.length(); j++){
                if (!(remove.toLowerCase().charAt(j) == base.toLowerCase().charAt(i + j)))
                    break;
                if (j == remove.length() - 1){
                    base = base.substring(0,i) + base.substring(i + j + 1);
                    --i;
                }
            }
            if (remove.length() > base.length()){
                break;
            }
        }
        return base;
    }
}
