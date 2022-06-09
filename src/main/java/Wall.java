public class Wall implements Difficultness{
    double high;

    public Wall(double high) {
        this.high = high;
    }

    public double getHigh() {
        return high;
    }

    @Override
    public double high() {
        return high;
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public double difficult() {
        return high;
    }

    @Override
    public void about() {
        System.out.println("Стена высотой " + high + " м.");
    }
}
