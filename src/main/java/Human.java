public class Human implements motion{
    private String name;
    private float weight;
    private int runLimit;
    private int jumpLimit;
    private int barier;
    boolean moveNext;

    public Human(String name, int weight) {
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

    @Override
    public boolean run(int distance, String name, int limit, boolean moveNext) {
        motion.super.run(distance, name, limit, moveNext);
        return moveNext;
    }

    @Override
    public boolean jump(int high, String name, int barier, int limit, boolean moveNext) {
        motion.super.jump(high, name, barier, limit, moveNext);
        return moveNext;
    }

    public void aboutCat(){
        System.out.printf("Человека зовут %s; \nвесит %g килограмм", name, weight);
    }


}
