import java.util.Random;
/**
 * Класс, описывающий ТТХ, физику и название робота
 */
public class Robo implements Motion {
    static Random rnd = new Random();
    private String name;
    private double weight;
    private final double runLimit;  // предел бега
    private final double jumpLimit;  // предел преодоления высоты
    private final double barier;  // высота прыжка
    boolean moveNext;   // способность к продолжению движения

    /**
     * Конструктор. Всё сделает сам, если ему не мешать.
     * На вход нужно передать только:
     * @param name имя
     * @param weight массу в формате double
     */
    public Robo(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.runLimit = 20000 - (weight * 20);
        this.jumpLimit = 2.3 + weight * 0.0005;
        this.barier = 0.5;
        this.moveNext = true;
    }
    {
        name = "Aurora-T1";
        weight = 8;
    }

    public void roboRun (double distance){
        run(distance, name, runLimit, moveNext);
    }
    public void roboJump (double high){
        jump(high, name, barier, jumpLimit, moveNext);
    }

    /**
     * Бег для роботов. Никак не влияет на самого робота.
     * @param distance double  - дистанцию забега (длину дороги);
     * @param name     String  - имя движущегося объекта;
     * @param limit    double  - расстояние, которое способен преодолеть объект за один раз;
     * @param moveNext boolean - способность объекта продолжать движение;
     *                 В процессе движения может меняться с true на false;
     * @return Если робот не застрял на препятствии - вернётся moveNext == true.
     */
    @Override
    public boolean run(double distance, String name, double limit, boolean moveNext) {
        this.moveNext = Motion.super.run(distance, name, limit, moveNext);
        return moveNext;
    }

    /**
     * Метод прыжков для роботов.
     * @param high      double  - высота препятствия, может быть нулевой и отрицательной;
     * @param name      String  - имя объекта;
     * @param barier    double  - высота на, которую объект может запрыгнуть;
     * @param limit     double  - максимальная высота, на которую может вскарабкаться объект;
     * @param moveNext  boolean - способность объекта продолжать движение;
     *                  В процессе движения может меняться с true на false;
     * @return вернёт true, если робот может продолжить движение.
     */
    @Override
    public boolean jump(double high, String name, double barier, double limit, boolean moveNext) {
        this.moveNext = Motion.super.jump(high, name, barier, limit, moveNext);
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
            roboJump(step.high());
        } else if (step instanceof Road) {
            roboRun(step.distance());
        }
        return moveNext;
    }

    @Override    // принудительный геттер для moveNext
    public boolean getMoveNext() {
        return moveNext;
    }
    @Override
    public void aboutRunner(){
        System.out.printf("Робот. \nНазвание: %s; \nвесит %.0f килограмм; \n", name, weight);
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
        return String.format("робот под названием %s", name);
    }



    /**
     * Метод генерации случайной массы робота
     * @return
     */
    public static double roboWeightGen(){
        double weight = 40;
        weight = (rnd.nextInt(350) + 40) * 0.9;
        return weight;
    }
    /**
     * Метод для рандомного выбора названия из массива.
     * @return
     */
    public static String roboNameGen (){
        String name = null;
        String roboNames[] = {"Atmega-droidA31", "Astra-214", "Ubi-21M", "Xenon-L2", "RBT-T1", "Knoppix-1", "Amnesia", "Tails-SPA", "Oracle-L", "Mandrake-X", "Scientific-N13", "Qubes-S2", "Mandriva-L", "Manjaro-X5", "Antergos-X" };
        // перебор для 8 имён в массиве
        name = roboNames[rnd.nextInt(roboNames.length)];
        return name;
    }
}
