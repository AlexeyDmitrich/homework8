import java.util.Random;

public class Cat implements motion{
    static Random rnd = new Random();
    private String name;
    private double weight;
    private double runLimit;
    private double jumpLimit;
    private double barier;
    boolean moveNext;

    public Cat(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.runLimit = 370 - (weight * 20);
        this.jumpLimit = 4 - (weight/10);
        this.barier = 2 -(weight/10);
        this.moveNext = true;

    }
    {
        name = "Хангрид";
        weight = 8;
    }

    public void catRun (double distance){
        run(distance, name, runLimit, moveNext);
        if (weight < 2){
            System.out.println("|#################################|");
            System.out.println("|             ВНИМАНИЕ!           |");
            System.out.println("|            кот истощен          |");
            System.out.println("|  и не может продолжить движение |");
            System.out.println("|_________________________________|");
            moveNext = false;
        }
    }
    public void catJump (double high){
        jump(high, name, barier, jumpLimit, moveNext);
    }
    @Override
    public boolean run(double distance, String name, double limit, boolean moveNext) {
        this.moveNext = motion.super.run(distance, name, limit, moveNext);
        if(moveNext) {
            weight -= distance / 4000;
            runLimit += distance / 1000;
        }
        return moveNext;
    }
    @Override
    public boolean jump(double high, String name, double barier, double limit, boolean moveNext) {
        this.moveNext = motion.super.jump(high, name, barier, limit, moveNext);
        if(moveNext) {
            jumpLimit += high / 20;
            this.barier += high / 23;
        }
        return moveNext;
    }
@Override
    public void aboutRunner(){
        System.out.printf("Кота зовут %s, \nвесит %.1f килограмм, ", name, weight);
        if (moveNext){
            System.out.print("готов продолжить движение.\n");
        } else {
            System.out.print("не может продолжать движение.\n");
        }
        System.out.printf("%s способен пробежать %.0f метров за один раз;\n", name, runLimit);
        System.out.printf("может запрыгнуть на препятствие выотой %.1f м. \n", barier);
    }

    public static double catWeightGen(){
        double weight = 2.2;
        //TODO: добавить пределы рандомизации каждому типу!
        weight = (rnd.nextInt(9)+1) * 0.9;
        return weight;
    }

    public static String catNameGen (){
        String name = null;
        //TODO: добавить массивы имен для случайного выбора
        String catsNames[] = {"Кокс", "Лаврентий", "Феликс", "Платон", "Барсик", "Селантий", "Матроскин", "Саймон", "Чешир", "кот Шрёдингера", "Иосиф", "Баюн", "Пиночет"};
        // перебор для 8 имён в массиве
        name = catsNames[rnd.nextInt(catsNames.length + 1)];
        return name;
    }
}
