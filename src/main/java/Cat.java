public class Cat implements motion{
    private String name;
    private float weight;
    private int runLimit;
    private int jumpLimit;
    private int barier;
    boolean moveNext;

    public Cat(String name, int weight) {
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

    @Override
    public void run(int distance, String name, int limit, boolean moveNext) {
        motion.super.run(distance, name, limit, moveNext);
    }

    @Override
    public void jump(int high, String name, int barier, int limit, boolean moveNext) {
        motion.super.jump(high, name, barier, limit, moveNext);
    }

    public void aboutCat(){
        System.out.printf("Кота зовут %s; \nвесит %g килограмм", name, weight);
    }

}
