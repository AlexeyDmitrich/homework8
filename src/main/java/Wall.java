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
        System.out.printf("На пути стена высотой %.2f м.", high);
    }
}
