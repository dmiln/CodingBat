package TasksFromInternet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {

    SearchEngine(){}

    public String displayByRegex(String fileName) {
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
                while (file.hasNextLine()) {
                    String s = file.nextLine();
                    matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        stringBuilder.append(s).append("\n");
                    }
                }
            }
        }

        return haveFind(stringBuilder, inpStr);
    }

    public String displayBySeveralWords(String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите набор слов по которым осуществлять поиск: ");
        String inpStr = scanner.nextLine();
        String[] rightWords = inpStr.split(" +");

        Scanner file = null;
        try {
            file = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Не удалось найти файл");
        }

        if (file != null) {
            while (file.hasNextLine()) {
                String s = file.nextLine();
                for (String searchWord : rightWords) {
                    if (s.toLowerCase().contains(searchWord.toLowerCase())) {
                        stringBuilder.append(s).append("\n");
                        break;
                    }
                }
            }
        }

        return haveFind(stringBuilder, inpStr);
    }

    public String displayByWord(String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово по которому будем выполнять поиск строк: ");
        String inpStr = scanner.next();

        if (inpStr != null) {
            Scanner file = null;
            try {
                file = new Scanner(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                System.err.println("Не удалось найти файл");
            }
            if (file != null) {
                while (file.hasNextLine()) {
                    String s = file.nextLine();
                    if (s.toLowerCase().contains(inpStr.toLowerCase())) {
                        stringBuilder.append(s).append("\n");
                    }
                }
            }
        }

        return haveFind(stringBuilder, inpStr);
    }

    private String haveFind(StringBuilder sB, String inpStr){
        if (sB.length() != 0) {
            return sB.toString();
        } else {
            sB.append("К сожаление в тексте не встречалось слов: ").append(inpStr);
            return sB.toString();
        }
    }
}
