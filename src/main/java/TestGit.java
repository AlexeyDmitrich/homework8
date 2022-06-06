public class TestGit {
    public static void main(String[] args) {
        System.out.print("Класс создан исключительно для тренировки работы в git \n");
        // стартовая версия
        printTestText();
        String third = "третья версия";
        finalyTest(third);
        SecondGitTest.merge();

    }
    public static void printTestText(){
        String version = "вторая версия";
        System.out.println(version);
        // проект с первыми изменениями
    }

    static void finalyTest (String last){
        System.out.println(last + "с окончательными изменениями");


    }
}
