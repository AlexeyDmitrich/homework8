import java.util.Random;
/**
 * Класс, описывающий биологию, физику и имя кота
 */
public class Cat implements Motion {
    static Random rnd = new Random();
    private String name;
    private double weight;
    private double runLimit;    // предел бега
    private double jumpLimit;   // предел преодоления высоты
    private double barier;     // высота прыжка
    boolean moveNext;  // способность к продолжению движения

    /**
     * Конструктор. Всё сделает сам, если ему не мешать.
     * На вход нужно передать только:
     * @param name имя
     * @param weight массу в формате double
     */
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

    /**
     * Метод для проверки соответствия весовой категории
     * @param distance принимает дистацию будущего маршрута
     */
    public void catRun (double distance){
        run(distance, name, runLimit, moveNext);
        if (weight < 2){
            System.out.println("|#################################|");
            System.out.println("|             ВНИМАНИЕ!           |");
            System.out.printf("  -=! кот %s истощен !=-  \n", name);
            System.out.println("|  и не может продолжить движение |");
            System.out.println("|_________________________________|");
            moveNext = false;
        }
    }
    public void catJump (double high){
        jump(high, name, barier, jumpLimit, moveNext);
    }

    /**
     * Метод бега для котов, при прохождении этапа кот худеет и немного тренируется.
     * @param distance double  - дистанцию забега (длину дороги);
     * @param name     String  - имя движущегося объекта;
     * @param limit    double  - расстояние, которое способен преодолеть объект за один раз;
     * @param moveNext boolean - способность объекта продолжать движение;
     *                 В процессе движения может меняться с true на false;
     * @return Метод вернет способность кота двигаться дальше.
     */
    @Override
    public boolean run(double distance, String name, double limit, boolean moveNext) {
        this.moveNext = Motion.super.run(distance, name, limit, moveNext);
        if(moveNext) {
            weight -= distance / 4000;
            runLimit += distance / 1000;
        }
        return moveNext;
    }

    /**
     * Прыжки для котов с тренировочной составляющей
     * @param high      double  - высота препятствия, может быть нулевой и отрицательной;
     * @param name      String  - имя объекта;
     * @param barier    double  - высота на, которую объект может запрыгнуть;
     * @param limit     double  - максимальная высота, на которую может вскарабкаться объект;
     * @param moveNext  boolean - способность объекта продолжать движение;
     *                  В процессе движения может меняться с true на false;
     * @return Возвращает способность двигаться дальше
     */
    @Override
    public boolean jump(double high, String name, double barier, double limit, boolean moveNext) {
        this.moveNext = Motion.super.jump(high, name, barier, limit, moveNext);
        if(moveNext) {
            jumpLimit += (high / 17);
            this.barier += (high / 20);
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
            catJump(step.high());
        } else if (step instanceof Road) {
            catRun(step.distance());
        }
        return moveNext;
    }

    @Override    // принудительный геттер для moveNext
    public boolean getMoveNext() {
        return moveNext;
    }
    @Override
    public void aboutRunner(){
        System.out.printf("Кот. \nКличка: %s; \nвесит %.1f килограмм; \n", name, weight);
        if (moveNext){
            System.out.print("готов продолжить движение.\n");
        } else {
            System.out.print("не может продолжать движение.\n");
        }
        System.out.printf("%s способен пробежать %.0f метров за один раз;\n", name, runLimit);
        System.out.printf("может запрыгнуть на препятствие высотой %.1f м. \n", barier);
    }
    @Override
    public String toString(){
        return String.format("кот %s", name);
    }


    /**
     * Метод генерации случайной массы кота
     * @return
     */
    public static double catWeightGen(){
        double weight = 2.2;
        weight = (rnd.nextInt(7-3)+3) * 0.9;
        return weight;
    }
    /**
     * Метод для выбора имени кота из массива рандомно.
     * @return
     */
    public static String catNameGen (){
        String name = null;
        String catsNames[] = {"Кокс", "Лаврентий", "Феликс", "Платон", "Барсик", "Селантий", "Матроскин", "Саймон", "Чешир", "Шрёдингера", "Иосиф", "Баюн", "Пиночет"};
        // перебор для 8 имён в массиве
        name = catsNames[rnd.nextInt(catsNames.length)];
        return name;
    }
}
