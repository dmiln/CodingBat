package TasksFromInternet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Grep {

    public static void main(String[] args) {
        String path = "./src/TasksFromInternet/files/readMe.txt";
        //displayByWord(path);
        displayByFewWords(path);
    }

    private static void displayByWord(String fileName)  {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово по которому будем выполнять поиск строк: ");
        String inpStr = scanner.next();
        if (inpStr != null){
            Scanner in = null;
            try {
                in = new Scanner(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                System.err.println("Не удалось найти файл");
            }
            if (in != null) {
                System.out.println("Всё, что нам удалось найти по запросу " + inpStr + ":");
                while (in.hasNextLine()){
                    String s = in.nextLine();
                    if (s.toLowerCase().contains(inpStr.toLowerCase())) {
                        System.out.println(s);
                    }
                }
            }
        }
    }

    private static void displayByFewWords(String fileName) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Введите набор слов по которым осуществлять поиск: ");
        String inpStr = scanner.nextLine();
        String[] rightWords = inpStr.split(" +");

        Scanner in = null;
        try {
            in = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Не удалось найти файл");
        }

        if (in != null){
            System.out.println("Все что нашлось по запросу - " + inpStr + ": ");
            while (in.hasNextLine()){
                String s = in.nextLine();
                for (String searchWord: rightWords){
                    if (s.toLowerCase().contains(searchWord.toLowerCase())){
                        stringBuilder.append(s).append("\n");
                        break;
                    }
                }
            }
        }

        if (stringBuilder.length() != 0){
            System.out.println(stringBuilder.toString());
        }else{
            System.out.println("К сожаление в тексте не встречалось слов:" + inpStr);
        }
    }

}
