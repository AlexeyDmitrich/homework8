public class Human implements motion{
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

    public void aboutHuman(){
        System.out.printf("Человека зовут %s; \nвесит %.1f килограмм, ", name, weight);
        if (moveNext){
            System.out.print("готов продолжить движение.\n");
        } else {
            System.out.print("не может продолжать движение.\n");
        }
        System.out.printf("%s способен пробежать %.0f метров за один раз;\n", name, runLimit);
        System.out.printf("может перепрыгнуть препятствие выотой %.1f м. \n", barier);
    }


}
