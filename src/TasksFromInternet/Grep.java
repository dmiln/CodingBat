package TasksFromInternet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Grep {

    public static void main(String[] args) {
        displayByWord();
    }

    private static void displayByWord()  {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("Введите слово по которому будем выполнять поиск строк: ");
        String inpStr = scanner.next();
        if (inpStr != null){
            Scanner in = null;
            try {
                in = new Scanner(new FileReader("./src/TasksFromInternet/files/readMe.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
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


}
