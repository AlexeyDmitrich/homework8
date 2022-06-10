import java.util.Random;

public class Human implements motion{
    static Random rnd = new Random();
    private String name;
    private double weight;
    private double runLimit;
    private double jumpLimit;
    private double barier;
    boolean moveNext;

    public Human(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.runLimit = 7000 - (weight * 4);
        this.jumpLimit = 3 - (weight/100);
        this.barier = 2 -(weight/100);
        this.moveNext = true;

    }
    {
        name = "Василий";
        weight = 75;
    }

    public void humanRun (double distance){
        run(distance, name, runLimit, moveNext);
        if (weight < 40){
            System.out.println("|#################################|");
            System.out.println("|             ВНИМАНИЕ!           |");
            System.out.println("|          человек истощен        |");
            System.out.println("|  и не может продолжить движение |");
            System.out.println("|_________________________________|");
            moveNext = false;
        }
    }
    public void humanJump (double high){
        jump(high, name, barier, jumpLimit, moveNext);
    }
    @Override
    public boolean run(double distance, String name, double limit, boolean moveNext) {
        this.moveNext = motion.super.run(distance, name, limit, moveNext);
        if (moveNext) {
            runLimit += distance / 60;
            jumpLimit += distance / 10000;
            weight -= distance / 20000;
        }
        return moveNext;
    }
    @Override
    public boolean jump(double high, String name, double barier, double limit, boolean moveNext) {
        this.moveNext = motion.super.jump(high, name, barier, limit, moveNext);
        if (moveNext) {
            jumpLimit += high / 20;
            this.barier += high / 23;
        }
        return moveNext;
    }
    @Override
    public boolean getMoveNext() {
        return moveNext;
    }
@Override
    public void aboutRunner(){
        System.out.printf("Человек. \nИмя: %s; \nвесит %.1f килограмм; \n", name, weight);
        if (moveNext){
            System.out.print("готов продолжить движение.\n");
        } else {
            System.out.print("не может продолжать движение.\n");
        }
        System.out.printf("%s способен пробежать %.0f метров за один раз;\n", name, runLimit);
        System.out.printf("может перепрыгнуть препятствие выотой %.1f м. \n", barier);
    }

    @Override
    public boolean goOn(Difficultness step) {
        if (step instanceof Wall){
            humanJump(step.high());
        } else if (step instanceof Road) {
            humanRun(((Road) step).length);
        }
        return moveNext;
    }

    public static double humanWeightGen(){
        double weight = 41.2;
        //TODO: добавить пределы рандомизации каждому типу!
        weight = (rnd.nextInt(90)+41) * 0.9;
        return weight;
    }

    public static String humanNameGen (){
        String name = null;
        //TODO: добавить массивы имен для случайного выбора
        String humanNames[] = {"Роман", "Платон", "Сергей", "Евгений", "Семен", "Анатолий", "Олег", "Адам", "Игорь", "Филипп", "Артур", "Валерий", "Ян", "Назар", "Александр", "Владимир", "Дмитрий", "Николай", "Юрий", "Алексей", "Иван", "Виктор" };
        // перебор для 8 имён в массиве
        name = humanNames[rnd.nextInt(humanNames.length)];
        return name;
    }
}
