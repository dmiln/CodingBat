package TasksFromInternet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {


    public static void main(String[] args) {
        String path = "./src/TasksFromInternet/files/readMe.txt";
        //displayByWord(path);
        //displayByFewWords(path);
        displayByRegex(path);

        Pattern p = Pattern.compile("[Тт]а[ий]ланд");
        Matcher m = p.matcher("Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!");
        System.out.println();
        String s = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";
        System.out.println(s.replaceAll("[Тт]а[ий]ланд", "Россия"));


        Pattern pattern;
        Matcher matcher;
        String s2 = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";
        pattern = Pattern.compile("[Тт]а[ий]ланд");
        matcher = pattern.matcher(s2);

        System.out.println("Есть совпадение?: " + matcher.find());
    }

    private static void displayByRegex(String fileName) {
        Pattern pattern;
        Matcher matcher;
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите регулярное выражение по которому будем осуществлять поиск: ");
        String inpStr = scanner.next();

        if (inpStr != null) {
            pattern = Pattern.compile(inpStr);
            Scanner file = null;
            try {
                file = new Scanner(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                System.err.println("Не удалось найти файл");
            }
            if (file != null) {
                System.out.println("Всё, что нам удалось найти по запросу " + inpStr + ":");
                while (file.hasNextLine()) {
                    String s = file.nextLine();
                    matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        stringBuilder.append(s).append("\n");
                    }
                }
            }
        }

        if (stringBuilder.length() != 0) {
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println("К сожаление в тексте не встречалось слов:" + inpStr);
        }

    }

    private static void displayByWord(String fileName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово по которому будем выполнять поиск строк: ");
        String inpStr = scanner.next();
        if (inpStr != null) {
            Scanner in = null;
            try {
                in = new Scanner(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                System.err.println("Не удалось найти файл");
            }
            if (in != null) {
                System.out.println("Всё, что нам удалось найти по запросу " + inpStr + ":");
                while (in.hasNextLine()) {
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

        if (in != null) {
            System.out.println("Все что нашлось по запросу - " + inpStr + ": ");
            while (in.hasNextLine()) {
                String s = in.nextLine();
                for (String searchWord : rightWords) {
                    if (s.toLowerCase().contains(searchWord.toLowerCase())) {
                        stringBuilder.append(s).append("\n");
                        break;
                    }
                }
            }
        }

        if (stringBuilder.length() != 0) {
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println("К сожаление в тексте не встречалось слов:" + inpStr);
        }
    }

}
