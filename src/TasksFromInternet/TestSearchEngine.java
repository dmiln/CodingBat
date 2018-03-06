package TasksFromInternet;

public class TestSearchEngine {
    public static void main(String[] args) {
        String path = "./src/TasksFromInternet/files/readMe.txt";
        SearchEngine sE = new SearchEngine();
        //System.out.println(sE.displayByRegex(path));
        //System.out.println(sE.displayBySeveralWords(path));
        System.out.println(sE.displayByWord(path));
    }
}
