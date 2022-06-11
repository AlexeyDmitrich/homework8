import java.util.Random;

/**
 * Класс, описывающий биологию, физику и имя человека
 */
public class Human implements Motion {
    static Random rnd = new Random();
    private String name;
    private double weight;
    private double runLimit;   // предел бега
    private double jumpLimit;  // предел преодоления высоты
    private double barier;     // высота прыжка
    boolean moveNext;          // способность к продолжению движения

    /**
     * Конструктор. Всё сделает сам, если ему не мешать.
     * На вход нужно передать только:
     * @param name имя
     * @param weight массу в формате double
     */
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

    /**
     * Метод для проверки соответствия весовой категории
     * @param distance принимает дистацию будущего маршрута
     */
    public void humanRun (double distance){
        run(distance, name, runLimit, moveNext);
        if (weight < 40){
            System.out.println("|#################################|");
            System.out.println("|             ВНИМАНИЕ!           |");
            System.out.printf(" -=! человек %s истощен !=- \n", name);
            System.out.println("|  и не может продолжить движение |");
            System.out.println("|_________________________________|");
            moveNext = false;
        }
    }
    public void humanJump (double high){
        jump(high, name, barier, jumpLimit, moveNext);
    }

    /**
     * Метод бега для человека, при успешном прохождении, показатели улучшаются.
     * Но человек при этом теряет в весе.
     * @param distance double  - дистанцию забега (длину дороги);
     * @param name     String  - имя движущегося объекта;
     * @param limit    double  - расстояние, которое способен преодолеть объект за один раз;
     * @param moveNext boolean - способность объекта продолжать движение;
     *                 В процессе движения может меняться с true на false;
     * @return Метод вернет способность человека продолжить движение.
     */
    @Override
    public boolean run(double distance, String name, double limit, boolean moveNext) {
        this.moveNext = Motion.super.run(distance, name, limit, moveNext);
        if (moveNext) {
            runLimit += distance / 60;
            jumpLimit += distance / 10000;
            weight -= distance / 20000;
        }
        return moveNext;
    }

    /**
     * Прыжки человека. С каждым прыжком человек учится прыгать чуть выше.
     * @param high      double  - высота препятствия, может быть нулевой и отрицательной;
     * @param name      String  - имя объекта;
     * @param barier    double  - высота на, которую объект может запрыгнуть;
     * @param limit     double  - максимальная высота, на которую может вскарабкаться объект;
     * @param moveNext  boolean - способность объекта продолжать движение;
     *                  В процессе движения может меняться с true на false;
     * @return Вернет способность продолжать движение
     */
    @Override
    public boolean jump(double high, String name, double barier, double limit, boolean moveNext) {
        this.moveNext = Motion.super.jump(high, name, barier, limit, moveNext);
        if (moveNext) {
            jumpLimit += (high / 20);
            this.barier += (high / 23);
        }
        return moveNext;
    }

    /**
     * Метод преодоления препятствий (стен или дорог)
     * @param step в качестве аргумента принимает препятствие, имплементирующее интерфейс Difficultness.
     * @return вернет способность двигаться дальше
     */
    @Override
    public boolean goOn(Difficultness step) {
        if (step instanceof Wall){
            humanJump(step.high());
        } else if (step instanceof Road) {
            humanRun(step.distance());
        }
        return moveNext;
    }

    @Override    // принудительный геттер для moveNext
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
        System.out.printf("может перепрыгнуть препятствие высотой %.1f м. \n", barier);
    }
    @Override
    public String toString(){
        return String.format("человек по имени %s", name);
}

    /**
     * Метод генерации случайной массы для человека
     * @return
     */
    public static double humanWeightGen(){
        double weight = 41.2;
        weight = (rnd.nextInt(150-41)+41) * 0.9;
        return weight;
    }

    /**
     * Метод для выбора имени человека из массива рандомно.
     * @return
     */
    public static String humanNameGen (){
        String name = null;
        String humanNames[] = {"Роман", "Платон", "Сергей", "Евгений", "Семен", "Анатолий", "Олег", "Адам", "Игорь", "Филипп", "Артур", "Валерий", "Ян", "Назар", "Александр", "Владимир", "Дмитрий", "Николай", "Юрий", "Алексей", "Иван", "Виктор" };
        // перебор для 8 имён в массиве
        name = humanNames[rnd.nextInt(humanNames.length)];
        return name;
    }
}
