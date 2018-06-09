package string;

public class String3 {
    public static void main(String[] args) {
        System.out.println(countYZ("day fyyyz"));
        System.out.println(countYZ("day fyz"));
        System.out.println(countYZ("day^fyz"));
    }

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
}
