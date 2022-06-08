public class Robo implements motion {
    private String name;
    private double weight;
    private double runLimit;
    private double jumpLimit;
    private double barier;
    boolean moveNext;

    public Robo(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.runLimit = 20000 - (weight * 20);
        this.jumpLimit = 2.3;
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
    @Override
    public boolean run(double distance, String name, double limit, boolean moveNext) {
        this.moveNext = motion.super.run(distance, name, limit, moveNext);
        return moveNext;
    }
    @Override
    public boolean jump(double high, String name, double barier, double limit, boolean moveNext) {
        this.moveNext = motion.super.jump(high, name, barier, limit, moveNext);
        return moveNext;
    }
    public void aboutRobot(){
        System.out.printf("Робот называется %s; \nвесит %.0f килограмм, ", name, weight);
        if (moveNext){
            System.out.print("готов продолжить движение.\n");
        } else {
            System.out.print("не может продолжать движение.\n");
        }
        System.out.printf("%s способен пробежать %.0f метров за один раз;\n", name, runLimit);
        System.out.printf("может запрыгнуть на препятствие выотой %.1f м. \n", barier);
    }


}
